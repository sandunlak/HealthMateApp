package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity_addbodycondition : AppCompatActivity() {
    lateinit var enterweight: EditText
    lateinit var enterheight: EditText
    lateinit var entermedicalhistory: EditText
    lateinit var enterfitnessgoals: EditText
    lateinit var enterdailyactivitylevel: EditText
    lateinit var buttonsubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_addbodycondition)

        enterweight = findViewById(R.id.inputweight)
        enterheight = findViewById(R.id.inputheight)
        entermedicalhistory = findViewById(R.id.inputMedicalHistory)
        enterfitnessgoals = findViewById(R.id.inputFitnessGoals)
        enterdailyactivitylevel = findViewById(R.id.inputDailyActivityLevel)
        buttonsubmit = findViewById(R.id.buttonsubmit)

        // Pre-fill the input fields with existing data from SharedPreferences
        val sharedPref = getSharedPreferences("body_data", MODE_PRIVATE)
        enterweight.setText(sharedPref.getString("weight", ""))
        enterheight.setText(sharedPref.getString("height", ""))
        entermedicalhistory.setText(sharedPref.getString("medicalhistory", ""))
        enterfitnessgoals.setText(sharedPref.getString("fitnessgoals", ""))
        enterdailyactivitylevel.setText(sharedPref.getString("dailyactivitylevel", ""))

        buttonsubmit.setOnClickListener {
            val editor = sharedPref.edit()

            val w = enterweight.text.toString()
            val h = enterheight.text.toString()
            val m = entermedicalhistory.text.toString()
            val f = enterfitnessgoals.text.toString()
            val d = enterdailyactivitylevel.text.toString()

            // Store the updated data
            editor.putString("weight", w)
            editor.putString("height", h)
            editor.putString("medicalhistory", m)
            editor.putString("fitnessgoals", f)
            editor.putString("dailyactivitylevel", d)
            editor.apply()

            Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show()

            // Navigate back to MainActivity_showbodycondition
            val intent = Intent(this, MainActivity_showbodycondition::class.java)
            startActivity(intent)
        }
    }

}
