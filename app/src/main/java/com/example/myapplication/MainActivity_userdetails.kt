package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_userdetails : AppCompatActivity() {
    lateinit var resultregister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_userdetails)


        val backbutton2 = findViewById<Button>(R.id.userdetails_back)
        backbutton2.setOnClickListener {
            val Intent = Intent(this,MainActivity3_Homepage::class.java)
            startActivity(Intent)
        }

        resultregister = findViewById(R.id.tvresult)

        val sharedPref = getSharedPreferences("Register data", MODE_PRIVATE)
        val Name = sharedPref.getString("name", null)
        val Phone = sharedPref.getString("phone", null)
        val Email = sharedPref.getString("email", null)
        val Password = sharedPref.getString("password", null)

        // Debugging: Check if the data is retrieved correctly
        if (Name == null || Phone == null || Email == null || Password == null) {
            Toast.makeText(this, "Data not found", Toast.LENGTH_LONG).show()
        } else {
            resultregister.text = "Name: $Name\nPhone: $Phone\nEmail: $Email\nPassword: $Password"
        }
    }
}
