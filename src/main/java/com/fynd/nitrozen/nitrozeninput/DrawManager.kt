package com.fynd.nitrozen.nitrozeninput

import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.fynd.nitrozen.nitrozeninput.drawer.*
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput

class DrawManager constructor(view: NInput, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)

    private val text = TitleTextDrawer(view, controller.nitrozenInput)
    val editTextDrawer = EditTextDrawer(view, controller.nitrozenInput)
    private val hintText = HintTextDrawer(view, controller.nitrozenInput)
    private val successText = SuccessTextDrawer(view, controller.nitrozenInput)
    private val successHintTextDrawer = SuccessHintTextDrawer(view, controller.nitrozenInput)
    private val errorText = ErrorTextDrawer(view, controller.nitrozenInput)
    private val errorHintTextDrawer = ErrorHintTextDrawer(view, controller.nitrozenInput)


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

    fun getEditText(): AppCompatEditText {
        return editTextDrawer.getEditText()
    }


    fun setText(text: String) {
        return editTextDrawer.setText(text)
    }


    private fun defineDrawingOrder() {
        text.draw()
        editTextDrawer.draw()

        if (getInput().showError) {
            if (hintText.isReady() && errorText.isReady()) {
                errorHintTextDrawer.draw()
            } else {
                errorText.draw()
            }
        } else {
            if (hintText.isReady() && !successText.isReady() && !errorText.isReady()) {
                //only hint
                hintText.draw()
            } else if (!hintText.isReady() && successText.isReady() && !errorText.isReady()) {
                //only success
                successText.draw()
            } else if (!hintText.isReady() && !successText.isReady() && errorText.isReady()) {
                //only error
                errorText.draw()
            } else if (hintText.isReady() && successText.isReady() && !errorText.isReady()) {
                //hint and success
                successHintTextDrawer.draw()
            } else if (hintText.isReady() && !successText.isReady() && errorText.isReady()) {
                //hint and error
                errorHintTextDrawer.draw()
            } else if (hintText.isReady() && successText.isReady() && errorText.isReady()) {
                //error should override success
                errorHintTextDrawer.draw()
            }
        }
    }

    fun updateViews() {
        text.updateLayout()
        editTextDrawer.updateLayout()
        hintText.updateLayout()
    }
}