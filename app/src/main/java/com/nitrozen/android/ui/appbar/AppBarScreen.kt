package com.nitrozen.android.ui.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.appbar.NitrozenAppBar
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewBadgeScreen() {
    NitrozenTheme {
        AppBarScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun AppBarScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "AppBar",
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

            NitrozenAppBar(
                title = "Account",
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Leading Title",
                style = NitrozenTheme.typography.headingXs,
                modifier = Modifier.padding(top = 32.dp)
            )

            NitrozenAppBar(
                title = "Account",
                leading = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = NitrozenTheme.colors.background
                        )
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Title Trailing",
                style = NitrozenTheme.typography.headingXs,
                modifier = Modifier.padding(top = 32.dp)
            )

            NitrozenAppBar(
                title = "Account",
                trailing = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = NitrozenTheme.colors.background
                        )
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = "Leading Title Trailing",
                style = NitrozenTheme.typography.headingXs,
                modifier = Modifier.padding(top = 32.dp)
            )

            NitrozenAppBar(
                title = "Account",
                trailing = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = NitrozenTheme.colors.background
                        )
                    }
                },
                leading = {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = NitrozenTheme.colors.background
                        )
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }
}