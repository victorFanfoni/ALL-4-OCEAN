package com.fiap.all4ocean

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

class AtualizarCadastro : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId", "RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.atulizarcadastro)

        database = Firebase.database.reference
        auth = Firebase.auth

        val nomeEditText = findViewById<EditText>(R.id.nome)
        val telefoneEditText = findViewById<EditText>(R.id.Telefone)
        val home = findViewById<ImageView>(R.id.home)
        val buttonSalvar = findViewById<Button>(R.id.buttonSalvar)

        buttonSalvar.setOnClickListener {
            val nome = nomeEditText.text.toString()
            val telefone = telefoneEditText.text.toString()

            if (nome.isEmpty() || telefone.isEmpty()) {
                Toast.makeText(this, R.string.preencha_todos_os_campos, Toast.LENGTH_LONG).show()
            } else {
                updateDataUser(nome, telefone)
                val intent = Intent(this, UsuarioLogado::class.java)
                intent.putExtra("nome", nome)
                startActivity(intent)
                finish()
            }
        }

        home.setOnClickListener {
            val intent = Intent(this, UsuarioLogado::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun updateDataUser(nome: String, telefone: String) {
        val user = User(nome, telefone)
        val userID = auth.currentUser?.uid
        if (userID != null) {
            database.child("users").child(userID).setValue(user)
        }
    }
}