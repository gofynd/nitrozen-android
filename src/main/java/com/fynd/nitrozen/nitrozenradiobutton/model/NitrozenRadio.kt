package com.fynd.nitrozen.nitrozenradiobutton.model

import android.graphics.drawable.Drawable
import android.view.ViewGroup

data class NitrozenRadio(
    var layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    var layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT,
    var text: String? = null,
    var textSize: Float=12f,
    var isEnabled: Boolean = true
)