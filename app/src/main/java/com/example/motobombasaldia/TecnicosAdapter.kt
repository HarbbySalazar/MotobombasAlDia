package com.example.motobombasaldia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TecnicosAdapter (private val context: Context, val listado:MutableList<datosTecnicos>):
        RecyclerView.Adapter<TecnicosAdapter.ViewHolder>(){
           inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
               lateinit var datoNom:TextView
               lateinit var datoEmail:TextView
               init{
                   datoNom=itemview.findViewById(R.id.txtNomTecnico)
                   datoEmail=itemview.findViewById(R.id.txtCorreoTecnico)
               }
           }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val itemview= LayoutInflater.from(parent.context).inflate(R.layout.datos_tecnico, parent,false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tecnico= listado[position]
        holder.datoNom.text= tecnico.nombre
        holder.datoEmail.text=tecnico.correo
    }

    override fun getItemCount(): Int {
        return listado.size
    }
}
