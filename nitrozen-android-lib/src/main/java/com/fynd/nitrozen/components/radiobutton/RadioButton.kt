package com.fynd.nitrozen.components.radiobutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple

@Preview(showBackground = true)
@Composable
private fun NitrozenRadioButton_Normal() {
    NitrozenTheme {
        NitrozenRadioButton(
            text = "RadioButton Normal",
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenRadioButton_Selected() {
    NitrozenTheme {
        NitrozenRadioButton(
            text = "RadioButton Selected",
            selected = true,
            onClick = {}
        )
    }
}

@Composable
fun NitrozenRadioButton(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
) {
    val textColor = if (selected)
        NitrozenTheme.colors.grey100
    else
        NitrozenTheme.colors.grey80
    Row(
        modifier = modifier
            .clickableWithoutRipple {
                onClick()
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = NitrozenTheme.colors.primary50
            ),
        )
        Text(
            text = text,
            style = NitrozenTheme.typography.bodySmall,
            color = textColor,
        )
    }
}