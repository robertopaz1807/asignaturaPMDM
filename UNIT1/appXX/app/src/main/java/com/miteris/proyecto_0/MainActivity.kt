package com.miteris.proyecto_0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val elboton: Button = findViewById(R.id.btnChangeActivity)
        elboton.setText("Saludar")

        btnChangeActivity.setOnClickListener { checkValue() }

    }

    //Comprobamos si el texto está vacío
    fun checkValue(){
        if(etName.text.toString().isEmpty()){
            Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
        }else{
            //Iremos a otra pantalla
        }
    }

}