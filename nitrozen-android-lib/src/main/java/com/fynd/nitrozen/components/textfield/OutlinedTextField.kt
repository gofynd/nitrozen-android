package com.fynd.nitrozen.components.textfield

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.theme.typography.fontsNitrozen
import com.fynd.nitrozen.R

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedTextField_Idle() {
    NitrozenTheme {
        NitrozenOutlinedTextField(
            value = "",
            hint = "Idle",
            onValueChange = {},
            textFieldState = TextFieldState.Idle("Idle message")
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedTextField_Success() {
    NitrozenTheme {
        NitrozenOutlinedTextField(
            value = "Valid value",
            hint = "Success",
            onValueChange = {},
            textFieldState = TextFieldState.Success("Success message")
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedTextField_Error() {
    NitrozenTheme {
        NitrozenOutlinedTextField(
            value = "Invalid value",
            hint = "Error",
            onValueChange = {},
            textFieldState = TextFieldState.Error("Error message")
        )
    }
}

@Composable
fun NitrozenOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions(),
    textFieldState: TextFieldState = TextFieldState.Idle(),
    label: String? = null,
    backgroundColor: Color = Color.Transparent,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val borderColor = when (textFieldState) {
        is TextFieldState.Idle -> NitrozenTheme.colors.grey60
        is TextFieldState.Success -> NitrozenTheme.colors.success50
        is TextFieldState.Error -> NitrozenTheme.colors.error50
    }

    val infoTextColor = when (textFieldState) {
        is TextFieldState.Idle -> NitrozenTheme.colors.grey80
        is TextFieldState.Success -> NitrozenTheme.colors.success80
        is TextFieldState.Error -> NitrozenTheme.colors.error80
    }

    val icon: Painter? = when (textFieldState) {
        is TextFieldState.Error -> painterResource(id = R.drawable.ic_error_text_field)
        is TextFieldState.Success -> painterResource(id = R.drawable.ic_success_text_field)
        is TextFieldState.Idle -> null
    }

    Column(
        modifier = modifier.fillMaxWidth(),
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
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = NitrozenTheme.typography.bodySmall,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = NitrozenTheme.colors.grey100,
                unfocusedBorderColor = borderColor,
                focusedBorderColor = borderColor,
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
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction,
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardActions = keyboardActions,
            shape = NitrozenTheme.shapes.rounded16,
            visualTransformation = visualTransformation,
        )
        if (textFieldState.message != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            ) {
                if (icon != null) {
                    Image(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier.alignByBaseline()
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(
                    text = textFieldState.message!!,
                    fontFamily = fontsNitrozen,
                    fontWeight = FontWeight.Light,
                    lineHeight = 20.sp,
                    fontSize = 14.sp,
                    color = infoTextColor,
                    modifier = Modifier.alignByBaseline()
                )
            }
        }
    }
}