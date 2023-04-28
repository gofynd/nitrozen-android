package com.fynd.nitrozen.components.selector

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenSelectorStyle(
    val backgroundColor: Color,
    val selectedBackgroundColor: Color,
    val textColor: Color,
    val selectedTextColor: Color,
    val textStyle: TextStyle,
) {
    companion object
}

val NitrozenSelectorStyle.Companion.Default: NitrozenSelectorStyle
    @Composable
    get() = NitrozenSelectorStyle(
        backgroundColor = NitrozenTheme.colors.grey20,
        selectedBackgroundColor = NitrozenTheme.colors.primary50,
        textColor = NitrozenTheme.colors.primary60,
        selectedTextColor = NitrozenTheme.colors.inverse,
        textStyle = NitrozenTheme.typography.bodySmall,
    )
