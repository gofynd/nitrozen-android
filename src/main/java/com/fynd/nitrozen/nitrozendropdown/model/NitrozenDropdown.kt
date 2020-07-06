package com.fynd.nitrozen.nitrozendropdown.model

import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatSpinner

class NitrozenDropdown {
    var layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT
    var layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT
    var titleText: String? = null
    var titleTextSize: Float = 12f
    var isFocused: Boolean = false
    var showLoader: Boolean = false
    var placeHolder: String = "Placeholder"
    var placeHolderTextSize: Float = 12f
    var spinner: AppCompatSpinner? = null
    var errorText: String? = null
    var editable: Boolean = true
    var enabled: Boolean = true
}