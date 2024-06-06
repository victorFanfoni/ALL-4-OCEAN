package com.fiap.all4ocean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class DetalheCuriosidadeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curiosidade_detalhe)

        val textoCuriosidade = intent.getStringExtra(getString(R.string.curiosidade_texto))
        val buttonVoltar = findViewById<Button>(R.id.button5)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, ListaCuriosidadesActivity ::class.java)
            startActivity(intent)
            finish()
        }

        val textViewDetalhe = findViewById<TextView>(R.id.textViewDetalhe)
        textViewDetalhe.text = textoCuriosidade
    }
}