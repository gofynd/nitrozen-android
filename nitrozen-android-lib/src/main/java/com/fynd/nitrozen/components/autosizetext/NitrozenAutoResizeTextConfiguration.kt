package com.fynd.nitrozen.components.autosizetext

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NitrozenAutoResizeTextConfiguration(
    val minFontSize: TextUnit,
    val maxLines: Int
) {
    companion object
}

val NitrozenAutoResizeTextConfiguration.Companion.Default: NitrozenAutoResizeTextConfiguration
    @Composable
    get() = NitrozenAutoResizeTextConfiguration(
        minFontSize = 12.sp,
        maxLines = 1
    )