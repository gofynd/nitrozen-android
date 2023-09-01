package com.nitrozen.android.ui.autosizetext

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.components.autosizetext.Default
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeText
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeTextConfiguration
import com.fynd.nitrozen.components.stepper.NitrozenStepper
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewSwitchScreen() {
    NitrozenTheme {
        AutoResizeTextScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun AutoResizeTextScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "AutoSizeText",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Text with no change",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = NitrozenTheme.colors.primary50,
                        shape = NitrozenTheme.shapes.rounded16
                    )
                    .padding(10.dp)
                    .width(42.dp)
            ) {
                NitrozenAutoResizeText(
                    modifier = Modifier,
                    text = "Auto"
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Resized Text",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = NitrozenTheme.colors.primary50,
                        shape = NitrozenTheme.shapes.rounded16
                    )
                    .padding(10.dp)
                    .width(110.dp)
            ) {
                NitrozenAutoResizeText(
                    modifier = Modifier,
                    text = "Auto Resize Text"
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Resized + Ellipsized Text",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = NitrozenTheme.colors.primary50,
                        shape = NitrozenTheme.shapes.rounded16
                    )
                    .padding(10.dp)
                    .width(80.dp)
            ) {
                NitrozenAutoResizeText(
                    modifier = Modifier,
                    text = "Auto Resize Text",
                    configuration = NitrozenAutoResizeTextConfiguration(
                        minFontSize = 12.sp,
                        maxLines = 1
                    )
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Multiline Text",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = NitrozenTheme.colors.primary50,
                        shape = NitrozenTheme.shapes.rounded16
                    )
                    .padding(10.dp)
                    .width(120.dp)
            ) {
                NitrozenAutoResizeText(
                    modifier = Modifier,
                    text = "This is a very long text to test multiline text",
                    configuration = NitrozenAutoResizeTextConfiguration(
                        minFontSize = 12.sp,
                        maxLines = 2
                    )
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}