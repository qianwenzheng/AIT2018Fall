package hu.aut.android.highlowgame

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
    }

    override fun onBackPressed() {
        //Toast.makeText(this, "YOU CAN NOT GO BACK", Toast.LENGTH_LONG).show()

        var intentMain = Intent()
        intentMain.setClass(this, MainActivity::class.java)
        intentMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intentMain)

        finish()
    }

}
