package com.greemoid.ithelps.presentation.instruments.breathing

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

class Circle : View {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
        attrs,
        defStyleAttr)

    val paint = Paint().apply {
        color = Color.RED
    }
    private val centre = PointF(50F, 50F)

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(centre.x, centre.y, 50F, paint)
    }

}