package com.fynd.nitrozen.components.selector

sealed interface NitrozenSelectorItem {
    data class Text(val text: String) : NitrozenSelectorItem
}
