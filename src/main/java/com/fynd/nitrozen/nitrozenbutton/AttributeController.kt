package com.fynd.nitrozen.nitrozenbutton

import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.model.IconPosition
import com.fynd.nitrozen.nitrozenbutton.model.NitrozenButton
import com.fynd.nitrozen.nitrozenbutton.model.Shape
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozenbutton.utils.txtPxToSp

class AttributeController(private val view: View, private val attrs: AttributeSet?) {


    lateinit var button: NitrozenButton

    init {
        initAttr()
    }

    private fun initAttr() {
        val typedArray = view.context.obtainStyledAttributes(
            attrs,
            R.styleable.NBtn
        )
        // Init button image
        val icon = typedArray.getDrawable(R.styleable.NBtn_nb_icon)
        val iconColor = typedArray.getColor(R.styleable.NBtn_nb_iconColor, Color.TRANSPARENT)
        val iconWidth = typedArray.getDimension(
            R.styleable.NBtn_nb_iconWidth, icon?.intrinsicWidth?.toFloat() ?: 0f
        )
        val iconHeight = typedArray.getDimension(
            R.styleable.NBtn_nb_iconHeight, icon?.intrinsicHeight?.toFloat() ?: 0f
        )
        val iconMarginStart = typedArray.getDimension(R.styleable.NBtn_nb_iconMarginStart, 0f)
        val iconMarginTop = typedArray.getDimension(R.styleable.NBtn_nb_iconMarginTop, 0f)
        val iconMarginEnd = typedArray.getDimension(R.styleable.NBtn_nb_iconMarginEnd, dpToPx(5f))
        val iconMarginBottom = typedArray.getDimension(R.styleable.NBtn_nb_iconMarginBottom, 0f)
        val iconPosition =
            typedArray.getInt(R.styleable.NBtn_nb_iconPosition, IconPosition.LEFT.position)
        val iconVisibility = typedArray.getInt(R.styleable.NBtn_nb_iconVisibility, View.VISIBLE)

        // Init divider
        val divColor = typedArray.getColor(R.styleable.NBtn_nb_divColor, Color.DKGRAY)
        val divWidth = typedArray.getDimension(R.styleable.NBtn_nb_divWidth, 0f)
        val divHeight = typedArray.getDimension(R.styleable.NBtn_nb_divHeight, 0f)
        val divMarginTop = typedArray.getDimension(R.styleable.NBtn_nb_divMarginTop, 0f)
        val divMarginBottom = typedArray.getDimension(R.styleable.NBtn_nb_divMarginBottom, 0f)
        val divMarginStart = typedArray.getDimension(R.styleable.NBtn_nb_divMarginStart, 0f)
        val divMarginEnd = typedArray.getDimension(R.styleable.NBtn_nb_divMarginEnd, 0f)
        val divVisibility = typedArray.getInt(R.styleable.NBtn_nb_divVisibility, View.VISIBLE)

        // Init button text
        val text = typedArray.getString(R.styleable.NBtn_nb_text)
        val textPaddingStart = typedArray.getDimension(R.styleable.NBtn_nb_textPaddingStart, 0f)
        val textPaddingTop = typedArray.getDimension(R.styleable.NBtn_nb_textPaddingTop, 0f)
        val textPaddingEnd = typedArray.getDimension(R.styleable.NBtn_nb_textPaddingEnd, 0f)
        val textPaddingBottom = typedArray.getDimension(R.styleable.NBtn_nb_textPaddingBottom, 0f)
        val fontRes = typedArray.getResourceId(R.styleable.NBtn_nb_fontFamilyRes, R.font.poppins)
        val textStyle = typedArray.getInt(R.styleable.NBtn_nb_textStyle, Typeface.BOLD)
        val textSize = typedArray.getDimension(R.styleable.NBtn_nb_textSize, txtPxToSp(16f))
        val textColor = typedArray.getColor(R.styleable.NBtn_nb_textColor, Color.WHITE)
        val textAllCaps = typedArray.getBoolean(R.styleable.NBtn_nb_textAllCaps, false)
        val textVisibility = typedArray.getInt(R.styleable.NBtn_nb_textVisibility, View.VISIBLE)

        // Init button
        val btnColor = typedArray.getColor(
            R.styleable.NBtn_nb_backgroundColor,
            ContextCompat.getColor(view.context, R.color.btn_primary_color)
        )
        val disableColor = typedArray.getColor(R.styleable.NBtn_nb_disableColor, 0)
        val elDisableColor = typedArray.getColor(R.styleable.NBtn_nb_disableElementsColor, 0)
        val enableRipple = typedArray.getBoolean(R.styleable.NBtn_nb_enableRipple, true)
        val rippleColor =
            typedArray.getColor(R.styleable.NBtn_nb_rippleColor, Color.parseColor("#42FFFFFF"))
        val shape = typedArray.getInt(R.styleable.NBtn_nb_shape, Shape.RECTANGLE.shape)
        val cornerRadius = typedArray.getDimension(
            R.styleable.NBtn_nb_cornerRadius, if (shape == Shape.ROUNDED.shape) {
                dpToPx(30f)
            } else {
                dpToPx(6f)
            }
        )
        val enable = typedArray.getBoolean(R.styleable.NBtn_android_enabled, true)
        val borderColor = typedArray.getColor(R.styleable.NBtn_nb_borderColor, Color.TRANSPARENT)
        val borderWidth = typedArray.getDimension(R.styleable.NBtn_nb_borderWidth, 0f)
        val elevation = typedArray.getDimension(R.styleable.NBtn_nb_shadow, dpToPx(2f))
        val isLoader = typedArray.getBoolean(R.styleable.NBtn_nb_isLoader, false)
        val isStroke = typedArray.getBoolean(R.styleable.NBtn_nb_isStorke, false)
        var height = 0
        var width = 0
        val layoutHeight =
            attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height")
        val layoutWidth =
            attrs?.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_width")

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
        button = NitrozenButton(
            icon,
            iconColor,
            iconWidth,
            iconHeight,
            iconMarginStart,
            iconMarginTop,
            iconMarginEnd,
            iconMarginBottom,
            IconPosition.values().first { ic -> ic.position == iconPosition },
            iconVisibility,
            divColor,
            divWidth,
            divHeight,
            divMarginTop,
            divMarginBottom,
            divMarginStart,
            divMarginEnd,
            divVisibility,
            text,
            textPaddingStart,
            textPaddingTop,
            textPaddingEnd,
            textPaddingBottom,
            fontRes,
            null,
            textStyle,
            textSize,
            textColor,
            textAllCaps,
            textVisibility,
            width,
            height,
            btnColor,
            disableColor,
            elDisableColor,
            cornerRadius,
            enableRipple,
            rippleColor,
            Shape.values().first { s -> s.shape == shape },
            enable,
            borderColor,
            borderWidth,
            elevation,
            isLoader,
            isStroke
        )

        typedArray.recycle()
    }

}