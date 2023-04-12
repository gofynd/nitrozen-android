package com.fynd.nitrozen.components.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.theme.typography.fontsNitrozen
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
            onValueChange = {
                onValueChange.invoke(it)
                scope.launch {
                    textChangeBringIntoViewRequester.bringIntoView()
                }
            },
            modifier = Modifier.fillMaxWidth()
                .bringIntoViewRequester(textChangeBringIntoViewRequester),
            textStyle = NitrozenTheme.typography.bodySmall,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = NitrozenTheme.colors.grey100,
                unfocusedBorderColor = textFieldState.borderColor,
                focusedBorderColor = textFieldState.borderColor,
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
            if (textFieldState is TextFieldState.Error) {
                LaunchedEffect(key1 = value) {
                    bringIntoViewRequester.bringIntoView()
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            ) {
                val icon = textFieldState.icon
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
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    fontSize = 14.sp,
                    color = textFieldState.infoTextColor,
                    modifier = Modifier.alignByBaseline()
                        .bringIntoViewRequester(bringIntoViewRequester)
                )
            }
        }
    }
}