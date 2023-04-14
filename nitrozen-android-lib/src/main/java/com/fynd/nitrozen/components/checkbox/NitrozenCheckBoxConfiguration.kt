package com.fynd.nitrozen.components.checkbox

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

data class NitrozenCheckBoxConfiguration(
    val textPadding: PaddingValues,
) {
    companion object
}

val NitrozenCheckBoxConfiguration.Companion.Default: NitrozenCheckBoxConfiguration
    @Composable
    get() = NitrozenCheckBoxConfiguration(
        textPadding = PaddingValues(start = 8.dp)
    )

