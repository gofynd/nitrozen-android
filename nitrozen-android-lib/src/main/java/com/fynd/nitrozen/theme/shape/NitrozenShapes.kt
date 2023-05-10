package com.fynd.nitrozen.theme.shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class NitrozenShapes(
    val small: Shape,
    val pill: Shape,
    val topRoundedXl: Shape,
    val rounded8: Shape,
    val rounded16: Shape,
    val roundedXl: RoundedCornerShape,
    val round: RoundedCornerShape,
    val rounded80: Shape,
    val rounded12: Shape,
)

val LocalNitrozenShapes = staticCompositionLocalOf {
    NitrozenShapes(
        small = RoundedCornerShape(0.dp),
        pill = RoundedCornerShape(0.dp),
        topRoundedXl = RoundedCornerShape(0.dp),
        rounded16 = RoundedCornerShape(0.dp),
        roundedXl = RoundedCornerShape(0.dp),
        round = RoundedCornerShape(100),
        rounded80 = RoundedCornerShape(0.dp),
        rounded12 = RoundedCornerShape(0.dp),
        rounded8 = RoundedCornerShape(0.dp),
    )
}
