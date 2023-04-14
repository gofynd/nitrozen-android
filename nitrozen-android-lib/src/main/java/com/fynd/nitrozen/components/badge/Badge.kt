package com.fynd.nitrozen.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
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
    configuration : NitrozenBadgeConfiguration =
        NitrozenBadgeConfiguration.Default,
    style: NitrozenBadgeStyle =
        NitrozenBadgeStyle.Default
) {
    Text(
        modifier = modifier
            .background(
                color = style.backgroundColor,
                shape = NitrozenTheme.shapes.small
            )
            .padding(configuration.contentPadding),
        text = text,
        style = style.textStyle,
        color = style.textColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
