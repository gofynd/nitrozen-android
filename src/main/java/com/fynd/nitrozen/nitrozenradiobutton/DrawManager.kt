package com.fynd.nitrozen.nitrozenradiobutton

import android.util.AttributeSet
import com.fynd.nitrozen.nitrozeninput.drawer.*
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput
import com.fynd.nitrozen.nitrozenradiobutton.model.NitrozenRadio

internal class DrawManager constructor(view: NRadio, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)


    companion object Create {
        fun init(view: NRadio, attrs: AttributeSet): DrawManager {
            return DrawManager(view, attrs)
        }
    }

    fun draw() {
        defineDrawingOrder()
    }

    fun changeMeasure(width: Int, height: Int) {
        updateViews()
    }

    fun getRadio(): NitrozenRadio {
        return controller.nitrozenRadio
    }

    private fun defineDrawingOrder() {

    }

    fun updateViews() {
    }
}