package com.fynd.nitrozen.nitrozeninput.model

import android.graphics.drawable.Drawable
import android.view.ViewGroup

data class NitrozenInput(
    var layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    var layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT,
    var titleText: String? = null,
    var titleTextSize: Float,
    var placeHolderText: String? = null,
    var hintText: String? = null,
    var hintTextSize: Float,
    var leadingIcon: Drawable? = null,
    var trailingIcon: Drawable? = null,
    var isEnabled: Boolean = true,
    var isEditable: Boolean = true,
    var isFocused: Boolean = false,
    var showError: Boolean = false,
    var successText: String? = null,
    var showLoader: Boolean = false
)