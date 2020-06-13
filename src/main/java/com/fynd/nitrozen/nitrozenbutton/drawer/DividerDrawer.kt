package com.fynd.nitrozen.nitrozenbutton.drawer
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import com.fynd.nitrozen.utils.Drawer
import com.fynd.nitrozen.nitrozenbutton.NBtn
import com.fynd.nitrozen.nitrozenbutton.model.NitrozenButton
import com.fynd.nitrozen.nitrozenbutton.model.Shape

class DividerDrawer(val view: NBtn, val button: NitrozenButton)
    : Drawer<NBtn, NitrozenButton>(view, button) {

    private var div: View = View(view.context)

    override fun draw() {
        initDivider()
        view.addView(div)
    }

    override fun isReady(): Boolean {
        return button.divVisibility != View.GONE
    }

    private fun initDivider() {
        div.visibility = button.divVisibility
        val divParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        divParams.marginStart = button.divMarginStart.toInt()
        divParams.topMargin = button.divMarginTop.toInt()
        divParams.marginEnd = button.divMarginEnd.toInt()
        divParams.bottomMargin = button.divMarginBottom.toInt()
        setMeasure(divParams)
        setColor()
        div.layoutParams = divParams
    }

    private fun setColor() {
        if (!button.enable) {
            if (button.elementsDisableColor != 0) {
                div.setBackgroundColor(button.elementsDisableColor)
            } else {
                div.setBackgroundColor(button.divColor)
                div.alpha = getAlpha()
            }
        } else {
            div.setBackgroundColor(button.divColor)
        }
    }

    // Set the divider measure if a shape of the button was changed
    private fun setMeasure(divParams: ViewGroup.MarginLayoutParams) {
        val minMeasure = Math.min(view.measuredWidthAndState, view.measuredHeightAndState)
        val borderMeasure = (button.borderWidth * 2f).toInt()
        if (button.divHeight == 0f && view.orientation == LinearLayout.HORIZONTAL) {
            val wMeas = when(button.btnShape) {
                Shape.SQUARE, Shape.CIRCLE -> minMeasure
                else -> view.measuredHeightAndState
            }
            divParams.height = wMeas - borderMeasure
        } else {
            divParams.height = button.divHeight.toInt()
        }
        if (button.divWidth == 0f && view.orientation == LinearLayout.VERTICAL) {
            val hMeas = when(button.btnShape) {
                Shape.SQUARE, Shape.CIRCLE -> minMeasure
                else -> view.measuredWidthAndState
            }
            divParams.width = hMeas - borderMeasure
        } else {
            divParams.width = button.divWidth.toInt()
        }
    }

    override fun updateLayout() {
        initDivider()
    }

}