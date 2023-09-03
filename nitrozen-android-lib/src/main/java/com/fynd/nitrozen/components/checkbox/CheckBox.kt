package com.fynd.nitrozen.components.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.checkbox.base.*
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
            enabled = false,
            configuration = NitrozenCheckBoxConfiguration.Default.copy(
                size = 16.dp
            )
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
    onTextClick: () -> Unit = {
      onCheckedChange(!checked)
    },
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
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
            Checkbox(
                modifier = Modifier
                    .alignByBaseline(),
                checked = checked,
                enabled = enabled,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = style.checkedColor,
                    checkmarkColor = style.checkmarkColor,
                    disabledColor = style.checkedColor,
                    uncheckedColor = style.uncheckedColor,
                ),
                size = configuration.size
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