package com.nitrozen.android.ui.pagecontrol

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.filled.NitrozenFilledButton
import com.fynd.nitrozen.components.pagecontrol.Default
import com.fynd.nitrozen.components.pagecontrol.DotConfiguration
import com.fynd.nitrozen.components.pagecontrol.DotStyle
import com.fynd.nitrozen.components.pagecontrol.NitrozenPageControl
import com.fynd.nitrozen.components.pagecontrol.NitrozenPageControlConfiguration
import com.fynd.nitrozen.components.pagecontrol.NitrozenPageControlStyle
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewCheckBoxScreen() {
    NitrozenTheme {
        PageControlScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun PageControlScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "PageControl",
            onBackClick = onBackClick
        )

        val selectedItem = remember {
            mutableStateOf(2)
        }

        val dotCount = 5

        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                Text(
                    text = "Default",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenPageControl(
                    modifier = Modifier,
                    dotCount = dotCount,
                    selectedDot = selectedItem.value
                )

                Text(
                    text = "Custom Color",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenPageControl(
                    modifier = Modifier,
                    dotCount = dotCount,
                    selectedDot = selectedItem.value,
                    style = NitrozenPageControlStyle.Default.copy(
                        selectedDotStyle = NitrozenPageControlStyle.Default.selectedDotStyle.copy(
                            color = NitrozenTheme.colors.success80,
                        ),
                        defaultDotStyle = NitrozenPageControlStyle.Default.defaultDotStyle.copy(
                            color = NitrozenTheme.colors.success80.copy(
                                alpha = 0.3f
                            )
                        )
                    )
                )

                Text(
                    text = "Custom Shape And Border",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenPageControl(
                    modifier = Modifier,
                    dotCount = dotCount,
                    selectedDot = selectedItem.value,
                    style = NitrozenPageControlStyle.Default.copy(
                        DotStyle(
                            shape = NitrozenTheme.shapes.topRoundedXl,
                            color = NitrozenTheme.colors.success50,
                            borderWidth = 1.dp,
                            borderColor = NitrozenTheme.colors.success80
                        ),
                        defaultDotStyle = DotStyle(
                            shape = NitrozenTheme.shapes.topRoundedXl,
                            color = NitrozenTheme.colors.success20,
                            borderWidth = 1.dp,
                            borderColor = NitrozenTheme.colors.success80
                        )
                    )
                )

                Text(
                    text = "Custom Size And Spacing",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenPageControl(
                    modifier = Modifier,
                    dotCount = dotCount,
                    selectedDot = selectedItem.value,
                    configuration = NitrozenPageControlConfiguration.Default.copy(
                        selectedDotConfiguration = DotConfiguration(
                            width = 14.dp,
                            height = 14.dp
                        ),
                        defaultDotConfiguration = DotConfiguration(
                            width = 10.dp,
                            height = 10.dp
                        ),
                        dotSpacing = 16.dp
                    )
                )

                Text(
                    text = "Complete Example",
                    style = NitrozenTheme.typography.headingXs
                )

                NitrozenPageControl(
                    modifier = Modifier,
                    dotCount = dotCount,
                    selectedDot = selectedItem.value,
                    style = NitrozenPageControlStyle(
                        selectedDotStyle = DotStyle(
                            shape = RectangleShape,
                            color = NitrozenTheme.colors.grey60,
                            borderWidth = 1.dp,
                            borderColor = NitrozenTheme.colors.grey100
                        ),
                        defaultDotStyle = DotStyle(
                            shape = RectangleShape,
                            color = NitrozenTheme.colors.grey40,
                            borderWidth = 1.dp,
                            borderColor = NitrozenTheme.colors.grey100
                        )
                    ),
                    configuration = NitrozenPageControlConfiguration(
                        selectedDotConfiguration = DotConfiguration(
                            width = 40.dp,
                            height = 24.dp
                        ),
                        defaultDotConfiguration = DotConfiguration(
                            width = 24.dp,
                            height = 16.dp
                        ),
                        dotSpacing = 16.dp
                    )
                )
            }

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                NitrozenFilledButton(
                    modifier = Modifier.weight(1f),
                    text = "Previous",
                    onClick = {
                        selectedItem.value = selectedItem
                            .value
                            .minus(1)
                            .coerceIn(1,dotCount)
                    }
                )

                NitrozenFilledButton(
                    modifier = Modifier.weight(1f),
                    text = "Next",
                    onClick = {
                        selectedItem.value = selectedItem
                            .value
                            .plus(1)
                            .coerceIn(1,dotCount)
                    }
                )
            }
        }
    }
}
