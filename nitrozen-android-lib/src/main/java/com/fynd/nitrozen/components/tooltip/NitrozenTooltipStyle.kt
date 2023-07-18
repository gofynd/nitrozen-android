package com.fynd.nitrozen.components.tooltip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.tooltip.AnchorEdge

data class NitrozenTooltipStyle(
    val textStyle : TextStyle,
    val textColor: Color,
    val backgroundColor: Color
){
    companion object
}

val NitrozenTooltipStyle.Companion.Default
    @Composable
    get() = NitrozenTooltipStyle(
        textStyle = NitrozenTheme.typography.bodyMediumBold,
        textColor = NitrozenTheme.colors.inverse,
        backgroundColor = NitrozenTheme.colors.grey100
    )