package com.fynd.nitrozen.components.textfield

sealed class TextFieldState(
    open val message: String? = null,
) {
    data class Idle(override val message: String? = null) : TextFieldState(message)
    data class Success(override val message: String? = null) : TextFieldState(message)
    data class Error(override val message: String? = null) : TextFieldState(message)
}