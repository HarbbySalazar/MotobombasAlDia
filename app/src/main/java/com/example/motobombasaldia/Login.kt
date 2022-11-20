package com.example.motobombasaldia

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.motobombasaldia.dao.UsuarioDAO
import com.example.motobombasaldia.data.UsuarioDB
import com.example.motobombasaldia.databinding.ActivityLoginBinding
import com.example.motobombasaldia.model.UsuarioModel


class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var database: UsuarioDB
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MotobombasAlDia)
        Thread.sleep(3000)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fun validar(){
           database= Room.databaseBuilder(
                application,UsuarioDB::class.java, UsuarioDB.DATABASE_NAME).allowMainThreadQueries().build()
            val datos:List<UsuarioModel> = database.usuarioDAO.consultarUno(binding.txtUsuario.text.toString())
            if ((binding.txtUsuario.text.toString()!="") || (binding.txtPassword.text.toString()!=""))
            {
                if (datos.size==0)
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
                else {
                    val usuario=datos.get(0).usuario
                    val clave=datos.get(0).clave
                    if ((usuario == binding.txtUsuario.text.toString()) && (clave == binding.txtPassword.text.toString())) {
                        Toast.makeText(
                            this,
                            "Bienvenido " + datos.get(0).nombre,
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(Intent(this, Principal::class.java))
                    } else
                        Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG)
                            .show()
                }
            }else {
                if (binding.txtUsuario.text.toString() == "")
                    binding.txtUsuario.setBackgroundColor(Color.RED)
                if (binding.txtPassword.text.toString() == "")
                    binding.txtPassword.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Usuario o contraseña no digitados", Toast.LENGTH_LONG).show()
            }

        }

        fun consultar(){


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