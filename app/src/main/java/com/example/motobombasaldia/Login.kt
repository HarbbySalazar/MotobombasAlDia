package com.example.motobombasaldia

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motobombasaldia.databinding.ActivityLoginBinding


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MotobombasAlDia)
        Thread.sleep(3000)
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fun validar(){
            val txtusuario:String= binding.txtUsuario.text.toString()
            val txtclave:String= binding.txtPassword.text.toString()
            val datos = getSharedPreferences(txtusuario,Context.MODE_PRIVATE)
            val usuario=datos.getString("nombreusuario","")
            val clave=datos.getString("claveusuario","")
            if ((txtusuario!="") || (txtclave!="")) {
                if ((usuario == txtusuario) && (clave == txtclave)) {
                    Toast.makeText(
                        this,
                        "Bienvenido " + datos.getString("nombres", ""),
                        Toast.LENGTH_LONG
                    ).show()
                    startActivity(Intent(this, Principal::class.java))
                } else
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
            }else {
                if (txtusuario == "")
                    binding.txtUsuario.setBackgroundColor(Color.RED)
                if (txtclave == "")
                    binding.txtPassword.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Usuario o contraseña no digitados", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnIngresar.setOnClickListener {
            validar()
        }
        binding.btnRegistrarse.setOnClickListener {
            startActivity(Intent(this,Reg_Usuarios::class.java))
        }

        binding.lblOlvido.setOnClickListener {
            startActivity((Intent(this,olvidoPassword::class.java)))
        }
    }
}