package com.fynd.nitrozen.components.button

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview(showBackground = true)
@Composable
private fun NitrozenTextButton_Enabled() {
    NitrozenTheme {
        NitrozenTextButton(
            text = "Text Button Enabled",
            onClick = {},
            enabled = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenTextButton_Disabled() {
    NitrozenTheme {
        NitrozenTextButton(
            text = "Text Button Disabled",
            onClick = {},
            enabled = false
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenTextButton_Underlined() {
    NitrozenTheme {
        NitrozenTextButton(
            text = "Text Button Underlined",
            onClick = {},
            enabled = true,
            underline = true,
        )
    }
}

@Composable
fun NitrozenTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    underline: Boolean = false,
    color: Color = NitrozenTheme.colors.primary60,
    enabled: Boolean = true,
) {
    val textDecoration = if (underline)
        TextDecoration.Underline
    else
        TextDecoration.None

    val textColor =
        if (enabled)
            color
        else
            color.copy(alpha = 0.3F)

    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(),
        modifier = modifier
            .heightIn(min = 54.dp),
        shape = NitrozenTheme.shapes.rounded16,
        enabled = enabled,
    ) {
        Text(
            text = text,
            style = NitrozenTheme.typography.bodyXsLink,
            color = textColor,
            textDecoration = textDecoration,
        )
    }
}