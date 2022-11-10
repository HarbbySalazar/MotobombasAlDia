package com.example.motobombasaldia

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motobombasaldia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MotobombasAlDia)
        Thread.sleep(3000)
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnIngresar.setOnClickListener {
            val usuario:String = binding.txtUsuario.text.toString()
            val contrasena:String = binding.txtPassword.text.toString()
            println(usuario)
            if ((usuario == "hysalazar") && (contrasena == "123456")){
                startActivity(Intent(this,principal::class.java))
                Toast.makeText(this, "Ingreso Exitoso", Toast.LENGTH_LONG).show()
            }
            else
               Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
        }
        binding.btnRegistrarse.setOnClickListener {
            startActivity(Intent(this,ActClientes::class.java))
        }

        binding.lblOlvido.setOnClickListener {
            startActivity((Intent(this,olvidoPassword::class.java)))
        }
    }
}