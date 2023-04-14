package com.fynd.nitrozen.components.toggle

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import com.fynd.nitrozen.theme.NitrozenTheme

@Preview
@Composable
private fun PreviewSwitch() {
    var checked by remember {
        mutableStateOf(false)
    }
    NitrozenTheme {
        NitrozenSwitch(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            configuration = NitrozenSwitchConfiguration.Default
        )
    }
}


/**
 *
 * A NitrozenSwitch is a UI element that toggles between two states, either
 * "checked" or "unchecked". It consists of a rectangular track and a thumb.
 * This switch can be customized with various properties, including its colors,
 * size, and stroke width.
 *
 * @param modifier The [Modifier] to be applied to the NitrozenSwitch.
 * @param checked A [Boolean] value indicating whether the NitrozenSwitch is currently in the "checked" state.
 * @param onCheckedChange A lambda function to be executed when the NitrozenSwitch's state is changed.
 * @param configuration [NitrozenSwitchConfiguration] describing width, height and padding for the switch.
 * @param style [NitrozenSwitchStyle] to customise the style of the switch
 *
 * */

@Composable
fun NitrozenSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    configuration: NitrozenSwitchConfiguration =
        NitrozenSwitchConfiguration.Default,
    style: NitrozenSwitchStyle = NitrozenSwitchStyle.Default,
) {

    val height = configuration.height
    val width = configuration.width

    val gapBetweenThumbAndTrackEdge = configuration.thumbPadding

    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    val trackRadius = (height) * 100 / 100

    val animationDuration = 300

    // To move thumb, we need to calculate the position (along x axis)
    val animatePosition = animateFloatAsState(
        targetValue = if (checked)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() },
        animationSpec = tween(durationMillis = animationDuration)
    )

    //Animate track color
    val animateTrackColor = animateColorAsState(
        targetValue = if (checked)
            style.checkedTrackColor
        else
            style.uncheckedTrackColor,
        animationSpec = tween(durationMillis = animationDuration)
    )

    //Animate thumb color
    val animateThumbColor = animateColorAsState(
        targetValue = if (checked)
            style.checkedThumbColor
        else
            style.uncheckedThumbColor,
        animationSpec = tween(durationMillis = animationDuration)
    )

    //Animate track stroke color
    val animateTrackStrokeColor = animateColorAsState(
        targetValue = if (checked)
            style.checkedTrackBorderColor
        else
            style.uncheckedBorderTrackColor,
        animationSpec = tween(durationMillis = animationDuration)
    )

    Canvas(
        modifier = modifier
            .size(width = width, height = height)
            .pointerInput(checked) {
                detectTapGestures(
                    onTap = {
                        // This is called when the user taps on the canvas
                        onCheckedChange(checked.not())
                    }
                )
            },
    ) {
        // Track
        drawRoundRect(
            color = animateTrackColor.value,
            cornerRadius = CornerRadius(x = trackRadius.toPx(), y = trackRadius.toPx()),
            style = Fill,
        )

        // Track Stroke
        drawRoundRect(
            color = animateTrackStrokeColor.value,
            cornerRadius = CornerRadius(x = trackRadius.toPx(), y = trackRadius.toPx()),
            style = Stroke(width = style.strokeWidth.toPx()),
        )

        // Thumb
        drawCircle(
            color = animateThumbColor.value,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            ),
        )
    }
}
