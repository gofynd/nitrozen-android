package com.fynd.nitrozen.components.stepper

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenStepperStyle(
    val completeStepColor : Color,
    val defaultStepColor : Color
){
    companion object
}

val NitrozenStepperStyle.Companion.Default
    @Composable
    get() = NitrozenStepperStyle(
        completeStepColor = NitrozenTheme.colors.primary50,
        defaultStepColor = NitrozenTheme.colors.grey40
    )