package com.example.zenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.app.AlertDialog
import android.content.Intent
import android.content.Context
import android.content.SharedPreferences

class loginPage : AppCompatActivity() {

    private lateinit var nameField: EditText
    private lateinit var mailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var signInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        nameField = findViewById(R.id.name_field)
        mailField = findViewById(R.id.mail_field)
        passwordField = findViewById(R.id.password_field)
        signInButton = findViewById(R.id.signinbutton)

        signInButton.setOnClickListener {
            val name = nameField.text.toString()
            val email = mailField.text.toString()
            val password = passwordField.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {

                showAlert("Empty field")
            } else {
                saveUserData(name, email)

                // Optionally, show a toast or alert confirming data saved
                showAlert("Login successful")

                // Clear input fields if needed
                nameField.text.clear()
                mailField.text.clear()
                passwordField.text.clear()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun saveUserData(name: String, email: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("NAME", name)
        editor.putString("EMAIL", email)
        editor.apply()
    }

    private fun showAlert(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)
        val dialog = builder.create()
        dialog.show()
    }
}