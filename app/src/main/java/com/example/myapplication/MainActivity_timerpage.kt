package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity_timerpage : AppCompatActivity() {

    private lateinit var stopwatch: Chronometer
    private lateinit var startButton: Button
    private lateinit var pauseButton: Button
    private lateinit var resetButton: Button

    private var isRunning = false
    private var pauseOffset: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_timerpage)

        // Setting up the view elements
        stopwatch = findViewById(R.id.stopwatch)
        startButton = findViewById(R.id.startButton)
        pauseButton = findViewById(R.id.pauseButton)
        resetButton = findViewById(R.id.resetButton)

        startButton.setOnClickListener {
            if (!isRunning) {
                startStopwatch()
            }
        }

        pauseButton.setOnClickListener {
            if (isRunning) {
                pauseStopwatch()
            }
        }

        resetButton.setOnClickListener {
            resetStopwatch()
        }

        // Back button to go to MainActivity3_Home_Workout
        val backToWorkoutButton = findViewById<Button>(R.id.button_backhome)
        backToWorkoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity3_Home_Workout::class.java)
            startActivity(intent)
        }
    }

    private fun startStopwatch() {
        stopwatch.base = SystemClock.elapsedRealtime() - pauseOffset
        stopwatch.start()
        isRunning = true
    }

    private fun pauseStopwatch() {
        stopwatch.stop()
        pauseOffset = SystemClock.elapsedRealtime() - stopwatch.base
        isRunning = false
    }

    private fun resetStopwatch() {
        stopwatch.base = SystemClock.elapsedRealtime()
        pauseOffset = 0
        if (isRunning) {
            stopwatch.start()
        } else {
            stopwatch.stop()
        }
    }
}
