package com.fynd.nitrozen.components.pagecontrol

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

data class DotStyle(
    val shape : Shape,
    val color : Color,
    val borderWidth : Dp,
    val borderColor : Color,
)
data class NitrozenPageControlStyle(
    val selectedDotStyle: DotStyle,
    val defaultDotStyle: DotStyle
){
    companion object
}

val NitrozenPageControlStyle.Companion.Default : NitrozenPageControlStyle
    @Composable
    get() = NitrozenPageControlStyle(
        selectedDotStyle = DotStyle(
            shape = NitrozenTheme.shapes.round,
            color = NitrozenTheme.colors.primary60,
            borderColor = Color.Unspecified,
            borderWidth = 0.dp
        ),
        defaultDotStyle = DotStyle(
            shape = NitrozenTheme.shapes.round,
            color = NitrozenTheme.colors.primary60.copy(
                alpha = 0.3f
            ),
            borderColor = Color.Unspecified,
            borderWidth = 0.dp
        ),
    )
