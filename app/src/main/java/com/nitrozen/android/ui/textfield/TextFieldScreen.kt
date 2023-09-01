package com.nitrozen.android.ui.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.textfield.MaxCharacterConfiguration
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration.Default
import com.fynd.nitrozen.components.textfield.outlined.NitrozenOutlinedTextField
import com.fynd.nitrozen.components.textfield.outlined.NitrozenOutlinedTextFieldReadOnly
import com.fynd.nitrozen.components.textfield.TextFieldState
import com.fynd.nitrozen.components.tooltip.Default
import com.fynd.nitrozen.components.tooltip.NitrozenToolTipConfiguration
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple
import com.fynd.nitrozen.utils.tooltip.AnchorEdge
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewButtonsScreen() {
    NitrozenTheme {
        TextFieldScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun TextFieldScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "TextFields",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Outlined Normal",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedTextField(
                value = "",
                hint = "Hint",
                onValueChange = {},
                label = "Label",
                textFieldState = TextFieldState.Idle("Message goes here"),
                configuration = NitrozenTextFieldConfiguration.Outlined.Default.copy(
                    maxCharacterConfiguration = MaxCharacterConfiguration.Enabled(100, true)
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Outlined Success",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedTextField(
                value = "Valid value",
                hint = "Hint",
                onValueChange = {},
                label = "Label",
                textFieldState = TextFieldState.Success("Value is valid")
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Outlined Error",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedTextField(
                value = "Invalid value",
                hint = "Hint",
                onValueChange = {},
                label = "Label",
                textFieldState = TextFieldState.Error("Value is invalid")
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Outlined ReadOnly",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedTextFieldReadOnly(
                value = "ReadOnly Value",
                hint = "Hint",
                label = "Label",
                enabled = false,
                onClicked = {},
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Outlined ReadOnly With Tooltip",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(50.dp))

            var tooltipVisibleOutline by remember { mutableStateOf(false) }

            NitrozenOutlinedTextFieldReadOnly(
                value = "ReadOnly Value",
                hint = "Hint",
                label = "Label",
                enabled = false,
                onClicked = {},
                anchorView = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier
                            .clickableWithoutRipple {
                                tooltipVisibleOutline = !tooltipVisibleOutline
                            }
                    )
                },
                toolTipText = "Your Text",
                onDismissRequest = {
                    tooltipVisibleOutline = false
                },
                toolTipVisibility = tooltipVisibleOutline,
                toolTipConfiguration = NitrozenToolTipConfiguration.Default.copy(
                    anchorEdge = AnchorEdge.Top
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Outlined Multiline",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedTextField(
                value = "Multi line value that takes more then one line in the field",
                hint = "Hint",
                label = "Label",
                onValueChange = {},
                configuration = NitrozenTextFieldConfiguration.Outlined.Default.copy(
                    maxLine = 2,
                    fieldHeight = NitrozenTextFieldConfiguration.Outlined.Default.fieldHeight * 2,
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Outlined With Leading And Trailing",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedTextField(
                value = "",
                hint = "Hint",
                onValueChange = {},
                label = "Label",
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null)
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Outlined With Tooltip",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(50.dp))

            var tooltipVisible by remember { mutableStateOf(false) }

            NitrozenOutlinedTextField(
                value = "",
                hint = "Hint",
                onValueChange = {},
                label = "Label",
                anchorView = {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier
                            .clickableWithoutRipple {
                                tooltipVisible = !tooltipVisible
                            }
                    )
                },
                toolTipText = "Your Text",
                onDismissRequest = {
                    tooltipVisible = false
                },
                toolTipVisibility = tooltipVisible,
                toolTipConfiguration = NitrozenToolTipConfiguration.Default.copy(
                    anchorEdge = AnchorEdge.Top
                )
            )
        }
    }
}
