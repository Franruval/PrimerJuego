package com.example.primerjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btnContinuar:Button

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContinuar = findViewById(R.id.btnContinuar)
        btnContinuar.setOnClickListener{
            val intentContinuar = Intent(this,JuegoActivity::class.java)
            startActivity(intentContinuar)

        }
    }
}