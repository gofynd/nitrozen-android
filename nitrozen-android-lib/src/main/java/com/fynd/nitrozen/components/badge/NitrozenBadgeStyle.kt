package com.fynd.nitrozen.components.badge

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenBadgeStyle(
    val textColor : Color,
    val backgroundColor : Color,
    val textStyle: TextStyle
){
    companion object
}

val NitrozenBadgeStyle.Companion.Default
    @Composable
    get() = NitrozenBadgeStyle(
        textStyle = NitrozenTheme.typography.bodyXsReg,
        backgroundColor = NitrozenTheme.colors.primary20,
        textColor = NitrozenTheme.colors.grey80
    )

