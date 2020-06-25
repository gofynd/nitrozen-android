package com.fynd.nitrozen.nitrozeninput.drawer

import android.graphics.PorterDuff
import android.graphics.Typeface
import android.os.Build
import android.text.InputFilter
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozeninput.NInput
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput
import com.fynd.nitrozen.nitrozeninput.view.NitrozenEditText
import com.fynd.nitrozen.nitrozenloader.NLoader
import com.fynd.nitrozen.utils.Drawer
import java.lang.reflect.Field

class EditTextDrawer(val view: NInput, val input: NitrozenInput) :
    Drawer<NInput, NitrozenInput>(view, input) {

    private var et: NitrozenEditText = NitrozenEditText(view.context)
    private var relativeLayout: FrameLayout = FrameLayout(view.context)
    private var loaderView =
        NLoader(view.context).apply {
            setColor(R.color.nitrozen_seconday_color)
        }

    override fun draw() {
        init()
        if (input.showLoader) {
            relativeLayout.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT
            )
            et.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                if (input.layoutGravity != null) {
                    gravity = input.layoutGravity!!
                }
            }
            loaderView.layoutParams = FrameLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT,
                Gravity.END
            )
            (loaderView.layoutParams as FrameLayout.LayoutParams).setMargins(
                0, 0,
                pxToDp(10f).toInt(), 0
            )
            relativeLayout.addView(et)
            relativeLayout.addView(loaderView)
            view.addView(relativeLayout)
        } else {
            et.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT
            )
            view.addView(et)
        }
    }

    fun setLeadingIconVisibility(visibility: Int) {
        when (visibility) {
            View.VISIBLE -> {
                if (!input.showLoader) {
                    et.setCompoundDrawablesWithIntrinsicBounds(
                        input.leadingIcon,
                        null,
                        input.trailingIcon,
                        null
                    )
                }
            }
            View.GONE -> {
                et.setCompoundDrawablesWithIntrinsicBounds(
                    null,
                    null,
                    input.trailingIcon,
                    null
                )
            }
        }
    }

    fun setTrailingIconVisibility(visibility: Int) {
        when (visibility) {
            View.VISIBLE -> {
                if (!input.showLoader) {
                    et.setCompoundDrawablesWithIntrinsicBounds(
                        input.leadingIcon,
                        null,
                        input.trailingIcon,
                        null
                    )
                }
            }
            View.GONE -> {
                et.setCompoundDrawablesWithIntrinsicBounds(
                    input.leadingIcon,
                    null,
                    null,
                    null
                )
            }
        }
    }

    fun getEditText(): AppCompatEditText {
        return et
    }


    fun setText(text: String?) {
        et.setText(text)
    }

    fun setDrawableClickListener(listener: NitrozenEditText.DrawableClickListener) {
        et.setDrawableClickListener(object : NitrozenEditText.DrawableClickListener {
            override fun onClick(target: NitrozenEditText.DrawableClickListener.DrawablePosition?) {
                when (target) {
                    NitrozenEditText.DrawableClickListener.DrawablePosition.LEADING -> {
                        listener.onClick(NitrozenEditText.DrawableClickListener.DrawablePosition.LEADING)
                    }
                    NitrozenEditText.DrawableClickListener.DrawablePosition.TRAILING -> {
                        listener.onClick(NitrozenEditText.DrawableClickListener.DrawablePosition.TRAILING)
                    }
                    else -> {
                    }
                }
            }
        })
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
        if(input.maxLength>0){
            et.filters += InputFilter.LengthFilter(input.maxLength)
        }
        et.hint = input.placeHolderText
        et.minimumHeight = dpToPx(40f).toInt()
        if (!input.isEnabled) {
            et.isEnabled = false
            et.setBackgroundResource(R.drawable.ninput_background)
        } else if (!input.isEditable) {
            et.setBackgroundResource(R.drawable.uneditable_background)
            et.isEnabled = false
        } else {
            et.isEnabled = true
            if (!input.errorText.isNullOrEmpty()) {
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

        //et.setText(input.text)
        et.textSize = input.textSize
        if (isValueProvided(input.ellipSize)) {
            et.ellipsize = TextUtils.TruncateAt.values()[input.ellipSize!!]
        }
        if (isValueProvided(input.gravity)) {
            et.gravity = input.gravity!!
        }
        if (isValueProvided(input.inputType)) {
            et.inputType = input.inputType!!
        }
        if (input.singeLine) {
            et.setSingleLine()
        }
        et.maxLines = input.maxLines
        if (input.leadingIcon != null) {
            val drawable =
                DrawableCompat.wrap(input.leadingIcon!!)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                DrawableCompat.setTint(input.leadingIcon!!, input.leadingIconTint)
            } else {
                drawable.mutate().setColorFilter(input.leadingIconTint, PorterDuff.Mode.SRC_IN)
            }
        }
        if (input.trailingIcon != null) {
            val drawable =
                DrawableCompat.wrap(input.trailingIcon!!)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                DrawableCompat.setTint(input.trailingIcon!!, input.trailingIconTint)
            } else {
                drawable.mutate().setColorFilter(input.trailingIconTint, PorterDuff.Mode.SRC_IN)
            }
        }
    }


    fun isValueProvided(value: Int?): Boolean {
        return value != null && value != -1
    }

    override fun updateLayout() {
        init()
    }
}