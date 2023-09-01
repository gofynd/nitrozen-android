package com.fynd.nitrozen.components.badge

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.R
import com.fynd.nitrozen.theme.NitrozenTheme


@Preview(showBackground = true)
@Composable
private fun BadgePreview() {
    NitrozenTheme {
        NitrozenBadge(
            modifier = Modifier,
            text = "Badge"
        )
    }
}

/**
 * A Badge is a small UI element used to display contextual information.
 * It consists of a text label and a background shape,
 * which can be customized with various properties,
 * including its text color, background color, and text style.
 *
 * @param modifier The [Modifier] to be applied to the Badge.
 * @param text The text label to be displayed on the Badge.
 * @param style [NitrozenBadgeStyle] The style for the NitrozenBadge, which includes text style, text color and background color.
 * @param configuration [NitrozenBadgeConfiguration] The configuration for the NitrozenBadge, that configures content padding.
 *
* */
@Composable
fun NitrozenBadge(
    modifier: Modifier = Modifier,
    text: String,
    leading : @Composable (RowScope.()->Unit)? = null,
    configuration : NitrozenBadgeConfiguration =
        NitrozenBadgeConfiguration.Default,
    style: NitrozenBadgeStyle =
        NitrozenBadgeStyle.Default
) {
    Row(
        modifier
            .background(
                color = style.backgroundColor,
                shape = NitrozenTheme.shapes.small
            )
            .padding(configuration.contentPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {

        leading?.invoke(this)

        Text(
            modifier = Modifier,
            text = text,
            style = style.textStyle,
            color = style.textColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
