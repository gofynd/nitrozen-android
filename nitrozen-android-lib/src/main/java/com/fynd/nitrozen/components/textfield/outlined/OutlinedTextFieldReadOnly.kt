package com.fynd.nitrozen.components.textfield.outlined

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.components.textfield.*
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration.Default
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle.Default
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.theme.typography.fontsNitrozen

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedTextFieldReadOnly() {
    NitrozenTheme {
        NitrozenOutlinedTextFieldReadOnly(
            value = "",
            hint = "Hint",
            onClicked = { }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NitrozenOutlinedTextFieldReadOnly(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    label: String? = null,
    onClicked: () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    textFieldState: TextFieldState = TextFieldState.Idle(),
    style: NitrozenTextFieldStyle.Outlined = NitrozenTextFieldStyle.Outlined.Default,
    configuration: NitrozenTextFieldConfiguration.Outlined = NitrozenTextFieldConfiguration.Outlined.Default,
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged {
                if (it.hasFocus) {
                    onClicked()
                    focusManager.clearFocus(force = true)
                }
            },
    ) {
        if (label != null) {
            Text(
                text = label,
                style = style.labelTextStyle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                color = style.labelTextColor
            )

            Spacer(modifier = Modifier.height(4.dp))
        }

        OutlinedTextField(
            value = value,
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            textStyle = style.textStyle,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = style.textColor,
                unfocusedBorderColor = textFieldState.borderColor,
                focusedBorderColor = textFieldState.borderColor,
                cursorColor = style.cursorColor,
                backgroundColor = style.backgroundColor,
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = style.placeholderTextStyle,
                    color = style.placeholderTextColor
                )
            },
            singleLine = true,
            maxLines = 1,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = configuration.shape,
            visualTransformation = configuration.visualTransformation,
        )

        TextFieldMessage(
            textFieldState = textFieldState,
            textStyle = style.infoTextStyle
        )
    }
}
