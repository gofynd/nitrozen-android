package com.fynd.nitrozen.nitrozencheckbox

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozenbutton.utils.pxToDp

class NCheckBox : AppCompatCheckBox {

    private var manager: DrawManager? = null

    constructor(context: Context) : super(context) {
        bind(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        bind(attrs)
    }

    private fun bind(attrs: AttributeSet?) {
        manager = DrawManager(this, attrs)
        manager?.draw()

        val params =
            ViewGroup.LayoutParams(
                manager!!.getCheckBox().layoutWidth,
                manager!!.getCheckBox().layoutHeight
            )
        layoutParams = params
        includeFontPadding = false
        text = manager!!.getCheckBox().text
        try {
            typeface = ResourcesCompat.getFont(context, R.font.poppins)
        } catch (e: Exception) {
        }
        setPadding(pxToDp(10f).toInt(), 0, 0, 0)
        isEnabled = manager!!.getCheckBox().isEnabled
        textSize = manager!!.getCheckBox().textSize
        gravity = Gravity.CENTER_VERTICAL
        if (manager!!.getCheckBox().isIndeterminate) {
            if (isEnabled) {
                setButtonDrawable(R.drawable.ncheckbox_indeterminate_background)
                setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorCheckBoxText
                    )
                )
            } else {
                setButtonDrawable(R.drawable.ncheckbox_disabled_checked_indeterminate_drawable)
                setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorCheckBoxEdge
                    )
                )
            }
        } else {
            if (manager!!.getCheckBox().isEnabled) {
                setButtonDrawable(R.drawable.ncheckbox_background)
                setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorCheckBoxText
                    )
                )
            } else {
                setButtonDrawable(R.drawable.ncheckbox_disabled_background)
                setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorCheckBoxEdge
                    )
                )
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}