package com.fynd.nitrozen.nitrozeninput

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class NInput : LinearLayout {

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
        if (manager != null) {
            if (!manager!!.getInput().isEnabled) {
                alpha = 0.5f
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    fun getShowError(): Boolean = manager!!.getInput().showError

    fun setShowError(showError: Boolean): NInput {
        manager!!.getInput().showError = showError
        updateView()
        return this
    }

    fun getTitleText(): String = manager!!.getInput().titleText ?: ""

    fun setTitleText(text: String): NInput {
        manager!!.getInput().titleText = text
        updateView()
        return this
    }

    private fun updateView() {
        requestLayout()
    }
}