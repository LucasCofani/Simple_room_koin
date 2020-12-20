package com.example.simple_room_koin.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_room_koin.R
import com.example.simple_room_koin.models.Cliente

class MainAdapter(): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var clientes : ArrayList<Cliente> = arrayListOf()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNome : TextView = itemView.findViewById(R.id.tv_nome)
        val tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        val tvCEP: TextView = itemView.findViewById(R.id.tv_cep)
        val tvBairro: TextView = itemView.findViewById(R.id.tv_bairro)
        val tvCidade: TextView = itemView.findViewById(R.id.tv_cidade)
        val tvEstado: TextView = itemView.findViewById(R.id.tv_estado)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var layoutItemRest = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cliente, parent, false)
        return ViewHolder(layoutItemRest)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currItem = clientes[position]
        holder.tvNome.text = currItem.nome
        holder.tvEmail.text = "Email: ${currItem.email}"
        holder.tvBairro.text = "Bairro: ${currItem.bairro}"
        holder.tvCEP.text = "CEP: ${currItem.CEP}"
        holder.tvCidade.text = "Cidade: ${currItem.cidade}"
        holder.tvEstado.text = "Estado: ${currItem.estado}"
    }

    override fun getItemCount(): Int {
        return clientes.size
    }

    fun updateCliente(_clientes : ArrayList<Cliente>){
        clientes = _clientes
        notifyDataSetChanged()
    }

}