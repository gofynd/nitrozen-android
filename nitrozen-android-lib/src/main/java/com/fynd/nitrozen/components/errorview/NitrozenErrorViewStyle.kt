package com.fynd.nitrozen.components.errorview

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenErrorViewStyle(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
){
    companion object
}

val NitrozenErrorViewStyle.Companion.Default
    @Composable
    get() = NitrozenErrorViewStyle(
        titleTextStyle = NitrozenTheme.typography.headingXxs,
        subTitleTextStyle = NitrozenTheme.typography.bodySmall
    )