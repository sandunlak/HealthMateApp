package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.timerapp.MainActivity_alarm

class MainActivity3_medic2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_medic2)
        val Backtoworkoutbutton = findViewById<Button>(R.id.button_backhome)
        Backtoworkoutbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity3_Food_page::class.java)
            startActivity(Intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageButton1: ImageButton? = findViewById(R.id.mindful_meditation_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, MainActivity_alarm::class.java)
            startActivity(intent)
        }
    }
}