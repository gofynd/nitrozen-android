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
import com.fynd.nitrozen.nitrozendropdown.NDropdown

class NCheckBox : AppCompatCheckBox {

    private var manager: DrawManager? = null

    constructor(context: Context) : super(context) {
        buildDrawManager(null)
        bind()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        buildDrawManager(attrs)
        bind()
    }

    private fun buildDrawManager(attrs: AttributeSet?) {
        manager = DrawManager(this, attrs)
        manager?.draw()
        val params =
            ViewGroup.LayoutParams(
                manager!!.getCheckBox().layoutWidth,
                manager!!.getCheckBox().layoutHeight
            )
        layoutParams = params
    }

    private fun bind() {
        includeFontPadding = false
        text = manager!!.getCheckBox().text
        try {
            typeface = ResourcesCompat.getFont(context, R.font.poppins)
        } catch (e: Exception) {
        }
        setPadding(
            if (paddingLeft == 0) {
                pxToDp(10f).toInt()
            } else {
                paddingLeft
            },
            paddingTop,
            paddingRight,
            paddingBottom
        )
        isEnabled = manager!!.getCheckBox().isEnabled
        textSize = manager!!.getCheckBox().textSize
        gravity = Gravity.CENTER_VERTICAL
        if (manager!!.getCheckBox().isIndeterminate) {
            if (manager!!.getCheckBox().isEnabled) {
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

    fun setNcbEnabled(isEnabled: Boolean): NCheckBox {
        manager!!.getCheckBox().isEnabled = isEnabled
        updateView()
        return this
    }

    fun setNcbText(text: String): NCheckBox {
        manager!!.getCheckBox().text = text
        updateView()
        return this
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        manager?.changeMeasure(widthMeasureSpec, heightMeasureSpec)
        bind()
    }

    private fun updateView() {
        requestLayout()
    }
}