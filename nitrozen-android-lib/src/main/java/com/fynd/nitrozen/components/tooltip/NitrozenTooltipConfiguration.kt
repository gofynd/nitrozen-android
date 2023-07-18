package com.fynd.nitrozen.components.tooltip

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.utils.tooltip.AnchorEdge
import com.fynd.nitrozen.utils.tooltip.EdgePosition

data class NitrozenToolTipConfiguration(
    val anchorEdge: AnchorEdge,
    val tipEdgePosition: TipEdgePosition
) {
    companion object
}

val NitrozenToolTipConfiguration.Companion.Default: NitrozenToolTipConfiguration
    @Composable
    get() = NitrozenToolTipConfiguration(
        anchorEdge = AnchorEdge.Top,
        tipEdgePosition = TipEdgePosition.MIDDLE
    )

enum class TipEdgePosition(val edgePosition: EdgePosition) {
    START(EdgePosition(0.01f)),
    MIDDLE(EdgePosition(0.5f))
}