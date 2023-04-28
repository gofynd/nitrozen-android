package com.fynd.nitrozen.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.SecureFlagPolicy


sealed interface ActionDirection {
    object Horizontal : ActionDirection
    object Vertical : ActionDirection
}

/**
 * The [NitrozenDialogConfiguration] data class represents the configuration options for the [NitrozenDialog] composable.
 * @param dismissOnBackPress: A [Boolean] value indicating whether the dialog should be dismissed when the back button is pressed. The default value is true.
 * @param dismissOnClickOutside: A [Boolean] value indicating whether the dialog should be dismissed when the user clicks outside of it. The default value is true.
 * @param securePolicy: A [SecureFlagPolicy] enum value representing the secure policy for the dialog.
 * @param direction: An [ActionDirection] enum value representing the direction of the action for the dialog.
 * @param showCancelIcon: A [Boolean] value indicating whether to show the cancel icon in the dialog. The default value is false.
 * @param textAlign: A [TextAlign] enum value representing the text alignment for the dialog title and subtitle.
 * */

data class NitrozenDialogConfiguration(
    val dismissOnBackPress: Boolean,
    val dismissOnClickOutside: Boolean,
    val securePolicy: SecureFlagPolicy,
    val direction : ActionDirection,
    val showCancelIcon : Boolean,
    val textAlign: TextAlign
){
    companion object
}

val NitrozenDialogConfiguration.Companion.Default : NitrozenDialogConfiguration
    @Composable
    get() = NitrozenDialogConfiguration(
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
        securePolicy = SecureFlagPolicy.Inherit,
        direction = ActionDirection.Horizontal,
        showCancelIcon = true,
        textAlign = TextAlign.Center
    )