package hu.ait.android.aithellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShow.setOnClickListener{
            val time: String = Date(System.currentTimeMillis()).toString()
            tvTime.text = time
            Toast.makeText(this@MainActivity, time, Toast.LENGTH_LONG).show()
        }
    }
}
