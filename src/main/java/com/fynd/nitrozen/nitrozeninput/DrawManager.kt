package com.fynd.nitrozen.nitrozeninput

import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.fynd.nitrozen.nitrozeninput.drawer.*
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput

class DrawManager constructor(view: NInput, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)

    val text = TitleTextDrawer(view, controller.nitrozenInput)
    val editTextDrawer = EditTextDrawer(view, controller.nitrozenInput)
    val hintText = HintTextDrawer(view, controller.nitrozenInput)
    val successText = SuccessTextDrawer(view, controller.nitrozenInput)
    val successHintTextDrawer = SuccessHintTextDrawer(view, controller.nitrozenInput)
    val errorText = ErrorTextDrawer(view, controller.nitrozenInput)
    val errorHintTextDrawer = ErrorHintTextDrawer(view, controller.nitrozenInput)


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

    fun setText(text: String?) {
        return editTextDrawer.setText(text?:"")
    }

    private fun defineDrawingOrder() {
        text.draw()
        editTextDrawer.draw()
        hintText.draw()
        successText.draw()
        successHintTextDrawer.draw()
        errorText.draw()
        errorHintTextDrawer.draw()
    }

    fun updateViews() {
        text.updateLayout()
        editTextDrawer.updateLayout()
        hintText.updateLayout()
        successText.updateLayout()
        successHintTextDrawer.updateLayout()
        errorText.updateLayout()
        errorHintTextDrawer.updateLayout()
    }
}