package com.fynd.nitrozen.components.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NitrozenBottomNavigationConfiguration(
    val elevation: Dp,
){
    companion object
}

val NitrozenBottomNavigationConfiguration.Companion.Default
    @Composable
    get() = NitrozenBottomNavigationConfiguration(
        elevation = 0.dp
    )

