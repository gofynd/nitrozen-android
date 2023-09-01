package com.fynd.nitrozen.components.notification

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.components.button.NitrozenButtonStyle
import com.fynd.nitrozen.components.button.NitrozenButtonStyle.Default
import com.fynd.nitrozen.theme.NitrozenTheme

object NitrozenNotificationStyle {

    data class Toast(
        val backgroundColor : Color,
        val shape : Shape,
        val titleStyle : TextStyle,
        val titleTextColor : Color,
        val subTitleStyle : TextStyle,
        val subTitleColor : Color,
        val secondaryButtonStyle : NitrozenButtonStyle.Text,
        val primaryButtonStyle: NitrozenButtonStyle.Outlined,
    ){
        companion object
    }

    val Toast.Companion.Default
        @Composable
        get() = Toast(
            backgroundColor = NitrozenTheme.colors.grey80,
            shape = NitrozenTheme.shapes.roundedXl,
            titleStyle = NitrozenTheme.typography.bodySmallBold,
            titleTextColor = NitrozenTheme.colors.background,
            subTitleStyle = NitrozenTheme.typography.bodyXsReg,
            subTitleColor = NitrozenTheme.colors.grey20,
            secondaryButtonStyle = NitrozenButtonStyle.Text.Default.copy(
                textColorEnabled = NitrozenTheme.colors.primary20,
            ),
            primaryButtonStyle = NitrozenButtonStyle.Outlined.Default.copy(
                textColorEnabled = NitrozenTheme.colors.primary20,
                backgroundColor = Color.Transparent,
            ),

            )

    data class SuggestionBanner(
        val titleStyle : TextStyle,
        val titleTextColor : Color,
        val subTitleStyle : TextStyle,
        val subTitleColor : Color,
        val backgroundColor : Color,
        val shape: Shape,
        val primaryButtonStyle : NitrozenButtonStyle.Filled
    ){
        companion object
    }

    val SuggestionBanner.Companion.Default
        @Composable
        get() = SuggestionBanner(
            titleStyle = NitrozenTheme.typography.bodySmallBold,
            titleTextColor = NitrozenTheme.colors.grey100,
            subTitleStyle = NitrozenTheme.typography.bodyXsReg,
            subTitleColor = NitrozenTheme.colors.grey80,
            shape = NitrozenTheme.shapes.rounded16,
            backgroundColor = NitrozenTheme.colors.grey20,
            primaryButtonStyle = NitrozenButtonStyle.Filled.Default
        )
}