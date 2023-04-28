package com.fynd.nitrozen.components.avatar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

object NitrozenAvatarStyle{


    data class Initials(
        val backgroundColor : Color,
        val shape : Shape,
        val textStyle: TextStyle,
        val textColor : Color
    ) {
        companion object
    }

    val Initials.Companion.Default : Initials
        @Composable
        get() = Initials(
            backgroundColor = NitrozenTheme.colors.sparkle20,
            shape = NitrozenTheme.shapes.round,
            textStyle = NitrozenTheme.typography.bodySmall,
            textColor = NitrozenTheme.colors.sparkle60
        )

    data class Picture(
        val shape : Shape
    ) {
        companion object
    }

    val Picture.Companion.Default : Picture
        @Composable
        get() = Picture(
            shape = NitrozenTheme.shapes.round,
        )

    data class Icon(
        val backgroundColor : Color,
        val shape : Shape,
        val tint : Color
    ) {
        companion object
    }

    val Icon.Companion.Default : Icon
        @Composable
        get() = Icon(
            backgroundColor = NitrozenTheme.colors.primary20,
            shape = NitrozenTheme.shapes.round,
            tint = NitrozenTheme.colors.primary50
        )

}