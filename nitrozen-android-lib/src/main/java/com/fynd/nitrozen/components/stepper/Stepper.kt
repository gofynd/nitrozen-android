package com.fynd.nitrozen.components.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
private fun StepperPreview() {
    NitrozenTheme {
        NitrozenStepper(
            modifier = Modifier,
            completedStep = 1,
            totalSteps = 3
        )
    }
}

@Composable
fun NitrozenStepper(
    modifier: Modifier = Modifier,
    completedStep: Int = 0,
    totalSteps: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement
            .spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterHorizontally
            )
    ) {
        for (i in 1..totalSteps) {
            val backgroundColor = if (i <= completedStep)
                NitrozenTheme.colors.primary50
            else
                NitrozenTheme.colors.grey40

            Box(
                modifier = modifier
                    .weight(1f)
                    .height(8.dp)
                    .clip(NitrozenTheme.shapes.rounded16)
                    .background(backgroundColor)
            )
        }
    }
}
