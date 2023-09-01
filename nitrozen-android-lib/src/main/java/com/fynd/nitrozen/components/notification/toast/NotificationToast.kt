package com.fynd.nitrozen.components.notification.toast

import androidx.compose.ui.tooling.preview.Preview

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.outlined.NitrozenOutlinedButton
import com.fynd.nitrozen.components.button.text.NitrozenTextButton
import com.fynd.nitrozen.components.notification.NitrozenNotificationConfiguration
import com.fynd.nitrozen.components.notification.NitrozenNotificationConfiguration.Default
import com.fynd.nitrozen.components.notification.NitrozenNotificationStyle
import com.fynd.nitrozen.components.notification.NitrozenNotificationStyle.Default
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
private fun NotificationToastPreview() {
    NitrozenTheme {
        Box {
            NitrozenNotificationToast(
                modifier = Modifier.padding(16.dp),
                title = "Heading text",
                subTitle = "Sub",
                primaryAction = NotificationAction("ac",{}),
                secondaryAction = NotificationAction("ac",{}),
            )
        }
    }
}

@Composable
fun NitrozenNotificationToast(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String? = null,
    leading: @Composable (RowScope.() -> Unit)? = null,
    trailing: @Composable (RowScope.() -> Unit)? = null,
    primaryAction: NotificationAction? = null,
    secondaryAction: NotificationAction? = null,
    style: NitrozenNotificationStyle.Toast =
        NitrozenNotificationStyle.Toast.Default,
    configuration : NitrozenNotificationConfiguration.Toast =
        NitrozenNotificationConfiguration.Toast.Default
) {
    Column(
        modifier = modifier
            .background(
                color = style.backgroundColor,
                shape = style.shape
            )
            .padding(configuration.contentPadding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .heightIn(min = configuration.minHeight),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            leading?.invoke(this)

            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = style.titleStyle,
                    color = style.titleTextColor
                )
                if (!subTitle.isNullOrEmpty()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        text = subTitle,
                        style = style.subTitleStyle,
                        color = style.subTitleColor
                    )
                }
            }

            trailing?.invoke(this)
        }

        if (primaryAction != null || secondaryAction != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (secondaryAction != null) {
                    NitrozenTextButton(
                        text = secondaryAction.actionText,
                        onClick = secondaryAction.action,
                        style = style.secondaryButtonStyle,
                        configuration = configuration.secondaryButtonConfiguration
                    )
                }
                if (primaryAction != null) {
                    NitrozenOutlinedButton(
                        text = primaryAction.actionText,
                        onClick = primaryAction.action,
                        style = style.primaryButtonStyle,
                        configuration = configuration.primaryButtonConfiguration
                    )
                }
            }
        }
    }
}

@Composable
fun NitrozenNotificationToast(
    title: String,
    subTitle: String? = null
) {
    NitrozenNotificationToast(
        title = title,
        subTitle = subTitle,
        leading = null,
        trailing = null
    )
}

@Composable
fun NitrozenNotificationToast(
    title: String,
    subTitle: String? = null,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
) {
    NitrozenNotificationToast(
        title = title,
        subTitle = subTitle,
        leading = leadingIcon?.let {
            {
                Icon(
                    modifier = Modifier
                        .size(32.dp),
                    painter = painterResource(id = leadingIcon),
                    contentDescription = null,
                )
            }
        },
        trailing = trailingIcon?.let {
            {
                Icon(
                    modifier = Modifier
                        .size(32.dp),
                    painter = painterResource(id = trailingIcon),
                    contentDescription = null,
                )
            }
        },
    )
}
