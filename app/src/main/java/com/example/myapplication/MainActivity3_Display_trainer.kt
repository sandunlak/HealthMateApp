package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity3_Display_trainer : AppCompatActivity() {

    private lateinit var textTrainerName: TextView
    private lateinit var btnUpdateTrainer: Button
    private lateinit var btnDeleteTrainer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity3_display_trainer)

        textTrainerName = findViewById(R.id.text_trainer_name)
        btnUpdateTrainer = findViewById(R.id.btn_update_trainer)
        btnDeleteTrainer = findViewById(R.id.btn_delete_trainer)

        // Get the selected trainer name from the previous activity
        val selectedTrainer = intent.getStringExtra("SELECTED_TRAINER")
        textTrainerName.text = selectedTrainer

        btnUpdateTrainer.setOnClickListener {
            // Handle update logic here (e.g., show dialog to update trainer details)
            Toast.makeText(this, "Update Trainer: $selectedTrainer", Toast.LENGTH_SHORT).show()
        }

        btnDeleteTrainer.setOnClickListener {
            // Handle delete logic here (e.g., clear trainer or navigate back)
            textTrainerName.text = ""
            Toast.makeText(this, "Trainer Deleted", Toast.LENGTH_SHORT).show()
        }
    }
}