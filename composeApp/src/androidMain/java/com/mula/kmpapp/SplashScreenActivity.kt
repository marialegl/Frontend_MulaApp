package com.mula.kmpapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen) // Vincular al diseño del splash

        // Referencia al botón
        val btnContinue: MaterialButton = findViewById(R.id.btnAddProduct)

        // Configurar el listener del botón
        btnContinue.setOnClickListener {
            // Navegar a la actividad de selección de tipo de usuario
            val intent = Intent(this, SelectTypeActivity::class.java)
            startActivity(intent)
            // Opcional: Finalizar esta actividad para que no pueda regresar con "Atrás"
            finish()
        }
    }
}