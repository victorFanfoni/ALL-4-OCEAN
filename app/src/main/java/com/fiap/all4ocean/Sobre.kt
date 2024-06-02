package com.fiap.all4ocean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class Sobre : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sobre)

        val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)
        val textViewProjeto = findViewById<TextView>(R.id.textViewProjeto)
        val textViewEconomiaAzul = findViewById<TextView>(R.id.textViewEconomiaAzul)

        // Preencher informações sobre o projeto
        val projetoInfo = "Projeto: All4Ocean\n\n" +
                "All4Ocean é um aplicativo desenvolvido para conscientização e proteção dos oceanos. " +
                "Nosso objetivo é educar as pessoas sobre a importância dos oceanos e incentivar ações " +
                "para preservar o meio ambiente marinho."

        // Preencher informações sobre a Economia Azul
        val economiaAzulInfo = "Economia Azul:\n\n" +
                "A Economia Azul se refere a todas as atividades econômicas relacionadas aos " +
                "oceanos e mares. Inclui setores como pesca, turismo, transporte marítimo, " +
                "energia renovável oceânica, entre outros."

        textViewProjeto.text = projetoInfo
        textViewEconomiaAzul.text = economiaAzulInfo

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, Logado::class.java)
            startActivity(intent)
            finish()
        }
    }
}
