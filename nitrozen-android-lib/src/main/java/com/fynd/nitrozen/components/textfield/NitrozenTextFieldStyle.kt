package com.fynd.nitrozen.components.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.theme.typography.fontsNitrozen

object NitrozenTextFieldStyle {

    data class Outlined(
        val labelTextStyle: TextStyle,
        val labelTextColor: Color,
        val textStyle: TextStyle,
        val textColor: Color,
        val cursorColor: Color,
        val backgroundColor: Color,
        val placeholderTextStyle: TextStyle,
        val placeholderTextColor: Color,
        val infoTextStyle: TextStyle,
    ) {
        companion object
    }

    val Outlined.Companion.Default: Outlined
        @Composable
        get() = Outlined(
            labelTextStyle = NitrozenTheme.typography.bodyXsReg,
            labelTextColor = NitrozenTheme.colors.grey80,
            textStyle = NitrozenTheme.typography.bodySmall,
            textColor = NitrozenTheme.colors.grey100,
            cursorColor = NitrozenTheme.colors.grey60,
            backgroundColor = Color.Transparent,
            placeholderTextStyle = NitrozenTheme.typography.bodySmall,
            placeholderTextColor = NitrozenTheme.colors.grey60,
            infoTextStyle = TextStyle(
                fontFamily = fontsNitrozen,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                fontSize = 14.sp,
            ),
        )

    data class Otp(
        val labelTextStyle: TextStyle,
        val labelTextColor: Color,
        val backgroundColor: Color,
        val placeholderTextColor: Color,
        val textColor: Color,
        val textColorError: Color,
        val borderColor: Color,
        val borderColorFocused: Color,
        val borderColorError: Color,
        val textStyle: TextStyle,
        val infoTextStyle: TextStyle,
    ) {
        companion object
    }

    val Otp.Companion.Default: Otp
        @Composable
        get() = Otp(
            labelTextStyle = NitrozenTheme.typography.bodyXsReg,
            labelTextColor = NitrozenTheme.colors.grey80,
            backgroundColor = NitrozenTheme.colors.background,
            placeholderTextColor = NitrozenTheme.colors.grey60,
            textColor = NitrozenTheme.colors.grey100,
            textColorError = NitrozenTheme.colors.error50,
            borderColor = NitrozenTheme.colors.grey60,
            borderColorError = NitrozenTheme.colors.error50,
            borderColorFocused = NitrozenTheme.colors.primary60,
            textStyle = NitrozenTheme.typography.bodySmall,
            infoTextStyle = Outlined.Default.infoTextStyle
        )
}
