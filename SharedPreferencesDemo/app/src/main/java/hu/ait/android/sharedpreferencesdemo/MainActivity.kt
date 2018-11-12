package hu.ait.android.sharedpreferencesdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    companion object {
        val KEY_LAST = "KEY_LAST"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLastTimeText()

        saveLastTime()
    }

    private fun showLastTimeText() {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val lastTime = sp.getString(KEY_LAST, "This is the first time when we meet:)")
        tvData.text = lastTime
    }

    private fun saveLastTime() {
        val sp = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sp.edit()
        editor.putString(KEY_LAST, Date(System.currentTimeMillis()).toString())
        editor.apply()
    }


}
