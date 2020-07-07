package com.fynd.nitrozen.nitrozeninput

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozenbutton.utils.txtPxToSp
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput

class AttributeController(private val view: View, private val attrs: AttributeSet?) {


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

        val text = typedArray.getString(R.styleable.NInput_ni_text)
        val textSize = typedArray.getDimension(
            R.styleable.NInput_ni_textSize,
            pxToDp(12f)
        )
        val titleText = typedArray.getString(R.styleable.NInput_ni_title)
        val titleTextSize = typedArray.getDimension(
            R.styleable.NInput_ni_titleTextSize,
            pxToDp(12f)
        )
        val placeHolderText = typedArray.getString(R.styleable.NInput_ni_placeHolder)
        val hintText = typedArray.getString(R.styleable.NInput_ni_hint)
        val hintTextSize = typedArray.getDimension(
            R.styleable.NInput_ni_hintTextSize,
            pxToDp(12f)
        )
        val successText = typedArray.getString(R.styleable.NInput_ni_showSuccessText)
        val errorText = typedArray.getString(R.styleable.NInput_ni_errorText)
        val showLoader = typedArray.getBoolean(R.styleable.NInput_ni_showLoader, false)
        val leadingIcon = typedArray.getDrawable(R.styleable.NInput_ni_leadingIcon)
        val leadingIconTint =
            typedArray.getColor(R.styleable.NInput_ni_leadingIconTint, Color.BLACK)
        val trailingIcon = typedArray.getDrawable(R.styleable.NInput_ni_trailingIcon)
        val trailingIconTint =
            typedArray.getColor(R.styleable.NInput_ni_trailingIconTint, Color.BLACK)
        val isEnabled = typedArray.getBoolean(R.styleable.NInput_ni_enabled, true)
        val isEditable = typedArray.getBoolean(R.styleable.NInput_ni_editable, true)

        val ellipSize = typedArray.getInt(R.styleable.NInput_ni_ellipsize, -1)
        val layoutGravity = typedArray.getInt(R.styleable.NInput_ni_layout_gravity, -1)
        val gravity = typedArray.getInt(R.styleable.NInput_ni_gravity, Gravity.CENTER_VERTICAL)
        val inputType = typedArray.getInt(R.styleable.NInput_ni_inputType, -1)
        val imeOptions = typedArray.getInt(R.styleable.NInput_ni_imeOptions, -1)
        val singleLine = typedArray.getBoolean(R.styleable.NInput_ni_singleLine, false)
        val maxLines = typedArray.getInt(R.styleable.NInput_ni_maxLines, 1)
        val maxLength = typedArray.getInt(R.styleable.NInput_ni_maxLength, -1)

        val trailingIconVisibility = typedArray.getInt(R.styleable.NInput_ni_trailingIconVisibility, View.VISIBLE)
        val leadingIconVisibility = typedArray.getInt(R.styleable.NInput_ni_leadingIconVisibility, View.VISIBLE)

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
            text = text,
            textSize = textSize,
            titleText = titleText,
            titleTextSize = titleTextSize,
            placeHolderText = placeHolderText,
            hintText = hintText,
            hintTextSize = hintTextSize,
            successText = successText,
            showLoader = showLoader,
            leadingIcon = leadingIcon,
            leadingIconTint = leadingIconTint,
            trailingIcon = trailingIcon,
            trailingIconTint = trailingIconTint,
            isEnabled = isEnabled,
            isEditable = isEditable,
            errorText = errorText,
            ellipSize = ellipSize,
            layoutGravity = layoutGravity,
            gravity = gravity,
            inputType = inputType,
            imeOptions = imeOptions,
            singeLine = singleLine,
            maxLines = maxLines,
            maxLength =  maxLength,
            leadingIconVisibility = leadingIconVisibility,
            trailingIconVisibility = trailingIconVisibility
        )
        typedArray.recycle()
    }
}