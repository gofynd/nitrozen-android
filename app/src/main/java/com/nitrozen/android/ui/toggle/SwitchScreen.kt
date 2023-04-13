package com.nitrozen.android.ui.toggle

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
import com.fynd.nitrozen.components.toggle.NitrozenSwitch
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewCheckBoxScreen() {
    NitrozenTheme {
        SwitchScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun SwitchScreen(
    onBackClick: () -> Unit
) {
    var checkedState by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Switch",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Checked",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenSwitch(
                modifier = Modifier
                    .padding(top = 16.dp),
                checked = true,
                onCheckedChange = {}
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Unchecked",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenSwitch(
                modifier = Modifier
                    .padding(top = 16.dp),
                checked = false,
                onCheckedChange = {}
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Interactive",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenSwitch(
                modifier = Modifier
                    .padding(top = 16.dp),
                checked = checkedState,
                onCheckedChange = {
                    checkedState = it
                }
            )


        }

    }
}