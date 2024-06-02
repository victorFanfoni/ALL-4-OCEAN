package com.fiap.all4ocean

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CuriosidadeAdapter(private val context: Context, private val curiosidades: List<Curiosidade>) : RecyclerView.Adapter<CuriosidadeAdapter.CuriosidadeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuriosidadeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_curiosidade, parent, false)
        return CuriosidadeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CuriosidadeViewHolder, position: Int) {
        val curiosidade = curiosidades[position]
        holder.textViewCuriosidade.text = curiosidade.texto

        holder.itemView.setOnClickListener {
            val intent = Intent(context, CuriosidadeDetalheActivity::class.java).apply {
                putExtra("curiosidade_texto", curiosidade.texto)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return curiosidades.size
    }

    class CuriosidadeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewCuriosidade: TextView = itemView.findViewById(R.id.textViewCuriosidade)
    }
}
