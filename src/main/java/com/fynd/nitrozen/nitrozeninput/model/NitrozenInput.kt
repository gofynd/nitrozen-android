package com.fynd.nitrozen.nitrozeninput.model

import android.graphics.drawable.Drawable
import android.text.InputFilter
import android.view.Gravity
import android.view.ViewGroup
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozenbutton.utils.txtPxToSp

data class NitrozenInput(
    var layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    var layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT,
    var text: String? = null,
    var textSize: Float = txtPxToSp(7f),
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
    var successText: String? = null,
    var errorText: String? = null,
    var showLoader: Boolean = false,
    var maxLines: Int = 1,
    var maxLength: Int = -1,
    var singeLine: Boolean = true,
    var ellipSize: Int? = null,
    var layoutGravity: Int? = null,
    var gravity: Int? = Gravity.CENTER_VERTICAL,
    var inputType: Int? = null,
    var imeOptions: Int? = null,
    var filters: Array<InputFilter> = arrayOf<InputFilter>()
)