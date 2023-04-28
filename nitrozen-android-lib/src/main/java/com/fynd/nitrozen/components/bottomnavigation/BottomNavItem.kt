package com.fynd.nitrozen.components.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavItem(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    companion object
}
