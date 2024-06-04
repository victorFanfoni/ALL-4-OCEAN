package com.fiap.all4ocean

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity

class ComoAjudarActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.como_ajudar)

        val home = findViewById<ImageView>(R.id.home)
        val atualizarCadastro = findViewById<ImageView>(R.id.imageView5)

        home.setOnClickListener{
            val intent = Intent(this, UsuarioLogado::class.java)
            startActivity(intent)
            finish()
        }

        atualizarCadastro.setOnClickListener{
            val intent = Intent(this, AtualizarCadastro::class.java)
            startActivity(intent)
            finish()
        }
    }
}
