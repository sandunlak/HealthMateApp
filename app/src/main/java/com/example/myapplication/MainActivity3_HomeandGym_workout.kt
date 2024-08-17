package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3_HomeandGym_workout : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_homeand_gym_workout)

        val imageButton_gym: ImageButton = findViewById(R.id.imageButton_gymworkout)

        imageButton_gym.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_Gym_workout::class.java)
            startActivity(intent)
        }
        val imageButton_home: ImageButton = findViewById(R.id.imageButton_Homeworkout)

        imageButton_home.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_Home_Workout::class.java)
            startActivity(intent)
        }
        val Homeworkout_back_button = findViewById<Button>(R.id.button_workout)
        Homeworkout_back_button.setOnClickListener {
            val Intent = Intent(this,MainActivity3_CheckMF::class.java)
            startActivity(Intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}