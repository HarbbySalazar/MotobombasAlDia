package com.example.motobombasaldia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motobombasaldia.databinding.ActivityOlvidoPasswordBinding

class olvidoPassword : AppCompatActivity() {
    private lateinit var binding: ActivityOlvidoPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_olvido_password)
        binding = ActivityOlvidoPasswordBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)
        binding.btnEnviar.setOnClickListener {
            val email = binding.txtEmail.text.toString()
            if (email !="")
                if((email=="harbysalazar@gmail.com") || (email=="davalbe@gmail.com") || (email=="gutavo.moralesp@gmail.com"))
                    Toast.makeText(this, "Envio de contraseña exitoso", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this, "Correo electrónico no registrado", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Diligencie un correo electrónico", Toast.LENGTH_LONG).show()
        }

    }
}