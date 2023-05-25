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
        val maxLine: Int,
        val fieldHeight: Dp,
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
            shape = NitrozenTheme.shapes.rounded16,
            maxLine = 1,
            fieldHeight = 48.dp
        )

    data class OTP(
        val shape: Shape,
        val size: Dp
    ) {
        companion object
    }

    val OTP.Companion.Default: OTP
        @Composable
        get() = OTP(
            shape = NitrozenTheme.shapes.rounded16,
            size = 48.dp
        )
}
