package com.fynd.nitrozen.components.textfield

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.R
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.theme.typography.fontsNitrozen


@Preview
@Composable
private fun NitrozenOtpTextField_Idle() {
    NitrozenTheme {
        NitrozenOtpTextField(
            state = OtpTextFieldState.Idle,
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
        NitrozenOtpTextField(
            state = OtpTextFieldState.Error("Invalid OTP"),
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
        NitrozenOtpTextField(
            state = OtpTextFieldState.Success("OTP verified"),
            otp = "123456",
            onOtpChange = {},
            onKeyboardDone = {}
        )
    }
}

@Composable
fun NitrozenOtpTextField(
    modifier: Modifier = Modifier,
    backgroundColor: Color = NitrozenTheme.colors.background,
    state: OtpTextFieldState = OtpTextFieldState.Idle,
    otpSize: Int = 6,
    otp: String,
    onOtpChange: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    focus: Boolean = false,
) {
    val focusRequester = FocusRequester.Default

    val infoTextColor = when (state) {
        is OtpTextFieldState.Idle -> NitrozenTheme.colors.grey80
        is OtpTextFieldState.Success -> NitrozenTheme.colors.success80
        is OtpTextFieldState.Error -> NitrozenTheme.colors.error80
    }

    val icon: Painter? = when (state) {
        is OtpTextFieldState.Error -> painterResource(id = R.drawable.ic_error_text_field)
        is OtpTextFieldState.Success -> painterResource(id = R.drawable.ic_success_text_field)
        is OtpTextFieldState.Idle -> null
    }

    LaunchedEffect(key1 = Unit, block = {
        if (focus) {
            focusRequester.requestFocus()
        }
    })

    Column(
        modifier = modifier
            .background(backgroundColor),
    ) {
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
                            index > otp.length -> "0"
                            index == otp.length -> "|"
                            else -> otp[index].toString()
                        }

                        val textColor = if (char == "0" && index >= otp.length) {
                            NitrozenTheme.colors.grey60
                        } else if (state is OtpTextFieldState.Error) {
                            NitrozenTheme.colors.error50
                        } else {
                            NitrozenTheme.colors.grey100
                        }

                        val borderColor = when {
                            state is OtpTextFieldState.Error -> NitrozenTheme.colors.error50
                            index == otp.length -> NitrozenTheme.colors.primary60
                            else -> NitrozenTheme.colors.grey60
                        }

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(NitrozenTheme.shapes.rounded16)
                                .border(
                                    width = 1.dp,
                                    color = borderColor,
                                    shape = NitrozenTheme.shapes.rounded16
                                ),
                        ) {
                            Text(
                                text = char,
                                style = NitrozenTheme.typography.bodySmall,
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
        if (state.message != null && state.message!!.isNotBlank()) {
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
                    text = state.message!!,
                    fontFamily = fontsNitrozen,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 20.sp,
                    fontSize = 14.sp,
                    color = infoTextColor,
                    modifier = Modifier.alignByBaseline()
                )
            }
        }
    }
}