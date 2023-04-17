package com.nitrozen.android.ui.otpfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.textfield.TextFieldState
import com.fynd.nitrozen.components.textfield.otp.NitrozenOtpTextField
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewOpFieldPreview() {
    NitrozenTheme {
        OtpFieldScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun OtpFieldScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "OtpField",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Normal",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOtpTextField(
                label = "Label",
                otp = "",
                onOtpChange = {},
                onKeyboardDone = {

                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Success",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOtpTextField(
                label = "Label",
                otp = "122324",
                onOtpChange = {},
                onKeyboardDone = {

                },
                state = TextFieldState.Success("Success text")
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Error",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOtpTextField(
                label = "Label",
                otp = "122324",
                onOtpChange = {},
                onKeyboardDone = {

                },
                state = TextFieldState.Error("Error text")
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Otp Size",
                style = NitrozenTheme.typography.headingXs
            )

            Spacer(modifier = Modifier.height(16.dp))

            NitrozenOtpTextField(
                label = "Label",
                otp = "",
                otpSize = 4,
                onOtpChange = {},
                onKeyboardDone = {

                },
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
