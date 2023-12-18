package com.fynd.nitrozen.components.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavItem(
    val id: Int,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val badgeConfiguration: BadgeConfiguration = BadgeConfiguration.Disabled
) {
    sealed interface BadgeConfiguration{
        data class Enabled(val badgeCount : Int) : BadgeConfiguration
        data object Disabled : BadgeConfiguration
    }
    companion object
}
