package com.fiap.all4ocean

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Cadastrar : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)

        auth = Firebase.auth

        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password= findViewById<EditText>(R.id.editTextTextPassword)
        val confirmPassword = findViewById<EditText>(R.id.editTextTextPassword2)
        val registerButton = findViewById<Button>(R.id.button)
        val backButton = findViewById<Button>(R.id.buttonVoltar)

        backButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

        registerButton.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()
            val confirmPassword = confirmPassword.text.toString()

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
               Toast.makeText(this, "Preencha todos os campos!!", Toast.LENGTH_LONG).show()
            }
            else if (!email.contains("@")){
                showAlert("Email invalido!!", "Email exemplo: usuario@gmail.com")
                Toast.makeText(this,"Email invalido!", Toast.LENGTH_SHORT).show()
            }
            else if (password != confirmPassword){
                Toast.makeText(this, "As senhas devem ser identicas!!", Toast.LENGTH_SHORT).show()
            }
            else if (password.length <= 5){
                Toast.makeText(this, "A senha deve ter pelomenos 6 caracteres", Toast.LENGTH_SHORT).show()
            }
            else {
                createAccount(email, password)
            }
        }
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("Ok") { dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }

    companion object {
        private const val TAG = "EmailAndPassword"
    }
    fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val user = com.google.firebase.ktx.Firebase.auth.currentUser
                user!!.sendEmailVerification()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            println("Email sent.")
                        }
                    }
                Toast.makeText(this, " Cadastro Realizado com Sucesso", Toast.LENGTH_LONG).show()
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Usuario ja cadastrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}