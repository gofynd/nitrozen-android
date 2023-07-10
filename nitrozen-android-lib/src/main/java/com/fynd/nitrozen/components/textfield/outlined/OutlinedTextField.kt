package com.fynd.nitrozen.components.textfield.outlined

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeText
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeTextStyle
import com.fynd.nitrozen.components.textfield.*
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration.Default
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle.Default
import com.fynd.nitrozen.components.textfield.outlined.base.BaseOutlinedTextField
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

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedTextField_Max() {
    var value by remember {
        mutableStateOf("")
    }
    NitrozenTheme {
        NitrozenOutlinedTextField(
            value = value,
            hint = "Error",
            onValueChange = {value = it},
            label = "Lable",
            textFieldState = TextFieldState.Error("Error message"),
            configuration = NitrozenTextFieldConfiguration.Outlined.Default.copy(
                maxCharacterConfiguration = MaxCharacterConfiguration.Enabled(
                    12,
                    true
                )
            )
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

    var isFocused by remember {
        mutableStateOf(false)
    }

    val borderColor = if(isFocused && textFieldState is TextFieldState.Idle)
        NitrozenTheme.colors.primary60
    else textFieldState.borderColor

    val textChangeBringIntoViewRequester = remember {
        BringIntoViewRequester()
    }

    val scope = rememberCoroutineScope()

    val maxCharacterConfiguration = configuration.maxCharacterConfiguration

    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (label != null) {
            Row {
                NitrozenAutoResizeText(
                    text = label,
                    style = NitrozenAutoResizeTextStyle(
                        textStyle = style.labelTextStyle,
                        textColor = style.labelTextColor,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp),
                )

                if(maxCharacterConfiguration is MaxCharacterConfiguration.Enabled &&
                    maxCharacterConfiguration.showMaxCharacter) {
                    Text(
                        modifier = Modifier
                            .padding(end = 8.dp),
                        text = "${value.length}/${maxCharacterConfiguration.maxChar}",
                        style = NitrozenTheme.typography.bodyXsReg,
                        color = NitrozenTheme.colors.grey80
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
        }

        BaseOutlinedTextField(
            value = value,
            onValueChange = {
                val newText = if(maxCharacterConfiguration is MaxCharacterConfiguration.Enabled){
                    it.take(maxCharacterConfiguration.maxChar)
                }else{
                    it
                }
                onValueChange.invoke(newText)
                scope.launch {
                    textChangeBringIntoViewRequester.bringIntoView()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(configuration.fieldHeight)
                .onFocusChanged {
                    isFocused = it.hasFocus
                }
                .bringIntoViewRequester(textChangeBringIntoViewRequester),
            textStyle = style.textStyle,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = style.textColor,
                unfocusedBorderColor = borderColor,
                focusedBorderColor = borderColor,
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
