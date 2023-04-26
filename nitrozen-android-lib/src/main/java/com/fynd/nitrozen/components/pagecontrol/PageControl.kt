package com.fynd.nitrozen.components.pagecontrol

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithRipple

@Preview(showBackground = true)
@Composable
private fun PageControlPreview() {
    var currentItem : Int by remember {
        mutableStateOf(1)
    }
    NitrozenTheme {
        NitrozenPageControl(
            modifier = Modifier
                .clickableWithRipple {
                    currentItem += 1
                }
                .padding(8.dp),
            dotCount = 5,
            selectedDot = currentItem,
            enableAnimation = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PageControlCustomPreview() {
    NitrozenTheme {
        NitrozenPageControl(
            modifier = Modifier.padding(8.dp),
            dotCount = 5,
            selectedDot = 2,
            style = NitrozenPageControlStyle(
                selectedDotStyle = DotStyle(
                    shape = RectangleShape,
                    color = NitrozenTheme.colors.primary40,
                    borderWidth = 1.dp,
                    borderColor = NitrozenTheme.colors.primary50
                ),
                defaultDotStyle = DotStyle(
                    shape = NitrozenTheme.shapes.round,
                    color = NitrozenTheme.colors.primary20,
                    borderWidth = 1.dp,
                    borderColor = NitrozenTheme.colors.grey40
                )
            ),
            configuration = NitrozenPageControlConfiguration(
                selectedDotConfiguration = DotConfiguration(
                    width = 18.dp,
                    height = 12.dp
                ),
                defaultDotConfiguration = DotConfiguration(
                    width = 12.dp,
                    height = 5.dp
                ),
                dotSpacing = 10.dp
            )
        )
    }
}

/**
* A composable function that displays a Nitrozen Page Control.
* @param modifier optional [Modifier] to apply to the composable
* @param dotCount an [Int] value indicating the total number of dots to be displayed in the page control
* @param selectedDot an [Int] value indicating the currently selected dot in the page control
* @param enableAnimation [Boolean] whether to enable animations or not
* @param style [NitrozenPageControlStyle] indicating the style of the page control, defaults to [NitrozenPageControlStyle.Companion.Default]
* @param configuration [NitrozenPageControlConfiguration] indicating the configuration of the page control, defaults to [NitrozenPageControlConfiguration.Companion.Default]
* */
@Composable
fun NitrozenPageControl(
    modifier: Modifier = Modifier,
    dotCount : Int,
    selectedDot : Int,
    enableAnimation : Boolean = true,
    style: NitrozenPageControlStyle = NitrozenPageControlStyle.Default,
    configuration: NitrozenPageControlConfiguration = NitrozenPageControlConfiguration.Default,
) {
    Row(
        modifier = modifier
            .height(
                max(
                    configuration.selectedDotConfiguration.height,
                    configuration.defaultDotConfiguration.height
                )
            ),
        horizontalArrangement = Arrangement.spacedBy(configuration.dotSpacing),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(dotCount){ index ->
            val isCurrentItem = index == (selectedDot - 1).coerceIn(0, dotCount - 1)
            if(enableAnimation) {
                Dot(
                    modifier = Modifier,
                    style = style,
                    configuration = configuration,
                    selected = isCurrentItem
                )
            }else{
                if(isCurrentItem){
                    Dot(
                        modifier = Modifier,
                        style = style,
                        configuration = configuration,
                        selected = true
                    )
                }else{
                    Dot(
                        modifier = Modifier,
                        style = style,
                        configuration = configuration,
                        selected = false
                    )
                }
            }
        }
    }
}

@Composable
private fun Dot(
    modifier: Modifier,
    style: NitrozenPageControlStyle,
    configuration: NitrozenPageControlConfiguration,
    selected : Boolean
) {
    val duration = 1000

    val color = animateColorAsState(
        targetValue = if(selected)
            style.selectedDotStyle.color
        else style.defaultDotStyle.color,
        animationSpec = tween(durationMillis = duration)
    )

    val width = animateDpAsState(
        targetValue = if(selected)
            configuration.selectedDotConfiguration.width
        else configuration.defaultDotConfiguration.width,
        animationSpec = tween(durationMillis = duration)

    )

    val height = animateDpAsState(
        targetValue = if(selected)
            configuration.selectedDotConfiguration.height
        else configuration.defaultDotConfiguration.height,
        animationSpec = tween(durationMillis = duration)

    )

    val shape = if(selected)
        style.selectedDotStyle.shape
    else style.defaultDotStyle.shape

    val borderWidth = animateDpAsState(
        targetValue = if(selected)
            style.selectedDotStyle.borderWidth
        else style.defaultDotStyle.borderWidth,
        animationSpec = tween(durationMillis = duration)

    )

    val borderColor = animateColorAsState(
        targetValue = if(selected)
            style.selectedDotStyle.borderColor
        else style.defaultDotStyle.borderColor,
        animationSpec = tween(durationMillis = duration)
    )


    Box(
        modifier = modifier
            .size(
                width = width.value,
                height = height.value,
            )
            .background(
                color = color.value,
                shape = shape,
            )
            .border(
                width = borderWidth.value,
                color = borderColor.value,
                shape = shape
            )
    )
}