package com.fynd.nitrozen.components.selector

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.R
import com.fynd.nitrozen.utils.DisplayMetrics

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
            modifier = Modifier.width(300.dp)
        )
    }
}

@Preview
@Composable
fun NitrozenSelector_Icon() {
    val selectedItemIndex = remember {
        mutableStateOf(0)
    }

    NitrozenTheme {
        NitrozenSelector(
            items = listOf(
                NitrozenSelectorItem.Icon(R.drawable.ic_chevron_down),
                NitrozenSelectorItem.Icon(R.drawable.ic_chevron_down),
                NitrozenSelectorItem.Icon(R.drawable.ic_chevron_down),
            ),
            selectedItemIndex = selectedItemIndex.value,
            onItemClick = {
                selectedItemIndex.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun NitrozenSelector_IconText_Horizontal() {
    val selectedItemIndex = remember {
        mutableStateOf(0)
    }

    NitrozenTheme {
        NitrozenSelector(
            items = listOf(
                NitrozenSelectorItem.IconText("Item", R.drawable.ic_chevron_down),
                NitrozenSelectorItem.IconText("Item", R.drawable.ic_chevron_down),
                NitrozenSelectorItem.IconText("Item", R.drawable.ic_chevron_down),
            ),
            selectedItemIndex = selectedItemIndex.value,
            onItemClick = {
                selectedItemIndex.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun NitrozenSelector_IconText_Vertical() {
    val selectedItemIndex = remember {
        mutableStateOf(0)
    }

    NitrozenTheme {
        NitrozenSelector(
            items = listOf(
                NitrozenSelectorItem.IconText("Item", R.drawable.ic_chevron_down),
                NitrozenSelectorItem.IconText("Item", R.drawable.ic_chevron_down),
                NitrozenSelectorItem.IconText("Item", R.drawable.ic_chevron_down),
            ),
            selectedItemIndex = selectedItemIndex.value,
            isItemDirectionVertical = true,
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
    isItemDirectionVertical: Boolean = false,
    style: NitrozenSelectorStyle = NitrozenSelectorStyle.Default,
    configuration: NitrozenSelectorConfiguration = NitrozenSelectorConfiguration.Default,
) {
    Box(
        modifier = modifier
            .clip(NitrozenTheme.shapes.pill)
            .background(
                color = style.backgroundColor,
                shape = NitrozenTheme.shapes.pill
            )
            .padding(configuration.contentPadding),
        contentAlignment = Alignment.CenterStart
    ) {
        val selectorWidth = remember {
            mutableStateOf(0.dp)
        }

        val selectorHeight = remember {
            mutableStateOf(0.dp)
        }

        val selectorTranslationTarget = remember {
            mutableStateOf(0F)
        }

        val selectorTranslationX = animateFloatAsState(targetValue = selectorTranslationTarget.value)

        Box(
            modifier = Modifier
                .graphicsLayer(
                    translationX = if (configuration.allowAnimation)
                        selectorTranslationX.value
                    else
                        selectorTranslationTarget.value
                )
                .size(width = selectorWidth.value, height = selectorHeight.value)
                .background(
                    color = style.selectedBackgroundColor,
                    shape = NitrozenTheme.shapes.pill
                )
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = configuration.spaceBetweenItems,
                alignment = Alignment.CenterHorizontally
            ),
        ) {
            items.forEachIndexed { index, item ->
                val selected = index == selectedItemIndex
                NitrozenSelectorPill(
                    item = item,
                    selected = selected,
                    onClick = {
                        onItemClick(index)
                        selectorTranslationTarget.value = (index * DisplayMetrics.convertDpToPixel(selectorWidth.value.value)) + (index * DisplayMetrics.convertDpToPixel(configuration.spaceBetweenItems.value))
                    },
                    modifier = Modifier
                        .weight(1F)
                        .onSizeChanged {
                            selectorWidth.value = DisplayMetrics.convertPixelsToDp(it.width.toFloat()).dp
                            selectorHeight.value = DisplayMetrics.convertPixelsToDp(it.height.toFloat()).dp
                        },
                    isItemDirectionVertical = isItemDirectionVertical
                )
            }
        }
    }

}