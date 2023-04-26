package com.fynd.nitrozen.components.pagecontrol

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DotConfiguration(
    val width : Dp,
    val height : Dp,
)
data class NitrozenPageControlConfiguration(
    val selectedDotConfiguration: DotConfiguration,
    val defaultDotConfiguration: DotConfiguration,
    val dotSpacing : Dp
){
    companion object
}

val NitrozenPageControlConfiguration.Companion.Default : NitrozenPageControlConfiguration
    @Composable
    get() = NitrozenPageControlConfiguration(
        selectedDotConfiguration = DotConfiguration(
            width = 24.dp,
            height = 8.dp
        ),
        defaultDotConfiguration = DotConfiguration(
            width = 8.dp,
            height = 8.dp
        ),
        dotSpacing = 8.dp
    )
