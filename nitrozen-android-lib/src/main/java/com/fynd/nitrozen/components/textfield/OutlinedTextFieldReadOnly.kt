package com.fynd.nitrozen.components.textfield

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

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

@Composable
fun NitrozenOutlinedTextFieldReadOnly(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    onClicked: () -> Unit,
    label: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = Color.Transparent,
    visualTransformation: VisualTransformation = VisualTransformation.None,
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
                style = NitrozenTheme.typography.bodyXsReg,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                color = NitrozenTheme.colors.grey80
            )

            Spacer(modifier = Modifier.height(4.dp))
        }

        OutlinedTextField(
            value = value,
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            textStyle = NitrozenTheme.typography.bodySmall,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = NitrozenTheme.colors.grey100,
                unfocusedBorderColor = NitrozenTheme.colors.grey60,
                focusedBorderColor = NitrozenTheme.colors.grey60,
                cursorColor = NitrozenTheme.colors.grey60,
                backgroundColor = backgroundColor,
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = NitrozenTheme.typography.bodySmall,
                    color = NitrozenTheme.colors.grey60
                )
            },
            singleLine = true,
            maxLines = 1,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = NitrozenTheme.shapes.rounded16,
            visualTransformation = visualTransformation,
        )
    }
}