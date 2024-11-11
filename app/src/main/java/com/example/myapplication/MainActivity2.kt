package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    lateinit var entername: EditText
    lateinit var enterphone: EditText
    lateinit var enteremail: EditText
    lateinit var enterpw: EditText
    lateinit var submitbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        entername = findViewById(R.id.inputweight)
        enterphone = findViewById(R.id.inputphone)
        enteremail = findViewById(R.id.inputemail)
        enterpw = findViewById(R.id.inputpassword)
        submitbtn = findViewById(R.id.buttonsubmit)

        submitbtn.setOnClickListener {
            val sharedPref = getSharedPreferences("Register data", MODE_PRIVATE)
            val editor = sharedPref.edit()

            val n = entername.text.toString()
            val p = enterphone.text.toString()
            val e = enteremail.text.toString()
            val pw = enterpw.text.toString()

            // Store the data
            editor.putString("name", n)
            editor.putString("phone", p)
            editor.putString("email", e)
            editor.putString("password", pw)
            editor.apply()

            // Debugging: Show a Toast message
            Toast.makeText(this, "Data saved: $n, $p, $e, $pw", Toast.LENGTH_LONG).show()
        }
    }
}
