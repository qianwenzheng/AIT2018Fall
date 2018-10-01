package hu.ait.android.multiactivitydemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val KEY_EDIT_DATA = "KEY_EDIT_DATA"
        val REQUEST_DETAILS = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener {
            var intentStart = Intent()
            intentStart.setClass(this@MainActivity, DetailsActivity::class.java)

            intentStart.putExtra(KEY_EDIT_DATA, etData.text.toString())


            //startActivity(intentStart)

            startActivityForResult(intentStart, REQUEST_DETAILS)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_DETAILS) {
            if (resultCode == Activity.RESULT_OK) {
                var content = data?.getStringExtra("KEY_MY_RESULT")
                Toast.makeText(this, content, Toast.LENGTH_LONG).show()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "REQUEST CANCELLED", Toast.LENGTH_LONG).show()
            }
        }
    }

}
