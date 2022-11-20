package com.example.motobombasaldia

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.airbnb.lottie.animation.content.Content
import com.example.motobombasaldia.databinding.ActivityRegTecnicosBinding
import java.io.File
import java.io.OutputStream


class Reg_Tecnicos : AppCompatActivity() {
    private lateinit var binding: ActivityRegTecnicosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegTecnicosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnTomarFoto.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                it.resolveActivity(packageManager).also { component->
                    archivofoto()
                    val photoUri: Uri = FileProvider.getUriForFile(
                        this, BuildConfig.APPLICATION_ID + ".fileprovider", file)
                    it.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                }
            }
            abrirCamara.launch(intent)
        }

        binding.btnGabar.setOnClickListener{
            if ((binding.txtIdentificacion.text.toString()!="") ||(binding.txtApellidos.text.toString()!="") || (binding.txtEmail.text.toString()!="") || (binding.txtTel.text.toString()!=""))
                Toast.makeText(this, "Datos del técnico guardados", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Faltan datos por digitar", Toast.LENGTH_LONG).show()
        }
    }

    val abrirCamara = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result->
            if (result.resultCode == RESULT_OK) {
                //val intent=result.data

                val bitmap = BitmapFactory.decodeFile(file.toString())
                binding.imgFoto.setImageBitmap(bitmap)
            }
        }

    private lateinit var file: File

    private fun archivofoto() {
        val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
        file = File.createTempFile("IMG_${System.currentTimeMillis()}_", ".jpg", dir)
    }


}
