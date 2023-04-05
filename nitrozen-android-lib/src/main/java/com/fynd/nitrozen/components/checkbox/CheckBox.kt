package com.fynd.nitrozen.components.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple

@Preview(showBackground = true)
@Composable
private fun NitrozenCheckBox_Normal() {
    NitrozenTheme {
        NitrozenCheckBox(
            text = "CheckBox Normal",
            onCheckedChange = {},
            onTextClick = {},
            checked = false,
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

@Composable
fun NitrozenCheckBox(
    modifier: Modifier = Modifier,
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTextClick: () -> Unit = {},
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .alpha(
                if (enabled) 1f else 0.3f
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            modifier = Modifier,
            checked = checked,
            enabled = enabled,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = NitrozenTheme.colors.primary50,
                checkmarkColor = NitrozenTheme.colors.background,
                disabledColor = NitrozenTheme.colors.primary50,
            ),
        )
        Text(
            text = text,
            style = NitrozenTheme.typography.bodySmall,
            color = NitrozenTheme.colors.grey100,
            modifier = Modifier.clickableWithoutRipple(onTextClick)
        )
    }
}