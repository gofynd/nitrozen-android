package com.fynd.nitrozen.components.radiobutton

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenRadioButtonStyle(
    val textColorUnselected: Color,
    val textColorSelected: Color,
    val colorUnselected: Color,
    val colorSelected: Color,
    val backgroundColor: Color,
    val textStyle: TextStyle,
) {
    companion object
}

val NitrozenRadioButtonStyle.Companion.Default: NitrozenRadioButtonStyle
    @Composable
    get() = NitrozenRadioButtonStyle(
        textColorUnselected = NitrozenTheme.colors.grey80,
        textColorSelected = NitrozenTheme.colors.grey100,
        colorSelected = NitrozenTheme.colors.primary50,
        colorUnselected = NitrozenTheme.colors.grey80,
        backgroundColor = NitrozenTheme.colors.background,
        textStyle = NitrozenTheme.typography.bodySmall,
    )
