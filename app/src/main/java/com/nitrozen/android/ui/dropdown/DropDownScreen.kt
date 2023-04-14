package com.nitrozen.android.ui.dropdown

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.dropdown.NitrozenDropDownTextField
import com.fynd.nitrozen.components.textfield.TextFieldState
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewDropDown() {
    NitrozenTheme {
        DropDownScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun DropDownScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "DropDownTextField",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Dropdown Selected",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDropDownTextField(
                modifier = Modifier
                    .padding(top = 16.dp),
                label = "Label",
                hint = "Hint",
                onClicked = {}
            )

            Spacer(modifier = Modifier.height(32.dp))


            Text(
                text = "Dropdown Selected",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDropDownTextField(
                modifier = Modifier
                    .padding(top = 16.dp),
                label = "Label",
                value = "Selected Item",
                hint = "Hint",
                onClicked = {}
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Dropdown With Subtitle",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDropDownTextField(
                modifier = Modifier
                    .padding(top = 16.dp),
                label = "Label",
                value = "Selected Item",
                hint = "Hint",
                onClicked = {},
                textFieldState = TextFieldState.Idle("Subtitle")
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Dropdown With Error",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDropDownTextField(
                modifier = Modifier
                    .padding(top = 16.dp),
                value = "Selected Item",
                label = "Label",
                hint = "Hint",
                onClicked = {},
                textFieldState = TextFieldState.Error("Error State")
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Dropdown With Success",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDropDownTextField(
                modifier = Modifier
                    .padding(top = 16.dp),
                value = "Selected Item",
                label = "Label",
                hint = "Hint",
                onClicked = {},
                textFieldState = TextFieldState.Success("Success State")
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}