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

class MainActivity3_Gym_workout : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_gym_workout)

        val Backtoworkoutbutton = findViewById<Button>(R.id.button_back_female)
        Backtoworkoutbutton.setOnClickListener {
            val Intent = Intent(this,MainActivity3_HomeandGym_workout::class.java)
            startActivity(Intent)
        }
        val imageButton1: ImageButton? = findViewById(R.id.button1)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, MainActivity_timerpage::class.java)
            startActivity(intent)
        }
        val imageButton2: ImageButton? = findViewById(R.id.button2)
        imageButton2?.setOnClickListener {
            val intent = Intent(this, MainActivity_timerpage::class.java)
            startActivity(intent)
        }
        val imageButton3: ImageButton? = findViewById(R.id.button3)
        imageButton3?.setOnClickListener {
            val intent = Intent(this, MainActivity_timerpage::class.java)
            startActivity(intent)
        }
        val imageButton4: ImageButton? = findViewById(R.id.button4)
        imageButton4?.setOnClickListener {
            val intent = Intent(this, MainActivity_timerpage::class.java)
            startActivity(intent)
        }
        val imageButton5: ImageButton? = findViewById(R.id.button5)
        imageButton5?.setOnClickListener {
            val intent = Intent(this, MainActivity_timerpage::class.java)
            startActivity(intent)
        }
        val imageButton6: ImageButton? = findViewById(R.id.button6)
        imageButton6?.setOnClickListener {
            val intent = Intent(this, MainActivity_timerpage::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}