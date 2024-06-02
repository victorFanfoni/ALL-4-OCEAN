package com.fiap.all4ocean

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

class Logado : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logado)

        database = Firebase.database.reference
        auth = Firebase.auth

        val buttonSair = findViewById<TextView>(R.id.textView)
        val buttonCuriosidades = findViewById<Button>(R.id.Curiosidades)
        val buttonSobre = findViewById<Button>(R.id.Sobre)
        val buttonComoAjudar = findViewById<Button>(R.id.ComoAjudar)
        val home = findViewById<ImageView>(R.id.home)
        val ham = findViewById<ImageView>(R.id.imageView5)
        val nameUserTextView = findViewById<TextView>(R.id.textView4)

        val userID = auth.currentUser?.uid
        if (userID != null) {
            getDataUser(userID) { user ->
                nameUserTextView.text = user?.nome ?: "Usuário"
            }
        }

        home.setOnClickListener{
            val intent = Intent(this, Logado::class.java)
            startActivity(intent)
            finish()
        }

        ham.setOnClickListener {
            val intent = Intent(this, AtualizarCadastro::class.java)
            startActivity(intent)
            finish()
        }

        buttonSair.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

        buttonComoAjudar.setOnClickListener {
            val intent = Intent(this, ComoAjudar::class.java)
            startActivity(intent)
        }

        buttonCuriosidades.setOnClickListener {
            val intent = Intent(this, Curiosidades::class.java)
            startActivity(intent)
        }

        buttonSobre.setOnClickListener {
            val intent = Intent(this, Sobre::class.java)
            startActivity(intent)
        }
    }

    private fun getDataUser(userID: String, callback: (User?) -> Unit) {
        database.child("users").child(userID).get().addOnSuccessListener {
            val user = it.getValue(User::class.java)
            callback(user)
        }.addOnFailureListener {
            callback(null)
        }
    }
}
