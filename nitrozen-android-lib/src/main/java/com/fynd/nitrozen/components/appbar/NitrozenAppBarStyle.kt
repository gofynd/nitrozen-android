package com.fynd.nitrozen.components.appbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenAppBarStyle(
    val backgroundColor: Color,
    val titleTextStyle: TextStyle,
    val titleTextColor: Color,
) {
    companion object
}

val NitrozenAppBarStyle.Companion.Default
    @Composable
    get() = NitrozenAppBarStyle(
        backgroundColor = NitrozenTheme.colors.primary50,
        titleTextStyle = NitrozenTheme.typography.bodySmall,
        titleTextColor = NitrozenTheme.colors.background,
    )
