package com.example.timerapp

import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.MainActivity3_Food_page
import com.example.myapplication.R

class MainActivity_alarm : AppCompatActivity() {

    private lateinit var tvTimer: TextView
    private lateinit var startButton: Button
    private lateinit var minutesInput: EditText
    private lateinit var secondsInput: EditText
    private var alarmRingtone: Ringtone? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main31)

        tvTimer = findViewById(R.id.tv_timer)
        startButton = findViewById(R.id.start_button)
        minutesInput = findViewById(R.id.et_minutes)
        secondsInput = findViewById(R.id.et_seconds)

        // Get the default alarm sound from the device, fall back to notification if not available
        val alarmUri: Uri? = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            ?: RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        // Ensure alarmRingtone is non-null
        alarmRingtone = RingtoneManager.getRingtone(applicationContext, alarmUri)

        startButton.setOnClickListener {
            // Get user input time
            val minutes = minutesInput.text.toString().toLongOrNull() ?: 0L
            val seconds = secondsInput.text.toString().toLongOrNull() ?: 0L
            val totalTimeInMillis = (minutes * 60 + seconds) * 1000

            if (totalTimeInMillis > 0) {
                startTimer(totalTimeInMillis)
            } else {
                Toast.makeText(this, "Please enter a valid time", Toast.LENGTH_SHORT).show()
            }
        }

        // Set up the Back to Workout button
        val backToWorkoutButton = findViewById<Button>(R.id.button_backhome)
        backToWorkoutButton.setOnClickListener {
            // Navigate to MainActivity1 (or MainActivity3_Home_Workout)
            val intent = Intent(this, MainActivity3_Food_page::class.java)
            startActivity(intent)
        }

    }

    private fun startTimer(timeInMillis: Long) {
        val timer = object : CountDownTimer(timeInMillis, 1000) {

            // Called on every tick (every 1 second)
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                tvTimer.text = formatTime(secondsRemaining)
            }

            // Called when the timer finishes
            override fun onFinish() {
                tvTimer.text = "00:00"
                ringAlarm()
                Toast.makeText(this@MainActivity_alarm, "Timer Finished!", Toast.LENGTH_SHORT).show()
            }
        }
        timer.start()
    }

    // Method to ring the alarm when the timer ends
    private fun ringAlarm() {
        alarmRingtone?.let {
            if (!it.isPlaying) {
                it.play()
            }
        }
    }

    // Utility function to format the time into MM:SS format
    private fun formatTime(seconds: Long): String {
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }

    // Ensure the ringtone stops when the activity is destroyed
    override fun onDestroy() {
        alarmRingtone?.let {
            if (it.isPlaying) {
                it.stop()
            }
        }
        super.onDestroy()
    }
}
