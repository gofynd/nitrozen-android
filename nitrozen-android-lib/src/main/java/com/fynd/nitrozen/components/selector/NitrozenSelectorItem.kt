package com.fynd.nitrozen.components.selector

import androidx.annotation.DrawableRes

sealed interface NitrozenSelectorItem {
    data class Text(val text: String) : NitrozenSelectorItem

    data class Icon(
        @DrawableRes val icon: Int,
        val contentDescription: String? = null
    ) : NitrozenSelectorItem

    data class IconText(
        val text: String,
        @DrawableRes val icon: Int,
        val contentDescription: String? = null
    ) : NitrozenSelectorItem
}
