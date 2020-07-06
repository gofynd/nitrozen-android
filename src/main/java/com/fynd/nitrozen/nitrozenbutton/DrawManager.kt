package com.fynd.nitrozen.nitrozenbutton

import android.util.AttributeSet
import android.view.View
import com.fynd.nitrozen.nitrozenbutton.drawer.*
import com.fynd.nitrozen.nitrozenbutton.model.IconPosition
import com.fynd.nitrozen.nitrozenbutton.model.NitrozenButton

class DrawManager constructor(view: NBtn, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)

    private val container = ContainerDrawer(view, controller.button)
    private val icon = IconDrawer(view, controller.button)
    private val divider = DividerDrawer(view, controller.button)
    private val text = TextDrawer(view, controller.button)
    private val loaderDrawer = LoaderDrawer(view, controller.button)
    private val strokeDrawer = StrokeDrawer(view, controller.button)

    companion object Create {
        fun init(view: NBtn, attrs: AttributeSet): DrawManager {
            return DrawManager(view, attrs)
        }
    }

    /**
     * Draw customized [FitButton] on [View]
     */
    fun drawButton() {
        container.draw()
        defineDrawingOrder()
    }

    /**
     * Resize button measure
     * @param width new button width
     * @param height new button height
     */
    fun changeMeasure(width: Int, height: Int) {
        updateViews()
    }

    /**
     * @return [FButton] with attrs or default values
     */
    fun getButton(): NitrozenButton {
        return controller.button
    }

    private fun defineDrawingOrder() {
        val icPosition: IconPosition = getButton().iconPosition
        if (icon.isReady()) {
            if (IconPosition.LEFT == icPosition || IconPosition.TOP == icPosition) {
                icon.draw()
                if (divider.isReady()) {
                    divider.draw()
                }
                if (text.isReady()) {
                    text.draw()
                }
            } else {
                if (text.isReady()) {
                    text.draw()
                }
                if (divider.isReady()) {
                    divider.draw()
                }
                icon.draw()
            }
        } else {
            if (text.isReady()) {
                text.draw()
            }
        }
    }

    /**
     * Update the button layouts and it elements
     */
    fun updateViews() {
        container.updateLayout()
        text.updateLayout()
        icon.updateLayout()
        divider.updateLayout()
        if (getButton().isLoader) {
            loaderDrawer.updateLayout()
        }
        if (getButton().isStroke) {
            strokeDrawer.updateLayout()
        }
    }
}