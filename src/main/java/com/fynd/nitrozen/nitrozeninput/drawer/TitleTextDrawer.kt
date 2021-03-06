package com.fynd.nitrozen.nitrozeninput.drawer

import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.dpToPx
import com.fynd.nitrozen.nitrozeninput.NInput
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput
import com.fynd.nitrozen.utils.Drawer


class TitleTextDrawer(val view: NInput, val input: NitrozenInput) :
    Drawer<NInput, NitrozenInput>(view, input) {

    private var tv: TextView = TextView(view.context)

    override fun draw() {
        init()
        isViewAdded = true
        view.addView(tv)
    }

    override fun isReady(): Boolean {
        return !TextUtils.isEmpty(input.titleText)
    }

    private fun init() {
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        tv.setSingleLine()
        tv.ellipsize = TextUtils.TruncateAt.END
        tv.setLines(1)
        tv.includeFontPadding = false
        tv.layoutParams = params
        tv.text = input.titleText
        tv.textSize = input.titleTextSize
        tv.minimumHeight = dpToPx(20f).toInt()
        tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorTitle))
        if (!input.errorText.isNullOrEmpty()) {
            tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorError))
        } else {
            if (input.isFocused) {
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

    override fun  updateLayout() {
        if (isViewAdded) {
            init()
        } else {
            draw()
        }
    }
}