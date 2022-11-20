package com.example.motobombasaldia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        binding.btnGrabar.setOnClickListener{
            if ((binding.txtIdentificacion.text.toString()!="") || (binding.txtNombres.text.toString()!="") || (binding.txtEmail.text.toString()!=""))
                Toast.makeText(this, "Datos del cliente guardados", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Faltan datos, verifique", Toast.LENGTH_LONG).show()
        }
    }
}