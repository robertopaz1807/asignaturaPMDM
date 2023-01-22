package com.miteris.myspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //val datos = arrayOf("Elem1", "Elem2", "Elem3", "Elem4", "Elem5")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //    val adaptador =
    //        ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)

        var adaptador =
            ArrayAdapter.createFromResource(this, R.array.valores_array,
                android.R.layout.simple_spinner_item)

        var cmbOpciones: Spinner = findViewById(R.id.cmbOpciones)

        adaptador.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)
        cmbOpciones.adapter = adaptador



        cmbOpciones.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>) {

                var lblSeleccion: TextView = findViewById(R.id.lblSeleccion)
                lblSeleccion.text = "Sin selección"
            }
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val pos = parent.getItemAtPosition(position)
                var lblSeleccion: TextView = findViewById(R.id.lblSeleccion)
                lblSeleccion.text = "Seleccionado: $pos"
            }
        }


    }
}