package com.fynd.nitrozen.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

/**
 * @param titleTextStyle: [TextStyle] of the title
 * @param subTitleStyle: [TextStyle] of the subTitle
 * @param backgroundColor: [Color] background color of the dialog
 * */
data class NitrozenDialogStyle(
    val titleTextStyle: TextStyle,
    val subTitleStyle: TextStyle,
    val backgroundColor: Color
){
    companion object
}

val NitrozenDialogStyle.Companion.Default : NitrozenDialogStyle
    @Composable
    get() = NitrozenDialogStyle(
        titleTextStyle = NitrozenTheme.typography.headingXs,
        subTitleStyle = NitrozenTheme.typography.bodySmall,
        backgroundColor = NitrozenTheme.colors.grey80.copy(
            alpha = 0.65f
        )
    )
