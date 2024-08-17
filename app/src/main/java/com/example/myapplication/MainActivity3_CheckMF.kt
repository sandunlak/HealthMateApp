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

class MainActivity3_CheckMF : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_check_mf)

        val imageButtonmale: ImageButton = findViewById(R.id.imageButton_male)

        imageButtonmale.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_HomeandGym_workout::class.java)
            startActivity(intent)
        }

        val imageButtonfemale: ImageButton = findViewById(R.id.imageButton_female)

        imageButtonfemale.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_Female_Workout::class.java)
            startActivity(intent)
        }

        val backbutton = findViewById<Button>(R.id.button_back_home)
        backbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity3_Homepage::class.java)
            startActivity(Intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}