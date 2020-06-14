package com.fynd.nitrozen.nitrozencheckbox.drawer

import android.view.Gravity
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozencheckbox.NCheckBox
import com.fynd.nitrozen.nitrozencheckbox.model.NitrozenCheckBox
import com.fynd.nitrozen.utils.Drawer


class CheckBoxDrawer(val view: NCheckBox, val nCheckBox: NitrozenCheckBox) :
    Drawer<NCheckBox, NitrozenCheckBox>(view, nCheckBox) {

    private var checkBox: AppCompatCheckBox = AppCompatCheckBox(view.context)

    override fun draw() {
        init()
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        checkBox.layoutParams = params
        view.addView(checkBox, params)
    }

    override fun isReady(): Boolean {
        return true
    }

    private fun init() {
        checkBox.includeFontPadding = false
        checkBox.text = nCheckBox.text
        try {
            checkBox.typeface = ResourcesCompat.getFont(view.context, R.font.poppins)
        } catch (e: Exception) {
        }
        checkBox.setPadding(pxToDp(10f).toInt(), 0, 0, 0)
        checkBox.isEnabled = nCheckBox.isEnabled
        checkBox.isChecked = nCheckBox.isChecked
        checkBox.textSize = nCheckBox.textSize
        checkBox.gravity = Gravity.CENTER_VERTICAL
        if (nCheckBox.isIndeterminate) {
            if (nCheckBox.isEnabled) {
                checkBox.setButtonDrawable(R.drawable.ncheckbox_indeterminate_background)
                checkBox.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorCheckBoxText
                    )
                )
            } else {
                checkBox.setButtonDrawable(R.drawable.ncheckbox_disabled_checked_indeterminate_drawable)
                checkBox.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorCheckBoxEdge
                    )
                )
            }
        } else {
            if (nCheckBox.isEnabled) {
                checkBox.setButtonDrawable(R.drawable.ncheckbox_background)
                checkBox.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorCheckBoxText
                    )
                )
            } else {
                checkBox.setButtonDrawable(R.drawable.ncheckbox_disabled_background)
                checkBox.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.colorCheckBoxEdge
                    )
                )
            }
        }
    }

    fun getCheckBox(): AppCompatCheckBox {
        return checkBox
    }

    override fun updateLayout() {
        init()
    }
}