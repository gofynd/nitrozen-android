package com.fynd.nitrozen.components.selector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
fun NitrozenSelector_Text() {
    val selectedItemIndex = remember {
        mutableStateOf(0)
    }

    NitrozenTheme {
        NitrozenSelector(
            items = listOf(
                NitrozenSelectorItem.Text("Item 1"),
                NitrozenSelectorItem.Text("Item 2"),
                NitrozenSelectorItem.Text("Item 3"),
            ),
            selectedItemIndex = selectedItemIndex.value,
            onItemClick = {
                selectedItemIndex.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun NitrozenSelector(
    modifier: Modifier = Modifier,
    items: List<NitrozenSelectorItem>,
    onItemClick: (index: Int) -> Unit,
    selectedItemIndex: Int = 0,
    style: NitrozenSelectorStyle = NitrozenSelectorStyle.Default,
    configuration: NitrozenSelectorConfiguration = NitrozenSelectorConfiguration.Default,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            space = configuration.spaceBetweenItems,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .clip(NitrozenTheme.shapes.pill)
            .background(
                color = style.backgroundColor,
                shape = NitrozenTheme.shapes.pill
            )
            .padding(configuration.contentPadding)
            .then(modifier),
    ) {
        items.forEachIndexed { index, item ->
            val selected = index == selectedItemIndex
            when (item) {
                is NitrozenSelectorItem.Text -> {
                    NitrozenSelectorPill(
                        title = item.text,
                        selected = selected,
                        onClick = {
                            onItemClick(index)
                        },
                        modifier = Modifier.weight(1F)
                    )
                }
            }
        }
    }
}