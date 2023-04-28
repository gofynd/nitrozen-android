package com.fynd.nitrozen.components.appbar

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NitrozenAppBarConfiguration(
    val minHeight: Dp,
    val leadingStartPadding: Dp,
    val trailingEndPadding: Dp,
    val titleStartPadding: Dp,
    val titleWithLeadingStartPadding: Dp,
) {
    companion object
}

val NitrozenAppBarConfiguration.Companion.Default
    get() = NitrozenAppBarConfiguration(
        minHeight = 64.dp,
        leadingStartPadding = 12.dp,
        trailingEndPadding = 16.dp,
        titleStartPadding = 28.dp,
        titleWithLeadingStartPadding = 16.dp,
    )
