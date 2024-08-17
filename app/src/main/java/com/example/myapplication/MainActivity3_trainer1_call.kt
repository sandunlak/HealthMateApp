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

class MainActivity3_trainer1_call : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_trainer1_call)

        val Buttonback = findViewById<Button>(R.id.button_backto_trainer1)
        Buttonback.setOnClickListener {
            val Intent = Intent(this,MainActivity3_per_train1::class.java)
            startActivity(Intent)
        }

        val imageButtoncall: ImageButton = findViewById(R.id.imageButton_call_trainer1)

        imageButtoncall.setOnClickListener {
            // Navigate to SecondActivity when the button is pressed
            val intent = Intent(this,MainActivity3_call1::class.java)
            startActivity(intent)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}