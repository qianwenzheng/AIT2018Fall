package hu.ait.android.timeshowapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShow.setOnClickListener{
            displayTime()
        }
    }

    private fun displayTime() {
        val time =
                "Hello: ${etName.text.toString()} ${Date(System.currentTimeMillis()).toString()}"


        tvTime.text = time


        /*Toast.makeText(this@MainActivity,
                time,
                Toast.LENGTH_LONG).show()*/

        Snackbar.make(layoutContent, time, Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.btn_clear)) {
                    tvTime.text = ""
                }
                .show()

        // THIS WAS THE OLD JAVA WAY with anonim OnClickListener object
        /*Snackbar.make(layoutContent, time, Snackbar.LENGTH_LONG)
                .setAction("Clear", new OnClickListener() {
                    public void onClick(View v) {
                        tvTime.setText("");
                    }
                })
                .show()*/
    }

}
