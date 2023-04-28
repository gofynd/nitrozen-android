package com.fynd.nitrozen.components.divider

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenDividerStyle(
    val shape: Shape,
    val backgroundColor : Color
){
    companion object
}

val NitrozenDividerStyle.Companion.Default
    @Composable
    get() = NitrozenDividerStyle(
        shape = NitrozenTheme.shapes.round,
        backgroundColor = NitrozenTheme.colors.grey40
    )