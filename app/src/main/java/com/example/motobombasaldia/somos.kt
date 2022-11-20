package com.example.motobombasaldia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.motobombasaldia.databinding.ActivitySomosBinding

class somos : AppCompatActivity() {
    private lateinit var binding: ActivitySomosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivitySomosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}