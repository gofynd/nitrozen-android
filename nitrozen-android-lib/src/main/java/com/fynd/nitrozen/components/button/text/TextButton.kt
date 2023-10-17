package com.fynd.nitrozen.components.button.text

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.components.autosizetext.Default
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeText
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeTextStyle
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration.Default
import com.fynd.nitrozen.components.button.NitrozenButtonStyle
import com.fynd.nitrozen.components.button.NitrozenButtonStyle.Default
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.MultipleEventsCutter
import com.fynd.nitrozen.utils.extensions.get

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
            style = NitrozenButtonStyle.Text.Default.copy(
                textDecoration = TextDecoration.Underline,
            ),
        )
    }
}

@Composable
fun NitrozenTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    leading: @Composable (()->Unit)? = null,
    style: NitrozenButtonStyle.Text = NitrozenButtonStyle.Text.Default,
    configuration: NitrozenButtonConfiguration.Text = NitrozenButtonConfiguration.Text.Default,
) {
    val cutter = remember { MultipleEventsCutter.get() }
    val textColor =
        if (enabled)
            style.textColorEnabled
        else
            style.textColorDisabled

    TextButton(
        onClick = {
            cutter.processEvent(onClick)
        },
        colors = ButtonDefaults.textButtonColors(),
        modifier = modifier
            .heightIn(min = configuration.minHeight),
        shape = configuration.shape,
        enabled = enabled,
        contentPadding = configuration.contentPadding,
    ) {
        leading?.invoke()
        NitrozenAutoResizeText(
            text = text,
            style = NitrozenAutoResizeTextStyle.Default.copy(
                textStyle = style.textStyle,
                textColor = textColor,
                textDecoration = style.textDecoration
            )
        )
    }
}