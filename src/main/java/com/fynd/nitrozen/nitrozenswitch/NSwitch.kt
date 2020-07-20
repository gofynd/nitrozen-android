package com.fynd.nitrozen.nitrozenswitch

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp


class NSwitch : SwitchCompat {

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
                ContextCompat.getColor(context, R.color.ninput_edge_color),
                ContextCompat.getColor(context, R.color.colorTitle)
            )
        )

        val trackColorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_enabled)
            ),
            intArrayOf(
                ContextCompat.getColor(context, R.color.nitrozen_seconday_color_light),
                ContextCompat.getColor(context, R.color.colorTitle),
                ContextCompat.getColor(context, R.color.ninput_edge_color)
            )
        )
        thumbTintList = colorStateList
        trackTintList = trackColorStateList
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