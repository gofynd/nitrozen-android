package com.fynd.nitrozen.nitrozenautocomplete.model

import android.view.ViewGroup

data class NitrozenAutocomplete(
    var layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    var layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT,
    var hintText: String? = null
)