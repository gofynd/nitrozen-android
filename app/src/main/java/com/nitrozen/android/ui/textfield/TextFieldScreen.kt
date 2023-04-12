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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.textfield.NitrozenOutlinedTextField
import com.fynd.nitrozen.components.textfield.NitrozenOutlinedTextFieldReadOnly
import com.fynd.nitrozen.components.textfield.TextFieldState
import com.fynd.nitrozen.theme.NitrozenTheme
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
                textFieldState = TextFieldState.Idle("Message goes here")
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
                onClicked = {}
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
        }

    }
}