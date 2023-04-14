package com.fynd.nitrozen.components.chip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenChipStyle(
    val backgroundColor: Color,
    val borderColor: Color,
    val textColor: Color,
    val textStyle: TextStyle,
) {
    companion object
}

val NitrozenChipStyle.Companion.Default: NitrozenChipStyle
    @Composable
    get() = NitrozenChipStyle(
        backgroundColor = NitrozenTheme.colors.primary20,
        borderColor = NitrozenTheme.colors.primary40,
        textColor = NitrozenTheme.colors.grey100,
        textStyle = NitrozenTheme.typography.bodySmallRegular,
    )
