package com.fynd.nitrozen.nitrozenbutton.drawer

import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.fynd.nitrozen.nitrozenbutton.NBtn
import com.fynd.nitrozen.nitrozenbutton.model.IconPosition
import com.fynd.nitrozen.nitrozenbutton.model.NitrozenButton
import com.fynd.nitrozen.nitrozenbutton.model.Shape
import com.fynd.nitrozen.nitrozenbutton.utils.RippleEffect
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.utils.Drawer

class ContainerDrawer(val view: NBtn, val button: NitrozenButton) :
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
        if (button.width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            if (button.icon != null) {
                view.setPadding(
                    dpToPx(35f).toInt(),
                    dpToPx(0f).toInt(),
                    dpToPx(35f).toInt(),
                    dpToPx(0f).toInt()
                )
            } else if(button.isLoader){
                view.setPadding(
                    dpToPx(55f).toInt(),
                    dpToPx(0f).toInt(),
                    dpToPx(55f).toInt(),
                    dpToPx(0f).toInt()
                )
            }else{
                view.setPadding(
                    dpToPx(48f).toInt(),
                    dpToPx(15f).toInt(),
                    dpToPx(48f).toInt(),
                    dpToPx(15f).toInt()
                )
            }
        }
        view.gravity = Gravity.CENTER
        container = GradientDrawable()
        container.cornerRadius = pxToDp(button.cornerRadius)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.elevation = button.elevation
        }
        setButtonColor()
        addRipple()
    }

    private fun setButtonColor() {
        if (!button.enable) {
            if (button.disableColor != 0) {
                container.setColor(button.disableColor)
                container.setStroke(button.borderWidth.toInt(), button.disableColor)
            } else {
                container.setColor(button.btnColor)
                container.setStroke(button.borderWidth.toInt(), button.borderColor)
                container.alpha = getAlpha().toInt()
            }
        } else {
            container.setColor(button.btnColor)
            container.setStroke(button.borderWidth.toInt(), button.borderColor)
        }
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
            Shape.ROUNDED -> alignSides(GradientDrawable.RECTANGLE)
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