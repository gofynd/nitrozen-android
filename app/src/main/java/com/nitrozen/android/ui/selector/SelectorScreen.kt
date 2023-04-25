package com.nitrozen.android.ui.selector

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.selector.NitrozenSelector
import com.fynd.nitrozen.components.selector.NitrozenSelectorItem
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewSelectorScreen() {
    NitrozenTheme {
        SelectorScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun SelectorScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Selector",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Text",
                style = NitrozenTheme.typography.headingXs
            )

            val indexForText = remember {
                mutableStateOf(0)
            }
            NitrozenSelector(
                items = listOf(
                    NitrozenSelectorItem.Text("Item 1"),
                    NitrozenSelectorItem.Text("Item 2"),
                    NitrozenSelectorItem.Text("Item 3"),
                ),
                selectedItemIndex = indexForText.value,
                onItemClick = {
                    indexForText.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            Text(
                text = "Icon",
                style = NitrozenTheme.typography.headingXs,
                modifier = Modifier.padding(top = 32.dp)
            )

            val indexForIcon = remember {
                mutableStateOf(0)
            }
            NitrozenSelector(
                items = listOf(
                    NitrozenSelectorItem.Icon(com.nitrozen.android.R.drawable.ic_heart),
                    NitrozenSelectorItem.Icon(com.nitrozen.android.R.drawable.ic_heart),
                    NitrozenSelectorItem.Icon(com.nitrozen.android.R.drawable.ic_heart),
                ),
                selectedItemIndex = indexForIcon.value,
                onItemClick = {
                    indexForIcon.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            Text(
                text = "Icon Text Horizontal",
                style = NitrozenTheme.typography.headingXs,
                modifier = Modifier.padding(top = 32.dp)
            )

            val indexForIconTextH = remember {
                mutableStateOf(0)
            }
            NitrozenSelector(
                items = listOf(
                    NitrozenSelectorItem.IconText("Item", com.nitrozen.android.R.drawable.ic_heart),
                    NitrozenSelectorItem.IconText("Item", com.nitrozen.android.R.drawable.ic_heart),
                    NitrozenSelectorItem.IconText("Item", com.nitrozen.android.R.drawable.ic_heart),
                ),
                selectedItemIndex = indexForIconTextH.value,
                onItemClick = {
                    indexForIconTextH.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            Text(
                text = "Icon Text Vertical",
                style = NitrozenTheme.typography.headingXs,
                modifier = Modifier.padding(top = 32.dp)
            )

            val indexForIconTextV = remember {
                mutableStateOf(0)
            }
            NitrozenSelector(
                items = listOf(
                    NitrozenSelectorItem.IconText("Item", com.nitrozen.android.R.drawable.ic_heart),
                    NitrozenSelectorItem.IconText("Item", com.nitrozen.android.R.drawable.ic_heart),
                    NitrozenSelectorItem.IconText("Item", com.nitrozen.android.R.drawable.ic_heart),
                ),
                selectedItemIndex = indexForIconTextV.value,
                onItemClick = {
                    indexForIconTextV.value = it
                },
                isItemDirectionVertical = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }

    }
}