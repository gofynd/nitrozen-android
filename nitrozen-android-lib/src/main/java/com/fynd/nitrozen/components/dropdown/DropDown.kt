package com.fynd.nitrozen.components.dropdown

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.R
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle.Default
import com.fynd.nitrozen.components.textfield.outlined.NitrozenOutlinedTextFieldReadOnly
import com.fynd.nitrozen.components.textfield.TextFieldState
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithUnBoundedRipple

@Preview(showBackground = true)
@Composable
private fun DropDownPreview_Selected() {
    NitrozenTheme {
        NitrozenDropDownTextField(
            modifier = Modifier.padding(8.dp),
            value = "Selected",
            enabled = true,
            hint = "Hint",
            onClicked = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DropDownPreview_UnSelected() {
    NitrozenTheme {
        NitrozenDropDownTextField(
            modifier = Modifier.padding(8.dp),
            hint = "Hint",
            onClicked = {},
            enabled = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DropDownPreview_State() {
    NitrozenTheme {
        NitrozenDropDownTextField(
            modifier = Modifier.padding(8.dp),
            value = "Selected",
            hint = "Hint",
            onClicked = {},
            enabled = true,
            textFieldState = TextFieldState.Success("Success")
        )
    }
}


@Composable
fun NitrozenDropDownTextField(
    modifier: Modifier = Modifier,
    hint: String,
    enabled : Boolean,
    onClicked: () -> Unit,
    value: String? = null,
    label: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    style: NitrozenTextFieldStyle.Outlined = NitrozenTextFieldStyle.Outlined.Default,
    textFieldState: TextFieldState = TextFieldState.Idle()
){
    NitrozenOutlinedTextFieldReadOnly(
        modifier = modifier,
        value = value?:"",
        hint = hint,
        onClicked = onClicked,
        label = label,
        leadingIcon = leadingIcon,
        style = style,
        textFieldState = textFieldState,
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .clickableWithUnBoundedRipple {
                        onClicked.invoke()
                    }
                    .size(24.dp),
                painter = painterResource(id = R.drawable.ic_chevron_down),
                contentDescription = "Down Arrow",
                tint = NitrozenTheme.colors.grey100
            )
        },
        enabled = enabled
    )
}

