package com.fynd.nitrozen.components.autosizetext

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenAutoResizeTextStyle(
    val textStyle : TextStyle,
    val textColor: Color,
    val textDecoration: TextDecoration? = null,
){
    companion object
}

val NitrozenAutoResizeTextStyle.Companion.Default
    @Composable
    get() = NitrozenAutoResizeTextStyle(
        textStyle = NitrozenTheme.typography.bodyMediumBold,
        textColor = NitrozenTheme.colors.inverse,
        textDecoration = null
    )