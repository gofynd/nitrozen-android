package com.fynd.nitrozen.components.textfield

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

object NitrozenTextFieldConfiguration {

    data class Outlined(
        val keyboardType: KeyboardType,
        val imeAction: ImeAction,
        val keyboardActions: KeyboardActions,
        val visualTransformation: VisualTransformation,
        val shape: Shape,
    ) {
        companion object
    }

    val Outlined.Companion.Default: Outlined
        @Composable
        get() = Outlined(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
            keyboardActions = KeyboardActions(),
            visualTransformation = VisualTransformation.None,
            shape = NitrozenTheme.shapes.rounded16
        )

    data class Otp(
        val shape: Shape,
        val size: Dp
    ) {
        companion object
    }

    val Otp.Companion.Default: Otp
        @Composable
        get() = Otp(
            shape = NitrozenTheme.shapes.rounded16,
            size = 48.dp
        )
}
