package com.fynd.nitrozen.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

object NitrozenButtonConfiguration {

    data class Filled(
        val minHeight: Dp,
        val shape: Shape,
        val contentPadding: PaddingValues,
    ) {
        companion object
    }

    val Filled.Companion.Default: Filled
        @Composable
        get() = Filled(
            minHeight = 48.dp,
            shape = NitrozenTheme.shapes.pill,
            contentPadding = PaddingValues(horizontal = 16.dp)
        )

    data class Outlined(
        val minHeight: Dp,
        val shape: Shape,
        val contentPadding: PaddingValues,
    ) {
        companion object
    }

    val Outlined.Companion.Default: Outlined
        @Composable
        get() = Outlined(
            minHeight = 48.dp,
            shape = NitrozenTheme.shapes.pill,
            contentPadding = PaddingValues(horizontal = 16.dp)
        )

    data class Text(
        val minHeight: Dp,
        val shape: Shape,
        val contentPadding: PaddingValues,
    ) {
        companion object
    }

    val Text.Companion.Default: Text
        @Composable
        get() = Text(
            minHeight = 48.dp,
            shape = NitrozenTheme.shapes.pill,
            contentPadding = PaddingValues(horizontal = 16.dp)
        )
}