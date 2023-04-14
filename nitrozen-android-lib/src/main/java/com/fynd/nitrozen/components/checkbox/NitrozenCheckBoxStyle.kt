package com.fynd.nitrozen.components.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenCheckBoxStyle(
    val checkedColor: Color,
    val uncheckedColor: Color,
    val checkmarkColor: Color,
    val textColor: Color,
    val textStyle: TextStyle,
) {
    companion object
}

val NitrozenCheckBoxStyle.Companion.Default: NitrozenCheckBoxStyle
    @Composable
    get() = NitrozenCheckBoxStyle(
        checkmarkColor = NitrozenTheme.colors.background,
        checkedColor = NitrozenTheme.colors.primary50,
        uncheckedColor = NitrozenTheme.colors.grey80,
        textColor = NitrozenTheme.colors.grey100,
        textStyle = NitrozenTheme.typography.bodySmall,
    )