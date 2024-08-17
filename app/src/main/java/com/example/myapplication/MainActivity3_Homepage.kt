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

class MainActivity3_Homepage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_homepage)
        val imageButtonworkout: ImageButton = findViewById(R.id.imageButton_workout_page)

        imageButtonworkout.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_CheckMF::class.java)
            startActivity(intent)
        }

        val imageButton: ImageButton = findViewById(R.id.imageButton_food)

        imageButton.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_Food_page::class.java)
            startActivity(intent)
        }

        val imageButton_trainer: ImageButton = findViewById(R.id.imageButton_trainer)

        imageButton_trainer.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_per_train1::class.java)
            startActivity(intent)
        }

        val Backtoworkoutbutton_home = findViewById<Button>(R.id.button_homepage_logout)
        Backtoworkoutbutton_home.setOnClickListener {
            val Intent = Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}