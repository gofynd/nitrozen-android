package com.fynd.nitrozen.components.divider

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
private fun NitrozenDividerPreview() {
    NitrozenTheme {
        NitrozenDivider()
    }
}

/**
 * Nitrozen Divider shows a divider line
 * @param modifier optional [Modifier] to apply to the composable
 * @param style an object of type [NitrozenDividerStyle] indicating the style of the divider, defaults to [NitrozenDividerStyle.Companion.Default]
 * @param configuration an object of type [NitrozenDividerConfiguration] indicating the configuration of the divider, defaults to [NitrozenDividerConfiguration.Companion.Default]
 *
 * */
@Composable
fun NitrozenDivider(
    modifier : Modifier = Modifier,
    style : NitrozenDividerStyle = NitrozenDividerStyle.Default,
    configuration : NitrozenDividerConfiguration = NitrozenDividerConfiguration.Default
){
    val newModifier = when(configuration.direction){
        NitrozenDividerConfiguration.Direction.Horizontal -> {
            modifier
                .height(configuration.thickness)
                .fillMaxWidth()
        }

        NitrozenDividerConfiguration.Direction.Vertical -> {
            modifier
                .width(configuration.thickness)
                .fillMaxHeight()
        }
    }
    Box(
        modifier = newModifier
            .background(
                shape = style.shape,
                color = style.backgroundColor
            )
    )
}

