package com.fynd.nitrozen.nitrozeninput.drawer

import android.graphics.Typeface
import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.utils.Drawer
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozeninput.NInput
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput


internal class HintTextDrawer(val view: NInput, val input: NitrozenInput) :
    Drawer<NInput, NitrozenInput>(view, input) {

    private var tv: TextView = TextView(view.context)

    override fun draw() {
        init()
        view.addView(tv)
    }

    override fun isReady(): Boolean {
        return !TextUtils.isEmpty(input.hintText)
    }

    private fun init() {
        val params: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(input.layoutWidth, input.layoutHeight)
        params.setMargins(
            pxToDp(5f).toInt(),
            pxToDp(5f).toInt(), 0, 0
        )
        tv.setSingleLine()
        tv.ellipsize = TextUtils.TruncateAt.END
        tv.setLines(1)
        tv.layoutParams = params
        tv.text = input.hintText
        tv.textSize = input.hintTextSize
        try {
            val tf = ResourcesCompat.getFont(view.context, R.font.poppins)
            tv.setTypeface(tf, Typeface.NORMAL)
        } catch (e: Exception) {
        }
        if (input.showError) {
            tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorError))
        } else {
            tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorTitle))
        }
    }

    override fun updateLayout() {
        init()
    }
}