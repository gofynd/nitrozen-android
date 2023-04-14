package com.fynd.nitrozen.components.radiobutton

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    text: String? = null,
    selected: Boolean,
    onClick: () -> Unit,
    style: NitrozenRadioButtonStyle = NitrozenRadioButtonStyle.Default,
    configuration: NitrozenRadioButtonConfiguration = NitrozenRadioButtonConfiguration.Default,
) {
    val textColor = if (selected)
        style.textColorSelected
    else
        style.textColorUnselected

    val strokeWidth = animateDpAsState(
        targetValue = if (selected) configuration.strokeWidth else 1.dp,
        animationSpec = tween()
    )

    val color = animateColorAsState(
        targetValue = if (selected)
            style.colorSelected
        else
            style.colorUnselected,
        animationSpec = tween()
    )

    Row(
        modifier = modifier
            .clickableWithoutRipple {
                onClick()
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .border(
                    shape = NitrozenTheme.shapes.round,
                    width = strokeWidth.value,
                    color = color.value
                )
                .size(configuration.size)
                .background(
                    shape = NitrozenTheme.shapes.round,
                    color = style.backgroundColor
                )
        )

        if (text != null) {
            Text(
                modifier = Modifier
                    .padding(configuration.textPadding),
                text = text,
                style = style.textStyle,
                color = textColor
            )
        }
    }
}
