package com.nitrozen.android.ui.typography

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewButtonsScreen() {
    NitrozenTheme {
        TypographyScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun TypographyScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Typography",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Heading XS",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Heading XXS",
                style = NitrozenTheme.typography.headingXxs
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Body Large Bold",
                style = NitrozenTheme.typography.bodyLBold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Body Medium Bold",
                style = NitrozenTheme.typography.bodyMediumBold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Body Small",
                style = NitrozenTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Body Small Regular",
                style = NitrozenTheme.typography.bodySmallRegular
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Body Small Bold",
                style = NitrozenTheme.typography.bodySmallBold
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Body XS Regular",
                style = NitrozenTheme.typography.bodyXsReg
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Body XS Bold",
                style = NitrozenTheme.typography.bodyXsBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Body XS Link",
                style = NitrozenTheme.typography.bodyXsLink
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Body XXS Regular",
                style = NitrozenTheme.typography.bodyXxsReg
            )
        }

    }
}