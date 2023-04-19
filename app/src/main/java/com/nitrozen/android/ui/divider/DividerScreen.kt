package com.nitrozen.android.ui.divider

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
import com.fynd.nitrozen.components.divider.Default
import com.fynd.nitrozen.components.divider.NitrozenDivider
import com.fynd.nitrozen.components.divider.NitrozenDividerConfiguration
import com.fynd.nitrozen.components.divider.NitrozenDividerStyle
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewDividerScreen() {
    NitrozenTheme {
        DividerScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun DividerScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Divider",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Default",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDivider(
                modifier = Modifier
                    .padding(top = 16.dp),
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Thickness",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDivider(
                modifier = Modifier
                    .padding(top = 16.dp),
                configuration = NitrozenDividerConfiguration.Default.copy(
                    thickness = 16.dp
                )
            )

            Spacer(modifier = Modifier.height(32.dp))


            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Vertical",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDivider(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(42.dp),
                configuration = NitrozenDividerConfiguration.Default.copy(
                    direction = NitrozenDividerConfiguration.Direction.Vertical,
                    thickness = 4.dp
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Color",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDivider(
                modifier = Modifier
                    .padding(top = 16.dp),
                style = NitrozenDividerStyle.Default.copy(
                    backgroundColor = NitrozenTheme.colors.success50
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Shape",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenDivider(
                modifier = Modifier
                    .padding(top = 16.dp),
                style = NitrozenDividerStyle.Default.copy(
                    shape = NitrozenTheme.shapes.small
                ),
                configuration = NitrozenDividerConfiguration.Default.copy(
                    thickness = 18.dp
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}
