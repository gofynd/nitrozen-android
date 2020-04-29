package com.fynd.nitrozen.nitrozenbutton.drawer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.fynd.nitrozen.R

class CircleView : View {

    var circleRadius: Int = 30

    var circleColor: Int = 0

    var isAntiAlias: Boolean = true

    private var xyCordinates: Float = 0.0f
    private val paint: Paint = Paint()

    constructor(
        context: Context,
        circleRadius: Int,
        circleColor: Int,
        isAntiAlias: Boolean = true
    ) : super(context) {
        this.circleRadius = circleRadius
        this.circleColor = circleColor
        this.isAntiAlias = isAntiAlias

        initValues()
    }

    constructor(
        context: Context,
        circleRadius: Int,
        circleColor: Int,
        drawOnlyStroke: Boolean,
        strokeWidth: Int
    ) : super(context) {
        this.circleRadius = circleRadius
        this.circleColor = circleColor
        initValues()
    }

    constructor(context: Context) : super(context) {
        initValues()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
        initValues()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initAttributes(attrs)
        initValues()
    }


    fun initAttributes(attrs: AttributeSet) {
        this.circleRadius = 30
        this.circleColor = ContextCompat.getColor(context, R.color.white)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val widthHeight = (2 * (circleRadius))
        setMeasuredDimension(widthHeight, widthHeight)
    }

    private fun initValues() {
        paint.isAntiAlias = isAntiAlias
        paint.style = Paint.Style.FILL
        paint.color = circleColor

        //adding half of strokeWidth because
        //the stroke will be half inside the drawing circle and half outside
        xyCordinates = (circleRadius + (0 / 2)).toFloat()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(xyCordinates, xyCordinates, circleRadius.toFloat(), paint)
    }
}