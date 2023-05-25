package com.fynd.nitrozen.components.textfield.outlined

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.textfield.*
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration.Default
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle.Default
import com.fynd.nitrozen.theme.NitrozenTheme
import kotlinx.coroutines.launch

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NitrozenOutlinedTextField(
    modifier: Modifier = Modifier,
    hint: String,
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    textFieldState: TextFieldState = TextFieldState.Idle(),
    style: NitrozenTextFieldStyle.Outlined = NitrozenTextFieldStyle.Outlined.Default,
    configuration: NitrozenTextFieldConfiguration.Outlined = NitrozenTextFieldConfiguration.Outlined.Default,
) {
    val bringIntoViewRequester = remember { BringIntoViewRequester() }

    val textChangeBringIntoViewRequester = remember {
        BringIntoViewRequester()
    }

    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxWidth(),
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
            onValueChange = {
                onValueChange.invoke(it)
                scope.launch {
                    textChangeBringIntoViewRequester.bringIntoView()
                }
            },
            modifier = Modifier.fillMaxWidth()
                .height(configuration.fieldHeight)
                .bringIntoViewRequester(textChangeBringIntoViewRequester),
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
                    color = style.placeholderTextColor,
                    maxLines = configuration.maxLine,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            singleLine = configuration.maxLine == 1,
            maxLines = configuration.maxLine,
            keyboardOptions = KeyboardOptions(
                keyboardType = configuration.keyboardType,
                imeAction = configuration.imeAction,
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            keyboardActions = configuration.keyboardActions,
            shape = configuration.shape,
            visualTransformation = configuration.visualTransformation,
        )

        TextFieldMessage(
            textFieldState = textFieldState,
            textStyle = style.infoTextStyle
        )
    }
}
