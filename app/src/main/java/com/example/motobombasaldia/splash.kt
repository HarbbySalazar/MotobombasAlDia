package com.example.motobombasaldia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.motobombasaldia.databinding.ActivityMainBinding
import com.example.motobombasaldia.databinding.ActivitySplashBinding
import kotlinx.coroutines.delay

class splash : AppCompatActivity() {
    private lateinit var binding:ActivitySplashBinding
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        handler=Handler(Looper.myLooper()!!)
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        },5000)
    }
}