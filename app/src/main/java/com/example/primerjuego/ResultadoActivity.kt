package com.example.primerjuego

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class ResultadoActivity : AppCompatActivity() {
    lateinit var animView:LottieAnimationView
    lateinit var btnRegresar:Button
    lateinit var tvRespuestaCorrecta:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        initUi()

        var sonidoCorrecto = MediaPlayer.create(this, R.raw.correctsound)
        var sonidoIncorrecto = MediaPlayer.create(this,R.raw.incorrectsound)

        btnRegresar.setOnClickListener{
            val intentRegresar = Intent(this,ResultadoActivity::class.java)
            startActivity(intentRegresar)
        }

        val extras = intent.extras
        val respuestaCorrecta = extras!!.getBoolean("respuesta")
        if(respuestaCorrecta){
            animView.setAnimation(R.raw.correct)
            sonidoCorrecto.start()
        }else{
            animView.setAnimation(R.raw.incorrect)
            sonidoIncorrecto.start()
        }

        val extras2 = intent.extras
        val numeroCorrecto = extras2!!.getInt("numCorrecto")
        tvRespuestaCorrecta.text = numeroCorrecto.toString()

    }
    fun initUi(){
        animView = findViewById(R.id.animation_view)
        btnRegresar = findViewById(R.id.btnRegresar)
        tvRespuestaCorrecta = findViewById(R.id.tvRespuestaCorrecta)
    }
}