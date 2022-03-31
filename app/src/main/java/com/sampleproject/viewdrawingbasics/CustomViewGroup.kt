package com.sampleproject.viewdrawingbasics

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout
import androidx.core.view.marginTop

class CustomViewGroup @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val SPACING = 16

    var animating = false
    private var animator: Animator? = null
    private var animationIndexOffset = 0

    private val paint = Paint().apply {
        color = Color.GREEN
    }

    override fun dispatchDraw(canvas: Canvas?) {
        Log.d("CUSTOMVIEWTEST", "dispatchDraw: CustomViewGroup")
        super.dispatchDraw(canvas)
        canvas?.drawPaint(paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("CUSTOMVIEWTEST", "onMeasure: CustomViewGroup")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d("CUSTOMVIEWTEST", "onDraw: CustomViewGroup")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.d("CUSTOMVIEWTEST", "onLayout: CustomViewGroup")
        var currentSpacing = 0
        (0 until childCount).map { getChildAt((it + animationIndexOffset) % childCount) }
            .forEach {
                it.layout(
                    left + currentSpacing,
                    top + currentSpacing - height - marginTop,
                    right - currentSpacing,
                    bottom - currentSpacing - height - marginTop
                )
                currentSpacing += SPACING
            }
    }

    fun animateChild() {
        animator = ValueAnimator.ofInt(0, childCount - 1)
            .apply {
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
                addUpdateListener {
                    animationIndexOffset = it.animatedValue as? Int ?: animationIndexOffset
                    requestLayout()
                }
            }
        animator?.start()
        animating = true
    }

    fun disableAnimation() {
        animator?.cancel()
        animator = null
        animating = false
    }

}