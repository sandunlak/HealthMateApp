package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3_Enter_veri_code : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_enter_veri_code)


        val button_resondcode = findViewById<Button>(R.id.button_Resend_code)
        button_resondcode.setOnClickListener {
            val Intent = Intent(this,MainActivity_Forget_password::class.java)
            startActivity(Intent)
        }


        val button_vrei = findViewById<Button>(R.id.button_Enter_vericode_confirm)
        button_vrei.setOnClickListener {
            val Intent = Intent(this,MainActivity3_Enter_New_PW::class.java)
            startActivity(Intent)
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}