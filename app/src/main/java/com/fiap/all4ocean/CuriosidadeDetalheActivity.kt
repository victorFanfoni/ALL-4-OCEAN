package com.fiap.all4ocean

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class CuriosidadeDetalheActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curiosidade_detalhe)

        val textoCuriosidade = intent.getStringExtra("curiosidade_texto")

        val textViewDetalhe = findViewById<TextView>(R.id.textViewDetalhe)
        textViewDetalhe.text = textoCuriosidade
    }
}
