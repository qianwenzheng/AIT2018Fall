package hu.aut.android.threadandtimerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var enabled = false

    private inner class MyAppendThread : Thread() {
        override fun run() {
            while (enabled) {
                runOnUiThread {
                    tvData.append("#")
                }


                // Java version
                /*
                runOnUiThread(new Runnable() {
                    public void run() {
                        tvData.append("#")
                    }
                })*/


                sleep(500)
            }
        }
    }

    private inner class MyTimerTask : TimerTask() {
        override fun run() {
            runOnUiThread {
                tvTime.text = Date().toString()
            }
        }
    }

    private lateinit var mainTimer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTimer = Timer()

        btnStart.setOnClickListener {
            if (!enabled) {
                enabled = true
                MyAppendThread().start()
            }
        }

        btnStop.setOnClickListener {
            enabled = false
        }

        btnStartTimer.setOnClickListener {
            mainTimer.schedule(MyTimerTask(), 0, 1000)
        }
    }

    override fun onStop() {
        enabled = false

        mainTimer.cancel() // cancels every TimerTask scheduled by this Timer

        super.onStop()
    }
}
