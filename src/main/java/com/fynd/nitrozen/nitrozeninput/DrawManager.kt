package com.fynd.nitrozen.nitrozeninput

import android.util.AttributeSet
import com.fynd.nitrozen.nitrozeninput.drawer.*
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput

internal class DrawManager constructor(view: NInput, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)

    private val text = TitleTextDrawer(view, controller.nitrozenInput)
    private val editText = EditTextDrawer(view, controller.nitrozenInput)
    private val hintText = HintTextDrawer(view, controller.nitrozenInput)
    private val successText = SuccessTextDrawer(view, controller.nitrozenInput)
    private val successHintTextDrawer = SuccessHintTextDrawer(view, controller.nitrozenInput)


    companion object Create {
        fun init(view: NInput, attrs: AttributeSet): DrawManager {
            return DrawManager(view, attrs)
        }
    }

    fun draw() {
        defineDrawingOrder()
    }

    fun changeMeasure(width: Int, height: Int) {
        updateViews()
    }

    fun getInput(): NitrozenInput {
        return controller.nitrozenInput
    }

    private fun defineDrawingOrder() {
        if (text.isReady()) {
            text.draw()
        }
        editText.draw()
        if (hintText.isReady() && successText.isReady()) {
            if (successHintTextDrawer.isReady()) {
                successHintTextDrawer.draw()
            }
        } else {
            if (hintText.isReady()) {
                hintText.draw()
            }
            if (successText.isReady()) {
                successText.draw()
            }
        }
    }

    fun updateViews() {
        text.updateLayout()
        editText.updateLayout()
        hintText.updateLayout()
    }
}