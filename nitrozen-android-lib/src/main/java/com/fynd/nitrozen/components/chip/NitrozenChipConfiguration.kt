package com.fynd.nitrozen.components.chip

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenChipConfiguration(
    val borderWidth: Dp,
    val minWidth: Dp,
    val shape: Shape,
    val contentPadding: PaddingValues,
) {
    companion object
}

val NitrozenChipConfiguration.Companion.Default: NitrozenChipConfiguration
    @Composable
    get() = NitrozenChipConfiguration(
        borderWidth = 1.dp,
        minWidth = 45.dp,
        shape = NitrozenTheme.shapes.rounded80,
        contentPadding = PaddingValues(
            top = 4.dp,
            end = 8.dp,
            bottom = 4.dp,
            start = 8.dp
        ),
    )

