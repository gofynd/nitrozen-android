package com.fynd.nitrozen.components.textfield

sealed class OtpTextFieldState(
    open val message: String? = null,
) {
    object Idle : OtpTextFieldState("")
    data class Success(override val message: String? = null) : OtpTextFieldState(message)
    data class Error(override val message: String? = null) : OtpTextFieldState(message)
}