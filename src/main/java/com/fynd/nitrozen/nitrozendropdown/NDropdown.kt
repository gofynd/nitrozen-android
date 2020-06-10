package com.fynd.nitrozen.nitrozendropdown

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.SpinnerAdapter

class NDropdown : LinearLayout {

    private var manager: DrawManager? = null

    constructor(context: Context) : super(context) {
        bind(null)
        orientation = VERTICAL
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        bind(attrs)
        orientation = VERTICAL
    }

    override fun getOrientation(): Int {
        return VERTICAL
    }

    private fun bind(attrs: AttributeSet?) {
        manager = DrawManager(this, attrs)
        manager?.draw()
        if (manager?.getDropdown()?.editable == true || manager?.getDropdown()?.enabled == true) {
            isEnabled = false
        }
    }

    fun setAdapter(adapter: SpinnerAdapter) {
        manager?.getDropdown()?.spinner?.adapter = adapter
        manager?.spinner?.hidePlaceHolder()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun updateView() {
        requestLayout()
    }
}