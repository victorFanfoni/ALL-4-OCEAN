package com.fiap.all4ocean

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CuriosidadeAdapter(
    private val context: Context,
    private val curiosidades: List<String>,
    private val detalhesCuriosidades: List<String>
) : RecyclerView.Adapter<CuriosidadeAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewCuriosidade: TextView = itemView.findViewById(R.id.textViewCuriosidade)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                val intent = Intent(context, DetalheCuriosidadeActivity::class.java)
                intent.putExtra(context.getString(R.string.curiosidade_texto), detalhesCuriosidades[position])
                intent.putExtra(context.getString(R.string.curiosidade_titulo), curiosidades[position])
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_curiosidade, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewCuriosidade.text = curiosidades[position]
    }

    override fun getItemCount(): Int = curiosidades.size
}