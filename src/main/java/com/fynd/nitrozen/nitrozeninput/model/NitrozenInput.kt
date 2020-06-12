package com.fynd.nitrozen.nitrozeninput.model

import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.view.ViewGroup
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp

data class NitrozenInput(
    var layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    var layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT,
    var text: String? = null,
    var textSize: Float = pxToDp(12f),
    var titleText: String? = null,
    var titleTextSize: Float,
    var placeHolderText: String? = null,
    var hintText: String? = null,
    var hintTextSize: Float,
    var leadingIcon: Drawable? = null,
    var leadingIconTint: Int,
    var leadingIconVisibility: Int,
    var trailingIcon: Drawable? = null,
    var trailingIconTint: Int,
    var trailingIconVisibility: Int,
    var isEnabled: Boolean = true,
    var isEditable: Boolean = true,
    var isFocused: Boolean = false,
    var showError: Boolean = false,
    var successText: String? = null,
    var errorText: String? = null,
    var showLoader: Boolean = false,
    var maxLines: Int = 1,
    var singeLine: Boolean = true,
    var ellipSize: Int? = null,
    var layoutGravity: Int? = null,
    var gravity: Int? = null,
    var inputType: Int? = null,
    var imeOptions: Int? = null,
    var filters: Array<InputFilter> = arrayOf<InputFilter>()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NitrozenInput

        if (layoutHeight != other.layoutHeight) return false
        if (layoutWidth != other.layoutWidth) return false
        if (text != other.text) return false
        if (textSize != other.textSize) return false
        if (titleText != other.titleText) return false
        if (titleTextSize != other.titleTextSize) return false
        if (placeHolderText != other.placeHolderText) return false
        if (hintText != other.hintText) return false
        if (hintTextSize != other.hintTextSize) return false
        if (leadingIcon != other.leadingIcon) return false
        if (leadingIconTint != other.leadingIconTint) return false
        if (leadingIconVisibility != other.leadingIconVisibility) return false
        if (trailingIcon != other.trailingIcon) return false
        if (trailingIconTint != other.trailingIconTint) return false
        if (trailingIconVisibility != other.trailingIconVisibility) return false
        if (isEnabled != other.isEnabled) return false
        if (isEditable != other.isEditable) return false
        if (isFocused != other.isFocused) return false
        if (showError != other.showError) return false
        if (successText != other.successText) return false
        if (errorText != other.errorText) return false
        if (showLoader != other.showLoader) return false
        if (maxLines != other.maxLines) return false
        if (singeLine != other.singeLine) return false
        if (ellipSize != other.ellipSize) return false
        if (layoutGravity != other.layoutGravity) return false
        if (gravity != other.gravity) return false
        if (inputType != other.inputType) return false
        if (imeOptions != other.imeOptions) return false
        if (!filters.contentEquals(other.filters)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = layoutHeight
        result = 31 * result + layoutWidth
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + textSize.hashCode()
        result = 31 * result + (titleText?.hashCode() ?: 0)
        result = 31 * result + titleTextSize.hashCode()
        result = 31 * result + (placeHolderText?.hashCode() ?: 0)
        result = 31 * result + (hintText?.hashCode() ?: 0)
        result = 31 * result + hintTextSize.hashCode()
        result = 31 * result + (leadingIcon?.hashCode() ?: 0)
        result = 31 * result + leadingIconTint
        result = 31 * result + leadingIconVisibility
        result = 31 * result + (trailingIcon?.hashCode() ?: 0)
        result = 31 * result + trailingIconTint
        result = 31 * result + trailingIconVisibility
        result = 31 * result + isEnabled.hashCode()
        result = 31 * result + isEditable.hashCode()
        result = 31 * result + isFocused.hashCode()
        result = 31 * result + showError.hashCode()
        result = 31 * result + (successText?.hashCode() ?: 0)
        result = 31 * result + (errorText?.hashCode() ?: 0)
        result = 31 * result + showLoader.hashCode()
        result = 31 * result + maxLines
        result = 31 * result + singeLine.hashCode()
        result = 31 * result + (ellipSize ?: 0)
        result = 31 * result + (layoutGravity ?: 0)
        result = 31 * result + (gravity ?: 0)
        result = 31 * result + (inputType ?: 0)
        result = 31 * result + (imeOptions ?: 0)
        result = 31 * result + filters.contentHashCode()
        return result
    }
}