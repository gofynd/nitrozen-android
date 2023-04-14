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
import androidx.compose.ui.tooling.preview.Preview
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
            },
        )
    }
}


/**
 *
 * A composable function that creates a NitrozenChip.
 * A NitrozenChip is a small, interactive element that displays some text and an optional leading or trailing icon.
 * It can be customized with modifier, background color, border color, text and text style.
 *
 * @param leading Leading content slot
 * @param trailing Trailing content slot
 * @param onClick Will be called when the user clicks the chip
 * */
@Composable
fun NitrozenChip(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null,
    leading: @Composable (() -> Unit)? = null,
    trailing: @Composable (() -> Unit)? = null,
    style: NitrozenChipStyle = NitrozenChipStyle.Default,
    configuration: NitrozenChipConfiguration = NitrozenChipConfiguration.Default,
) {
    Row(
        modifier = modifier
            .widthIn(min = configuration.minWidth)
            .clip(shape = configuration.shape)
            .then(
                if(onClick != null)
                    Modifier.clickableWithRipple {
                        onClick.invoke()
                    }
                else Modifier
            )
            .background(
                color = style.backgroundColor,
                shape = configuration.shape
            )
            .border(
                width = configuration.borderWidth,
                color = style.borderColor,
                shape = configuration.shape
            )
            .padding(configuration.contentPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        leading?.invoke()

        Text(
            modifier = Modifier
                .padding(4.dp),
            text = text,
            style = style.textStyle,
            color = style.textColor,
        )

        trailing?.invoke()
    }
}

