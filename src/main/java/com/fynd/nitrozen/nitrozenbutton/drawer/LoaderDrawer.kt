package com.fynd.nitrozen.nitrozenbutton.drawer

import android.view.Gravity
import android.view.View
import com.fynd.nitrozen.nitrozenbutton.NBtn
import com.fynd.nitrozen.nitrozenbutton.model.NitrozenButton
import com.fynd.nitrozen.nitrozenbutton.views.SpinKitView

internal class LoaderDrawer(val view: NBtn, val button: NitrozenButton) :
    Drawer<NBtn, NitrozenButton>(view, button) {

    override fun draw() {
        if (button.isLoader) {
            initView()
        }
    }

    override fun isReady(): Boolean {
        return button.icon != null && button.iconVisibility != View.GONE
    }

    override fun updateLayout() {
        initView()
    }

    private fun initView() {
        view.setVerticalGravity(Gravity.BOTTOM)
        view.addView(
            SpinKitView(view.context)
        )
    }
}