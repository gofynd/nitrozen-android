package com.fynd.nitrozen.components.tooltip

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.autosizetext.Default
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeText
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeTextStyle
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple
import com.fynd.nitrozen.utils.tooltip.AnchorEdge
import com.fynd.nitrozen.utils.tooltip.EdgePosition
import com.fynd.nitrozen.utils.tooltip.Tooltip
import com.fynd.nitrozen.utils.tooltip.TooltipStyle

@Preview
@Composable
fun NitrozenTooltipPreview() {
    NitrozenTheme {
        var tooltipVisible by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .size(500.dp)
                .background(color = NitrozenTheme.colors.grey40),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NitrozenTooltip(
                modifier = Modifier,
                tooltipText = "Your text",
                anchorView = {
                    Text(
                        modifier = Modifier
                            .clickableWithoutRipple {
                                tooltipVisible = !tooltipVisible
                            },
                        text = "Tap here",
                    )
                },
                configuration = NitrozenToolTipConfiguration(
                    anchorEdge = AnchorEdge.Top,
                    edgePosition = EdgePosition(0.5f)
                ),
                visibility = tooltipVisible,
                onDismissRequest = {
                    tooltipVisible = false
                }
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NitrozenTooltip(
    modifier: Modifier = Modifier,
    anchorView: @Composable (() -> Unit),
    tooltipText: String,
    style: NitrozenTooltipStyle = NitrozenTooltipStyle.Default,
    configuration: NitrozenToolTipConfiguration = NitrozenToolTipConfiguration.Default,
    visibility: Boolean = false,
    onDismissRequest: () -> Unit
) {
    Box(
        modifier = modifier,
    ) {
        anchorView()

        Tooltip(
            anchorEdge = configuration.anchorEdge,
            visible = visibility,
            enterTransition = fadeIn(),
            exitTransition = fadeOut(),
            tipPosition = configuration.edgePosition,
            tooltipStyle = TooltipStyle(
                color = style.backgroundColor,
                cornerRadius = NitrozenTheme.radius.medium,
                tipWidth = 24.dp,
                tipHeight = 8.dp,
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ),
            margin = 3.dp,
            onDismissRequest = {
                onDismissRequest()
            }
        ) {
            if(configuration.isAutoResizeEnabled){
                NitrozenAutoResizeText(
                    text = tooltipText,
                    style = NitrozenAutoResizeTextStyle.Default.copy(
                        textStyle = style.textStyle,
                        textColor = style.textColor
                    ),
                )
            }else {
                Text(
                    text = tooltipText,
                    modifier = Modifier.widthIn(max = 256.dp),
                    color = style.textColor,
                    style = style.textStyle
                )
            }
        }
    }
}