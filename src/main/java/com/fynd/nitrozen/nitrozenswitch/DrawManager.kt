package com.fynd.nitrozen.nitrozenswitch

import android.util.AttributeSet
import com.fynd.nitrozen.nitrozeninput.drawer.*
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput
import com.fynd.nitrozen.nitrozenradiobutton.model.NitrozenRadio
import com.fynd.nitrozen.nitrozenswitch.model.NitrozenSwitch

class DrawManager constructor(view: NSwitch, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)


    companion object Create {
        fun init(view: NSwitch, attrs: AttributeSet): DrawManager {
            return DrawManager(view, attrs)
        }
    }

    fun draw() {
        defineDrawingOrder()
    }

    fun changeMeasure(width: Int, height: Int) {
        updateViews()
    }

    fun getRadio(): NitrozenSwitch {
        return controller.nitrozenSwitch
    }

    private fun defineDrawingOrder() {

    }

    fun updateViews() {
    }
}