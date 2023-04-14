package com.nitrozen.android.ui.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.badge.NitrozenBadge
import com.fynd.nitrozen.components.badge.NitrozenBadgeStyle
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewBadgeScreen() {
    NitrozenTheme {
        BadgeScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun BadgeScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Badge",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Default",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenBadge(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Badge"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Warning",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenBadge(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Badge",
                style = NitrozenBadgeStyle(
                    backgroundColor = NitrozenTheme.colors.warning20,
                    textColor = NitrozenTheme.colors.warning80,
                    textStyle = NitrozenTheme.typography.bodySmall
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Success",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenBadge(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Badge",
                style = NitrozenBadgeStyle(
                    backgroundColor = NitrozenTheme.colors.success20,
                    textColor = NitrozenTheme.colors.success80,
                    textStyle = NitrozenTheme.typography.bodySmall
                )
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Error",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenBadge(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Badge",
                style = NitrozenBadgeStyle(
                    backgroundColor = NitrozenTheme.colors.error20,
                    textColor = NitrozenTheme.colors.error80,
                    textStyle = NitrozenTheme.typography.bodySmall
                )
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}