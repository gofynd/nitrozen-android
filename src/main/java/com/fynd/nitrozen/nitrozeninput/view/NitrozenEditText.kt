package com.fynd.nitrozen.nitrozeninput.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import com.fynd.nitrozen.R
import com.fynd.nitrozen.nitrozeninput.view.NitrozenEditText.DrawableClickListener.DrawablePosition

class NitrozenEditText : AppCompatEditText {
    private var drawableRight: Drawable? = null
    private var drawableLeft: Drawable? = null
    private var drawableTop: Drawable? = null
    private var drawableBottom: Drawable? = null
    var actionX = 0
    var actionY = 0
    private var clickListener: DrawableClickListener? = null

    @JvmOverloads
    constructor(
        context: Context?,
        attrs: AttributeSet? = null
    ) : super(context, attrs)

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle)

    override fun setCompoundDrawables(
        left: Drawable?, top: Drawable?,
        right: Drawable?, bottom: Drawable?
    ) {
        if (left != null) {
            drawableLeft = left
        }
        if (right != null) {
            drawableRight = right
        }
        if (top != null) {
            drawableTop = top
        }
        if (bottom != null) {
            drawableBottom = bottom
        }
        super.setCompoundDrawables(left, top, right, bottom)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var bounds: Rect?
        if (event.action == MotionEvent.ACTION_DOWN) {
            actionX = event.x.toInt()
            actionY = event.y.toInt()
            if (drawableBottom != null
                && drawableBottom!!.bounds.contains(actionX, actionY)
            ) {
                clickListener!!.onClick(DrawablePosition.BOTTOM)
                return super.onTouchEvent(event)
            }
            if (drawableTop != null
                && drawableTop!!.bounds.contains(actionX, actionY)
            ) {
                clickListener!!.onClick(DrawablePosition.TOP)
                return super.onTouchEvent(event)
            }
            // this works for left since container shares 0,0 origin with bounds
            if (drawableLeft != null) {
                bounds = null
                bounds = drawableLeft!!.bounds
                var x: Int
                var y: Int
                val extraTapArea =
                    (13 * resources.displayMetrics.density + 0.5).toInt()
                x = actionX
                y = actionY
                if (!bounds.contains(actionX, actionY)) {
                    /** Gives the +20 area for tapping.  */
                    x = actionX - extraTapArea
                    y = actionY - extraTapArea
                    if (x <= 0) x = actionX
                    if (y <= 0) y = actionY
                    /** Creates square from the smallest value  */
                    if (x < y) {
                        y = x
                    }
                }
                if (bounds.contains(x, y) && clickListener != null) {
                    clickListener!!
                        .onClick(DrawablePosition.LEADING)
                    event.action = MotionEvent.ACTION_CANCEL
                    return false
                }
            }
            if (drawableRight != null) {
                bounds = null
                bounds = drawableRight!!.bounds
                var x: Int
                var y: Int
                val extraTapArea = 13
                /**
                 * IF USER CLICKS JUST OUT SIDE THE RECTANGLE OF THE DRAWABLE
                 * THAN ADD X AND SUBTRACT THE Y WITH SOME VALUE SO THAT AFTER
                 * CALCULATING X AND Y CO-ORDINATE LIES INTO THE DRAWBABLE
                 * BOUND. - this process help to increase the tappable area of
                 * the rectangle.
                 */
                x = actionX + extraTapArea
                y = actionY - extraTapArea
                /**Since this is right drawable subtract the value of x from the width
                 * of view. so that width - tappedarea will result in x co-ordinate in drawable bound.
                 */
                x = width - x
                /*x can be negative if user taps at x co-ordinate just near the width.
                 * e.g views width = 300 and user taps 290. Then as per previous calculation
                 * 290 + 13 = 303. So subtract X from getWidth() will result in negative value.
                 * So to avoid this add the value previous added when x goes negative.
                 */if (x <= 0) {
                    x += extraTapArea
                }
                /* If result after calculating for extra tappable area is negative.
                 * assign the original value so that after subtracting
                 * extratapping area value doesn't go into negative value.
                 */if (y <= 0) y = actionY
                /**If drawble bounds contains the x and y points then move ahead. */
                if (bounds.contains(x, y) && clickListener != null) {
                    clickListener!!
                        .onClick(DrawablePosition.TRAILING)
                    event.action = MotionEvent.ACTION_CANCEL
                    return false
                }
                return super.onTouchEvent(event)
            }
        }
        return super.onTouchEvent(event)
    }

    @Throws(Throwable::class)
    protected fun finalize() {
        drawableRight = null
        drawableBottom = null
        drawableLeft = null
        drawableTop = null
    }

    fun setDrawableClickListener(listener: DrawableClickListener?) {
        clickListener = listener
    }

    interface DrawableClickListener {
        enum class DrawablePosition {
            LEADING, TRAILING, TOP, BOTTOM
        }

        fun onClick(target: DrawablePosition?)
    }
}