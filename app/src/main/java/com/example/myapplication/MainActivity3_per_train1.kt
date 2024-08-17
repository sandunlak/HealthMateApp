package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3_per_train1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_per_train1)


        val imageButton_back: ImageButton = findViewById(R.id.imageButton4_backtohome)

        imageButton_back.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_Homepage::class.java)
            startActivity(intent)
        }


        val imageButton_call: ImageButton = findViewById(R.id.imageButton_trainer1)

        imageButton_call.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_trainer1_call::class.java)
            startActivity(intent)
        }


        val imageButton_secondpage: ImageButton = findViewById(R.id.imageButton_to_Secondpage)

        imageButton_secondpage.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_per_train2::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}