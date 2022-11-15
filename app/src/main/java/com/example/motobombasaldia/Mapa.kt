package com.example.motobombasaldia

import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionProvider
import android.view.SearchEvent
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class Mapa : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap
    private lateinit var fusedLocation: FusedLocationProviderClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa)

        crearfragment()
    }

    private fun crearfragment() {
        val mapfragment: SupportMapFragment=supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapfragment.getMapAsync(this)
        fusedLocation=LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onMapReady(gm: GoogleMap){
        map=gm
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
        != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
            1)
        return
        }
        map.isMyLocationEnabled=true
        map.uiSettings.isZoomControlsEnabled=true
        map.uiSettings.isCompassEnabled=true

        fusedLocation.lastLocation.addOnSuccessListener { location ->
            if (location!=null){
                val ubicacion=LatLng(location.latitude, location.longitude)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,12f))
            }
        }
    }

}