package com.cdp.mymap

import android.os.Bundle
import android.widget.EditText
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

private lateinit var txtLatitud: EditText
private lateinit var txtLongitud: EditText
private lateinit var mMap: GoogleMap

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtLatitud = findViewById(R.id.txtLatitud)
        txtLongitud = findViewById(R.id.txtLongitud)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        }

        override fun onMapReady(@NonNull googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMapClickListener(this)
        mMap.setOnMapLongClickListener(this)

        val mexico = LatLng(19.8077463, -99.4077038)
        mMap.addMarker(MarkerOptions().position(mexico).title("México"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico))
        }

        override fun onMapClick(@NonNull latLng: LatLng) {
        txtLatitud.setText(latLng.latitude.toString())
        txtLongitud.setText(latLng.longitude.toString())

        mMap.clear()
        val mexico = LatLng(latLng.latitude, latLng.longitude)
        mMap.addMarker(MarkerOptions().position(mexico).title(""))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico))
        }

        override fun onMapLongClick(@NonNull latLng: LatLng) {
        txtLatitud.setText(latLng.latitude.toString())
        txtLongitud.setText(latLng.longitude.toString())

        mMap.clear()
        val mexico = LatLng(latLng.latitude, latLng.longitude)
        mMap.addMarker(MarkerOptions().position(mexico).title(""))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mexico))
        }
        }
