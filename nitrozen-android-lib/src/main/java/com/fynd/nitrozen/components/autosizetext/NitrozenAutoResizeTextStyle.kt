package com.fynd.nitrozen.components.autosizetext

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenAutoResizeTextStyle(
    val textStyle : TextStyle,
    val textColor: Color
){
    companion object
}

val NitrozenAutoResizeTextStyle.Companion.Default
    @Composable
    get() = NitrozenAutoResizeTextStyle(
        textStyle = NitrozenTheme.typography.bodyMediumBold,
        textColor = NitrozenTheme.colors.inverse
    )