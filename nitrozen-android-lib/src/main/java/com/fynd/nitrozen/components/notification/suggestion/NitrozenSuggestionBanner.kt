package com.fynd.nitrozen.components.notification.suggestion

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Visibility
import androidx.core.graphics.blue
import com.fynd.nitrozen.R
import com.fynd.nitrozen.components.autosizetext.Default
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeText
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeTextConfiguration
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeTextStyle
import com.fynd.nitrozen.components.button.filled.NitrozenFilledButton
import com.fynd.nitrozen.components.notification.NitrozenNotificationConfiguration
import com.fynd.nitrozen.components.notification.NitrozenNotificationConfiguration.Default
import com.fynd.nitrozen.components.notification.NitrozenNotificationStyle
import com.fynd.nitrozen.components.notification.NitrozenNotificationStyle.Default
import com.fynd.nitrozen.components.notification.toast.NotificationAction
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithUnBoundedRipple

@Preview(widthDp = 350)
@Composable
private fun NitrozenSuggestionBannerPreview() {
    NitrozenTheme {
        NitrozenSuggestionBanner(
            modifier = Modifier
                .fillMaxWidth(),
            title = "With love, from nitrozen test terst test test",
            subtitle = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
            icon = R.drawable.ic_success_text_field,
            primaryAction = NotificationAction("Task"){}
        )
    }
}

@Composable
fun NitrozenSuggestionBanner(
    modifier : Modifier = Modifier,
    title: String,
    @DrawableRes icon : Int,
    onCancel : ()-> Unit = {},
    subtitle: String? = null,
    primaryAction : NotificationAction? = null,
    style : NitrozenNotificationStyle.SuggestionBanner = NitrozenNotificationStyle.SuggestionBanner.Default,
    configuration : NitrozenNotificationConfiguration.SuggestionBanner =
        NitrozenNotificationConfiguration.SuggestionBanner.Default
){
    ConstraintLayout(
        modifier = modifier
            .background(
                shape = style.shape,
                color = style.backgroundColor
            )
            .padding(configuration.contentPadding),
    ) {
        val (iconRef, titleRef, subTitleRef, cancelRef, actionRef) = createRefs()

        Image(
            modifier = Modifier
                .size(configuration.iconSize)
                .constrainAs(iconRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            painter = painterResource(id = icon),
            contentDescription = null,
        )

        NitrozenAutoResizeText(
            modifier = Modifier
                .constrainAs(titleRef) {
                    top.linkTo(parent.top)
                    end.linkTo(cancelRef.start)
                    start.linkTo(iconRef.end, margin = configuration.itemSpacing)
                    width = Dimension.fillToConstraints
                },
            text = title,
            style = NitrozenAutoResizeTextStyle.Default.copy(
                textStyle = style.titleStyle,
                textColor = style.titleTextColor
            ),
            configuration = NitrozenAutoResizeTextConfiguration.Default.copy(
                maxLines = 2
            )
        )
        Icon(
            modifier = Modifier
                .clickableWithUnBoundedRipple(
                    onCancel
                )
                .constrainAs(cancelRef) {
                    start.linkTo(titleRef.end, configuration.itemSpacing)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.wrapContent
                },
            imageVector = Icons.Rounded.Close,
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .constrainAs(subTitleRef) {
                    start.linkTo(titleRef.start)
                    end.linkTo(titleRef.end)
                    top.linkTo(titleRef.bottom, 4.dp)
                    width = Dimension.fillToConstraints
                    visibility = if(subtitle!= null) Visibility.Visible
                                else Visibility.Gone
                },
            text = subtitle ?: "",
            style = style.subTitleStyle,
            color = style.subTitleColor
        )

        primaryAction?.let {
            NitrozenFilledButton(
                modifier = Modifier
                    .constrainAs(actionRef) {
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(subTitleRef.bottom, margin = 8.dp, goneMargin = 8.dp)
                        height = Dimension.wrapContent
                    },
                text = it.actionText,
                onClick = it.action,
                configuration = configuration.primaryButtonConfiguration,
                style = style.primaryButtonStyle
            )
        }

    }
}