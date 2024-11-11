package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity3_select_trainer : AppCompatActivity() {

    private lateinit var checkBoxTrainer1: CheckBox
    private lateinit var checkBoxTrainer2: CheckBox
    private lateinit var checkBoxTrainer3: CheckBox
    private lateinit var checkBoxTrainer4: CheckBox
    private lateinit var checkBoxTrainer5: CheckBox
    private lateinit var checkBoxTrainer6: CheckBox
    private lateinit var btnSubmitTrainer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity3_select_trainer)

        checkBoxTrainer1 = findViewById(R.id.checkbox_trainer1)
        checkBoxTrainer2 = findViewById(R.id.checkbox_trainer2)
        checkBoxTrainer3 = findViewById(R.id.checkbox_trainer3)
        checkBoxTrainer4 = findViewById(R.id.checkbox_trainer4)
        checkBoxTrainer5 = findViewById(R.id.checkbox_trainer5)
        checkBoxTrainer6 = findViewById(R.id.checkbox_trainer6)
        btnSubmitTrainer = findViewById(R.id.btn_submit_trainer)

        btnSubmitTrainer.setOnClickListener {
            val selectedTrainer = when {
                checkBoxTrainer1.isChecked -> "Trainer 1"
                checkBoxTrainer2.isChecked -> "Trainer 2"
                checkBoxTrainer3.isChecked -> "Trainer 3"
                checkBoxTrainer4.isChecked -> "Trainer 4"
                checkBoxTrainer5.isChecked -> "Trainer 5"
                checkBoxTrainer6.isChecked -> "Trainer 6"
                else -> null
            }

            if (selectedTrainer != null) {
                val intent = Intent(this, MainActivity3_Display_trainer::class.java)
                intent.putExtra("SELECTED_TRAINER", selectedTrainer)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a trainer", Toast.LENGTH_SHORT).show()
            }
        }
    }
}