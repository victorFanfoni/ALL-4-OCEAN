package com.fiap.all4ocean

import android.annotation.SuppressLint
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        auth = FirebaseAuth.getInstance()

        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.senha)
        val loginButton = findViewById<Button>(R.id.ButtonEntrar)
        val registerButton = findViewById<Button>(R.id.ButtonCadastro)
        val resetPasswordTextView = findViewById<TextView>(R.id.redefinirSenha)

        registerButton.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, R.string.preencha_todos_os_campos, Toast.LENGTH_LONG).show()
            }
            else if (!email.contains("@")){
                Toast.makeText(this, R.string.email_invalido, Toast.LENGTH_LONG).show()
            }else{
                signInWithEmailAndPassword(email, password)
            }
        }

        resetPasswordTextView.setOnClickListener {
            val intent = Intent(this, ResetarSenhaActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as? ConnectivityManager
        return connectivityManager?.activeNetworkInfo?.isConnected?: false
    }

    companion object {
        private const val TAG = "EmailAndPassword"
    }

    private fun signInWithEmailAndPassword(email: String, password: String) {
        if (!isNetworkAvailable()) {
            Toast.makeText(this, getString(R.string.email_ou_senha_invalidos), Toast.LENGTH_SHORT).show()
            return
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    startActivity(Intent(this, AtualizarCadastro::class.java))
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.email_ou_senha_invalidos),
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }
}
