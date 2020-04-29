package com.fynd.nitrozen.nitrozenbutton.utils

import android.content.res.Resources
import android.util.TypedValue


fun dpToPx(dp: Float): Float {
    return TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem()
                .displayMetrics
        )
}

fun pxToDp(px: Float): Float {
    return TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_PX, px, Resources.getSystem()
                .displayMetrics
        )
}

fun txtPxToSp(px: Float): Float {
    return TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_SP, px, Resources.getSystem()
                .displayMetrics
        )
}

fun getDensity(): Float {
    return Resources.getSystem().displayMetrics.density
}