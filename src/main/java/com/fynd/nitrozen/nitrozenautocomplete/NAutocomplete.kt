package com.fynd.nitrozen.nitrozenautocomplete

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp


class NAutocomplete : AppCompatAutoCompleteTextView {

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
        hint = manager!!.getAutoComplete().hintText

        setPadding(pxToDp(30f).toInt(), pxToDp(30f).toInt(),pxToDp(30f).toInt(), pxToDp(30f).toInt())
        try {
            val tf = ResourcesCompat.getFont(context, R.font.poppins)
            setTypeface(tf, Typeface.NORMAL)
        } catch (e: Exception) {
        }
        setBackgroundResource(R.drawable.ninput_background)
        includeFontPadding = false
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    private fun updateView() {
        requestLayout()
    }
}