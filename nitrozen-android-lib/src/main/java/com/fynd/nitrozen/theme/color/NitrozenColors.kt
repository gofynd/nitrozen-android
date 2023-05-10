package com.fynd.nitrozen.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class NitrozenColors(
    val primary20: Color,
    val primary30: Color,
    val primary40: Color,
    val primary50: Color,
    val primary60: Color,
    val primary80: Color,
    val grey20: Color,
    val grey40: Color,
    val grey60: Color,
    val grey80: Color,
    val grey100: Color,
    val inverse: Color,
    val error20: Color,
    val error50: Color,
    val error80: Color,
    val success20: Color,
    val success50: Color,
    val success80: Color,
    val background: Color,
    val warning20: Color,
    val warning50: Color,
    val warning80: Color,
    val sparkle20: Color,
    val sparkle60: Color,
    val shadow: Color,
    val overlay: Color,
)

val LocalNitrozenColors = staticCompositionLocalOf {
    NitrozenColors(
        primary20 = Color.Unspecified,
        primary30 = Color.Unspecified,
        primary40 = Color.Unspecified,
        primary50 = Color.Unspecified,
        primary60 = Color.Unspecified,
        primary80 = Color.Unspecified,
        grey20 = Color.Unspecified,
        grey40 = Color.Unspecified,
        grey60 = Color.Unspecified,
        grey80 = Color.Unspecified,
        grey100 = Color.Unspecified,
        inverse = Color.Unspecified,
        error20 = Color.Unspecified,
        error50 = Color.Unspecified,
        error80 = Color.Unspecified,
        success20 = Color.Unspecified,
        success50 = Color.Unspecified,
        success80 = Color.Unspecified,
        background = Color.Unspecified,
        warning20 = Color.Unspecified,
        warning50 = Color.Unspecified,
        warning80 = Color.Unspecified,
        sparkle20 = Color.Unspecified,
        sparkle60 = Color.Unspecified,
        shadow = Color.Unspecified,
        overlay = Color.Unspecified
    )
}
