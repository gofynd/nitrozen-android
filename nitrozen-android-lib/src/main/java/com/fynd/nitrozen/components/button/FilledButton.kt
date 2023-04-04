package com.fynd.nitrozen.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview(showBackground = true)
@Composable
private fun NitrozenFilledButton_Enabled() {
    NitrozenTheme {
        NitrozenFilledButton(
            text = "Filled Button Enabled",
            enabled = true,
            onClick = {

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenFilledButton_Disabled() {
    NitrozenTheme {
        NitrozenFilledButton(
            text = "Filled Button Disabled",
            enabled = false,
            onClick = {

            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenFilledButton_WithLeading() {
    NitrozenTheme {
        NitrozenFilledButton(
            text = "Filled Button With Leading",
            enabled = true,
            onClick = {

            },
            leading = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        )
    }
}

@Composable
fun NitrozenFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    leading: @Composable (() -> Unit)? = null,
    onClick: () -> Unit,
) {
    val backgroundColor =
        if (enabled)
            NitrozenTheme.colors.primary50
        else
            NitrozenTheme.colors.primary50.copy(alpha = 0.3F)
    val textColor = NitrozenTheme.colors.inverse

    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
        ),
        modifier = modifier
            .heightIn(min = 48.dp),
        shape = NitrozenTheme.shapes.pill,
        enabled = enabled,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        if (leading != null) {
            leading()
        }
        Text(
            text = text,
            style = NitrozenTheme.typography.bodyMediumBold,
            color = textColor,
        )
    }
}