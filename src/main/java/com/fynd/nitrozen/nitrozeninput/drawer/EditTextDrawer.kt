package com.fynd.nitrozen.nitrozeninput.drawer

import android.graphics.Typeface
import android.view.Gravity
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.utils.Drawer
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozeninput.NInput
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput
import com.fynd.nitrozen.nitrozenloader.NLoader
import java.lang.reflect.Field


internal class EditTextDrawer(val view: NInput, val input: NitrozenInput) :
    Drawer<NInput, NitrozenInput>(view, input) {

    private var et: EditText = EditText(view.context)
    private var relativeLayout: FrameLayout = FrameLayout(view.context)
    private var loaderView =
        NLoader(view.context).apply {
            setColor(R.color.nitrozen_seconday_color)
        }

    override fun draw() {
        init()
        if (input.showLoader) {
            relativeLayout.layoutParams = FrameLayout.LayoutParams(
                input.layoutWidth, input.layoutHeight
            )
            et.layoutParams = FrameLayout.LayoutParams(
                input.layoutWidth, input.layoutHeight
            )
            loaderView.layoutParams = FrameLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                Gravity.END
            )
            (loaderView.layoutParams as FrameLayout.LayoutParams).setMargins(0, 0,
                pxToDp(10f).toInt(), 0)
            relativeLayout.addView(et)
            relativeLayout.addView(loaderView)
            view.addView(relativeLayout)
        } else {
            et.layoutParams = FrameLayout.LayoutParams(
                input.layoutWidth, input.layoutHeight
            )
            view.addView(et)
        }
    }

    override fun isReady(): Boolean {
        return true
    }

    private fun init() {
        try {
            val f: Field = TextView::class.java.getDeclaredField("mCursorDrawableRes")
            f.isAccessible = true
            f.set(et, R.drawable.ninput_cursor)
        } catch (ignored: Exception) {
        }
        et.hint = input.placeHolderText

        if (!input.isEnabled) {
            et.isEnabled = false
            et.setBackgroundResource(R.drawable.ninput_background)
        } else if (!input.isEditable) {
            et.setBackgroundResource(R.drawable.uneditable_background)
            et.isEnabled = false
        } else {
            et.isEnabled = true
            if (input.showError) {
                et.setBackgroundResource(R.drawable.ninput_error_background)
            } else {
                et.setBackgroundResource(R.drawable.ninput_background)
            }
        }
        if (input.showLoader) {
            et.setPadding(
                pxToDp(30f).toInt(),
                et.paddingTop,
                (loaderView.width + pxToDp(10f).toInt()),
                et.paddingBottom
            )
            et.compoundDrawablePadding = pxToDp(30f).toInt()
            et.setCompoundDrawablesWithIntrinsicBounds(
                input.leadingIcon,
                null,
                null,
                null
            )
        } else {
            et.setPadding(
                pxToDp(30f).toInt(),
                et.paddingTop,
                pxToDp(30f).toInt(),
                et.paddingBottom
            )
            et.compoundDrawablePadding = pxToDp(30f).toInt()
            et.setCompoundDrawablesWithIntrinsicBounds(
                input.leadingIcon,
                null,
                input.trailingIcon,
                null
            )
        }
        et.setOnFocusChangeListener { v, hasFocus ->
            input.isFocused = v.isFocused
            view.invalidate()
        }

        try {
            val tf = ResourcesCompat.getFont(view.context, R.font.poppins)
            et.setTypeface(tf, Typeface.NORMAL)
        } catch (e: Exception) {
        }
    }

    override fun updateLayout() {
        init()
    }
}