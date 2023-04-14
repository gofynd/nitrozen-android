package com.fynd.nitrozen.components.toggle

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenSwitchStyle(
    val checkedThumbColor : Color,
    val checkedTrackBorderColor : Color,
    val checkedTrackColor : Color,
    val uncheckedBorderTrackColor : Color,
    val uncheckedThumbColor : Color,
    val uncheckedTrackColor : Color,
    val strokeWidth : Dp,
){
    companion object{
        val Default : NitrozenSwitchStyle
            @Composable
            get() = NitrozenSwitchStyle(
                checkedThumbColor = NitrozenTheme.colors.background,
                checkedTrackBorderColor = NitrozenTheme.colors.primary50,
                checkedTrackColor = NitrozenTheme.colors.primary50,
                uncheckedBorderTrackColor = NitrozenTheme.colors.grey80,
                uncheckedThumbColor = NitrozenTheme.colors.grey80,
                uncheckedTrackColor = NitrozenTheme.colors.background,
                strokeWidth = 1.dp,
            )
    }
}
