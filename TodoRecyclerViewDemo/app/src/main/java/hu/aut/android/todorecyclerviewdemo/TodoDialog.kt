package hu.aut.android.todorecyclerviewdemo

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import hu.aut.android.todorecyclerviewdemo.data.Todo
import kotlinx.android.synthetic.main.dialog_todo.view.*
import java.lang.RuntimeException
import java.util.*

class TodoDialog : DialogFragment() {

    interface TodoHandler {
        fun todoCreated(item: Todo)
        fun todoUpdated(item: Todo)
    }

    private lateinit var todoHandler: TodoHandler

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is TodoHandler) {
            todoHandler = context
        } else {
            throw RuntimeException(
                "The activity does not implement the TodoHandlerInterface")
        }
    }

    private lateinit var etTodoDate: EditText
    private lateinit var etTodoText: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("New todo")

        val rootView = requireActivity().layoutInflater.inflate(
            R.layout.dialog_todo, null
        )
        //etTodoDate = rootView.findViewById(R.id.etTodoText)
        etTodoDate = rootView.etTodoDate
        etTodoText = rootView.etTodoText
        builder.setView(rootView)

        val arguments = this.arguments
        if (arguments != null && arguments.containsKey(
                ScrollingActivity.KEY_ITEM_TO_EDIT)) {
            val todoItem = arguments.getSerializable(
                ScrollingActivity.KEY_ITEM_TO_EDIT
            ) as Todo
            etTodoDate.setText(todoItem.createDate)
            etTodoText.setText(todoItem.todoText)

            builder.setTitle("Edit todo")
        } else {
            etTodoDate.visibility = View.GONE
        }

        builder.setPositiveButton("OK") {
                dialog, witch -> // empty
        }

        return builder.create()
    }


    override fun onResume() {
        super.onResume()

        val positiveButton = (dialog as AlertDialog).getButton(Dialog.BUTTON_POSITIVE)
        positiveButton.setOnClickListener {
            if (etTodoText.text.isNotEmpty()) {
                val arguments = this.arguments
                if (arguments != null && arguments.containsKey(ScrollingActivity.KEY_ITEM_TO_EDIT)) {
                    handleTodoEdit()
                } else {
                    handleTodoCreate()
                }

                dialog.dismiss()
            } else {
                etTodoText.error = "This field can not be empty"
            }
        }
    }

    private fun handleTodoCreate() {
        todoHandler.todoCreated(
            Todo(
                null,
                Date(System.currentTimeMillis()).toString(),
                false,
                etTodoText.text.toString()
            )
        )
    }

    private fun handleTodoEdit() {
        val todoToEdit = arguments?.getSerializable(
            ScrollingActivity.KEY_ITEM_TO_EDIT
        ) as Todo
        todoToEdit.createDate = etTodoDate.text.toString()
        todoToEdit.todoText = etTodoText.text.toString()

        todoHandler.todoUpdated(todoToEdit)
    }

}