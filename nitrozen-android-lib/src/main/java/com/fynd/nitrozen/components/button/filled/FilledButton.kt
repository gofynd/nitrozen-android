package com.fynd.nitrozen.components.button.filled

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
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration.Default
import com.fynd.nitrozen.components.button.NitrozenButtonStyle
import com.fynd.nitrozen.components.button.NitrozenButtonStyle.Default
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
    onClick: () -> Unit,
    enabled: Boolean = true,
    leading: @Composable (() -> Unit)? = null,
    style: NitrozenButtonStyle.Filled = NitrozenButtonStyle.Filled.Default,
    configuration: NitrozenButtonConfiguration.Filled = NitrozenButtonConfiguration.Filled.Default,
) {
    val backgroundColor =
        if (enabled)
            style.backgroundColorEnabled
        else
            style.backgroundColorDisabled

    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
        ),
        modifier = modifier
            .heightIn(min = configuration.minHeight),
        shape = configuration.shape,
        enabled = enabled,
        contentPadding = configuration.contentPadding
    ) {
        if (leading != null) {
            leading()
        }
        Text(
            text = text,
            style = style.textStyle,
            color = style.textColor,
        )
    }
}