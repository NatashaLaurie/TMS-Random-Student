package com.example.randomstudent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox

class MainActivity : AppCompatActivity() {

    private lateinit var okButton: Button
    var students = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        okButton = findViewById<Button>(R.id.buttonOk)
        okButton.setOnClickListener {

            val studentsArr : ArrayList<String> = ArrayList<String>()
            studentsArr.addAll(students)
            println(studentsArr)
            val intent = GenerateRandomStudentActivity.newIntent(this@MainActivity, studentsArr)
            startActivity(intent)
        }
    }

    fun onCheckboxClicked(view: android.view.View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            if (checked) {
                students.add((view.text).toString())
                /*for (item in students) {
                    println(item)
                }*/
            } else {
                students.remove((view.text).toString())
                /*for (item in students) {
                    println(item)
                }*/
            }
            //println(students.toTypedArray().contentToString())
        }
    }

}
