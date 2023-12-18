package com.fynd.nitrozen.components.textfield.outlined

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeText
import com.fynd.nitrozen.components.autosizetext.NitrozenAutoResizeTextStyle
import com.fynd.nitrozen.components.textfield.*
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldConfiguration.Default
import com.fynd.nitrozen.components.textfield.NitrozenTextFieldStyle.Default
import com.fynd.nitrozen.components.textfield.outlined.base.BaseOutlinedTextField
import com.fynd.nitrozen.components.tooltip.Default
import com.fynd.nitrozen.components.tooltip.NitrozenToolTipConfiguration
import com.fynd.nitrozen.components.tooltip.NitrozenTooltip
import com.fynd.nitrozen.theme.NitrozenTheme
import com.fynd.nitrozen.utils.extensions.MultipleEventsCutter
import com.fynd.nitrozen.utils.extensions.clickableWithoutRipple
import com.fynd.nitrozen.utils.extensions.get

@Preview(showBackground = true)
@Composable
private fun NitrozenOutlinedTextFieldReadOnlyPreview() {
    var clicked by remember {
        mutableStateOf(0)
    }
    NitrozenTheme {
        NitrozenOutlinedTextFieldReadOnly(
            value = "",
            hint = "Hint $clicked",
            onClicked = {
                clicked+=1
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NitrozenOutlinedTextFieldReadOnly(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    label: String? = null,
    onClicked: () -> Unit,
    enabled : Boolean = true,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    anchorView: @Composable (() -> Unit)? = null,
    toolTipText: String? = null,
    toolTipVisibility: Boolean = false,
    onDismissRequest: () -> Unit = {},
    textFieldState: TextFieldState = TextFieldState.Idle(),
    style: NitrozenTextFieldStyle.Outlined = NitrozenTextFieldStyle.Outlined.Default,
    configuration: NitrozenTextFieldConfiguration.Outlined = NitrozenTextFieldConfiguration.Outlined.Default,
    toolTipConfiguration: NitrozenToolTipConfiguration = NitrozenToolTipConfiguration.Default
) {
    val focusManager = LocalFocusManager.current

    val cutter = remember { MultipleEventsCutter.get() }

    Column(
        modifier = modifier
            .fillMaxWidth()
//            .onFocusChanged {
//                if (it.hasFocus) {
//                    cutter.processEvent(onClicked)
//                    focusManager.clearFocus(force = true)
//                }
//            },
    ) {
        if (label != null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                NitrozenAutoResizeText(
                    text = label,
                    style = NitrozenAutoResizeTextStyle(
                        textStyle = style.labelTextStyle,
                        textColor = style.labelTextColor,
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp)
                )

                if (anchorView != null && toolTipText != null) {
                    NitrozenTooltip(
                        modifier = Modifier
                            .padding(start = 5.dp),
                        tooltipText = toolTipText,
                        anchorView = anchorView,
                        configuration = toolTipConfiguration,
                        visibility = toolTipVisibility,
                        onDismissRequest = {
                            onDismissRequest()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))
        }

        BaseOutlinedTextField(
            value = value,
            onValueChange = { },
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(configuration.fieldHeight)
                .clickableWithoutRipple {
                    onClicked()
                },
            textStyle = style.textStyle,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = style.textColor,
                unfocusedBorderColor = textFieldState.borderColor,
                focusedBorderColor = textFieldState.borderColor,
                cursorColor = style.cursorColor,
                backgroundColor = if(enabled) style.backgroundColor
                else style.disabledBackgroundColor,
                disabledBorderColor = textFieldState.borderColor,
                disabledTextColor = style.textColor,
                disabledPlaceholderColor = style.placeholderTextColor,
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = style.placeholderTextStyle,
                    color = style.placeholderTextColor,
                    maxLines = configuration.maxLine,
                    overflow = TextOverflow.Ellipsis
                )
            },
            singleLine = configuration.maxLine == 1,
            maxLines = configuration.maxLine,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = configuration.shape,
            visualTransformation = configuration.visualTransformation,
        )

        TextFieldMessage(
            textFieldState = textFieldState,
            textStyle = style.infoTextStyle
        )
    }
}
