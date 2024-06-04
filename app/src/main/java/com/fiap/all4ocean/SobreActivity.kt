package com.fiap.all4ocean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class SobreActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sobre)

        val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)
        val textViewProjeto = findViewById<TextView>(R.id.textViewProjeto)
        val textViewEconomiaAzul = findViewById<TextView>(R.id.textViewEconomiaAzul)

        val projetoInfo = getString(R.string.projeto_info)

        val economiaAzulInfo = getString(R.string.economia_azul_info)

        textViewProjeto.text = projetoInfo
        textViewEconomiaAzul.text = economiaAzulInfo

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, UsuarioLogado::class.java)
            startActivity(intent)
            finish()
        }
    }
}
