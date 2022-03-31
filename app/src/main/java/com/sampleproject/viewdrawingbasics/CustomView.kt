package com.sampleproject.viewdrawingbasics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val colors = listOf(Color.RED, Color.GREEN, Color.BLUE)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = colors.random()
        canvas?.drawPaint(paint)
        Log.d("CUSTOMVIEWTEST", "onDraw: CustomView")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("CUSTOMVIEWTEST", "onMeasure: CustomView")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d("CUSTOMVIEWTEST", "onLayout: CustomView")
    }

}