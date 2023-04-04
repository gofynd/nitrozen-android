package com.fynd.nitrozen.theme.shape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class NitrozenShapes(
    val pill: Shape,
    val topRoundedXl: Shape,
    val rounded16: Shape,
    val roundedXl: RoundedCornerShape,
    val round: RoundedCornerShape,
)

val LocalNitrozenShapes = staticCompositionLocalOf {
    NitrozenShapes(
        pill = RoundedCornerShape(0.dp),
        topRoundedXl = RoundedCornerShape(0.dp),
        rounded16 = RoundedCornerShape(0.dp),
        roundedXl = RoundedCornerShape(0.dp),
        round = RoundedCornerShape(100),
    )
}
