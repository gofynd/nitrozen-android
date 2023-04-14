package com.fynd.nitrozen.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
 * @param textStyle The [TextStyle] of the text label on the Badge.
 * @param textColor The [Color] of the text label on the Badge.
 * @param backgroundColor The [Color] of the background shape of the Badge.
 *
* */
@Composable
fun NitrozenBadge(
    modifier: Modifier = Modifier,
    text: String,
    textStyle: TextStyle = NitrozenTheme.typography.bodySmall,
    textColor: Color = NitrozenTheme.colors.grey80,
    backgroundColor: Color = NitrozenTheme.colors.primary20
) {
    Text(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = NitrozenTheme.shapes.small
            )
            .padding(
                horizontal = 4.dp,
                vertical = 2.dp
            ),
        text = text,
        style = textStyle,
        color = textColor
    )
}
