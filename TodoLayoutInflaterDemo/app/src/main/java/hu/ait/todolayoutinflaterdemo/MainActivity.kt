package hu.ait.todolayoutinflaterdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.todo_row.view.*
import java.util.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener{
            insertTodo()
        }

    }

    private fun insertTodo() {
        val viewTodo = layoutInflater.inflate(
            R.layout.todo_row, null, false
        )

        viewTodo.tvDate.text = Date(System.currentTimeMillis()).toString()
        viewTodo.tvTodo.text = etTodo.text.toString()

        viewTodo.btnDel.setOnClickListener {
            layoutContent.removeView(viewTodo)
        }



        layoutContent.addView(viewTodo, 0)
    }

}
