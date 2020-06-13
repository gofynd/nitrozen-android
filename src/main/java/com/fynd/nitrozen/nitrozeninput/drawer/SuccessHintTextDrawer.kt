package com.fynd.nitrozen.nitrozeninput.drawer

import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
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


class SuccessHintTextDrawer(val view: NInput, val input: NitrozenInput) :
    Drawer<NInput, NitrozenInput>(view, input) {

    private var successText: TextView = TextView(view.context)
    private var hintText: TextView = TextView(view.context)
    private var linearLayout: LinearLayout = LinearLayout(view.context)

    override fun draw() {
        if (isReady()) {
            init()
            linearLayout.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            linearLayout.orientation = LinearLayout.HORIZONTAL
            linearLayout.weightSum = 1f
            linearLayout.addView(successText)
            linearLayout.addView(hintText)
            isViewAdded = true
            view.addView(linearLayout)
        }
    }

    override fun isReady(): Boolean {
        return !TextUtils.isEmpty(input.successText) && input.errorText.isNullOrEmpty() && !input.hintText.isNullOrEmpty()
    }

    private fun init() {
        set(successText, true)
        set(hintText, false)
    }

    private fun set(textView: TextView, isSuccessText: Boolean) {
        if(isReady()){
            val params =
                LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    weight = 0.5f
                    gravity = if (isSuccessText) {
                        Gravity.START
                    } else {
                        Gravity.END
                    }
                }

            textView.includeFontPadding = false
            textView.setPadding(0, pxToDp(10f).toInt(), 0, 0)
            if (isSuccessText) {
                textView.gravity = Gravity.CENTER_VERTICAL
                params.setMargins(
                    pxToDp(5f).toInt(),
                    pxToDp(5f).toInt(), 0, 0
                )
                textView.text = input.successText
                textView.setTextColor(ContextCompat.getColor(view.context, R.color.btn_primary_color))
                textView.compoundDrawablePadding = pxToDp(10f).toInt()
                textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_success, 0, 0, 0)
            } else {
                textView.gravity = Gravity.END
                params.setMargins(
                    0,
                    pxToDp(10f).toInt(),
                    pxToDp(5f).toInt(), 0
                )
                textView.text = input.hintText
                textView.setTextColor(ContextCompat.getColor(view.context, R.color.colorTitle))
            }
            textView.setSingleLine()
            textView.ellipsize = TextUtils.TruncateAt.END
            textView.setLines(1)
            textView.layoutParams = params
            textView.textSize = input.titleTextSize
            try {
                val tf = ResourcesCompat.getFont(view.context, R.font.poppins)
                textView.setTypeface(tf, Typeface.NORMAL)
            } catch (e: Exception) {
            }
            textView.visibility = View.VISIBLE
        }else{
            textView.visibility = View.GONE
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