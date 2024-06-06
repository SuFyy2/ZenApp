package com.example.zenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import android.widget.ImageButton

class yogaPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga_page)

        val back: ImageButton = findViewById(R.id.backbutton3)

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val infoButton = findViewById<ImageButton>(R.id.infobutton2)
        infoButton.setOnClickListener {
            showPopup()
        }

    }

    private fun showPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.activity_yoga_popup, null)
        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogView.findViewById<ImageButton>(R.id.closebutton1).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


}