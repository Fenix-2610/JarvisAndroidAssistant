package com.jarvis.androidassistant.ui

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.myapplication.R
import com.jarvis.androidassistant.command.CommandRouter

class MainActivity : ComponentActivity() {

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

        openWhatsApp()
        CommandRouter.tap(950, 200)

    }

    fun openWhatsApp() {
        val intent = packageManager.getLaunchIntentForPackage("com.whatsapp")
        startActivity(intent)
    }


}