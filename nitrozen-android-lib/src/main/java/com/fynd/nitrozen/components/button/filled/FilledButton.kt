package com.fynd.nitrozen.components.button.filled

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Preview(showBackground = true)
@Composable
private fun NitrozenFilledButton_Loading() {
    NitrozenTheme {
        NitrozenFilledButton(
            text = "Filled Button With Leading",
            enabled = true,
            onClick = {

            },
            isLoading = true
        )
    }
}


@Composable
fun NitrozenFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    leading: @Composable (() -> Unit)? = null,
    style: NitrozenButtonStyle.Filled = NitrozenButtonStyle.Filled.Default,
    configuration: NitrozenButtonConfiguration.Filled = NitrozenButtonConfiguration.Filled.Default,
) {
    val cutter = remember { MultipleEventsCutter.get() }

    val backgroundColor =
        if(isLoading){
            style.backgroundColorDisabled
        }else {
            if (enabled)
                style.backgroundColorEnabled
            else
                style.backgroundColorDisabled
        }

    TextButton(
        onClick = {
              cutter.processEvent(onClick)
        },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
        ),
        modifier = modifier
            .heightIn(min = configuration.minHeight),
        shape = configuration.shape,
        enabled = enabled,
        contentPadding = configuration.contentPadding
    ) {
        if(isLoading){
            CircularProgressIndicator(
                color = style.backgroundColorEnabled,
                strokeWidth = 4.dp,
            )
        }else {
            if (leading != null) {
                leading()
            }
            NitrozenAutoResizeText(
                text = text,
                style = NitrozenAutoResizeTextStyle(
                    textStyle = style.textStyle,
                    textColor = style.textColor,
                )
            )
        }
    }
}