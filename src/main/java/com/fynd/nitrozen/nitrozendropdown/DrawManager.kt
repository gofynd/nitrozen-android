package com.fynd.nitrozen.nitrozendropdown

import android.util.AttributeSet
import com.fynd.nitrozen.nitrozendropdown.drawer.ErrorTextDrawer
import com.fynd.nitrozen.nitrozendropdown.drawer.SpinnerDrawer
import com.fynd.nitrozen.nitrozendropdown.drawer.TitleTextDrawer
import com.fynd.nitrozen.nitrozendropdown.model.NitrozenDropdown

class DrawManager constructor(view: NDropdown, attrs: AttributeSet?) {

    private val controller =
        AttributeController(view, attrs)

    private val text = TitleTextDrawer(view, controller.nitrozenDropdown)
    val spinner = SpinnerDrawer(view, controller.nitrozenDropdown)
    private val errorTextDrawer = ErrorTextDrawer(view, controller.nitrozenDropdown)

    companion object Create {
        fun init(view: NDropdown, attrs: AttributeSet): DrawManager {
            return DrawManager(view, attrs)
        }
    }

    fun draw() {
        defineDrawingOrder()
    }

    fun changeMeasure(width: Int, height: Int) {
        updateViews()
    }

    fun getDropdown(): NitrozenDropdown {
        return controller.nitrozenDropdown
    }

    private fun defineDrawingOrder() {
        text.draw()
        spinner.draw()
        errorTextDrawer.draw()
    }

    fun updateViews() {
        text.updateLayout()
        spinner.draw()
        errorTextDrawer.draw()
    }
}