package com.fynd.nitrozen.nitrozeninput

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import com.fynd.nitrozen.nitrozeninput.view.NitrozenEditText

class NInput : LinearLayout {

    private var manager: DrawManager? = null

    constructor(context: Context) : super(context) {
        bind(null)
        orientation = VERTICAL
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        bind(attrs)
        orientation = VERTICAL
    }

    override fun getOrientation(): Int {
        return VERTICAL
    }

    private fun bind(attrs: AttributeSet?) {
        manager = DrawManager(this, attrs)
        manager?.draw()
        val params =
            LayoutParams(
                manager!!.getInput().layoutWidth,
                manager!!.getInput().layoutHeight
            )
        layoutParams = params
        if (manager != null) {
            if (!manager!!.getInput().isEnabled) {
                alpha = 0.5f
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    fun setLayoutHeight(layoutHeight: Int): NInput {
        manager!!.getInput().layoutHeight = layoutHeight
        updateView()
        return this
    }

    fun getLayoutHeight(): Int = manager!!.getInput().layoutHeight


    fun setLayoutWidth(layoutWidth: Int): NInput {
        manager!!.getInput().layoutWidth = layoutWidth
        updateView()
        return this
    }

    fun getLayoutWidth(): Int = manager!!.getInput().layoutWidth

    fun getEditText(): AppCompatEditText {
        return manager!!.getEditText()
    }

    fun setLeadingIconVisibility(visibility: Int): NInput {
        manager!!.getInput().leadingIconVisibility = visibility
        updateView()
        return this
    }

    fun setNiMinimumHeight(minimumHeight: Float): NInput {
        manager!!.getInput().miniumHeight = minimumHeight
        updateView()
        return this
    }

    fun setTrailingIconVisibility(visibility: Int): NInput {
        manager!!.getInput().trailingIconVisibility = visibility
        updateView()
        return this
    }

    fun setDrawableClickListener(listener: NitrozenEditText.DrawableClickListener) {
        return manager!!.editTextDrawer.setDrawableClickListener(listener)
    }

    fun addTextChangedListener(watcher: TextWatcher) {
        return manager!!.editTextDrawer.getEditText().addTextChangedListener(watcher)
    }

    fun removeTextChangedListener(watcher: TextWatcher) {
        return manager!!.editTextDrawer.getEditText().removeTextChangedListener(watcher)
    }

    fun getText(): String {
        return manager!!.getEditText().text.toString()
    }

    fun setText(text: String?): NInput {
        manager!!.setText(text)
        updateView()
        return this
    }

    fun setTitleText(titleText: String?): NInput {
        manager!!.getInput().titleText = titleText
        updateView()
        return this
    }

    fun setMaxLines(maxLines: Int): NInput {
        manager!!.getInput().maxLines = maxLines
        updateView()
        return this
    }

    fun setSingleLine(singeLine: Boolean): NInput {
        manager!!.getInput().singeLine = singeLine
        updateView()
        return this
    }

    fun setMaxLength(maxLength: Int): NInput {
        manager!!.getInput().maxLength = maxLength
        updateView()
        return this
    }

    fun setInputType(inputType: Int): NInput {
        manager!!.getInput().inputType = inputType
        updateView()
        return this
    }

    fun setFilters(filters: Array<InputFilter>): NInput {
        manager!!.getInput().filters = filters
        updateView()
        return this
    }

    fun getTitleText(): String? = manager!!.getInput().titleText

    fun setTitleTextSize(titleTextSize: Float): NInput {
        manager!!.getInput().titleTextSize = titleTextSize
        updateView()
        return this
    }

    fun getTitleTextSize(): Float = manager!!.getInput().titleTextSize

    fun setPlaceHolderText(placeHolderText: String?): NInput {
        manager!!.getInput().hintText = placeHolderText
        updateView()
        return this
    }

    fun getPlaceHolderText(): String? = manager!!.getInput().placeHolderText

    fun setHintText(hintText: String?): NInput {
        manager!!.getInput().hintText = hintText
        updateView()
        return this
    }

    fun getHintText(): String? = manager!!.getInput().hintText

    fun setHintTextSize(hintTextSize: Float): NInput {
        manager!!.getInput().hintTextSize = hintTextSize
        updateView()
        return this
    }

    fun getHintTextSize(): Float = manager!!.getInput().hintTextSize

    fun setLeadingIcon(leadingIcon: Drawable?): NInput {
        manager!!.getInput().leadingIcon = leadingIcon
        updateView()
        return this
    }

    fun getLeadingIcon(): Drawable? = manager!!.getInput().leadingIcon

    fun setTrailingIcon(trailingIcon: Drawable?): NInput {
        manager!!.getInput().trailingIcon = trailingIcon
        updateView()
        return this
    }

    fun getTrailingIcon(): Drawable? = manager!!.getInput().trailingIcon

    fun setIsEnabled(isEnabled: Boolean): NInput {
        manager!!.getInput().isEnabled = isEnabled
        updateView()
        return this
    }

    fun getIsEnabled(): Boolean = manager!!.getInput().isEnabled

    fun setIsEditable(isEditable: Boolean): NInput {
        manager!!.getInput().isEditable = isEditable
        updateView()
        return this
    }

    fun getIsEditable(): Boolean = manager!!.getInput().isEditable

    fun setIsFocused(isFocused: Boolean): NInput {
        manager!!.getInput().isFocused = isFocused
        updateView()
        return this
    }

    fun getIsFocused(): Boolean = manager!!.getInput().isFocused

    fun getSuccessText(): String = manager!!.getInput().successText ?: ""

    fun setSuccessText(text: String): NInput {
        manager!!.getInput().successText = text
        updateView()
        return this
    }

    fun getShowLoader(): Boolean = manager!!.getInput().showLoader

    fun setShowLoader(showLoader: Boolean): NInput {
        manager!!.getInput().showLoader = showLoader
        updateView()
        return this
    }

    fun isNullOrEmpty(message: String, requestFocus: Boolean = true): Boolean {
        return if (manager!!.getEditText().text.isNullOrEmpty()) {
            setErrorText(message)
            if (requestFocus) {
                manager!!.getEditText().showKeyboard()
            }
            true
        } else {
            setErrorText("")
            manager!!.getEditText().clearFocus()
            false
        }
    }

    fun AppCompatEditText.showKeyboard() {
        post {
            requestFocus()
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun setErrorText(errorText: String?): NInput {
        manager!!.getInput().errorText = errorText
        updateView()
        return this
    }

    fun getErrorText(): String? {
        return manager!!.getInput().errorText
    }

    private fun updateView() {
        requestLayout()
    }
}