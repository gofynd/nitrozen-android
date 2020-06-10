package com.fynd.nitrozen.nitrozenbutton

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.FontRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.nitrozenbutton.model.IconPosition
import com.fynd.nitrozen.nitrozenbutton.model.Shape
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozenbutton.utils.getDensity
import com.fynd.nitrozen.nitrozenbutton.utils.txtPxToSp

class NBtn : LinearLayout {

    private var manager: DrawManager? = null

    constructor(context: Context) : super(context) {
        bind(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        bind(attrs)
    }

    private fun bind(attrs: AttributeSet?) {
        manager = DrawManager(this, attrs)
        manager?.drawButton()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    /**
     * Get the button icon
     * @return icon [Drawable]
     */
    fun getIcon(): Drawable? = manager!!.getButton().icon

    /**
     * Set an icon for the button
     * @param drawable [Drawable]
     */
    fun setIcon(drawable: Drawable): NBtn {
        manager!!.getButton().icon = drawable
        updateView()
        return this
    }

    /**
     * Get the button icon color
     * @return icon color [Int]
     */
    fun getIconColor(): Int = manager!!.getButton().iconColor

    /**
     * Set the button icon color
     * @param iconColor [Int]
     */
    fun setIconColor(iconColor: Int): NBtn {
        manager!!.getButton().iconColor = iconColor
        updateView()
        return this
    }

    /**
     * Get the button icon width
     * @return icon width [Float]
     */
    fun getIconWidth(): Float = manager!!.getButton().iconWidth

    /**
     * Set the button icon width
     * @param iconWidth [Float]
     */
    fun setIconWidth(iconWidth: Float): NBtn {
        manager!!.getButton().iconWidth = dpToPx(iconWidth)
        updateView()
        return this
    }

    /**
     * Get the button icon height
     * @return icon height [Float]
     */
    fun getIconHeight(): Float = manager!!.getButton().iconHeight

    /**
     * Set the button icon height
     * @param iconHeight [Float]
     */
    fun setIconHeight(iconHeight: Float): NBtn {
        manager!!.getButton().iconHeight = dpToPx(iconHeight)
        updateView()
        return this
    }

    /**
     * Get an icon start margin
     * @return icon start margin [Float]
     */
    fun getIconMarginStart(): Float = manager!!.getButton().iconMarginStart

    /**
     * Set an icon start margin
     * @param iconMarginStart [Float]
     */
    fun setIconMarginStart(iconMarginStart: Float): NBtn {
        manager!!.getButton().iconMarginStart = dpToPx(iconMarginStart)
        updateView()
        return this
    }

    /**
     * Get an icon top margin
     * @return icon top margin [Float]
     */
    fun getIconMarginTop(): Float = manager!!.getButton().iconMarginTop

    /**
     * Set an icon top margin
     * @param iconMarginTop [Float]
     */
    fun setIconMarginTop(iconMarginTop: Float): NBtn {
        manager!!.getButton().iconMarginTop = dpToPx(iconMarginTop)
        updateView()
        return this
    }

    /**
     * Get an icon end margin
     * @return icon end margin [Float]
     */
    fun getIconMarginEnd(): Float = manager!!.getButton().iconMarginEnd

    /**
     * Set an icon end margin
     * @param iconMarginEnd [Float]
     */
    fun setIconMarginEnd(iconMarginEnd: Float): NBtn {
        manager!!.getButton().iconMarginEnd = dpToPx(iconMarginEnd)
        updateView()
        return this
    }

    /**
     * Get an icon bottom margin
     * @return icon bottom margin [Float]
     */
    fun getIconMarginBottom(): Float = manager!!.getButton().iconMarginBottom

    /**
     * Set an icon bottom margin
     * @param iconMarginBottom [Float]
     */
    fun setIconMarginBottom(iconMarginBottom: Float): NBtn {
        manager!!.getButton().iconMarginBottom = dpToPx(iconMarginBottom)
        updateView()
        return this
    }

    /**
     * Get an icon position relative to other elements on the button
     * @return icon position [IconPosition]
     */
    fun getIconPosition(): IconPosition = manager!!.getButton().iconPosition

    /**
     * Set an icon position relative to other elements on the button
     * @param iconPosition [IconPosition]
     */
    fun setIconPosition(iconPosition: IconPosition): NBtn {
        manager!!.getButton().iconPosition = iconPosition
        updateView()
        return this
    }

    /**
     * Get an icon visibility. Uses the [View] constants VISIBLE, INVISIBLE, GONE
     * @return icon visibility [Int]
     */
    fun getIconVisibility(): Int = manager!!.getButton().iconVisibility

    /**
     * Set an icon visibility.
     * Uses the [View] constants VISIBLE, INVISIBLE, GONE
     * If you want set GONE for icon and divider was VISIBLE,
     * it's will be set GONE too.
     * But if you want to show divider without an icon,
     * please use INVISIBLE for this case
     * @param iconVisibility [IconPosition]
     */
    fun setIconVisibility(iconVisibility: Int): NBtn {
        manager!!.getButton().iconVisibility = iconVisibility
        updateView()
        return this
    }

    /**
     * Get the divider color
     * @return divider color [Int]
     */
    fun getDividerColor(): Int = manager!!.getButton().divColor

    /**
     * Set the divider color
     * @param divColor [Int]
     */
    fun setDividerColor(divColor: Int): NBtn {
        manager!!.getButton().divColor = divColor
        updateView()
        return this
    }

    /**
     * Get the divider width
     * @return divider width [Float]
     */
    fun getDividerWidth(): Float = manager!!.getButton().divWidth

    /**
     * Set the divider width
     * @param divWidth [Float]
     */
    fun setDividerWidth(divWidth: Float): NBtn {
        manager!!.getButton().divWidth = dpToPx(divWidth)
        updateView()
        return this
    }

    /**
     * Get the divider height
     * @return divider height [Float]
     */
    fun getDividerHeight(): Float = manager!!.getButton().divHeight

    /**
     * Set the divider height
     * @param divHeight [Float]
     */
    fun setDividerHeight(divHeight: Float): NBtn {
        manager!!.getButton().divHeight = dpToPx(divHeight)
        updateView()
        return this
    }

    /**
     * Get the divider top margin
     * @return divider top margin [Float]
     */
    fun getDividerMarginTop(): Float = manager!!.getButton().divMarginTop

    /**
     * Set the divider top margin
     * @param divMarginTop [Float]
     */
    fun setDividerMarginTop(divMarginTop: Float): NBtn {
        manager!!.getButton().divMarginTop = dpToPx(divMarginTop)
        updateView()
        return this
    }

    /**
     * Get the divider bottom margin
     * @return divider bottom margin [Float]
     */
    fun getDividerMarginBottom(): Float = manager!!.getButton().divMarginBottom

    /**
     * Set the divider bottom margin
     * @param divMarginBottom [Float]
     */
    fun setDividerMarginBottom(divMarginBottom: Float): NBtn {
        manager!!.getButton().divMarginBottom = dpToPx(divMarginBottom)
        updateView()
        return this
    }

    /**
     * Get the divider start margin
     * @return divider start margin [Float]
     */
    fun getDividerMarginStart(): Float = manager!!.getButton().divMarginStart

    /**
     * Set the divider start margin
     * @param divMarginStart [Float]
     */
    fun setDividerMarginStart(divMarginStart: Float): NBtn {
        manager!!.getButton().divMarginStart = dpToPx(divMarginStart)
        updateView()
        return this
    }

    /**
     * Get the divider end margin
     * @return divider end margin [Float]
     */
    fun getDividerMarginEnd(): Float = manager!!.getButton().divMarginEnd

    /**
     * Set the divider end margin
     * @param divMarginEnd [Float]
     */
    fun setDividerMarginEnd(divMarginEnd: Float): NBtn {
        manager!!.getButton().divMarginEnd = dpToPx(divMarginEnd)
        updateView()
        return this
    }

    /**
     * Get the divider visibility.
     * Uses the [View] constants VISIBLE, INVISIBLE, GONE
     * @return divider visibility [Int]
     */
    fun getDividerVisibility(): Int = manager!!.getButton().divVisibility

    /**
     * Set the divider visibility
     * If you want set GONE for icon and divider was VISIBLE,
     * it's will be set GONE too.
     * But if you want to show divider without an icon,
     * please use an icon INVISIBLE for this case
     * @param divVisibility [Int]
     */
    fun setDividerVisibility(divVisibility: Int): NBtn {
        manager!!.getButton().divVisibility = divVisibility
        updateView()
        return this
    }

    /**
     * Get the button text
     * @return text [String]
     */
    fun getText(): String? = manager!!.getButton().text

    /**
     * Set the button text
     * @param text [String]
     */
    fun setText(text: String?): NBtn {
        manager!!.getButton().text = text
        updateView()
        return this
    }

    /**
     * Set the button text using string res Id
     * @param resId [String]
     */
    fun setText(@StringRes resId: Int): NBtn {
        manager!!.getButton().text = resources.getString(resId)
        updateView()
        return this
    }

    /**
     * Get the button text start padding
     * @return text start padding [Float]
     */
    fun getTextPaddingStart(): Float = manager!!.getButton().textPaddingStart

    /**
     * Set the button text start padding
     * @param textPaddingStart [Float]
     */
    fun setTextPaddingStart(textPaddingStart: Float): NBtn {
        manager!!.getButton().textPaddingStart = dpToPx(textPaddingStart)
        updateView()
        return this
    }

    /**
     * Get the button text top padding
     * @return text top padding [Float]
     */
    fun getTextPaddingTop(): Float = manager!!.getButton().textPaddingTop

    /**
     * Set the button text top padding
     * @param textPaddingTop [Float]
     */
    fun setTextPaddingTop(textPaddingTop: Float): NBtn {
        manager!!.getButton().textPaddingTop = dpToPx(textPaddingTop)
        updateView()
        return this
    }

    /**
     * Get the button text end padding
     * @return text end padding [Float]
     */
    fun getTextPaddingEnd(): Float = manager!!.getButton().textPaddingEnd

    /**
     * Set the button text top padding
     * @param textPaddingEnd [Float]
     */
    fun setTextPaddingEnd(textPaddingEnd: Float): NBtn {
        manager!!.getButton().textPaddingEnd = dpToPx(textPaddingEnd)
        updateView()
        return this
    }

    /**
     * Get the button text bottom padding
     * @return text bottom padding [Float]
     */
    fun getTextPaddingBottom(): Float = manager!!.getButton().textPaddingBottom

    /**
     * Set the button text bottom padding
     * @param textPaddingBottom [Float]
     */
    fun setTextPaddingBottom(textPaddingBottom: Float): NBtn {
        manager!!.getButton().textPaddingBottom = dpToPx(textPaddingBottom)
        updateView()
        return this
    }

    /**
     * Get the button text font
     * @return text font [Typeface]
     */
    fun getTextTypeface(): Typeface? = manager!!.getButton().textFont

    /**
     * Set the button text font
     * If a Typeface [NBtn] was installed then it font will be used,
     * otherwise uses [NBtn] fontRes
     * @param textFont [Typeface]
     */
    fun setTextTypeface(textFont: Typeface?): NBtn {
        manager!!.getButton().textFont = textFont
        updateView()
        return this
    }

    /**
     * Set the button text font from font resources, e.g. res/font/example.ttf
     * Method [setTextTypeface] have priority
     * @param resId [FontRes]
     */
    fun setTextFont(@FontRes resId: Int): NBtn {
        manager!!.getButton().fontRes = resId
        manager!!.getButton().textFont = ResourcesCompat.getFont(context, resId)
        updateView()
        return this
    }

    /**
     * Get the button text style. By default uses [Typeface.NORMAL]
     * @return text style [Int]
     */
    fun getTextStyle(): Int = manager!!.getButton().textStyle

    /**
     * Set the button text style. Use values from [Typeface]
     * @param textStyle [Int]
     */
    fun setTextStyle(textStyle: Int): NBtn {
        manager!!.getButton().textStyle = textStyle
        updateView()
        return this
    }

    /**
     * Get the button text size
     * @return text size [Float]
     */
    fun getTextSize(): Float = manager!!.getButton().textSize

    /**
     * Set the button text size
     * @param textSize [Float]
     */
    fun setTextSize(textSize: Float): NBtn {
        manager!!.getButton().textSize = txtPxToSp(textSize)
        updateView()
        return this
    }

    /**
     * Get the button text color
     * @return text color [Int]
     */
    fun getTextColor(): Int = manager!!.getButton().textColor

    /**
     * Set the button text color
     * @param textColor [Int]
     */
    fun setTextColor(textColor: Int): NBtn {
        manager!!.getButton().textColor = textColor
        updateView()
        return this
    }

    /**
     * Get the text all caps state
     * @return text all caps [Boolean]
     */
    fun isTextAllCaps(): Boolean = manager!!.getButton().textAllCaps

    /**
     * Set the button text all caps
     * @param textAllCaps [Boolean]
     */
    fun setTextAllCaps(textAllCaps: Boolean): NBtn {
        manager!!.getButton().textAllCaps = textAllCaps
        updateView()
        return this
    }

    /**
     * Get a text visibility.
     * Uses the [View] constants VISIBLE, INVISIBLE, GONE
     * @return text visibility [Int]
     */
    fun getTextVisibility(): Int = manager!!.getButton().textVisibility

    /**
     * Set a text visibility.
     * Uses the [View] constants VISIBLE, INVISIBLE, GONE
     * @param textVisibility [Int]
     */
    fun setTextVisibility(textVisibility: Int): NBtn {
        manager!!.getButton().textVisibility = textVisibility
        updateView()
        return this
    }

    /**
     * Set button width in dp
     */
    fun setWidth(width: Int): NBtn {
        val w = (width * getDensity()).toInt()
        manager!!.getButton().width = w
        layoutParams.width = w
        updateView()
        return this
    }

    /**
     * Set button height in dp
     */
    fun setHeight(height: Int): NBtn {
        val h = (height * getDensity()).toInt()
        manager!!.getButton().height = h
        layoutParams.height = h
        updateView()
        return this
    }

    /**
     * Get the button background color
     * @return button background color [Int]
     */
    fun getButtonColor(): Int = manager!!.getButton().btnColor

    /**
     * Set the button background color
     * @param btnColor [Int]
     */
    fun setButtonColor(btnColor: Int): NBtn {
        manager!!.getButton().btnColor = btnColor
        updateView()
        return this
    }

    /**
     * Get the disabled background and border color of the button
     * @return disabled color [Int]
     */
    fun getDisabledColor(): Int = manager!!.getButton().disableColor

    /**
     * Set the button disabled background and border color
     * @param color [Int]
     */
    fun setDisabledButtonColor(color: Int): NBtn {
        manager!!.getButton().disableColor = color
        updateView()
        return this
    }

    /**
     * Get the disabled color of button elements
     * @return disabled color [Int]
     */
    fun getElementsDisabledColor(): Int = manager!!.getButton().elementsDisableColor

    /**
     * Set the disabled color of button elements
     * @param color [Int]
     */
    fun setElementsDisabledButtonColor(color: Int): NBtn {
        manager!!.getButton().elementsDisableColor = color
        updateView()
        return this
    }

    /**
     * Get the button corner radius
     * @return button corner radius [Float]
     */
    fun getCornerRadius(): Float = manager!!.getButton().cornerRadius

    /**
     * Set the button corner radius
     * @param cornerRadius [Float]
     */
    fun setCornerRadius(cornerRadius: Float): NBtn {
        manager!!.getButton().cornerRadius = dpToPx(cornerRadius)
        updateView()
        return this
    }

    /**
     * Check the button ripple effect state - enable/disable
     * @return ripple effect state [Boolean]
     */
    fun isRippleEnable(): Boolean = manager!!.getButton().enableRipple

    /**
     * Set the button ripple effect state enable/disable
     * @param enableRipple [Boolean]
     */
    fun setRippleEnable(enableRipple: Boolean): NBtn {
        manager!!.getButton().enableRipple = enableRipple
        updateView()
        return this
    }

    /**
     * Get the button ripple effect color
     * @return ripple effect color [Int]
     */
    fun getRippleColor(): Int = manager!!.getButton().rippleColor

    /**
     * Set the button ripple effect color
     * @param rippleColor [Int]
     */
    fun setRippleColor(rippleColor: Int): NBtn {
        manager!!.getButton().rippleColor = rippleColor
        updateView()
        return this
    }

    /**
     * Get the button shape. By default uses [Shape.RECTANGLE]
     * @return button shape [Shape]
     */
    fun getButtonShape(): Shape = manager!!.getButton().btnShape

    /**
     * Set the button shape
     * @param btnShape [Shape]
     */
    fun setButtonShape(btnShape: Shape): NBtn {
        manager!!.getButton().btnShape = btnShape
        updateView()
        return this
    }

    /**
     * Get the button border color
     * @return border color [Int]
     */
    fun getBorderColor(): Int = manager!!.getButton().borderColor

    /**
     * Set the button border color
     * @param borderColor [Int]
     */
    fun setBorderColor(borderColor: Int): NBtn {
        manager!!.getButton().borderColor = borderColor
        updateView()
        return this
    }

    /**
     * Get the button border width
     * @return border width [Float]
     */
    fun getBorderWidth(): Float = manager!!.getButton().borderWidth

    /**
     * Set the button border width
     * @param borderWidth [Float]
     */
    fun setBorderWidth(borderWidth: Float): NBtn {
        manager!!.getButton().borderWidth = dpToPx(borderWidth)
        updateView()
        return this
    }

    /**
     * Get shadow elevation
     * @return elevation [Float]
     */
    fun getShadow(): Float = manager!!.getButton().elevation

    /**
     * Set shadow elevation
     * Support SDK Lollipop+
     * @param elevation [Float]
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun setShadow(elevation: Float): NBtn {
        manager!!.getButton().elevation = dpToPx(elevation)
        updateView()
        return this
    }

    override fun isEnabled(): Boolean {
        return manager!!.getButton().enable
    }

    fun setIsLoader(flag: Boolean): NBtn {
        manager!!.getButton().isLoader = flag
        updateView()
        return this
    }

    fun getIsLoader(): Boolean {
        return manager!!.getButton().isLoader
    }

    /**
     * Set the button enabled state.
     * @param enabled [Boolean]
     */
    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        manager!!.getButton().enable = enabled
        requestLayout()
    }

    // Update the button and all elements on it
    private fun updateView() {
        requestLayout()
    }

}