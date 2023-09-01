package com.nitrozen.android.ui.tooltip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.tooltip.NitrozenToolTipConfiguration
import com.fynd.nitrozen.components.tooltip.NitrozenTooltip
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple
import com.fynd.nitrozen.utils.tooltip.AnchorEdge
import com.fynd.nitrozen.utils.tooltip.EdgePosition
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewToolTipScreen() {
    NitrozenTheme {
        ToolTipScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun ToolTipScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        var tooltipTopVisible by remember { mutableStateOf(false) }
        var tooltipBottomVisible by remember { mutableStateOf(false) }
        var tooltipStartVisible by remember { mutableStateOf(false) }
        var tooltipEndVisible by remember { mutableStateOf(false) }

        ComponentAppBar(
            title = "Tooltip",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Align Top",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .height(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                NitrozenTooltip(
                    modifier = Modifier,
                    tooltipText = "Your text",
                    anchorView = {
                        Text(
                            modifier = Modifier
                                .clickableWithoutRipple {
                                    tooltipTopVisible = !tooltipTopVisible
                                },
                            text = "Tap here",
                        )
                    },
                    configuration = NitrozenToolTipConfiguration(
                        anchorEdge = AnchorEdge.Top,
                        edgePosition = EdgePosition(0.5f)
                    ),
                    visibility = tooltipTopVisible,
                    onDismissRequest = {
                        tooltipTopVisible = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Align Bottom",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .height(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                NitrozenTooltip(
                    modifier = Modifier,
                    tooltipText = "Your text",
                    anchorView = {
                        Text(
                            modifier = Modifier
                                .clickableWithoutRipple {
                                    tooltipBottomVisible = !tooltipBottomVisible
                                },
                            text = "Tap here",
                        )
                    },
                    configuration = NitrozenToolTipConfiguration(
                        anchorEdge = AnchorEdge.Bottom,
                        edgePosition = EdgePosition(0.5f)
                    ),
                    visibility = tooltipBottomVisible,
                    onDismissRequest = {
                        tooltipBottomVisible = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Align Start",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
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
                                    tooltipStartVisible = !tooltipStartVisible
                                },
                            text = "Tap here",
                        )
                    },
                    configuration = NitrozenToolTipConfiguration(
                        anchorEdge = AnchorEdge.Start,
                        edgePosition = EdgePosition(0.5f)
                    ),
                    visibility = tooltipStartVisible,
                    onDismissRequest = {
                        tooltipStartVisible = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Align End",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth(),
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
                                    tooltipEndVisible = !tooltipEndVisible
                                },
                            text = "Tap here",
                        )
                    },
                    configuration = NitrozenToolTipConfiguration(
                        anchorEdge = AnchorEdge.End,
                        edgePosition = EdgePosition(0.5f)
                    ),
                    visibility = tooltipEndVisible,
                    onDismissRequest = {
                        tooltipEndVisible = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}