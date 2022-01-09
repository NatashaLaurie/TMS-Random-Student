package com.example.randomstudent

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

private const val EXTRA_STUDENTS_ARRAYLIST =
    "com.example.randomstudent.EXTRA_STUDENTS_ARRAYLIST"

class GenerateRandomStudentActivity : AppCompatActivity() {

    private var students = ArrayList<String>()

    private lateinit var generateButton: Button
    private lateinit var backButton: Button
    private lateinit var studentTextView: TextView
    private lateinit var pic: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_random_student)

        students = intent.getStringArrayListExtra(EXTRA_STUDENTS_ARRAYLIST) as ArrayList<String>
        println(students)

        generateButton = findViewById(R.id.buttonGenerate)
        studentTextView = findViewById(R.id.textViewRandomStudent)
        pic = findViewById(R.id.imageView)

        generateButton.setOnClickListener {
            if (students.isNotEmpty()) {
                val randomStudent = students.shuffled().first()
                println(randomStudent)
                studentTextView.text = randomStudent
                val mDrawableName = randomStudent.lowercase()
                val resID: Int = pic.context.resources
                    .getIdentifier(mDrawableName, "drawable", pic.context.packageName)
                pic.setImageResource(resID)
            }
        }

        backButton = findViewById(R.id.button2)
        backButton.setOnClickListener {
            this.finish()
        }

    }

    companion object {
        fun newIntent(packageContext: Context, students: ArrayList<String>): Intent {
            return Intent(packageContext, GenerateRandomStudentActivity::class.java).apply {
                putExtra(EXTRA_STUDENTS_ARRAYLIST, students)
            }
        }
    }

}
