package com.example.motobombasaldia

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class TecnicosAdapter (private val context: Context, val listado:MutableList<datosTecnicos>):
        RecyclerView.Adapter<TecnicosAdapter.ViewHolder>(){
           inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
               lateinit var datoNom:TextView
               lateinit var datoEmail:TextView
               //lateinit var datoFoto:ImageView
               init{
                   datoNom=itemview.findViewById(R.id.txtNomTecnico)
                   datoEmail=itemview.findViewById(R.id.txtCorreoTecnico)
                 //  datoFoto=itemview.findViewById(R.id.imgFoto)
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
        /*val file = File(context.filesDir, tecnico.foto.toString())
        val bitmap = BitmapFactory.decodeFile(file.toString())
        holder.datoFoto.setImageBitmap(bitmap)*/
    }

    override fun getItemCount(): Int {
        return listado.size
    }
}
