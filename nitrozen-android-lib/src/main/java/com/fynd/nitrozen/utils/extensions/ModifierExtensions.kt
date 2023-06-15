package com.fynd.nitrozen.utils.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
inline fun Modifier.clickableWithRipple(crossinline onClick: () -> Unit): Modifier = composed {
    val cutter = remember { MultipleEventsCutter.get() }
    clickable(
        indication = rememberRipple(bounded = true),
        interactionSource = remember { MutableInteractionSource() }
    ) {
        cutter.processEvent {
            onClick()
        }
    }
}

inline fun Modifier.clickableWithoutRipple(crossinline onClick: () -> Unit): Modifier = composed {
    val cutter = remember { MultipleEventsCutter.get() }
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
    ) {
        cutter.processEvent {
            onClick()
        }
    }
}

inline fun Modifier.clickableWithUnBoundedRipple(crossinline onClick: () -> Unit): Modifier = composed {
    val cutter = remember { MultipleEventsCutter.get() }
    clickable(
        indication = rememberRipple(bounded = false),
        interactionSource = remember { MutableInteractionSource() }
    ) {
        cutter.processEvent {
            onClick()
        }
    }
}
