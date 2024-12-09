package com.mula.kmpapp.client

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.mula.kmpapp.databinding.ActivityLoginClientBinding

class LoginClientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginClientBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    private var email: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginClientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)

        // Botón de login
        binding.btnLoginC.setOnClickListener {
            validateData()
        }

        // Botón para registro
        binding.tvRegisterC.setOnClickListener {
            startActivity(Intent(this@LoginClientActivity, RegistrationClientActivity::class.java))
        }
    }

    private fun validateData() {
        email = binding.etEmailC.text.toString().trim()
        password = binding.etPasswordC.text.toString().trim()

        if (email.isEmpty()) {
            binding.etEmailC.error = "Please enter your email"
            binding.etEmailC.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmailC.error = "Invalid email format"
            binding.etEmailC.requestFocus()
        } else if (password.isEmpty()) {
            binding.etPasswordC.error = "Please enter your password"
            binding.etPasswordC.requestFocus()
        } else {
            loginClient()
        }
    }

    private fun loginClient() {
        progressDialog.setMessage("Logging in...")
        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivityClient::class.java))
                finishAffinity()
            }
            .addOnFailureListener { e ->
                progressDialog.dismiss()
                Toast.makeText(this, "Login failed: ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
