package com.fynd.nitrozen.components.notification

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration.Default

object NitrozenNotificationConfiguration {
    data class Toast(
        val contentPadding : PaddingValues,
        val minHeight : Dp,
        val primaryButtonConfiguration: NitrozenButtonConfiguration.Outlined,
        val secondaryButtonConfiguration: NitrozenButtonConfiguration.Text,
    ){
        companion object
    }

    val Toast.Companion.Default
        @Composable
        get() = Toast(
            contentPadding = PaddingValues(16.dp),
            minHeight = 32.dp,
            primaryButtonConfiguration = NitrozenButtonConfiguration.Outlined.Default.copy(
                minHeight = 32.dp,
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 4.dp
                ),
            ),
            secondaryButtonConfiguration = NitrozenButtonConfiguration.Text.Default
        )

    data class SuggestionBanner(
        val contentPadding: PaddingValues,
        val itemSpacing: Dp,
        val primaryButtonConfiguration: NitrozenButtonConfiguration.Filled,
    ){
        companion object
    }

    val SuggestionBanner.Companion.Default
        @Composable
        get() = SuggestionBanner(
            contentPadding = PaddingValues(16.dp),
            itemSpacing = 12.dp,
            primaryButtonConfiguration = NitrozenButtonConfiguration.Filled.Default.copy(
                minHeight = 32.dp
            )
        )
}