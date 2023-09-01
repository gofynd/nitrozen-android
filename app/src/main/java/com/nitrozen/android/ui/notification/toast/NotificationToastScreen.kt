package com.nitrozen.android.ui.notification.toast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.fynd.nitrozen.components.notification.toast.NotificationAction
import com.fynd.nitrozen.components.notification.toast.NitrozenNotificationToast
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun NotficationToastPreview() {
    NitrozenTheme {
        NotificationToastScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun NotificationToastScreen(
    onBackClick : ()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Notification Toast",
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

                NitrozenNotificationToast(
                    title = "Heading Text"
                )

                Text(
                    text = "Subtitle",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenNotificationToast(
                    title = "Heading Text",
                    subTitle = "Subtitle text",
                )

                Text(
                    text = "Actions",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenNotificationToast(
                    title = "Heading Text",
                    subTitle = "Subtitle text",
                    primaryAction = NotificationAction("Action"){

                    },
                    secondaryAction = NotificationAction("Action"){

                    }
                )

                Text(
                    text = "Custom Style",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenNotificationToast(
                    title = "Heading Text",
                    subTitle = "Subtitle text",
                    primaryAction = NotificationAction("Action"){

                    },
                    secondaryAction = NotificationAction("Action"){

                    },
                    style = NitrozenNotificationStyle.Toast.Default.copy(
                        backgroundColor = NitrozenTheme.colors.primary30,
                        titleTextColor = NitrozenTheme.colors.primary50,
                        subTitleColor = NitrozenTheme.colors.primary40,
                        primaryButtonStyle = NitrozenButtonStyle.Outlined.Default.copy(
                            textColorEnabled = NitrozenTheme.colors.primary50,
                            backgroundColor = Color.Transparent,
                            borderColor = NitrozenTheme.colors.primary50
                        ),
                        secondaryButtonStyle = NitrozenButtonStyle.Text.Default.copy(
                            textColorEnabled = NitrozenTheme.colors.primary50
                        )
                    )
                )

            }
        }
    }
}