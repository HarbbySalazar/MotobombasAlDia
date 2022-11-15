package com.example.motobombasaldia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motobombasaldia.databinding.ActivityListadoTecnicosBinding

class ListadoTecnicos : AppCompatActivity() {
    private lateinit var binding: ActivityListadoTecnicosBinding
    private var listadot:MutableList<datosTecnicos> = mutableListOf()
    private lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListadoTecnicosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listadot.add(datosTecnicos("Harbby Salazar",  "hysc@gmail.com"))
        listadot.add(datosTecnicos("Gustavo Moreno",  "gusmo@gmail.com"))
        listadot.add(datosTecnicos("David Jimenez",  "davJim@gmail.com"))
        listadot.add(datosTecnicos("Pepito Perez",  "pepe@gmail.com"))
        listadot.add(datosTecnicos("Lalo Landa",  "lala@gmail.com"))
        listadot.add(datosTecnicos("Mary Pulido",  "mapu@gmail.com"))
        listadot.add(datosTecnicos("Sara Salazar",  "sasa@gmail.com"))
        estableceradapter()

    }
    private fun estableceradapter(){
        recycler=binding.listaRecycler
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter=TecnicosAdapter(this,listadot)
    }
}