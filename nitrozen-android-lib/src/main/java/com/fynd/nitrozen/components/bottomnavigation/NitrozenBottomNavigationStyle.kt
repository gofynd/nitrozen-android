package com.fynd.nitrozen.components.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.fynd.nitrozen.theme.NitrozenTheme

data class NitrozenBottomNavigationStyle(
    val selectedIconTint: Color,
    val unselectedIconTint: Color,
    val selectedTextColor: Color,
    val unselectedTextColor: Color,
    val textStyle: TextStyle,
) {
    companion object
}

val NitrozenBottomNavigationStyle.Companion.Default
    @Composable
    get() = NitrozenBottomNavigationStyle(
        selectedIconTint = NitrozenTheme.colors.primary50,
        unselectedIconTint = NitrozenTheme.colors.grey80.copy(alpha = 0.65F),
        selectedTextColor = NitrozenTheme.colors.grey100,
        unselectedTextColor = NitrozenTheme.colors.grey80.copy(alpha = 0.65F),
        textStyle = NitrozenTheme.typography.bodyXxs
    )

