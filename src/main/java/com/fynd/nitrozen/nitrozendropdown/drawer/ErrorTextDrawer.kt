package com.fynd.nitrozen.nitrozendropdown.drawer

import android.graphics.Typeface
import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.utils.Drawer
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozendropdown.NDropdown
import com.fynd.nitrozen.nitrozendropdown.model.NitrozenDropdown


class ErrorTextDrawer(val view: NDropdown, val nDropdown: NitrozenDropdown) :
    Drawer<NDropdown, NitrozenDropdown>(view, nDropdown) {

    private var tv: TextView = TextView(view.context)

    override fun draw() {
        init()
        view.addView(tv)
    }

    override fun isReady(): Boolean {
        return nDropdown.showError && nDropdown.errorText.isNotEmpty()
    }

    private fun init() {
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(
            pxToDp(5f).toInt(),
            pxToDp(10f).toInt(), 0,
            pxToDp(5f).toInt()
        )
        tv.setSingleLine()
        tv.ellipsize = TextUtils.TruncateAt.END
        tv.setLines(1)
        tv.layoutParams = params
        tv.text = nDropdown.errorText
        tv.textSize = nDropdown.titleTextSize
        tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorError))
        try {
            val tf = ResourcesCompat.getFont(view.context, R.font.poppins)
            tv.setTypeface(tf, Typeface.NORMAL)
        } catch (e: Exception) {
        }
    }

    override fun updateLayout() {
        init()
    }
}