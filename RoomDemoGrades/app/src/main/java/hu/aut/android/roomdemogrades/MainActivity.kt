package hu.aut.android.roomdemogrades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hu.aut.android.roomdemogrades.data.AppDatabase
import hu.aut.android.roomdemogrades.data.Grade
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsert.setOnClickListener {
            Thread {
                val newGrade1 = Grade(null, "Thanos", "C")
                val newGrade2 = Grade(null, "Iron man", "B-")
                AppDatabase.getInstance(this@MainActivity).gradeDao().insertGrades(
                    newGrade1, newGrade2
                )
            }.start()
        }

        btnQuery.setOnClickListener {
            Thread{
                val allGrades =
                    AppDatabase.getInstance(this@MainActivity).gradeDao().
                        getAllGrades()

                runOnUiThread {
                    // for loop.. print grades
                    tvData.text = ""
                    for (grade in allGrades) {
                        tvData.append("${grade.studentName} - ${grade.grade}\n")
                    }
                }
            }.start()
        }
    }
}
