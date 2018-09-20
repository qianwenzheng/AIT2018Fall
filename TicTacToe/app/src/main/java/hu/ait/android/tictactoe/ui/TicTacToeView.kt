package hu.ait.android.tictactoe.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class TicTacToeView(context: Context?, attrs: AttributeSet?) : View(context, attrs)
{
    private val paintBackGround = Paint()
    private val paintLine = Paint()

    private var myX: Float = 0F
    private var myY: Float = 0F

    init {
        paintBackGround.color = Color.BLACK
        paintBackGround.strokeWidth = 5F
        paintBackGround.style = Paint.Style.FILL

        paintLine.color = Color.WHITE
        paintLine.style = Paint.Style.STROKE
        paintLine.strokeWidth = 5F
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(0f, 0f,
                width.toFloat(), height.toFloat(), paintBackGround)

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(),
                paintLine)
        canvas.drawLine(0f, 0f, width.toFloat(), height.toFloat(),
                paintLine)

        canvas.drawCircle(myX, myY, 70F, paintLine)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        myX = event.x
        myY = event.y

        invalidate()


        return super.onTouchEvent(event)
    }

}


/*
public class TicTacToeView extends View {

    private final Paint paintBackground = new Paint();

    TicTacToeView(context, attrs) {
        super(context, attrs)

        paintBg.setColor(Color.Black);
    }

}*/