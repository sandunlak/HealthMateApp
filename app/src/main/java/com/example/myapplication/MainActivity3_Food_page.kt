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

class MainActivity3_Food_page : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_food_page)

        val imageButtonbreakfest: ImageButton = findViewById(R.id.imageButton1_medic)

        imageButtonbreakfest.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_medic1::class.java)
            startActivity(intent)
        }

        val imageButtonluanch: ImageButton = findViewById(R.id.imageButton2_medic)

        imageButtonluanch.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_medic2::class.java)
            startActivity(intent)
        }
        val imageButtondinner: ImageButton = findViewById(R.id.imageButton3_medic)

        imageButtondinner.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_medic3::class.java)
            startActivity(intent)
        }
        val imageButtondinner1: ImageButton = findViewById(R.id.imageButton4)

        imageButtondinner1.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_medic4::class.java)
            startActivity(intent)
        }

        val imageButtondinner2: ImageButton = findViewById(R.id.imageButton5)

        imageButtondinner2.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_medic5::class.java)
            startActivity(intent)
        }
        val imageButtondinner3: ImageButton = findViewById(R.id.imageButton6)

        imageButtondinner3.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_medic6::class.java)
            startActivity(intent)
        }





        val Backtoworkoutbutton = findViewById<Button>(R.id.button_backhome)
        Backtoworkoutbutton.setOnClickListener {
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