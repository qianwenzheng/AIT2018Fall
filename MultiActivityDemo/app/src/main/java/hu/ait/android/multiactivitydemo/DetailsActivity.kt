package hu.ait.android.multiactivitydemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //getIntent()
        if (intent.hasExtra(MainActivity.KEY_EDIT_DATA)) {
            tvData.text = intent.getStringExtra(MainActivity.KEY_EDIT_DATA)
        }


        btnOk.setOnClickListener {
            var intentResult = Intent()
            intentResult.putExtra("KEY_MY_RESULT", etResultData.text.toString())
            setResult(Activity.RESULT_OK, intentResult)
            finish()
        }

    }
}
