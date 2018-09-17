package hu.ait.android.simplecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()

        val user = User("Peter", "Budapest", 1231)
    }

    private fun setupUI() {
        btnPlus.setOnClickListener {
            if (etNumA.text.isEmpty()) {
                etNumA.error = "Can not be empty"
            } else if (etNumB.text.isEmpty()) {
                etNumB.error = "Can not be empty"
            } else {
                val sum: Int = Integer.parseInt(etNumA.text.toString()) +
                        Integer.parseInt(etNumB.text.toString())

                tvResult.text = "Result: $sum"
            }
        }

        btnMinus.setOnClickListener {
            Log.d("TAG_MSG", "minus button pressed, A is: ${etNumA.text}, B is: ${etNumB.text}")

            val sum: Int = Integer.parseInt(etNumA.text.toString()) -
                    Integer.parseInt(etNumB.text.toString())

            tvResult.text = "Result: $sum"
        }
    }
}
