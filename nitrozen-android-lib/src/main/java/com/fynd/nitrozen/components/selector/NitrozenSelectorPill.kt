package com.fynd.nitrozen.components.selector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.R
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithRipple

@Preview
@Composable
private fun NitrozenSelectorPill_TextNormal() {
    NitrozenTheme {
        NitrozenSelectorPill(
            item = NitrozenSelectorItem.Text("Item"),
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
private fun NitrozenSelectorPill_TextSelected() {
    NitrozenTheme {
        NitrozenSelectorPill(
            item = NitrozenSelectorItem.Text("Item"),
            selected = true,
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun NitrozenSelectorPill_IconNormal() {
    NitrozenTheme {
        NitrozenSelectorPill(
            item = NitrozenSelectorItem.Icon(R.drawable.ic_chevron_down),
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
private fun NitrozenSelectorPill_IconSelected() {
    NitrozenTheme {
        NitrozenSelectorPill(
            item = NitrozenSelectorItem.Icon(R.drawable.ic_chevron_down),
            selected = true,
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            style = NitrozenSelectorStyle.Default.copy(
                backgroundColor = NitrozenTheme.colors.grey20
            )
        )
    }
}

@Composable
fun NitrozenSelectorPill(
    modifier: Modifier = Modifier,
    item: NitrozenSelectorItem,
    onClick: () -> Unit,
    selected: Boolean = false,
    style: NitrozenSelectorStyle = NitrozenSelectorStyle.Default,
    configuration: NitrozenSelectorConfiguration = NitrozenSelectorConfiguration.Default,
) {
    val textColor = if (selected) style.selectedTextColor else style.textColor
    val backgroundColor = if (selected) style.selectedBackgroundColor else style.backgroundColor
    val itemModifier = modifier
        .clip(NitrozenTheme.shapes.pill)
        .background(backgroundColor, shape = NitrozenTheme.shapes.pill)
        .clickableWithRipple { onClick() }
        .padding(
            top = configuration.itemPaddingTop,
            bottom = configuration.itemPaddingBottom,
        )

    when (item) {
        is NitrozenSelectorItem.Text -> {
            Text(
                text = item.text,
                style = style.textStyle,
                color = textColor,
                textAlign = TextAlign.Center,
                modifier = itemModifier,
            )
        }
        is NitrozenSelectorItem.Icon -> {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = item.contentDescription,
                modifier = itemModifier.size(24.dp),
                tint = textColor
            )
        }
    }
}