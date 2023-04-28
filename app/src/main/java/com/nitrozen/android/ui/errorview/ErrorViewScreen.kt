package com.nitrozen.android.ui.errorview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.text.NitrozenTextButton
import com.fynd.nitrozen.components.errorview.NitrozenErrorView
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewErrorViewScreen() {
    NitrozenTheme {
        ErrorViewScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun ErrorViewScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "ErrorView",
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

            NitrozenErrorView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                title = "No internet connection",
                subtitle = "Check your connection, then refresh the page",
                topContent = {
                     Icon(
                         modifier = Modifier
                             .size(120.dp)
                             .padding(bottom = 8.dp),
                         painter = painterResource(id = com.nitrozen.android.R.drawable.no_internet),
                         contentDescription = null,
                         tint = NitrozenTheme.colors.primary40
                     )
                },
                bottomContent = {
                    NitrozenTextButton(
                        modifier = Modifier,
                        text = "Refresh",
                        onClick = {

                        }
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}