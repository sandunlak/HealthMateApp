package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.timerapp.MainActivity_alarm
import com.google.android.material.navigation.NavigationView

class MainActivity3_Homepage : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_activity3_homepage)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener(this)

        // Setup image button actions
        val imageButtonWorkout: ImageButton = findViewById(R.id.imageButton_workout_page)
        imageButtonWorkout.setOnClickListener {
            val intent = Intent(this, MainActivity3_CheckMF::class.java)
            startActivity(intent)
        }

        val imageButtonFood: ImageButton = findViewById(R.id.imageButton_food)
        imageButtonFood.setOnClickListener {
            val intent = Intent(this, MainActivity3_Food_page::class.java)
            startActivity(intent)
        }

        val imageButtonTrainer: ImageButton = findViewById(R.id.imageButton_trainer)
        imageButtonTrainer.setOnClickListener {
            val intent = Intent(this, MainActivity3_select_trainer::class.java)
            startActivity(intent)
        }


        val logoutButton = findViewById<Button>(R.id.button_homepage_logout)
        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)
        }


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_userdetails -> {
                val intent = Intent(this, MainActivity_userdetails::class.java)
                startActivity(intent)
            }
            R.id.nav_home -> {
                val intent = Intent(this, MainActivity3_Homepage::class.java)
                startActivity(intent)
            }
            R.id.nav_workout -> {
                val intent = Intent(this, MainActivity3_CheckMF::class.java)
                startActivity(intent)
            }
            R.id.nav_food -> {
                val intent = Intent(this, MainActivity_alarm::class.java)
                startActivity(intent)
            }
            R.id.nav_trainer -> {
                val intent = Intent(this, MainActivity3_CheckMF::class.java)
                startActivity(intent)
            }
            R.id.nav_adddetails -> {
                val intent = Intent(this, MainActivity_addbodycondition::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
