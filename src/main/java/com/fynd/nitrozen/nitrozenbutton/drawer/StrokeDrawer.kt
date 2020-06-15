package com.fynd.nitrozen.nitrozenbutton.drawer

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import android.widget.LinearLayout
import com.fynd.nitrozen.nitrozenbutton.NBtn
import com.fynd.nitrozen.nitrozenbutton.model.IconPosition
import com.fynd.nitrozen.nitrozenbutton.model.NitrozenButton
import com.fynd.nitrozen.nitrozenbutton.model.Shape
import com.fynd.nitrozen.nitrozenbutton.utils.RippleEffect
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.utils.Drawer

class StrokeDrawer(val view: NBtn, val button: NitrozenButton) :
    Drawer<NBtn, NitrozenButton>(view, button) {

    private lateinit var container: GradientDrawable

    override fun draw() {
        initContainer()
        setOrientation()
        drawShape()
    }

    override fun isReady(): Boolean {
        return view.visibility != View.GONE
    }

    private fun initContainer() {
        container = GradientDrawable()
        container.cornerRadius = pxToDp(button.cornerRadius)
        container.setColor(Color.WHITE)
        container.setStroke(1, button.borderColor)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.elevation = button.elevation
        }
        addRipple()
    }

    // GradientDrawable get the alpha value range 0 - 255, so the method should be override
    override fun getAlpha(): Float = MAX_ALPHA * (1 - (ALPHA_PERCENTS.toFloat() / 100))

    // Add a ripple effect for the button if it was enabled
    private fun addRipple() {
        view.isEnabled = button.enable
        view.isClickable = button.enable
        view.isFocusable = button.enable
        RippleEffect.createRipple(
            view,
            button.enableRipple && button.enable,
            button.btnColor,
            button.rippleColor,
            button.cornerRadius,
            button.btnShape,
            container
        )
    }

    // Set the layout orientation dependent on icon position
    private fun setOrientation() {
        view.orientation = when (button.iconPosition) {
            IconPosition.LEFT, IconPosition.RIGHT -> LinearLayout.HORIZONTAL
            else -> LinearLayout.VERTICAL
        }
    }

    // Draw button shape
    private fun drawShape() {
        container.shape = when (button.btnShape) {
            Shape.RECTANGLE -> GradientDrawable.RECTANGLE
            Shape.OVAL -> GradientDrawable.OVAL
            Shape.SQUARE -> alignSides(GradientDrawable.RECTANGLE)
            Shape.CIRCLE -> alignSides(GradientDrawable.OVAL)
        }
    }

    // Align shape sides
    private fun alignSides(shape: Int): Int {
        val dimension = if (view.layoutParams != null) {
            defineFitSide(view.layoutParams.width, view.layoutParams.height)
        } else {
            defineFitSide(view.measuredWidth, view.measuredHeight)
        }
        if (view.layoutParams != null) {
            view.layoutParams.width = dimension
            view.layoutParams.height = dimension
        }
        return shape
    }

    // Get a min side or a max side if anyone side equal zero or less
    private fun defineFitSide(w: Int, h: Int): Int {
        return if (w <= 0 || h <= 0) {
            Math.max(w, h)
        } else {
            Math.min(w, h)
        }
    }

    override fun updateLayout() {
        draw()
    }

}