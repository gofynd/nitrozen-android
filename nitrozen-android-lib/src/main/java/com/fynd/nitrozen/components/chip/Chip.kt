package com.fynd.nitrozen.components.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithRipple

@Preview
@Composable
private fun ChipPreview() {
    NitrozenTheme {
        NitrozenChip(
            text = "Text",
            modifier = Modifier,
            trailing = {
                Icon(
                    modifier = Modifier
                        .size(16.dp),
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,

                    )
            },
            leading = {
                Icon(
                    modifier = Modifier
                        .size(16.dp),
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            }
        )
    }
}


/**
 *
 * A composable function that creates a NitrozenChip.
 * A NitrozenChip is a small, interactive element that displays some text and an optional leading or trailing icon.
 * It can be customized with modifier, background color, border color, text and text style.
 *
 * @param backgroundColor [Color] to be used as background
 * @param borderColor [Color] to be used as border color
 * @param borderWidth Width of the chip in [Dp]
 * @param textStyle [TextStyle] to be applied on the [text], [textColor] will take priority to be applied as text color
 * @param textColor [Color] to be used as text color for [text]
 * @param leading Leading content slot
 * @param trailing Trailing content slot
 * @param onTap Will be called when the user clicks the chip
 * */
@Composable
fun NitrozenChip(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = NitrozenTheme.colors.primary20,
    borderColor: Color = NitrozenTheme.colors.primary40,
    borderWidth: Dp = 1.dp,
    textStyle: TextStyle = NitrozenTheme.typography.bodySmallRegular,
    textColor: Color = NitrozenTheme.colors.grey100,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    onTap: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .widthIn(
                min = 45.dp
            )
            .background(
                color = backgroundColor,
                shape = NitrozenTheme.shapes.rounded80
            )
            .border(
                width = borderWidth,
                color = borderColor,
                shape = NitrozenTheme.shapes.rounded80
            )
            .clip(
                shape = NitrozenTheme.shapes.rounded80
            )
            .then(
                if(onTap != null) Modifier.clickableWithRipple {
                    onTap.invoke()
                } else Modifier
            )
            .padding(
                top = 4.dp,
                end = 8.dp,
                bottom = 4.dp,
                start = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        leading?.invoke()

        Text(
            modifier = Modifier
                .padding(4.dp),
            text = text,
            style = textStyle.copy(
                color = textColor
            ),
        )

        trailing?.invoke()
    }
}

