package com.fynd.nitrozen.nitrozencheckbox

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatCheckBox

class NCheckBox : LinearLayout {

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

        val params =
            LayoutParams(
                manager!!.getCheckBox().layoutWidth,
                manager!!.getCheckBox().layoutHeight
            )
        layoutParams = params
    }

    fun getCheckBox(): AppCompatCheckBox {
        return manager?.checkBoxDrawer?.getCheckBox()!!
    }

    fun setText(text: String?): NCheckBox {
        manager?.checkBoxDrawer?.getCheckBox()!!.text = text
        updateView()
        return this
    }

    fun isChecked(): Boolean {
        return manager?.checkBoxDrawer?.getCheckBox()!!.isChecked
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun updateView() {
        requestLayout()
    }
}