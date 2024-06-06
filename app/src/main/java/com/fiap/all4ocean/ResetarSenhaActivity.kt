package com.fiap.all4ocean

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthException

class ResetarSenhaActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_password_activity)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.EmailAddress)
        val resetButton = findViewById<Button>(R.id.button2)
        val backButton = findViewById<Button>(R.id.button3)

        backButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        resetButton.setOnClickListener {
            val emailAddress = emailEditText.text.toString().trim()

            if (emailAddress.isEmpty()) {
                Toast.makeText(this, getString(R.string.please_enter_your_email_address), Toast.LENGTH_SHORT).show()
            } else {
                auth.sendPasswordResetEmail(emailAddress)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "Email sent.")
                            Toast.makeText(this, getString(R.string.reset_email_sent), Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, UsuarioLogado::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val exception = task.exception
                            val errorMessage = when (exception) {
                                is FirebaseAuthInvalidUserException -> getString(R.string.error_invalid_user)
                                is FirebaseAuthInvalidCredentialsException -> getString(R.string.error_invalid_credentials)
                                is FirebaseAuthUserCollisionException -> getString(R.string.error_user_collision)
                                else -> getString(R.string.failed_to_send_reset_email)
                            }
                            Log.e(TAG, errorMessage, exception)
                            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    companion object {
        private const val TAG = "EmailAndPassword"
    }
}
