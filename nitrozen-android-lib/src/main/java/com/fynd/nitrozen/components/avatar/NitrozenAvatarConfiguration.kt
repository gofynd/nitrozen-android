package com.fynd.nitrozen.components.avatar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

object NitrozenAvatarConfiguration {
    data class Initials(
        val contentPadding: PaddingValues,
        val size : DpSize
    ){
        companion object
    }

    val Initials.Companion.Default : Initials
        @Composable
        get() = Initials(
            contentPadding = PaddingValues(0.dp),
            size = DpSize(40.dp, 40.dp)
        )

    data class Picture(
        val size: DpSize
    ){
        companion object
    }

    val Picture.Companion.Default : Picture
        @Composable
        get() = Picture(
            size = DpSize(40.dp, 40.dp)
        )

    data class Icon(
        val contentPadding: PaddingValues,
        val size: DpSize,
    ){
        companion object
    }

    val Icon.Companion.Default : Icon
        @Composable
        get() = Icon(
            contentPadding = PaddingValues(4.dp),
            size = DpSize(40.dp, 40.dp)
        )
}