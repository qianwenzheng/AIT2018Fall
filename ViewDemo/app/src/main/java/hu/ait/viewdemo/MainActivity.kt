package hu.ait.viewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import kotlinx.android.synthetic.main.activity_autocomplete.*


class MainActivity : AppCompatActivity() {

    private val cityNames = arrayOf("Budapest", "Bukarest", "New York", "New Delhi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autocomplete)

        val cityAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, cityNames
        )
        autoCompleteTextViewCities.threshold = 1
        autoCompleteTextViewCities.setAdapter(cityAdapter)


        //setContentView(R.layout.activity_main)
        //imageView.setImageResource(R.mipmap.ic_launcher)
        //webView.loadUrl("http://babcomaut.aut.bme.hu/votes/")
    }
}
