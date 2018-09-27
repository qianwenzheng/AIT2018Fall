package hu.ait.android.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.design.widget.Snackbar
import hu.ait.android.tictactoe.model.TicTacToeModel
import hu.ait.android.tictactoe.ui.TicTacToeView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRestart.setOnClickListener {
            ticTacToeView.restart()
        }

        shimmerLayout.startShimmer()
    }

    private fun TicTacToeView.restart() {
            TicTacToeModel.resetModel()
            invalidate()
    }

    public fun showMessage(msg: String) {
        //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    }

    public fun showUndoMessage(msg: String) {
        Snackbar.make(ticTacToeView, msg, Snackbar.LENGTH_LONG)
                .setAction("Undo") {
                    TicTacToeModel.undo()
                    ticTacToeView.invalidate()
                }
                .show()
    }

    public fun showNextPlayer(msg: String) {
        tvPlayer.text = msg
        //showUndoMessage(msg)
    }

}
