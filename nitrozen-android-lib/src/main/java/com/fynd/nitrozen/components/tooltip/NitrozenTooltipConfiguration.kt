package com.fynd.nitrozen.components.tooltip

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.utils.tooltip.AnchorEdge
import com.fynd.nitrozen.utils.tooltip.EdgePosition

data class NitrozenToolTipConfiguration(
    val anchorEdge: AnchorEdge,
    val edgePosition: EdgePosition,
    val isAutoResizeEnabled : Boolean = false,
    val tooltipWidth: Dp = 256.dp
) {
    companion object
}

val NitrozenToolTipConfiguration.Companion.Default: NitrozenToolTipConfiguration
    @Composable
    get() = NitrozenToolTipConfiguration(
        anchorEdge = AnchorEdge.Top,
        edgePosition = EdgePosition(0.5f, 0.dp),
        tooltipWidth = 256.dp
    )
