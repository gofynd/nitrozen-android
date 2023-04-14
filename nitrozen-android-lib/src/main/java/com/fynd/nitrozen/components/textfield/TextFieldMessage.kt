package com.fynd.nitrozen.components.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextFieldMessage(
    textFieldState: TextFieldState,
    textStyle: TextStyle,
) {
    val bringIntoViewRequester = remember { BringIntoViewRequester() }

    val message = textFieldState.message
    if (message != null) {
        if (textFieldState is TextFieldState.Error) {
            LaunchedEffect(key1 = Unit) {
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
                text = message,
                style = textStyle,
                color = textFieldState.infoTextColor,
                modifier = Modifier.alignByBaseline()
                    .bringIntoViewRequester(bringIntoViewRequester)
            )
        }
    }
}
