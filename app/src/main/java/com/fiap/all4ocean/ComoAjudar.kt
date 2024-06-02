package com.fiap.all4ocean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class ComoAjudar : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.como_ajudar)

        val buttonVoltar = findViewById<Button>(R.id.buttonVoltar)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, Logado::class.java)
            startActivity(intent)
            finish()
        }
    }
}
