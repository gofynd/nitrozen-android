package com.fynd.nitrozen.components.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple

@Preview(showBackground = true)
@Composable
private fun NitrozenCheckBox_Normal() {
    var checked by remember {
        mutableStateOf(false)
    }
    NitrozenTheme {
        NitrozenCheckBox(
            text = "CheckBox Normal",
            onCheckedChange = {
                  checked = !checked
            },
            onTextClick = {
                  checked = !checked
            },
            checked = checked,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenCheckBox_Enabled() {
    NitrozenTheme {
        NitrozenCheckBox(
            text = "CheckBox Enabled",
            onCheckedChange = {},
            onTextClick = {},
            checked = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenCheckBox_Disabled() {
    NitrozenTheme {
        NitrozenCheckBox(
            text = "CheckBox Disabled",
            onCheckedChange = {},
            onTextClick = {},
            checked = true,
            enabled = false
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NitrozenCheckBox(
    modifier: Modifier = Modifier,
    text: String? = null,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTextClick: () -> Unit = {},
    enabled: Boolean = true,
    style: NitrozenCheckBoxStyle = NitrozenCheckBoxStyle.Default,
    configuration: NitrozenCheckBoxConfiguration = NitrozenCheckBoxConfiguration.Default,
) {
    Row(
        modifier = modifier
            .alpha(if (enabled) 1f else 0.3f),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
            Checkbox(
                modifier = Modifier,
                checked = checked,
                enabled = enabled,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = style.checkedColor,
                    checkmarkColor = style.checkmarkColor,
                    disabledColor = style.checkedColor,
                    uncheckedColor = style.uncheckedColor,
                ),
            )
        }

        if (text != null) {
            Text(
                text = text,
                style = style.textStyle,
                color = style.textColor,
                modifier = Modifier
                    .then(
                        if (enabled)
                            Modifier.clickableWithoutRipple(onTextClick)
                        else Modifier
                    )
                    .padding(configuration.textPadding)
            )
        }
    }
}