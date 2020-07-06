package com.fynd.nitrozen.nitrozencheckbox.model

import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatSpinner

class NitrozenCheckBox {
    var text : String = ""
    var textSize : Float = 12f
    var layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT
    var layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT
    var isIndeterminate : Boolean = false
    var isEnabled : Boolean = false
}