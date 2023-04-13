package com.nitrozen.android.ui.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.chip.NitrozenChip
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewCheckBoxScreen() {
    NitrozenTheme {
        ChipScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun ChipScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Chip",
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

            NitrozenChip(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Text"
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Leading Icon",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenChip(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Person",
                leading = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Trailing Icon",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenChip(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Item",
                trailing = {
                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = null,
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Leading And Trailing Icon",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenChip(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "email",
                trailing = {
                    Icon(
                        imageVector = Icons.Outlined.Clear,
                        contentDescription = null,
                    )
                },
                leading = {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = null,
                    )
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Clickable",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenChip(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Tap Here",
                onTap = {}
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Color Customization",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenChip(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Custom",
                backgroundColor = NitrozenTheme.colors.warning20,
                borderColor = NitrozenTheme.colors.warning80,
                textColor = NitrozenTheme.colors.warning80
            )

        }

    }
}