package com.example.motobombasaldia

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motobombasaldia.databinding.ActivityRegistroBinding

class Reg_Usuarios : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun guardar(){
            val logUsuario=binding.txtUsuario.text.toString()
            val clave:String = binding.txtPassword.text.toString()
            val datos=getSharedPreferences(logUsuario, Context.MODE_PRIVATE)
            val editar=datos.edit()
            editar.putString("nombreusuario",logUsuario)
            editar.putString("claveusuario",clave)
            editar.putString("identificacion",binding.txtIdentificacion.text.toString())
            editar.putString("nombres",binding.txtNombres.text.toString())
            editar.putString("apellidos",binding.txtApellidos.text.toString())
            editar.putString("direccion",binding.txtDir.text.toString())
            editar.putString("telefono",binding.txtTel.text.toString())
            editar.putString("correo",binding.txtEmail.text.toString())
            editar.commit()
        }
        binding.btnGrabar.setOnClickListener{

            guardar()
            Toast.makeText(this, "Datos Guardados", Toast.LENGTH_LONG).show()
        }

    }
}