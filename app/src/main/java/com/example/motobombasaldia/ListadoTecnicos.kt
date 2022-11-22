package com.example.motobombasaldia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.motobombasaldia.data.UsuarioDB
import com.example.motobombasaldia.databinding.ActivityListadoTecnicosBinding
import com.example.motobombasaldia.model.TecnicoModel
import com.example.motobombasaldia.model.UsuarioModel

class ListadoTecnicos : AppCompatActivity() {
    private lateinit var binding: ActivityListadoTecnicosBinding
    private var listadot:MutableList<datosTecnicos> = mutableListOf()
    private lateinit var recycler: RecyclerView
    private lateinit var database: UsuarioDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListadoTecnicosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database= Room.databaseBuilder(
            application,UsuarioDB::class.java, UsuarioDB.DATABASE_NAME).allowMainThreadQueries().build()
        val datos: List<TecnicoModel> = database.tecnicoDAO.consultarTodos()
        Toast.makeText(this, "Hay "+datos.size+" técnicos registrados", Toast.LENGTH_LONG).show()
        if (datos.size!=0)
        {
           for(i in 0..(datos.size-1)){
               listadot.add(datosTecnicos(datos.get(i).nombre.toString(),  datos.get(i).correo.toString()))
            }
        }
         estableceradapter()

    }
    private fun estableceradapter(){
        recycler=binding.listaRecycler
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=TecnicosAdapter(this,listadot)
    }
}