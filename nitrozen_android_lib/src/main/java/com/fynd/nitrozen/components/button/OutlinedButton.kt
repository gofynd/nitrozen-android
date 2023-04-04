package com.fynd.nitrozen.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedButton_Enabled() {
    NitrozenTheme {
        NitrozenOutlinedButton(
            text = "Outlined Button Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedButton_Disabled() {
    NitrozenTheme {
        NitrozenOutlinedButton(
            text = "Outlined Button Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Composable
fun NitrozenOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .heightIn(min = 48.dp),
        shape = NitrozenTheme.shapes.pill,
        enabled = enabled,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            style = NitrozenTheme.typography.bodyMediumBold,
            color = NitrozenTheme.colors.primary60,
        )
    }
}