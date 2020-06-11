package com.fynd.nitrozen.nitrozenloader

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import com.fynd.nitrozen.R

class NLoader @TargetApi(Build.VERSION_CODES.LOLLIPOP) constructor(
    context: Context?,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ProgressBar(context, attrs, defStyleAttr, defStyleRes) {
    private val mStyle: Style
    private var mColor: Int
    private var mSprite: Sprite? = null

    @JvmOverloads
    constructor(
        context: Context?,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = R.attr.NLoaderViewStyle
    ) : this(context, attrs, defStyleAttr, R.style.NLoaderView)

    private fun init() {
        val sprite = SpriteFactory.create(mStyle)
        sprite.color = mColor
        setNIndeterminateDrawable(sprite)
    }

    override fun setIndeterminateDrawable(d: Drawable) {
        require(d is Sprite) { "this d must be instanceof Sprite" }
        setNIndeterminateDrawable(d)
    }

    fun setNIndeterminateDrawable(d: Sprite?) {
        super.setIndeterminateDrawable(d)
        mSprite = d
        if (mSprite!!.color == 0) {
            mSprite!!.color = mColor
        }
        onSizeChanged(width, height, width, height)
        if (visibility == View.VISIBLE) {
            mSprite!!.start()
        }
    }

    override fun getIndeterminateDrawable(): Sprite {
        return mSprite!!
    }

    fun setColor(color: Int) {
        mColor = color
        if (mSprite != null) {
            mSprite!!.color = color
        }
        invalidate()
    }

    override fun unscheduleDrawable(who: Drawable) {
        super.unscheduleDrawable(who)
        if (who is Sprite) {
            who.stop()
        }
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        if (hasWindowFocus) {
            if (mSprite != null && visibility == View.VISIBLE) {
                mSprite!!.start()
            }
        }
    }

    override fun onScreenStateChanged(screenState: Int) {
        super.onScreenStateChanged(screenState)
        if (screenState == View.SCREEN_STATE_OFF) {
            if (mSprite != null) {
                mSprite!!.stop()
            }
        }
    }

    init {
        mStyle = Style.values()[6]
        mColor = Color.WHITE
        init()
        isIndeterminate = true
    }
}