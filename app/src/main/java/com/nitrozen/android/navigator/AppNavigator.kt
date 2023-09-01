package com.nitrozen.android.navigator

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.nitrozen.android.R

class AppNavigator constructor(
    private val activity: AppCompatActivity
) : Navigator {

    private val fragmentManager: FragmentManager
        get() = activity.supportFragmentManager

    private val navController: NavController
        get() {
            val navHostFragment =
                fragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
            return navHostFragment.navController
        }

    private val childFragmentManager: FragmentManager
        get() = fragmentManager.fragments.first().childFragmentManager

    private fun getRootFragmentId(): Int {
        // Here at 0 position, we do not have our own fragments.
        // User defined fragments will start from position 1.
        return navController.backQueue[1].destination.id
    }

    private fun isAvailableInStack(@IdRes id: Int): Boolean {
        return navController.backQueue.map { it.destination.id }.contains(id)
    }

    override fun addDestinationChangeListener(listener: NavController.OnDestinationChangedListener) {
        navController.addOnDestinationChangedListener(listener)
    }

    override fun removeDestinationChangeListener(listener: NavController.OnDestinationChangedListener) {
        navController.removeOnDestinationChangedListener(listener)
    }

    override fun goBack() {
        val isPopped = navController.popBackStack()
        if (!isPopped) {
            activity.finish()
        }
    }

    override fun openButtonsScreen() {
        navController.navigate(R.id.fragmentButtons)
    }

    override fun openTypographyScreen() {
        navController.navigate(R.id.fragmentTypography)
    }

    override fun openTextFieldsScreen() {
        navController.navigate(R.id.fragmentTextFields)
    }

    override fun openCheckBoxScreen() {
        navController.navigate(R.id.fragmentCheckBox)
    }

    override fun openRadioButtonScreen() {
        navController.navigate(R.id.fragmentRadioButton)
    }

    override fun openChipScreen() {
        navController.navigate(R.id.fragmentChip)
    }

    override fun openSwitchScreen() {
        navController.navigate(R.id.fragmentSwitch)
    }

    override fun openBadgeScreen() {
        navController.navigate(R.id.fragmentBadge)
    }

    override fun openStepperScreen() {
        navController.navigate(R.id.fragmentStepper)
    }

    override fun openDropDownScreen() {
        navController.navigate(R.id.fragmentDropDown)
    }

    override fun openDividerScreen() {
        navController.navigate(R.id.fragmentDivider)
    }

    override fun openAvatarScreen() {
        navController.navigate(R.id.fragmentAvatar)
    }

    override fun openOtpFieldScreen() {
        navController.navigate(R.id.fragmentOtpField)
    }

    override fun openBottomNavigationScreen() {
        navController.navigate(R.id.fragmentBottomNavigation)
    }

    override fun openAppBarScreen() {
        navController.navigate(R.id.fragmentAppBar)
    }

    override fun openSelectorScreen() {
        navController.navigate(R.id.fragmentSelector)
    }

    override fun openPageControlScreen() {
        navController.navigate(R.id.fragmentPageControl)
    }

    override fun openDialogScreen() {
        navController.navigate(R.id.fragmentDialog)
    }

    override fun openEmptyViewScreen() {
        navController.navigate(R.id.fragmentEmptyView)
    }

    override fun openErrorViewScreen() {
        navController.navigate(R.id.fragmentErrorView)
    }

    override fun openNotificationToastScreen() {
        navController.navigate(R.id.fragmentNotificationToast)
    }

    override fun openNotificationSuggestionScreen() {
        navController.navigate(R.id.fragmentNotificationSuggestion)
    }

    override fun openAutoSizeTextScreen() {
        navController.navigate(R.id.fragmentAutoSizeText)
    }

    override fun openToolTipScreen() {
        navController.navigate(R.id.fragmentTooltip)
    }
}
