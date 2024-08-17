package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3_per_train3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_per_train3)



        val imageButton_trainer3: ImageButton = findViewById(R.id.imageButton3_backto_secondpage)

        imageButton_trainer3.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_per_train2::class.java)
            startActivity(intent)
        }


        val imageButton_trainer3_call: ImageButton = findViewById(R.id.imageButton3_trainer3_call)

        imageButton_trainer3_call.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_trainer3_call::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}