package com.fynd.nitrozen.nitrozenradiobutton

import android.annotation.SuppressLint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenradiobutton.model.NitrozenRadio

class AttributeController(private val view: View, private val attrs: AttributeSet?) {


    lateinit var nitrozenRadio: NitrozenRadio

    init {
        initAttr()
    }

    @SuppressLint("NewApi")
    private fun initAttr() {
        val typedArray = view.context.obtainStyledAttributes(
            attrs,
            R.styleable.NRadio
        )

        val nrb_text = typedArray.getString(R.styleable.NRadio_nrb_text)
        val nrb_textSize = typedArray.getDimension(
            R.styleable.NRadio_nrb_textSize,
            12f
        )
        val isEnabled = typedArray.getBoolean(R.styleable.NRadio_nrb_enabled, true)
        val layoutHeight =
            attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height")
        val layoutWidth =
            attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_width")
        var height = 0
        var width = 0
        when {
            layoutHeight.equals(ViewGroup.LayoutParams.MATCH_PARENT.toString()) ->
                height = ViewGroup.LayoutParams.MATCH_PARENT
            layoutHeight.equals(ViewGroup.LayoutParams.WRAP_CONTENT.toString()) ->
                height = ViewGroup.LayoutParams.WRAP_CONTENT
            else -> view.context.obtainStyledAttributes(
                attrs,
                intArrayOf(android.R.attr.layout_height)
            ).apply {
                height = getDimensionPixelSize(0, ViewGroup.LayoutParams.WRAP_CONTENT)
                recycle()
            }
        }
        when {
            layoutWidth.equals(ViewGroup.LayoutParams.MATCH_PARENT.toString()) ->
                width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutWidth.equals(ViewGroup.LayoutParams.WRAP_CONTENT.toString()) ->
                width = ViewGroup.LayoutParams.WRAP_CONTENT
            else -> view.context.obtainStyledAttributes(
                attrs,
                intArrayOf(android.R.attr.layout_width)
            ).apply {
                width = getDimensionPixelSize(0, ViewGroup.LayoutParams.WRAP_CONTENT)
                recycle()
            }
        }
        nitrozenRadio = NitrozenRadio(
            layoutHeight = height,
            layoutWidth = width,
            text = nrb_text,
            textSize = nrb_textSize,
            isEnabled = isEnabled
        )
        typedArray.recycle()
    }
}