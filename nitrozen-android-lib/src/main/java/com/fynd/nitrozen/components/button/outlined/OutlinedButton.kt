package com.fynd.nitrozen.components.button.outlined

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration
import com.fynd.nitrozen.components.button.NitrozenButtonConfiguration.Default
import com.fynd.nitrozen.components.button.NitrozenButtonStyle
import com.fynd.nitrozen.components.button.NitrozenButtonStyle.Default
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.MultipleEventsCutter
import com.fynd.nitrozen.utils.extensions.get

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
    style: NitrozenButtonStyle.Outlined = NitrozenButtonStyle.Outlined.Default,
    configuration: NitrozenButtonConfiguration.Outlined = NitrozenButtonConfiguration.Outlined.Default,
) {
    val cutter = remember { MultipleEventsCutter.get() }

    val color = if (enabled)
        style.textColorEnabled
    else
        style.textColorDisabled

    OutlinedButton(
        onClick = {
            cutter.processEvent(onClick)
        },
        modifier = modifier
            .heightIn(min = configuration.minHeight),
        shape = configuration.shape,
        enabled = enabled,
        contentPadding = configuration.contentPadding,
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = style.backgroundColor
        ),
        border = BorderStroke(
            width = 1.dp,
            color = style.borderColor
        )
    ) {
        Text(
            text = text,
            style = style.textStyle,
            color = color,
        )
    }
}