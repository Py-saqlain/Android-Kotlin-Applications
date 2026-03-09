package com.example.studentlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var studentList: ArrayList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        // Create 50 Students according to the Student model (RollNumber, name, CGPA)
        studentList = ArrayList()

        for (i in 1..50) {
            val randomCGPA = 2.0 + Random.nextDouble() * 2.0 // Random CGPA between 2.0 and 4.0
            studentList.add(
                Student(
                    RollNumber = i,
                    name = "Student $i",
                    CGPA = String.format(Locale.US, "%.2f", randomCGPA).toDouble()
                )
            )
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentAdapter(studentList)
    }
}