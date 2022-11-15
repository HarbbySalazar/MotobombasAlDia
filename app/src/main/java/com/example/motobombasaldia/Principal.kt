package com.example.motobombasaldia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motobombasaldia.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnTecnico.setOnClickListener {
            startActivity(Intent(this,Reg_Tecnicos::class.java))
        }
        binding.btnListTecnicos.setOnClickListener{
            startActivity(Intent(this,ListadoTecnicos::class.java))
        }
        binding.btnCliente.setOnClickListener {
            startActivity(Intent(this,Reg_Clientes::class.java))
        }


    }
}