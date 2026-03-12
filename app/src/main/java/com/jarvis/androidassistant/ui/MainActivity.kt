package com.jarvis.androidassistant.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.jarvis.androidassistant.command.CommandRouter

class MainActivity : ComponentActivity() {

    fun openWhatsApp() {

        try {

            val launchIntent = packageManager.getLaunchIntentForPackage("com.whatsapp")

            if (launchIntent != null) {
                startActivity(launchIntent)
            } else {
                Toast.makeText(
                    this,
                    "WhatsApp not installed",
                    Toast.LENGTH_LONG
                ).show()
            }

        } catch (e: Exception) {

            Toast.makeText(
                this,
                "Error opening WhatsApp",
                Toast.LENGTH_LONG
            ).show()

            e.printStackTrace()
        }
    }

    fun openInstagram() {
        try {
            val launchIntent = packageManager.getLaunchIntentForPackage("com.instagram.android")

            if (launchIntent != null) {
                startActivity(launchIntent)
            } else {
                Toast.makeText(this, "Instagram not installed", Toast.LENGTH_LONG).show()
            }

        } catch (e: Exception) {
            Toast.makeText(this, "Error opening Instagram", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeButton = findViewById<Button>(R.id.homeButton)
        val backButton = findViewById<Button>(R.id.backButton)
        val recentsButton = findViewById<Button>(R.id.recentsButton)
        val tapButton = findViewById<Button>(R.id.tapButton)
        val clickSend = findViewById<Button>(R.id.clickSend)

        homeButton.setOnClickListener {
            CommandRouter.goHome()
        }

        backButton.setOnClickListener {
            CommandRouter.goBack()
        }

        recentsButton.setOnClickListener {
            CommandRouter.openRecents()
        }

        tapButton.setOnClickListener {
            CommandRouter.tap(500, 1000)
        }

        clickSend.setOnClickListener {
            CommandRouter.clickText("Send")
        }

        val openWhatsApp = findViewById<Button>(R.id.openWhatsApp)

        openWhatsApp.setOnClickListener {
            sendWhatsAppMessage("9884545935", "Hello")
        }

        Handler(Looper.getMainLooper()).postDelayed({

            CommandRouter.tap(950, 200)

        }, 2000)
    }

    fun sendWhatsAppMessage(contact: String, message: String) {

        openWhatsApp()

        Handler(Looper.getMainLooper()).postDelayed({
            CommandRouter.tap(950, 200)   // tap search icon
        }, 2000)

        Handler(Looper.getMainLooper()).postDelayed({
            CommandRouter.inputText(contact)  // type contact name
        }, 3000)

        Handler(Looper.getMainLooper()).postDelayed({
            CommandRouter.tap(500, 400)   // tap first search result
        }, 4500)

        Handler(Looper.getMainLooper()).postDelayed({
            CommandRouter.inputText(message) // type message
        }, 6000)

        Handler(Looper.getMainLooper()).postDelayed({
            CommandRouter.clickText("Send") // click send button
        }, 7500)
    }
}