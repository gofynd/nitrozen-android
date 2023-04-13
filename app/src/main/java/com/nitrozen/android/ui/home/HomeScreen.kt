package com.nitrozen.android.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.NitrozenOutlinedButton
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
private fun PreviewHomeScreen() {
    NitrozenTheme {
        HomeScreen(
            onAction = {}
        )
    }
}

@Composable
fun HomeScreen(
    onAction: (HomeScreenActions) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Nitrozen",
            style = NitrozenTheme.typography.headingXs
        )

        NitrozenOutlinedButton(
            text = "Typography",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenTypography)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "Buttons",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenButtons)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "TextFields",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenTextFields)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "CheckBox",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenCheckBox)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "RadioButton",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenRadioButton)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "Chip",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenChip)
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}