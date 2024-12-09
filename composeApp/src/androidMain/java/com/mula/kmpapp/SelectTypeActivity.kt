package com.mula.kmpapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class SelectTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_type) // Vincula al XML correspondiente

        // Referencia a los botones
        val sellerButton: MaterialButton = findViewById(R.id.Seller_type)
        val clientButton: MaterialButton = findViewById(R.id.Client_type)

        // Navegar al login de vendedor
        sellerButton.setOnClickListener {
            val intent = Intent(this, LoginSellerActivity::class.java)
            startActivity(intent)
        }

        // Navegar al login de cliente
        clientButton.setOnClickListener {
            val intent = Intent(this, LoginClientActivity::class.java)
            startActivity(intent)
        }
    }
}
