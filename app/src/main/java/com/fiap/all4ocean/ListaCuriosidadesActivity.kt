package com.fiap.all4ocean

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaCuriosidadesActivity : ComponentActivity() {

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.curiosidades)

        val buttonVoltar = findViewById<Button>(R.id.button4)
        val listaCuriosidades = findViewById<RecyclerView>(R.id.List)

        val curiosidades = listOf(
            getString(R.string.curiosidade_1),
            getString(R.string.curiosidade_2),
            getString(R.string.curiosidade_3),
            getString(R.string.curiosidade_4),
            getString(R.string.curiosidade_5),
            getString(R.string.curiosidade_6),
            getString(R.string.curiosidade_7),
            getString(R.string.curiosidade_8),
            getString(R.string.curiosidade_9),
            getString(R.string.curiosidade_10),
            getString(R.string.curiosidade_11),
            getString(R.string.curiosidade_12),
            getString(R.string.curiosidade_13),
            getString(R.string.curiosidade_14),
            getString(R.string.curiosidade_15),
            getString(R.string.curiosidade_16),
            getString(R.string.curiosidade_17),
            getString(R.string.curiosidade_18),
            getString(R.string.curiosidade_19),
            getString(R.string.curiosidade_20),
            getString(R.string.curiosidade_21),
            getString(R.string.curiosidade_22),
            getString(R.string.curiosidade_23),
            getString(R.string.curiosidade_24),
            getString(R.string.curiosidade_25)
        )

        val detalhesCuriosidades = listOf(
            getString(R.string.detalhe_curiosidade_1),
            getString(R.string.detalhe_curiosidade_2),
            getString(R.string.detalhe_curiosidade_3),
            getString(R.string.detalhe_curiosidade_4),
            getString(R.string.detalhe_curiosidade_5),
            getString(R.string.detalhe_curiosidade_6),
            getString(R.string.detalhe_curiosidade_7),
            getString(R.string.detalhe_curiosidade_8),
            getString(R.string.detalhe_curiosidade_9),
            getString(R.string.detalhe_curiosidade_10),
            getString(R.string.detalhe_curiosidade_11),
            getString(R.string.detalhe_curiosidade_12),
            getString(R.string.detalhe_curiosidade_13),
            getString(R.string.detalhe_curiosidade_14),
            getString(R.string.detalhe_curiosidade_15),
            getString(R.string.detalhe_curiosidade_16),
            getString(R.string.detalhe_curiosidade_17),
            getString(R.string.detalhe_curiosidade_18),
            getString(R.string.detalhe_curiosidade_19),
            getString(R.string.detalhe_curiosidade_20),
            getString(R.string.detalhe_curiosidade_21),
            getString(R.string.detalhe_curiosidade_22),
            getString(R.string.detalhe_curiosidade_23),
            getString(R.string.detalhe_curiosidade_24),
            getString(R.string.detalhe_curiosidade_25)
        )

        listaCuriosidades.layoutManager = LinearLayoutManager(this)
        listaCuriosidades.adapter = CuriosidadeAdapter(this, curiosidades, detalhesCuriosidades)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, UsuarioLogado::class.java)
            startActivity(intent)
            finish()
        }
    }
}
