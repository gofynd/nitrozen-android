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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
            }
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
 * @param scale The scale factor to be applied to the NitrozenSwitch's size.
 * @param width The width of the NitrozenSwitch.
 * @param height The height of the NitrozenSwitch.
 * @param strokeWidth The width of the stroke used to draw the NitrozenSwitch.
 * @param checkedThumbColor The color of the NitrozenSwitch's thumb in the "checked" state.
 * @param checkedTrackBorderColor The color of the border around the NitrozenSwitch's track in the "checked" state.
 * @param checkedTrackColor The color of the NitrozenSwitch's track in the "checked" state.
 * @param uncheckedBorderTrackColor The color of the border around the NitrozenSwitch's track in the "unchecked" state.
 * @param uncheckedThumbColor The color of the NitrozenSwitch's thumb in the "unchecked" state.
 * @param uncheckedTrackColor The color of the NitrozenSwitch's track in the "unchecked" state.
 * @param gapBetweenThumbAndTrackEdge The gap between the NitrozenSwitch's thumb and the edge of the track.
 *
 * */

@Composable
fun NitrozenSwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    scale: Float = 1f,
    width: Dp = 44.dp,
    height: Dp = 24.dp,
    strokeWidth: Dp = 1.dp,
    checkedThumbColor : Color = NitrozenTheme.colors.background,
    checkedTrackBorderColor : Color = NitrozenTheme.colors.primary50,
    checkedTrackColor : Color = NitrozenTheme.colors.primary50,
    uncheckedBorderTrackColor : Color = NitrozenTheme.colors.grey80,
    uncheckedThumbColor : Color = NitrozenTheme.colors.grey80,
    uncheckedTrackColor : Color = NitrozenTheme.colors.background,
    gapBetweenThumbAndTrackEdge: Dp = 4.dp
) {

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
            checkedTrackColor
        else
            uncheckedTrackColor,
        animationSpec = tween(durationMillis = animationDuration)
    )

    //Animate thumb color
    val animateThumbColor = animateColorAsState(
        targetValue = if (checked)
            checkedThumbColor
        else
            uncheckedThumbColor,
        animationSpec = tween(durationMillis = animationDuration)
    )

    val animateTrackStrokeColor = animateColorAsState(
        targetValue = if (checked)
            checkedTrackBorderColor
        else
            uncheckedBorderTrackColor,
        animationSpec = tween(durationMillis = animationDuration)
    )

    Canvas(
        modifier = modifier
            .size(width = width, height = height)
            .scale(scale = scale)
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
            style = Stroke(width = strokeWidth.toPx()),
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
