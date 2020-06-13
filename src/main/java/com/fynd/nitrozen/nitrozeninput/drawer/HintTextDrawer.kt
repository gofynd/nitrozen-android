package com.fynd.nitrozen.nitrozeninput.drawer

import android.graphics.Typeface
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp
import com.fynd.nitrozen.nitrozeninput.NInput
import com.fynd.nitrozen.nitrozeninput.model.NitrozenInput
import com.fynd.nitrozen.utils.Drawer


class HintTextDrawer(val view: NInput, val input: NitrozenInput) :
    Drawer<NInput, NitrozenInput>(view, input) {

    private var tv: TextView = TextView(view.context)

    override fun draw() {
        if (isReady()) {
            init()
            isViewAdded = true
            view.addView(tv)
        }
    }

    override fun isReady(): Boolean {
        return !input.hintText.isNullOrEmpty() && input.errorText.isNullOrEmpty() && input.successText.isNullOrEmpty()
    }

    private fun init() {
        if (isReady()) {
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
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
            tv.setTextColor(ContextCompat.getColor(view.context, R.color.colorTitle))
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