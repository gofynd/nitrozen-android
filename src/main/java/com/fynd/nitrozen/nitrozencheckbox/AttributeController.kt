package com.fynd.nitrozen.nitrozencheckbox

import android.annotation.SuppressLint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.txtPxToSp
import com.fynd.nitrozen.nitrozencheckbox.model.NitrozenCheckBox

internal class AttributeController(private val view: View, private val attrs: AttributeSet?) {


    lateinit var nitrozenCheckBox: NitrozenCheckBox

    init {
        initAttr()
    }

    @SuppressLint("NewApi")
    private fun initAttr() {
        val typedArray = view.context.obtainStyledAttributes(
            attrs,
            R.styleable.NCheckBox
        )

        val ncb_isIndeterminate = typedArray.getBoolean(
            R.styleable.NCheckBox_ncb_isIndeterminate,
            false
        )
        val ncb_text = typedArray.getString(
            R.styleable.NCheckBox_ncb_text
        )
        val ncb_textSize = typedArray.getDimension(
            R.styleable.NCheckBox_ncb_textSize,13f
        )

        val ncb_isChecked = typedArray.getBoolean(
            R.styleable.NCheckBox_ncb_checked,
            false
        )
        val ncb_isEnabled = typedArray.getBoolean(
            R.styleable.NCheckBox_ncb_enabled,
            true
        )
        val lHeight =
            attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height")
        val lWidth =
            attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_width")
        var height = 0
        var width = 0
        when {
            lHeight.equals(ViewGroup.LayoutParams.MATCH_PARENT.toString()) ->
                height = ViewGroup.LayoutParams.MATCH_PARENT
            lHeight.equals(ViewGroup.LayoutParams.WRAP_CONTENT.toString()) ->
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
            lWidth.equals(ViewGroup.LayoutParams.MATCH_PARENT.toString()) ->
                width = ViewGroup.LayoutParams.MATCH_PARENT
            lWidth.equals(ViewGroup.LayoutParams.WRAP_CONTENT.toString()) ->
                width = ViewGroup.LayoutParams.WRAP_CONTENT
            else -> view.context.obtainStyledAttributes(
                attrs,
                intArrayOf(android.R.attr.layout_width)
            ).apply {
                width = getDimensionPixelSize(0, ViewGroup.LayoutParams.WRAP_CONTENT)
                recycle()
            }
        }
        nitrozenCheckBox = NitrozenCheckBox().apply {
            text = ncb_text ?: ""
            textSize = ncb_textSize
            layoutHeight = height
            layoutWidth = width
            isIndeterminate = ncb_isIndeterminate
            isEnabled = ncb_isEnabled
            isChecked = ncb_isChecked
        }
        typedArray.recycle()
    }
}