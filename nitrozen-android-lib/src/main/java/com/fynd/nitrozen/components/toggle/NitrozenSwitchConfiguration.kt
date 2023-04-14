package com.fynd.nitrozen.components.toggle

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NitrozenSwitchConfiguration(
    val width: Dp,
    val height: Dp,
    val thumbPadding : Dp
) {
    companion object
}

val NitrozenSwitchConfiguration.Companion.Default: NitrozenSwitchConfiguration
    get() = NitrozenSwitchConfiguration(
        width = 44.dp,
        height = 24.dp,
        thumbPadding = 4.dp
    )

val NitrozenSwitchConfiguration.Companion.Small: NitrozenSwitchConfiguration
    get() = NitrozenSwitchConfiguration(
        width = 28.dp,
        height = 16.dp,
        thumbPadding = 4.dp
    )
