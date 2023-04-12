package com.fynd.nitrozen.components.textfield

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.fynd.nitrozen.R
import com.fynd.nitrozen.theme.NitrozenTheme

sealed class TextFieldState(
    open val message: String? = null,
) {
    data class Idle(override val message: String? = null) : TextFieldState(message)
    data class Success(override val message: String? = null) : TextFieldState(message)
    data class Error(override val message: String? = null) : TextFieldState(message)
}

val TextFieldState.borderColor: Color
    @Composable
    get() = when (this) {
        is TextFieldState.Idle -> NitrozenTheme.colors.grey40
        is TextFieldState.Success -> NitrozenTheme.colors.success50
        is TextFieldState.Error -> NitrozenTheme.colors.error50
    }

val TextFieldState.infoTextColor: Color
    @Composable
    get() = when (this) {
        is TextFieldState.Idle -> NitrozenTheme.colors.grey80
        is TextFieldState.Success -> NitrozenTheme.colors.success80
        is TextFieldState.Error -> NitrozenTheme.colors.error80
    }

val TextFieldState.icon: Painter?
    @Composable
    get() = when (this) {
        is TextFieldState.Error -> painterResource(id = R.drawable.ic_error_text_field)
        is TextFieldState.Success -> painterResource(id = R.drawable.ic_success_text_field)
        is TextFieldState.Idle -> null
    }