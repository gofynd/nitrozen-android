package com.fynd.nitrozen.components.tooltip

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.utils.tooltip.AnchorEdge
import com.fynd.nitrozen.utils.tooltip.EdgePosition

data class NitrozenToolTipConfiguration(
    val anchorEdge: AnchorEdge,
    val edgePosition: EdgePosition = EdgePosition(0.5f, 0.dp),
    val isAutoResizeEnabled : Boolean = false,
    val tooltipMaxWidth: Dp = 256.dp
) {
    companion object
}

val NitrozenToolTipConfiguration.Companion.Default: NitrozenToolTipConfiguration
    @Composable
    get() = NitrozenToolTipConfiguration(
        anchorEdge = AnchorEdge.Top,
        edgePosition = EdgePosition(0.5f, 0.dp),
        tooltipMaxWidth = 256.dp
    )
