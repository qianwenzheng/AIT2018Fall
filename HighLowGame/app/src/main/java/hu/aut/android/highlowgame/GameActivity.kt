package hu.aut.android.highlowgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class GameActivity : AppCompatActivity() {

    private var generatedNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        btnGuess.setOnClickListener {
            if (!TextUtils.isEmpty(etGuess.text)) {

                var guess = etGuess.text.toString().toInt()

                tvStatus.text = when {
                    guess == generatedNum -> {
                        var intentResult = Intent()
                        intentResult.setClass(GameActivity@this,
                                ResultActivity::class.java)
                        startActivity(intentResult)

                        "You have won"
                    }
                    guess < generatedNum -> "The number is larger"
                    else -> "The number is lower"
                }



            } else {
                etGuess.error = "This field can not be empty"
            }

        }

        generatedNum = savedInstanceState?.getInt("KEY_GEN") ?: generateNewNumber()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("KEY_GEN", generatedNum)

        super.onSaveInstanceState(outState)
    }


    private fun generateNewNumber() : Int {
        return Random(System.currentTimeMillis()).nextInt(3)
    }
}
