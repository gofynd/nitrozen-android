package com.fynd.nitrozen.nitrozenbutton.drawer

import android.graphics.Typeface
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.nitrozenbutton.NBtn
import com.fynd.nitrozen.nitrozenbutton.model.NitrozenButton
import com.fynd.nitrozen.nitrozenbutton.utils.getDensity

internal class TextDrawer(val view: NBtn, val button: NitrozenButton) :
    Drawer<NBtn, NitrozenButton>(view, button) {

    private var tv: TextView = TextView(view.context)

    override fun draw() {
        initText()
        view.addView(tv)
    }

    override fun isReady(): Boolean {
        return !TextUtils.isEmpty(button.text) && button.textVisibility != View.GONE
    }

    private fun initText() {
        tv.layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        tv.text = button.text
        tv.gravity = Gravity.CENTER
        tv.includeFontPadding = false
        tv.textSize = button.textSize / getDensity()
        tv.isAllCaps = button.textAllCaps
        tv.visibility = button.textVisibility
        tv.setPadding(
            button.textPaddingStart.toInt(), button.textPaddingTop.toInt(),
            button.textPaddingEnd.toInt(), button.textPaddingBottom.toInt()
        )

        setColor()
        setTypeface()
    }

    private fun setColor() {
        if (!button.enable) {
            if (button.elementsDisableColor != 0) {
                tv.setTextColor(button.elementsDisableColor)
            } else {
                tv.setTextColor(button.textColor)
                tv.alpha = getAlpha()
            }
        } else {
            tv.setTextColor(button.textColor)
        }
    }

    private fun setTypeface() {
        tv.setTypeface(Typeface.DEFAULT, button.textStyle)
        if (button.textFont != null) {
            tv.setTypeface(button.textFont, button.textStyle)
        } else {
            if (button.fontRes != 0) {
                try {
                    val tf = ResourcesCompat.getFont(view.context, button.fontRes)
                    tv.setTypeface(tf, button.textStyle)
                    button.textFont = tf
                } catch (e: Exception) {
                    Log.e(TextDrawer::class.java.simpleName, "Incorrect font resource")
                }
            }
        }
    }

    override fun updateLayout() {
        initText()
    }

}