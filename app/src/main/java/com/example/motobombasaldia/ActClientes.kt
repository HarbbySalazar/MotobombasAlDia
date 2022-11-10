package com.example.motobombasaldia

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.motobombasaldia.databinding.ActivityMainBinding
import com.example.motobombasaldia.databinding.ActivityRegistroBinding

class ActClientes : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnGrabar.setOnClickListener{
            val usuario:String = binding.txtUsuario.text.toString()
            val email:String = binding.txtEmail.text.toString()
            if ((usuario == "hsalazar") || (usuario == "gmorales") || (usuario == "djimenez"))
                Toast.makeText(this, "Usuario ya existe", Toast.LENGTH_LONG).show()
            else if ((email == "harbbysalazar@gmail.com") || (email=="davalbe@gmail.com") || (email=="gutavo.moralesp@gmail.com"))
                Toast.makeText(this, "Correo ya está registrado", Toast.LENGTH_LONG).show()
            else {
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show()
                startActivity(Intent(this,MainActivity::class.java))
            }
        }

    }
}