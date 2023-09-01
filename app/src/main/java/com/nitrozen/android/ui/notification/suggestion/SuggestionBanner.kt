package com.nitrozen.android.ui.notification.suggestion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.NitrozenButtonStyle
import com.fynd.nitrozen.components.button.NitrozenButtonStyle.Default
import com.fynd.nitrozen.components.notification.NitrozenNotificationStyle
import com.fynd.nitrozen.components.notification.NitrozenNotificationStyle.Default
import com.fynd.nitrozen.components.notification.suggestion.NitrozenSuggestionBanner
import com.fynd.nitrozen.components.notification.toast.NitrozenNotificationToast
import com.fynd.nitrozen.components.notification.toast.NotificationAction
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.R
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun SuggestionBannerPreview() {
    NitrozenTheme {
        SuggestionBannerScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun SuggestionBannerScreen(
    onBackClick : ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Suggestion Banner",
            onBackClick = onBackClick
        )


        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                Text(
                    text = "Default",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenSuggestionBanner(
                    modifier = Modifier
                        .fillMaxWidth(),
                    title = "Heading Text",
                    icon = com.fynd.nitrozen.R.drawable.ic_success_text_field
                )

                Text(
                    text = "Subtitle",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenSuggestionBanner(
                    modifier = Modifier
                        .fillMaxWidth(),
                    title = "Heading Text",
                    subtitle = "Subtitle text",
                    icon = com.fynd.nitrozen.R.drawable.ic_success_text_field
                )

                Text(
                    text = "Action",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenSuggestionBanner(
                    modifier = Modifier
                        .fillMaxWidth(),
                    title = "Heading Text",
                    subtitle = "Subtitle text",
                    icon = com.fynd.nitrozen.R.drawable.ic_success_text_field,
                    primaryAction = NotificationAction(
                        actionText = "Test",
                        action = {}
                    ),
                    onCancel = {

                    },
                )

                Text(
                    text = "Custom Style",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenSuggestionBanner(
                    modifier = Modifier
                        .fillMaxWidth(),
                    title = "Heading Text",
                    subtitle = "Subtitle text",
                    icon = com.fynd.nitrozen.R.drawable.ic_success_text_field,
                    primaryAction = NotificationAction(
                        actionText = "Test",
                        action = {}
                    ),
                    style = NitrozenNotificationStyle.SuggestionBanner.Default.copy(
                        backgroundColor = NitrozenTheme.colors.primary20,
                        titleTextColor = NitrozenTheme.colors.primary50,
                        subTitleColor = NitrozenTheme.colors.primary40,
                        shape = NitrozenTheme.shapes.topRoundedXl,
                        primaryButtonStyle = NitrozenButtonStyle.Filled.Default.copy(
                            backgroundColorEnabled = NitrozenTheme.colors.success50,
                        )
                    )
                )
            }
        }
    }
}