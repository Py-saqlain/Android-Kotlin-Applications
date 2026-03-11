package com.example.threadhome_work

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.threadhome_work.R
import java.util.concurrent.Executors

class MainActivity : Activity() {

    private lateinit var statusText: TextView
    private lateinit var startButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusText = findViewById(R.id.statusText)
        startButton = findViewById(R.id.startButton)

        startButton.setOnClickListener {

            statusText.text = "Running 100,000 tasks..."

            // Create thread pool of 10 threads
            val executorService = Executors.newFixedThreadPool(10)

            for (i in 1..100000) {

                // SAM conversion (Runnable is SAM interface)
                executorService.execute {
                    Log.d(
                        "SAM_THREAD",
                        "Task $i running on ${Thread.currentThread().name}"
                    )
                }
            }

            executorService.shutdown()

            statusText.text = "Tasks Submitted!"
        }
    }
}