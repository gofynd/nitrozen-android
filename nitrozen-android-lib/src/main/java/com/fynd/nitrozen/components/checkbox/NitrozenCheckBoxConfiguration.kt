package com.fynd.nitrozen.components.checkbox

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NitrozenCheckBoxConfiguration(
    val textPadding: PaddingValues,
    val size: Dp
) {
    companion object
}

val NitrozenCheckBoxConfiguration.Companion.Default: NitrozenCheckBoxConfiguration
    @Composable
    get() = NitrozenCheckBoxConfiguration(
        textPadding = PaddingValues(start = 8.dp),
        size = 24.dp
    )

