package com.fynd.nitrozen.nitrozenradiobutton

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp


class NRadio : AppCompatRadioButton {

    private var manager: DrawManager? = null

    constructor(context: Context) : super(context) {
        bind(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        bind(attrs)
    }

    @SuppressLint("RestrictedApi")
    private fun bind(attrs: AttributeSet?) {
        manager = DrawManager(this, attrs)
        manager?.draw()

        val params =
            LinearLayout.LayoutParams(
                manager!!.getRadio().layoutWidth,
                manager!!.getRadio().layoutHeight
            )
        layoutParams = params

        if (manager != null) {
            if (!manager!!.getRadio().isEnabled) {
                alpha = 0.5f
            }
        }
        text = manager!!.getRadio().text
        textSize = manager!!.getRadio().textSize
        isEnabled = manager!!.getRadio().isEnabled
        setPadding(pxToDp(10f).toInt(), 0, 0, 0)
        try {
            val tf = ResourcesCompat.getFont(context, R.font.poppins)
            setTypeface(tf, Typeface.NORMAL)
        } catch (e: Exception) {
        }
        val colorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_enabled)
            ),
            intArrayOf(
                ContextCompat.getColor(context, R.color.nitrozen_seconday_color),
                ContextCompat.getColor(context, R.color.colorCheckBoxEdge),
                ContextCompat.getColor(context, R.color.colorCheckBoxEdge)
            )
        )

        supportButtonTintList = colorStateList
        if (!manager!!.getRadio().isEnabled) {
            setTextColor(ContextCompat.getColor(context, R.color.colorCheckBoxEdge))
        } else {
            setTextColor(ContextCompat.getColor(context, R.color.colorCheckBoxText))
        }
        includeFontPadding = false
        updateView()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun updateView() {
        requestLayout()
    }
}