package com.nitrozen.android.ui.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.checkbox.NitrozenCheckBox
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewCheckBoxScreen() {
    NitrozenTheme {
        CheckBoxScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun CheckBoxScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "CheckBox",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Normal",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenCheckBox(
                text = "Click to toggle",
                checked = false,
                onCheckedChange = {

                },
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Checked",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenCheckBox(
                text = "Click to toggle",
                checked = true,
                onCheckedChange = {

                },
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Disabled",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenCheckBox(
                text = "Click to toggle",
                checked = true,
                onCheckedChange = {

                },
                enabled = false,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }
}