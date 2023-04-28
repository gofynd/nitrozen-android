package com.fynd.nitrozen.utils

import android.content.res.Resources
import kotlin.math.roundToInt

object DisplayMetrics {
    fun convertDpToPixel(dp: Float): Float {
        val metrics = Resources.getSystem().displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return px.roundToInt().toFloat()
    }

    fun convertPixelsToDp(px: Float): Float {
        val metrics = Resources.getSystem().displayMetrics
        val dp = px / (metrics.densityDpi / 160f)
        return dp.roundToInt().toFloat()
    }
}
