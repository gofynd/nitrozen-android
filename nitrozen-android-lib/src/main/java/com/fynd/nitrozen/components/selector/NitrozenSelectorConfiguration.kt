package com.fynd.nitrozen.components.selector

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NitrozenSelectorConfiguration(
    val itemPaddingTop: Dp,
    val itemPaddingBottom: Dp,
    val contentPadding: PaddingValues,
    val spaceBetweenItems: Dp,
) {
    companion object
}

val NitrozenSelectorConfiguration.Companion.Default: NitrozenSelectorConfiguration
    @Composable
    get() = NitrozenSelectorConfiguration(
        itemPaddingTop = 8.dp,
        itemPaddingBottom = 8.dp,
        contentPadding = PaddingValues(4.dp),
        spaceBetweenItems = 4.dp,
    )
