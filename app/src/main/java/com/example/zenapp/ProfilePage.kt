package com.example.zenapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView


class ProfilePage : AppCompatActivity() {

    private lateinit var profileNameTextView: TextView
    private lateinit var profileMailTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        profileNameTextView = findViewById(R.id.profile_name)
        profileMailTextView = findViewById(R.id.profile_mail)

        val sharedPreferences: SharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("NAME", "")
        val email = sharedPreferences.getString("EMAIL", "")
        val back: ImageButton = findViewById(R.id.backbutton)

        profileNameTextView.text = name
        profileMailTextView.text = email

        val logoutButton: Button = findViewById(R.id.signinbutton)
        logoutButton.setOnClickListener {
            // Clear the user data from SharedPreferences
            clearUserData()

            // Start the app from the splash screen
            val intent = Intent(this, SplashScreen::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
    private fun clearUserData() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}