package com.fynd.nitrozen.components.dialog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.fynd.nitrozen.components.button.filled.NitrozenFilledButton
import com.fynd.nitrozen.components.button.outlined.NitrozenOutlinedButton
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.clickableWithUnBoundedRipple

@Preview
@Composable
private fun DialogPreview() {
    NitrozenTheme {
        NitrozenDialog(
            title = "Your Order is on the way",
            subTitle = "Eget duis vulputate enim, iaculis ac faucibus magna faucibus. Magna elementum eu nibh non arcu eu, dolor nunc lacus. Vel eget augue vulputate aliquam. Ut facilisi egestas nec nunc. At maecenas placerat mauris pulvinar iaculis metus, dictum. ",
            positiveLabel = "Positive",
            negativeLabel = "Negative",
            onDismissRequest = {},

            configuration = NitrozenDialogConfiguration.Default.copy(
                direction = ActionDirection.Vertical
            )
        )
    }
}


/**
 * A composable function that displays a Nitrozen Dialog.
 * @param showDialog a [Boolean] value indicating whether to show or hide the dialog, defaults to true
 * @param title a [String] value indicating the title of the dialog
 * @param subTitle a [String] value indicating the subtitle of the dialog
 * @param positiveLabel a [String] value indicating the label to display on the positive button
 * @param negativeLabel a [String] value indicating the label to display on the negative button
 * @param icon an [Int] value indicating the icon to display in the dialog
 * @param positiveButtonClick a callback function that gets invoked when the positive button is clicked
 * @param negativeButtonClick a callback function that gets invoked when the negative button is clicked
 * @param configuration an object of type [NitrozenDialogConfiguration] indicating the configuration of the dialog, defaults to [NitrozenDialogConfiguration.Companion.Default]
 * @param style an object of type [NitrozenDialogStyle] indicating style of the dialog, defaults to [NitrozenDialogStyle.Companion.Default]
 * @param onDismissRequest a callback function that gets invoked when the dialog is dismissed
 * */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NitrozenDialog(
    showDialog : Boolean = true,
    title : String,
    subTitle : String,
    positiveLabel: String = "",
    negativeLabel: String = "",
    @DrawableRes icon: Int? = null,
    positiveButtonClick: (() -> Unit)? = null,
    negativeButtonClick: (() -> Unit)? = null,
    configuration : NitrozenDialogConfiguration = NitrozenDialogConfiguration.Default,
    style: NitrozenDialogStyle = NitrozenDialogStyle.Default,
    onDismissRequest: () -> Unit,
) {

    if(showDialog) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                dismissOnBackPress = configuration.dismissOnBackPress,
                dismissOnClickOutside = configuration.dismissOnClickOutside,
                securePolicy = configuration.securePolicy,
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = style.backgroundColor
                    )
                    .wrapContentHeight(
                        align = Alignment.CenterVertically
                    ),
                color = Color.Transparent
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            horizontal = 16.dp
                        )
                        .clip(NitrozenTheme.shapes.roundedXl)
                        .background(NitrozenTheme.colors.background)
                        .padding(24.dp)
                ) {
                    if (icon == null && configuration.textAlign == TextAlign.Start) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(1f),
                                textAlign = configuration.textAlign,
                                text = title,
                                style = style.titleTextStyle,
                                color = NitrozenTheme.colors.grey100
                            )
                            if (configuration.showCancelIcon) {
                                Icon(
                                    modifier = Modifier
                                        .padding(start = 8.dp)
                                        .padding(bottom = 16.dp)
                                        .clickableWithUnBoundedRipple {
                                            onDismissRequest()
                                        },
                                    imageVector = Icons.Rounded.Close,
                                    contentDescription = "",
                                    tint = NitrozenTheme.colors.primary60
                                )
                            }
                        }
                    } else {
                        if (configuration.showCancelIcon) {
                            Icon(
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .padding(bottom = 16.dp)
                                    .clickableWithUnBoundedRipple {
                                        onDismissRequest()
                                    },
                                imageVector = Icons.Rounded.Close,
                                contentDescription = "",
                                tint = NitrozenTheme.colors.primary60
                            )
                        }

                        if (icon != null) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .padding(
                                        bottom = 8.dp
                                    ),
                                painter = painterResource(id = icon),
                                contentDescription = ""
                            )
                        }

                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally),
                            textAlign = configuration.textAlign,
                            text = title,
                            style = style.titleTextStyle,
                            color = NitrozenTheme.colors.grey100
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        textAlign = configuration.textAlign,
                        text = subTitle,
                        style = style.subTitleStyle,
                        color = NitrozenTheme.colors.grey80
                    )

                    if (positiveLabel.isNotEmpty() || negativeLabel.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(32.dp))
                        when (configuration.direction) {
                            ActionDirection.Horizontal -> {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    if (negativeLabel.isNotEmpty()) {
                                        NitrozenOutlinedButton(
                                            modifier = Modifier.weight(1f),
                                            text = negativeLabel,
                                            onClick = {
                                                negativeButtonClick?.invoke()
                                            }
                                        )
                                    }


                                    if (positiveLabel.isNotEmpty()) {
                                        NitrozenFilledButton(
                                            modifier = Modifier.weight(1f),
                                            text = positiveLabel,
                                            onClick = {
                                                positiveButtonClick?.invoke()
                                            }
                                        )
                                    }
                                }
                            }

                            ActionDirection.Vertical -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    verticalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    if (positiveLabel.isNotEmpty()) {
                                        NitrozenFilledButton(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            text = positiveLabel,
                                            onClick = {
                                                positiveButtonClick?.invoke()
                                            }
                                        )
                                    }

                                    if (negativeLabel.isNotEmpty()) {
                                        NitrozenOutlinedButton(
                                            modifier = Modifier.fillMaxWidth(),
                                            text = negativeLabel,
                                            onClick = {
                                                negativeButtonClick?.invoke()
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}