package com.fiap.all4ocean

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Curiosidades : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.curiosidades)

        val buttonVoltar = findViewById<Button>(R.id.button4)
        val listaCuriosidades = findViewById<RecyclerView>(R.id.List)

        // 25 Curiosidades sobre o oceano
        val curiosidades = listOf(
            Curiosidade("1. O SOL DÁ AO OCEANO SUA TONALIDADE AZUL"),
            Curiosidade("2. OS OCEANOS MANTÊM A INTERNET ONLINE"),
            Curiosidade("3. A PARTE MAIS PROFUNDA DO OCEANO É MUITO, MUITO PROFUNDA"),
            Curiosidade("4. OS SONS PODEM VIAJAR PARA AS ÁREAS MAIS PROFUNDAS DO OCEANO"),
            Curiosidade("5. EXISTEM LAGOS E RIOS ABAIXO DA SUPERFÍCIE DO OCEANO"),
            Curiosidade("6. EXISTEM 20 MILHÕES DE TONELADAS DE OURO INTOCÁVEL NO OCEANO"),
            Curiosidade("7. SABEMOS MAIS SOBRE O OCEANO DO QUE VOCÊ IMAGINA"),
            Curiosidade("8. A MAIOR CACHOEIRA DA TERRA ESTÁ NO OCEANO ATLÂNTICO"),
            Curiosidade("9. SABEMOS MUITO POUCO SOBRE A MAIOR PARTE DA VIDA MARINHA DO OCEANO"),
            Curiosidade("10. FERDINAND MAGELLAN DEU NOME AO OCEANO PACÍFICO"),
            Curiosidade("11. O LUGAR MAIS REMOTO DA TERRA É O SUL DO PACÍFICO"),
            Curiosidade("12. A MAIORIA DAS ERUPÇÕES VULCÂNICAS ACONTECEM ABAIXO DA SUPERFÍCIE DO OCEANO"),
            Curiosidade("13. PODE HAVER BILHÕES DE DÓLARES EM TESOUROS NAS PROFUNDEZAS DOS OCEANOS"),
            Curiosidade("14. O OCEANO NOS MANTÉM RESPIRANDO"),
            Curiosidade("15. AS “ZONAS MORTAS” NO OCEANO PODEM SER ESTÉREIS DE QUALQUER VIDA"),
            Curiosidade("16. OS PEIXES NO OCEANO ESTÃO COMENDO MUITO PLÁSTICO"),
            Curiosidade("17. MANTER PEIXES TROPICAIS DE ESTIMAÇÃO PODE ESTAR PREJUDICANDO O OCEANO"),
            Curiosidade("18. AS ONDAS DO TSUNAMI PODEM ATINGIR 30 METROS DE ALTURA…"),
            Curiosidade("19. … MAS AS MAIORES ONDAS ESTÃO SOB A SUPERFÍCIE DO OCEANO."),
            Curiosidade("20. OS HUMANOS ESTÃO TENTANDO TORNAR O OCEANO POTÁVEL"),
            Curiosidade("21. O BRISTLEMOUTH É O VERTEBRADO MAIS ABUNDANTE DO MUNDO"),
            Curiosidade("22. AS ALGAS GIGANTES CRESCEM MUITO RAPIDAMENTE"),
            Curiosidade("23. OS PATOS-BORRACHA AJUDARAM A MOLDAR NOSSA COMPREENSÃO DO OCEANO"),
            Curiosidade("24. OS PEIXES ANTÁRTICOS POSSUEM ANTICONGELANTE NATURAL"),
            Curiosidade("25. CONCHAS DO MAR NÃO SOAM COMO O OCEANO")
        )

        // Set up RecyclerView
        listaCuriosidades.layoutManager = LinearLayoutManager(this)
        listaCuriosidades.adapter = CuriosidadeAdapter(this, curiosidades)

        buttonVoltar.setOnClickListener {
            val intent = Intent(this, Logado::class.java)
            startActivity(intent)
            finish()
        }
    }
}
