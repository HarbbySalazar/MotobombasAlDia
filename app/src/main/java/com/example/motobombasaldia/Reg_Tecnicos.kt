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
    }

    val abrirCamara =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
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
   /* private fun crearContenido():ContentValues{
        val nombrearchivo=file.name
        val tipoarchivo="image/jpg"
        return ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, nombrearchivo)
            put(MediaStore.Files.FileColumns.MIME_TYPE,tipoarchivo)
            put(MediaStore.MediaColumns.RELATIVE_PATH,Environment.DIRECTORY_PICTURES)
            put(MediaStore.MediaColumns.IS_PENDING,1)
       }
    }

    private fun guardarContenido(content: ContentValues):Uri {
        var outputStream: OutputStream?
        var uri: Uri?
        application.contentResolver.also { resolver ->
            uri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, content)
            outputStream = resolver.openOutputStream(uri!!)
        }
        outputStream.use { output ->
            mapeoImagen().compress(Bitmap.CompressFormat.JPEG, 80, output)
        }
        return uri!!
    }

    private fun mapeoImagen():Bitmap{
        return BitmapFactory.decodeFile(file.toString())
    }

    private fun guardarimagen(){
        val save=crearContenido()
        val uri=guardarContenido(content)
    }

    private fun tomarFoto(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{ takePicture ->
            takePicture.resolveActivity(packageManager)?.also {
                startActivityForResult(takePicture,REQUEST_CODE_TAKE_PHOTO)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_TAKE_PHOTO && resultCode == RESULT_OK){
            data?.extras?.let { bundle ->{
                val bitmap=bundle.get("data") as Bitmap
                binding.imgFoto.setImageBitmap(bitmap)
            }  }
        }
    }
*/

