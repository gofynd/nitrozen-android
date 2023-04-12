package com.nitrozen.android.ui.home

sealed class HomeScreenActions {
    object OpenTypography : HomeScreenActions()
    object OpenButtons : HomeScreenActions()
    object OpenTextFields : HomeScreenActions()
    object OpenCheckBox : HomeScreenActions()
    object OpenRadioButton : HomeScreenActions()
}
