package com.nitrozen.android.ui.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.NitrozenFilledButton
import com.fynd.nitrozen.components.button.NitrozenOutlinedButton
import com.fynd.nitrozen.components.button.NitrozenTextButton
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewButtonsScreen() {
    NitrozenTheme {
        ButtonsScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun ButtonsScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Buttons",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Filled",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenFilledButton(
                text = "Enabled",
                enabled = true,
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenFilledButton(
                text = "Disabled",
                enabled = false,
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenFilledButton(
                text = "With Leading",
                enabled = true,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                leading = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Outlined",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedButton(
                text = "Enabled",
                enabled = true,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOutlinedButton(
                text = "Disabled",
                enabled = false,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Text",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenTextButton(
                text = "Enabled",
                enabled = true,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenTextButton(
                text = "Disabled",
                enabled = false,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenTextButton(
                text = "Underlined",
                enabled = true,
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                underline = true,
            )
        }

    }
}