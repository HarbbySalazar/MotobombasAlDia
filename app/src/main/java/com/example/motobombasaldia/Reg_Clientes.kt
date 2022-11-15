package com.example.motobombasaldia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motobombasaldia.databinding.ActivityRegClientesBinding

class Reg_Clientes : AppCompatActivity() {
    private lateinit var binding:ActivityRegClientesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityRegClientesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton.setOnClickListener {
            startActivity(Intent(this,Mapa::class.java))
        }
    }
}