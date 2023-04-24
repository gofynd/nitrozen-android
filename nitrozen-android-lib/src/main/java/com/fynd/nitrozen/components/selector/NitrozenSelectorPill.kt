package com.fynd.nitrozen.components.selector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithRipple

@Preview
@Composable
private fun NitrozenSelectorPill_Normal() {
    NitrozenTheme {
        NitrozenSelectorPill(
            title = "Item",
            selected = false,
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            style = NitrozenSelectorStyle.Default.copy(
                backgroundColor = NitrozenTheme.colors.grey20
            )
        )
    }
}

@Preview
@Composable
private fun NitrozenSelectorPill_Selected() {
    NitrozenTheme {
        NitrozenSelectorPill(
            title = "Item",
            selected = true,
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun NitrozenSelectorPill(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
    selected: Boolean = false,
    style: NitrozenSelectorStyle = NitrozenSelectorStyle.Default,
    configuration: NitrozenSelectorConfiguration = NitrozenSelectorConfiguration.Default,
) {
    val textColor = if (selected) style.selectedTextColor else style.textColor
    val backgroundColor = if (selected) style.selectedBackgroundColor else style.backgroundColor

    Text(
        text = title,
        style = style.textStyle,
        color = textColor,
        textAlign = TextAlign.Center,
        modifier = modifier
            .clip(NitrozenTheme.shapes.pill)
            .background(backgroundColor, shape = NitrozenTheme.shapes.pill)
            .clickableWithRipple { onClick() }
            .padding(
                top = configuration.itemPaddingTop,
                bottom = configuration.itemPaddingBottom,
            ),
    )
}