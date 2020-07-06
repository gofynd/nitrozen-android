package com.fynd.nitrozen.nitrozencheckbox

import android.util.AttributeSet
import com.fynd.nitrozen.nitrozencheckbox.model.NitrozenCheckBox

class DrawManager constructor(view: NCheckBox, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)

    companion object Create {
        fun init(view: NCheckBox, attrs: AttributeSet): DrawManager {
            return DrawManager(view, attrs)
        }
    }

    fun draw() {
        defineDrawingOrder()
    }

    fun changeMeasure(width: Int, height: Int) {
        updateViews()
    }

    fun getCheckBox(): NitrozenCheckBox {
        return controller.nitrozenCheckBox
    }

    private fun defineDrawingOrder() {
    }

    fun updateViews() {

    }
}