package com.pina.layoutexplorer

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var progress = 0f
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 20f
        strokeCap = Paint.Cap.ROUND
    }

    fun setProgress(value: Float) {
        progress = value.coerceIn(0f, 100f)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (Math.min(width, height) / 2f) - 20f

        paint.color = Color.LTGRAY
        canvas.drawCircle(centerX, centerY, radius, paint)

        paint.color = Color.parseColor("#1565C0")
        val sweepAngle = (progress / 100f) * 360f
        canvas.drawArc(
            centerX - radius, centerY - radius,
            centerX + radius, centerY + radius,
            -90f, sweepAngle, false, paint
        )
    }
}