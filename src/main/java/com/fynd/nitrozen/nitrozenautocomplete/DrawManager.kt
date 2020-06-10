package com.fynd.nitrozen.nitrozenautocomplete

import android.util.AttributeSet
import com.fynd.nitrozen.nitrozenautocomplete.model.NitrozenAutocomplete
import com.fynd.nitrozen.nitrozeninput.drawer.*
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput
import com.fynd.nitrozen.nitrozenradiobutton.model.NitrozenRadio

internal class DrawManager constructor(view: NAutocomplete, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)


    companion object Create {
        fun init(view: NAutocomplete, attrs: AttributeSet): DrawManager {
            return DrawManager(view, attrs)
        }
    }

    fun draw() {
        defineDrawingOrder()
    }

    fun changeMeasure(width: Int, height: Int) {
        updateViews()
    }

    fun getAutoComplete(): NitrozenAutocomplete {
        return controller.nitrozenAutocomplete
    }

    private fun defineDrawingOrder() {

    }

    fun updateViews() {
    }
}