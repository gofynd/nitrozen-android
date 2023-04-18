package com.nitrozen.android.ui.emptyview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.text.NitrozenTextButton
import com.fynd.nitrozen.components.emptyview.NitrozenEmptyView
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewBadgeScreen() {
    NitrozenTheme {
        EmptyViewScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun EmptyViewScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "EmptyView",
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

            NitrozenEmptyView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                title = "No items found",
                subtitle = "Come back and check again"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Custom Action",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenEmptyView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                title = "No items found",
                bottomContent = {
                    NitrozenTextButton(
                        modifier = Modifier,
                        text = "Add Item",
                        onClick = {

                        }
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}