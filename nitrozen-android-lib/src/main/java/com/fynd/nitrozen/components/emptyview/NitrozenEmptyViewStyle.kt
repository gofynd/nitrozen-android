package com.fynd.nitrozen.components.emptyview

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenEmptyViewStyle(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
){
    companion object
}

val NitrozenEmptyViewStyle.Companion.Default
    @Composable
    get() = NitrozenEmptyViewStyle(
        titleTextStyle = NitrozenTheme.typography.headingXxs,
        subTitleTextStyle = NitrozenTheme.typography.bodySmall
    )