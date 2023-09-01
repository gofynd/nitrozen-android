package com.fynd.nitrozen.components.autosizetext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
private fun NitrozenAutoResizeTextPreview() {
    NitrozenTheme {
        Box(
            modifier = Modifier
                .background(
                    color = NitrozenTheme.colors.primary50,
                    shape = NitrozenTheme.shapes.rounded16
                )
                .padding(10.dp)
                .width(150.dp)
        ) {
            NitrozenAutoResizeText(
                modifier = Modifier,
                text = "Auto Resize Text"
            )
        }
    }
}

private const val TEXT_SCALE_REDUCTION_INTERVAL = 0.9f

/*
* Text will resize until it's size is reduced to minFontSize to fill it's
* container. Post that text will be ellipsized.
*
* Note:- Result will not show in Preview window.
*/
@Composable
fun NitrozenAutoResizeText(
    modifier: Modifier = Modifier,
    text: String,
    style: NitrozenAutoResizeTextStyle = NitrozenAutoResizeTextStyle.Default,
    configuration: NitrozenAutoResizeTextConfiguration = NitrozenAutoResizeTextConfiguration.Default,
) {
    var fontSize by remember { mutableStateOf(style.textStyle.fontSize) }

    val onTextLayout = { textLayoutResult: TextLayoutResult ->
        val maxCurrentLineIndex: Int = textLayoutResult.lineCount - 1

        if (textLayoutResult.isLineEllipsized(maxCurrentLineIndex)
            && fontSize.times(TEXT_SCALE_REDUCTION_INTERVAL) > configuration.minFontSize
        ) {
            fontSize = fontSize.times(TEXT_SCALE_REDUCTION_INTERVAL)
        }
    }

    Text(
        modifier = modifier,
        text = text,
        style = style.textStyle,
        color = style.textColor,
        fontSize = fontSize,
        onTextLayout = onTextLayout,
        maxLines = configuration.maxLines,
        overflow = TextOverflow.Ellipsis
    )
}
