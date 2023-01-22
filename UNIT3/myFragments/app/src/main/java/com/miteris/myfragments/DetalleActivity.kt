package com.miteris.myfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {
    companion object {
        val EXTRA_TEXTO : String = "net.sgoliver.android.fragments.EXTRA_TEXTO"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        val detalle = supportFragmentManager.findFragmentById(R.id.frgDetalle) as FragmentDetalle
        intent.getStringExtra(EXTRA_TEXTO)?.let { detalle.mostrarDetalle(it) }
    }
}
