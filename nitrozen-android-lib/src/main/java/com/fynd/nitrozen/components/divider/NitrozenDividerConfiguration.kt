package com.fynd.nitrozen.components.divider

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NitrozenDividerConfiguration(
    val thickness : Dp,
    val direction : Direction
){
    sealed interface Direction{
        object Horizontal : Direction
        object Vertical : Direction
    }

    companion object
}

val NitrozenDividerConfiguration.Companion.Default : NitrozenDividerConfiguration
    @Composable
    get() = NitrozenDividerConfiguration(
        thickness = 1.dp,
        direction = NitrozenDividerConfiguration.Direction.Horizontal
    )
