package com.example.primerjuego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class JuegoActivity : AppCompatActivity() {

    lateinit var etRespuesta:EditText
    lateinit var btnVerificar:Button
    var numAleatorio:Int = 0
    var respuestaCorrecta = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        initUi()

        btnVerificar.setOnClickListener{
            val strRespuesta =etRespuesta.text.toString()
            if(strRespuesta.equals("")){
                Toast.makeText(this,"Dejaste el campo vacío",Toast.LENGTH_LONG).show()
            }else{
                generaNumero()
                respuestaCorrecta = numAleatorio  == strRespuesta.toInt()
                val mostrarResultado = Intent(this,ResultadoActivity::class.java)
                mostrarResultado.putExtra("respuesta",respuestaCorrecta)
                mostrarResultado.putExtra("numCorrecto",numAleatorio)
                startActivity(mostrarResultado)
            }
        }
    }

    fun initUi(){
        etRespuesta = findViewById(R.id.etRespuesta)
        btnVerificar = findViewById(R.id.btnVerificar)
        generaNumero()
    }

    fun generaNumero(){
        numAleatorio = Random.nextInt(1,5)
        etRespuesta.text.clear()
    }
}