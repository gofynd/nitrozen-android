package com.fynd.nitrozen.nitrozendropdown.drawer

import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozendropdown.NDropdown
import com.fynd.nitrozen.nitrozendropdown.model.NitrozenDropdown
import com.fynd.nitrozen.utils.Drawer


class TitleTextDrawer(val view: NDropdown, val nDropdown: NitrozenDropdown) :
    Drawer<NDropdown, NitrozenDropdown>(view, nDropdown) {

    private var tv: TextView = TextView(view.context)

    override fun draw() {
        init()
        isViewAdded = true
        view.addView(tv)
    }

    override fun isReady(): Boolean {
        return !nDropdown.titleText.isNullOrEmpty()
    }

    private fun init() {
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        params.setMargins(
            pxToDp(5f).toInt(),
            0, 0,
            pxToDp(5f).toInt()
        )
        tv.includeFontPadding = false
        tv.setSingleLine()
        tv.ellipsize = TextUtils.TruncateAt.END
        tv.setLines(1)
        tv.minimumHeight = dpToPx(20f).toInt()
        tv.layoutParams = params
        tv.text = nDropdown.titleText
        tv.textSize = nDropdown.titleTextSize
        if (!nDropdown.errorText.isNullOrEmpty()) {
            tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorError))
        } else {
            if (nDropdown.isFocused) {
                tv.setTextColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.nitrozen_seconday_color
                    )
                )
            } else {
                tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorTitle))
            }
        }
        try {
            val tf = ResourcesCompat.getFont(view.context, R.font.poppins)
            tv.setTypeface(tf, Typeface.NORMAL)
        } catch (e: Exception) {
        }
        if (isReady()) {
            tv.visibility = View.VISIBLE
        } else {
            tv.visibility = View.GONE
        }
    }

    override fun updateLayout() {
        if (isViewAdded) {
            init()
        } else {
            draw()
        }
    }
}