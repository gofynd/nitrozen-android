package com.nitrozen.android.ui.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.button.filled.NitrozenFilledButton
import com.fynd.nitrozen.components.dialog.ActionDirection
import com.fynd.nitrozen.components.dialog.Default
import com.fynd.nitrozen.components.dialog.NitrozenDialog
import com.fynd.nitrozen.components.dialog.NitrozenDialogConfiguration
import com.fynd.nitrozen.theme.NitrozenTheme
import com.nitrozen.android.ui.components.ComponentAppBar
import com.nitrozen.android.R

@Preview
@Composable
private fun PreviewCheckBoxScreen() {
    NitrozenTheme {
        DialogScreen(
            onBackClick = {}
        )
    }
}

@Composable
fun DialogScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NitrozenTheme.colors.background)
    ) {
        ComponentAppBar(
            title = "Dialog",
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Default",
                style = NitrozenTheme.typography.headingXs
            )

            val showDefaultDialog = remember {
                mutableStateOf(false)
            }

            NitrozenFilledButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Show Dialog",
                onClick = {
                    showDefaultDialog.value = true
                }
            )

            if(showDefaultDialog.value){
                NitrozenDialog(
                    title = "Your Order is on the way",
                    subTitle = "Eget duis vulputate enim, " +
                        "iaculis ac faucibus magna faucibus." +
                        " Magna elementum eu nibh non arcu eu, ",
                    positiveLabel = "Primary",
                    negativeLabel = "Secondary",
                    icon = R.drawable.ic_dialog_checked,
                    positiveButtonClick = {
                        showDefaultDialog.value = false
                    },
                    negativeButtonClick = {
                        showDefaultDialog.value = false
                    },
                    onDismissRequest = {
                        showDefaultDialog.value = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Vertical Actions",
                style = NitrozenTheme.typography.headingXs
            )

            val showVerticalActions = remember {
                mutableStateOf(false)
            }

            NitrozenFilledButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Show Dialog",
                onClick = {
                    showVerticalActions.value = true
                }
            )

            if(showVerticalActions.value){
                NitrozenDialog(
                    title = "Your Order is on the way",
                    subTitle = "Eget duis vulputate enim, " +
                        "iaculis ac faucibus magna faucibus." +
                        " Magna elementum eu nibh non arcu eu, ",
                    positiveLabel = "Primary",
                    negativeLabel = "Secondary",
                    icon = R.drawable.ic_dialog_checked,
                    positiveButtonClick = {
                        showVerticalActions.value = false
                    },
                    negativeButtonClick = {
                        showVerticalActions.value = false
                    },
                    configuration = NitrozenDialogConfiguration.Default.copy(
                        direction = ActionDirection.Vertical
                    ),
                    onDismissRequest = {
                        showVerticalActions.value = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Informational",
                style = NitrozenTheme.typography.headingXs
            )

            val showInformationalDialog = remember {
                mutableStateOf(false)
            }

            NitrozenFilledButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Show Dialog",
                onClick = {
                    showInformationalDialog.value = true
                },
            )

            if(showInformationalDialog.value){
                NitrozenDialog(
                    title = "Your Order is on the way",
                    subTitle = "Eget duis vulputate enim, " +
                        "iaculis ac faucibus magna faucibus." +
                        " Magna elementum eu nibh non arcu eu, ",
                    configuration = NitrozenDialogConfiguration.Default.copy(
                        textAlign = TextAlign.Start
                    ),
                    onDismissRequest = {
                        showInformationalDialog.value = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Sticky",
                style = NitrozenTheme.typography.headingXs
            )

            val showStickyDialog = remember {
                mutableStateOf(false)
            }

            NitrozenFilledButton(
                modifier = Modifier
                    .padding(top = 16.dp),
                text = "Show Dialog",
                onClick = {
                    showStickyDialog.value = true
                }
            )

            if(showStickyDialog.value){
                NitrozenDialog(
                    title = "Your Order is on the way",
                    subTitle = "Eget duis vulputate enim, " +
                        "iaculis ac faucibus magna faucibus." +
                        " Magna elementum eu nibh non arcu eu, ",
                    configuration = NitrozenDialogConfiguration.Default.copy(
                        showCancelIcon = false,
                        dismissOnClickOutside = false,
                        dismissOnBackPress = false
                    ),
                    positiveLabel = "Okay",
                    positiveButtonClick = {
                        showStickyDialog.value = false
                    },
                    onDismissRequest = {
                        showStickyDialog.value = false
                    }
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
