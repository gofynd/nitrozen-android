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
import com.fynd.nitrozen.components.button.outlined.NitrozenOutlinedButton
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

        NitrozenOutlinedButton(
            text = "Switch",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenSwitch)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "Badge",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenBadge)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "Stepper",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenStepper)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "DropDownTextField",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenDropDown)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "Divider",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenDivider)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "Avatar",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenAvatar)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "OTPField",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenOtpField)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "BottomNavigation",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenBottomNavigation)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "AppBar",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenAppBar)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "Selector",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenSelector)
            },
            modifier = Modifier.fillMaxWidth()
        )

        NitrozenOutlinedButton(
            text = "PageControl",
            enabled = true,
            onClick = {
                onAction(HomeScreenActions.OpenPageControl)
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
