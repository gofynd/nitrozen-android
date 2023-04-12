package com.nitrozen.android.ui.radiobutton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.radiobutton.NitrozenRadioButton
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewRadioButtonScreen() {
    NitrozenTheme {
        RadioButtonScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun RadioButtonScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "RadioButton",
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

            NitrozenRadioButton(
                text = "Click to toggle",
                selected = false,
                onClick = {

                },
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Selected",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenRadioButton(
                text = "Click to toggle",
                selected = true,
                onClick = {

                },
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }
}