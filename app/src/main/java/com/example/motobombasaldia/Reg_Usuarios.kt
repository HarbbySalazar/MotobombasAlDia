package com.example.motobombasaldia

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import com.example.motobombasaldia.data.UsuarioDB
import com.example.motobombasaldia.databinding.ActivityRegistroBinding
import com.example.motobombasaldia.model.UsuarioModel

class Reg_Usuarios : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    private lateinit var database: UsuarioDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database=Room.databaseBuilder(
            application,UsuarioDB::class.java, UsuarioDB.DATABASE_NAME).allowMainThreadQueries().build()

        binding.btnGrabar.setOnClickListener{
            guardarusuario()
            Toast.makeText(this, "Datos Registrados en BD", Toast.LENGTH_LONG).show()
        }
    }

    private fun guardarusuario() {
        val usuario=binding.txtUsuario.text.toString()
        val nombres=binding.txtNombres.text.toString()
        val apellidos=binding.txtApellidos.text.toString()
        val direccion= binding.txtDir.text.toString()
        val identificacion=binding.txtIdentificacion.text.toString()
        val telefono=binding.txtTel.text.toString()
        val correo=binding.txtEmail.text.toString()
        val clave=binding.txtPassword.text.toString()
        val usu = UsuarioModel(identificacion, nombres, apellidos, direccion,correo, telefono, usuario, clave)
        database.usuarioDAO.insertar(usu)
    }
}