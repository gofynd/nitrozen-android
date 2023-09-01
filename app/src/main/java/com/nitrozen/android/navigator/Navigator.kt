package com.nitrozen.android.navigator

import androidx.navigation.NavController

interface Navigator {
    fun addDestinationChangeListener(listener: NavController.OnDestinationChangedListener)
    fun removeDestinationChangeListener(listener: NavController.OnDestinationChangedListener)
    fun goBack()

    fun openButtonsScreen()
    fun openTypographyScreen()
    fun openTextFieldsScreen()
    fun openCheckBoxScreen()
    fun openRadioButtonScreen()
    fun openChipScreen()
    fun openSwitchScreen()
    fun openBadgeScreen()
    fun openStepperScreen()
    fun openDropDownScreen()
    fun openDividerScreen()
    fun openAvatarScreen()
    fun openOtpFieldScreen()
    fun openBottomNavigationScreen()
    fun openAppBarScreen()
    fun openSelectorScreen()
    fun openPageControlScreen()
    fun openDialogScreen()
    fun openEmptyViewScreen()
    fun openErrorViewScreen()
    fun openNotificationToastScreen()
    fun openNotificationSuggestionScreen()
    fun openAutoSizeTextScreen()
    fun openToolTipScreen()
}
