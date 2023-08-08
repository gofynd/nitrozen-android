package com.fynd.nitrozen.components.textfield.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration.Default
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle.Default
import com.fynd.nitrozen.components.textfield.TextFieldMessage
import com.fynd.nitrozen.components.textfield.TextFieldState
import com.fynd.nitrozen.theme.NitrozenTheme


@Preview
@Composable
private fun NitrozenOtpTextField_Idle() {
    NitrozenTheme {
        NitrozenOTPField(
            state = TextFieldState.Idle(),
            otp = "",
            onOtpChange = {},
            onKeyboardDone = {}
        )
    }
}

@Preview
@Composable
private fun NitrozenOtpTextField_Error() {
    NitrozenTheme {
        NitrozenOTPField(
            state = TextFieldState.Error("Invalid OTP"),
            otp = "123456",
            onOtpChange = {},
            onKeyboardDone = {}
        )
    }
}

@Preview
@Composable
private fun NitrozenOtpTextField_Success() {
    NitrozenTheme {
        NitrozenOTPField(
            state = TextFieldState.Success("OTP verified"),
            otp = "123456",
            onOtpChange = {},
            onKeyboardDone = {}
        )
    }
}

@Composable
fun NitrozenOTPField(
    modifier: Modifier = Modifier,
    label : String? = null,
    hintChar : Char = '0',
    otp: String,
    onOtpChange: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    otpSize: Int = 6,
    focus: Boolean = false,
    state: TextFieldState = TextFieldState.Idle(),
    style: NitrozenTextFieldStyle.OTP = NitrozenTextFieldStyle.OTP.Default,
    configuration: NitrozenTextFieldConfiguration.OTP = NitrozenTextFieldConfiguration.OTP.Default,
) {
    val focusRequester = FocusRequester.Default

    LaunchedEffect(key1 = Unit, block = {
        if (focus) {
            focusRequester.requestFocus()
        }
    })

    Column(
        modifier = modifier
            .background(style.backgroundColor),
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

        BasicTextField(
            value = otp,
            onValueChange = {
                val newValue = it.trim()
                if (newValue.length <= otpSize) {
                    onOtpChange.invoke(it)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),
            decorationBox = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(otpSize) { index ->
                        val char = when {
                            index > otp.length -> hintChar.toString()
                            index == otp.length -> "|"
                            else -> otp[index].toString()
                        }

                        val textColor = if (char == "0" && index >= otp.length) {
                            style.placeholderTextColor
                        } else if (state is TextFieldState.Error) {
                            style.textColorError
                        } else {
                            style.textColor
                        }

                        val borderColor = when {
                            state is TextFieldState.Error -> style.borderColorError
                            index == otp.length -> style.borderColorFocused
                            else -> style.borderColor
                        }

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(configuration.size)
                                .clip(configuration.shape)
                                .border(
                                    width = 1.dp,
                                    color = borderColor,
                                    shape = configuration.shape
                                ),
                        ) {
                            Text(
                                text = char,
                                style = style.textStyle,
                                color = textColor,
                            )
                        }
                    }
                }
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    onKeyboardDone()
                }
            ),
            modifier = Modifier.focusRequester(focusRequester)
        )

        TextFieldMessage(
            textFieldState = state,
            textStyle = style.infoTextStyle,
            paddingStart = 4.dp
        )
    }
}
