package com.fynd.nitrozen.nitrozeninput

import android.annotation.SuppressLint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput

internal class AttributeController(private val view: View, private val attrs: AttributeSet?) {


    lateinit var nitrozenInput: NitrozenInput

    init {
        initAttr()
    }

    @SuppressLint("NewApi")
    private fun initAttr() {
        val typedArray = view.context.obtainStyledAttributes(
            attrs,
            R.styleable.NInput
        )

        val titleText = typedArray.getString(R.styleable.NInput_nb_title)
        val titleTextSize = typedArray.getDimension(
            R.styleable.NInput_nb_titleTextSize,
            pxToDp(12f)
        )
        val placeHolderText = typedArray.getString(R.styleable.NInput_nb_placeHolder)
        val hintText = typedArray.getString(R.styleable.NInput_nb_hint)
        val hintTextSize = typedArray.getDimension(
            R.styleable.NInput_nb_hintTextSize,
            pxToDp(12f)
        )
        val showError = typedArray.getBoolean(R.styleable.NInput_nb_showError, false)
        val successText = typedArray.getString(R.styleable.NInput_nb_showSuccessText)
        val showLoader = typedArray.getBoolean(R.styleable.NInput_nb_showLoader, false)
        val leadingIcon = typedArray.getDrawable(R.styleable.NInput_nb_leadingIcon)
        val trailingIcon = typedArray.getDrawable(R.styleable.NInput_nb_trailingIcon)
        val isEnabled = typedArray.getBoolean(R.styleable.NInput_nb_enabled, true)
        val isEditable = typedArray.getBoolean(R.styleable.NInput_nb_editable, true)

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
        nitrozenInput = NitrozenInput(
            layoutHeight = height,
            layoutWidth = width,
            titleText = titleText,
            titleTextSize = titleTextSize,
            placeHolderText = placeHolderText,
            hintText = hintText,
            hintTextSize = hintTextSize,
            showError = showError,
            successText = successText,
            showLoader = showLoader,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isEnabled = isEnabled,
            isEditable = isEditable
        )
        typedArray.recycle()
    }
}