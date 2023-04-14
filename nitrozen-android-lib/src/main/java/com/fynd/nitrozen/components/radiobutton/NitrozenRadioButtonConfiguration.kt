package com.fynd.nitrozen.components.radiobutton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NitrozenRadioButtonConfiguration(
    val strokeWidth: Dp,
    val size: Dp,
    val textPadding: PaddingValues,
) {
    companion object
}

val NitrozenRadioButtonConfiguration.Companion.Default: NitrozenRadioButtonConfiguration
    @Composable
    get() = NitrozenRadioButtonConfiguration(
        strokeWidth = 6.dp,
        size = 24.dp,
        textPadding = PaddingValues(start = 8.dp)
    )

