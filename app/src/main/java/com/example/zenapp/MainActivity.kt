package com.example.zenapp

import android.content.Intent
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val profile: ImageButton = findViewById(R.id.profile)

        profile.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        val motivationpage: ImageButton = findViewById(R.id.motivation_button)

        motivationpage.setOnClickListener {
            val intent = Intent(this, motivationPage::class.java)
            startActivity(intent)
        }

        val yogapage: ImageButton = findViewById(R.id.yoga_button)

        yogapage.setOnClickListener {
            val intent = Intent(this, yogaPage::class.java)
            startActivity(intent)
        }
        val infoButton = findViewById<ImageButton>(R.id.infobutton)
        infoButton.setOnClickListener {
            showPopup()
        }


    }
    private fun showPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_popup, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogView.findViewById<ImageButton>(R.id.closebutton2).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}