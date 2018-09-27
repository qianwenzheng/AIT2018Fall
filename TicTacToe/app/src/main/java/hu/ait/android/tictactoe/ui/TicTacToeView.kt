package hu.ait.android.tictactoe.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import hu.ait.android.tictactoe.MainActivity
import hu.ait.android.tictactoe.R
import hu.ait.android.tictactoe.model.TicTacToeModel

class TicTacToeView(context: Context?, attrs: AttributeSet?) : View(context, attrs)
{
    private val paintBackGround = Paint()
    private val paintLine = Paint()
    private val paintText = Paint()

    private var bitMapBg =
            BitmapFactory.decodeResource(resources, R.drawable.grass)

    init {
        paintBackGround.color = Color.BLACK
        paintBackGround.strokeWidth = 5F
        paintBackGround.style = Paint.Style.FILL

        paintLine.color = Color.WHITE
        paintLine.style = Paint.Style.STROKE
        paintLine.strokeWidth = 5F

        paintText.color = Color.GREEN
        paintText.textSize = 100F
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        paintText.textSize = height.toFloat()/3

        bitMapBg = Bitmap.createScaledBitmap(bitMapBg,
                width/3, height/3,false)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(0f, 0f,
                width.toFloat(), height.toFloat(), paintBackGround)

        canvas.drawBitmap(bitMapBg, 0F, 0F, null)

        canvas.drawText("A", 10F, height.toFloat()/3, paintText)

        drawGameArea(canvas)

        drawPlayers(canvas)
    }

    fun drawGameArea(canvas: Canvas) {
        // border
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paintLine)
        // two horizontal lines
        canvas.drawLine(0f, (height / 3).toFloat(), width.toFloat(), (height / 3).toFloat(),
                paintLine)
        canvas.drawLine(0f, (2 * height / 3).toFloat(), width.toFloat(),
                (2 * height / 3).toFloat(), paintLine)

        // two vertical lines
        canvas.drawLine((width / 3).toFloat(), 0f, (width / 3).toFloat(), height.toFloat(),
                paintLine)
        canvas.drawLine((2 * width / 3).toFloat(), 0f, (2 * width / 3).toFloat(), height.toFloat(),
                paintLine)
    }

    private fun drawPlayers(canvas: Canvas) {
        for (i in 0..2) {
            for (j in 0..2) {
                if (TicTacToeModel.getFieldContent(i, j) == TicTacToeModel.CIRCLE) {
                    val centerX = (i * width / 3 + width / 6).toFloat()
                    val centerY = (j * height / 3 + height / 6).toFloat()
                    val radius = height / 6 - 2

                    canvas.drawCircle(centerX, centerY, radius.toFloat(), paintLine)
                } else if (TicTacToeModel.getFieldContent(i, j) == TicTacToeModel.CROSS) {
                    canvas.drawLine((i * width / 3).toFloat(), (j * height / 3).toFloat(),
                            ((i + 1) * width / 3).toFloat(),
                            ((j + 1) * height / 3).toFloat(), paintLine)

                    canvas.drawLine(((i + 1) * width / 3).toFloat(), (j * height / 3).toFloat(),
                            (i * width / 3).toFloat(), ((j + 1) * height / 3).toFloat(), paintLine)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val tX = event.x.toInt() / (width / 3)
        val tY = event.y.toInt() / (height / 3)

        if (tX < 3 && tY < 3 &&
                TicTacToeModel.getFieldContent(tX, tY) == TicTacToeModel.EMPTY) {

            TicTacToeModel.setFieldContent(tX, tY, TicTacToeModel.getNextPlayer())
            TicTacToeModel.changeNextPlayer()
            (context as MainActivity).showNextPlayer(
                    if (TicTacToeModel.getNextPlayer() == TicTacToeModel.CIRCLE) "0 is coming" else
                        "X is coming"
            )

            (context as MainActivity).showUndoMessage("Next move")

            invalidate()

            //(context as MainActivity).showMessage("you have won")
        }

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