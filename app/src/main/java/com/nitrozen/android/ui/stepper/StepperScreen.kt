package com.nitrozen.android.ui.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.stepper.NitrozenStepper
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar

@Preview
@Composable
private fun PreviewSwitchScreen() {
    NitrozenTheme {
        StepperScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun StepperScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Stepper",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "No Progress",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenStepper(
                modifier = Modifier
                    .padding(top = 16.dp),
                completedStep = 0,
                totalSteps = 3
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "First Step Complete",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenStepper(
                modifier = Modifier
                    .padding(top = 16.dp),
                completedStep = 1,
                totalSteps = 3
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Second Step Complete",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenStepper(
                modifier = Modifier
                    .padding(top = 16.dp),
                completedStep = 2,
                totalSteps = 3
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "All Step Complete",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenStepper(
                modifier = Modifier
                    .padding(top = 16.dp),
                completedStep = 3,
                totalSteps = 3
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "More steps",
                style = NitrozenTheme.typography.headingXs
            )

            NitrozenStepper(
                modifier = Modifier
                    .padding(top = 16.dp),
                completedStep = 3,
                totalSteps = 5
            )

            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}