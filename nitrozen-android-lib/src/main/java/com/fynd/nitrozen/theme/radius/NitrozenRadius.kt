package com.fynd.nitrozen.theme.radius

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class NitrozenRadius(
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val xl: Dp,
    val xxl: Dp,
    val pill: Dp,
    val action: Dp,
)

val LocalNitrozenRadius = staticCompositionLocalOf {
    NitrozenRadius(
        small = 0.dp,
        medium = 0.dp,
        large = 0.dp,
        xl = 0.dp,
        xxl = 0.dp,
        pill = 0.dp,
        action = 0.dp
    )
}
