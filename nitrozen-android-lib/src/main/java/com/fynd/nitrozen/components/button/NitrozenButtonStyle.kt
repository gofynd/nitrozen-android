package com.fynd.nitrozen.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import com.fynd.nitrozen.theme.NitrozenTheme

object NitrozenButtonStyle {

    data class Filled(
        val backgroundColorEnabled: Color,
        val backgroundColorDisabled: Color,
        val textColor: Color,
        val textStyle: TextStyle,
    ) {
        companion object
    }

    val Filled.Companion.Default: Filled
        @Composable
        get() = Filled(
            backgroundColorEnabled = NitrozenTheme.colors.primary50,
            backgroundColorDisabled = NitrozenTheme.colors.primary50.copy(alpha = 0.3F),
            textColor = NitrozenTheme.colors.inverse,
            textStyle = NitrozenTheme.typography.bodyMediumBold
        )

    data class Outlined(
        val textColorEnabled: Color,
        val textColorDisabled: Color,
        val textStyle: TextStyle,
    ) {
        companion object
    }

    val Outlined.Companion.Default: Outlined
        @Composable
        get() = Outlined(
            textColorEnabled = NitrozenTheme.colors.primary60,
            textColorDisabled = NitrozenTheme.colors.primary60.copy(alpha = 0.3F),
            textStyle = NitrozenTheme.typography.bodyMediumBold,
        )

    data class Text(
        val textColorEnabled: Color,
        val textColorDisabled: Color,
        val textStyle: TextStyle,
        val textDecoration: TextDecoration,
    ) {
        companion object
    }

    val Text.Companion.Default: Text
        @Composable
        get() = Text(
            textColorEnabled = NitrozenTheme.colors.primary60,
            textColorDisabled = NitrozenTheme.colors.primary60.copy(alpha = 0.3F),
            textStyle = NitrozenTheme.typography.bodyXsLink,
            textDecoration = TextDecoration.None
        )
}

