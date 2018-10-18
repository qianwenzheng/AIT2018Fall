package hu.aut.android.todorecyclerviewdemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import hu.aut.android.todorecyclerviewdemo.adapter.TodoAdapter
import hu.aut.android.todorecyclerviewdemo.data.Todo
import hu.aut.android.todorecyclerviewdemo.touch.TodoTouchHelperCallback
import kotlinx.android.synthetic.main.activity_scrolling.*
import java.util.Date

class ScrollingActivity : AppCompatActivity() {

    private val todoAdapter = TodoAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        setSupportActionBar(toolbar)

        fabAddTodo.setOnClickListener { view ->
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/

            showAddTodoDialog()
        }

        recyclerTodo.adapter = todoAdapter

        val callback = TodoTouchHelperCallback(todoAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(recyclerTodo)
    }

    private fun showAddTodoDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Enter todo")
        val input = EditText(this)
        dialogBuilder.setView(input)
        dialogBuilder.setNegativeButton("Cancel") {
            dialog, button -> dialog.dismiss()
        }
        dialogBuilder.setPositiveButton("Add") {
            dialog, button ->
                val todo = Todo(
                    Date(System.currentTimeMillis()).toString(),
                    false, input.text.toString())

                todoAdapter.addTodo(todo)
        }
        dialogBuilder.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
