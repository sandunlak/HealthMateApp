package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_showbodycondition : AppCompatActivity() {
    lateinit var resultregister: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_showbodycondition)

        val backbutton1 = findViewById<Button>(R.id.showbody_back)
        val editbutton = findViewById<Button>(R.id.edit_button)
        val deletebutton = findViewById<Button>(R.id.delete_button)

        backbutton1.setOnClickListener {
            val intent = Intent(this, MainActivity3_Homepage::class.java)
            startActivity(intent)
        }

        resultregister = findViewById(R.id.tvresult2)

        val sharedPref = getSharedPreferences("body_data", MODE_PRIVATE)
        val Weight = sharedPref.getString("weight", null)
        val Height = sharedPref.getString("height", null)
        val Medicalhistory = sharedPref.getString("medicalhistory", null)
        val Fitnessgoals = sharedPref.getString("fitnessgoals", null)
        val Dailyactivitylevel = sharedPref.getString("dailyactivitylevel", null)

        if (Weight == null || Height == null || Medicalhistory == null || Fitnessgoals == null || Dailyactivitylevel == null) {
            Toast.makeText(this, "Data not found", Toast.LENGTH_LONG).show()
        } else {
            resultregister.text = "Weight: $Weight\nHeight: $Height\nMedicalhistory: $Medicalhistory\nFitnessgoals: $Fitnessgoals\nDailyactivitylevel: $Dailyactivitylevel"
        }

        // Handle the Edit button
        editbutton.setOnClickListener {
            val intent = Intent(this, MainActivity_addbodycondition::class.java)
            startActivity(intent)
        }

        // Handle the Delete button
        deletebutton.setOnClickListener {
            val editor = sharedPref.edit()
            editor.clear() // Remove all saved body condition data
            editor.apply()

            Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_SHORT).show()
            resultregister.text = "" // Clear the displayed data

            // Optionally, you can redirect back to the homepage
            val intent = Intent(this, MainActivity3_Homepage::class.java)
            startActivity(intent)
        }
    }
}

