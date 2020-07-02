package com.fynd.nitrozen.nitrozendropdown

import android.annotation.SuppressLint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozenbutton.utils.txtPxToSp
import com.fynd.nitrozen.nitrozendropdown.model.NitrozenDropdown

class AttributeController(private val view: View, private val attrs: AttributeSet?) {


    lateinit var nitrozenDropdown: NitrozenDropdown

    init {
        initAttr()
    }

    @SuppressLint("NewApi")
    private fun initAttr() {
        val typedArray = view.context.obtainStyledAttributes(
            attrs,
            R.styleable.NDropdown
        )

        val nd_titleText = typedArray.getString(R.styleable.NDropdown_nd_title)
        val nd_titleTextSize = typedArray.getDimension(
            R.styleable.NDropdown_nd_titleTextSize,
            txtPxToSp(7f)
        )
        val nd_placeHolder = typedArray.getString(R.styleable.NDropdown_nd_placeHolder)
        val nd_placeHolderTextSize = typedArray.getDimension(
            R.styleable.NDropdown_nd_placeHolderTextSize,
            txtPxToSp(7f)
        )
        val nd_showLoader = typedArray.getBoolean(
            R.styleable.NDropdown_nd_showLoader,
            false
        )
        val nd_errorText = typedArray.getString(R.styleable.NDropdown_nd_errorText)

        val nd_editable = typedArray.getBoolean(
            R.styleable.NDropdown_nd_editable,
            true
        )
        val nd_enabled = typedArray.getBoolean(
            R.styleable.NDropdown_nd_enabled,
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
        nitrozenDropdown = NitrozenDropdown().apply {
            layoutHeight = height
            layoutWidth = width
            titleText = nd_titleText
            titleTextSize = nd_titleTextSize
            showLoader = nd_showLoader
            placeHolder = nd_placeHolder ?: "Placeholder"
            placeHolderTextSize = nd_placeHolderTextSize
            errorText = nd_errorText ?: ""
            editable = nd_editable
            enabled = nd_enabled
        }
        typedArray.recycle()
    }
}