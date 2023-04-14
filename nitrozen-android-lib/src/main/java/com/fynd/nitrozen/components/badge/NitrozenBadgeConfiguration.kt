package com.fynd.nitrozen.components.badge

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

data class NitrozenBadgeConfiguration(
    val contentPadding: PaddingValues
) {
    companion object
}

val NitrozenBadgeConfiguration.Companion.Default
    get() = NitrozenBadgeConfiguration(
        contentPadding = PaddingValues(
            horizontal = 4.dp,
            vertical = 2.dp
        )
    )
