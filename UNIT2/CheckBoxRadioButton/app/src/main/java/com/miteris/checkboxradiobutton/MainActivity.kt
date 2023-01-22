package com.miteris.checkboxradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var chkMarcame:CheckBox = findViewById(R.id.chkMarcame)

        chkMarcame.setOnClickListener {
            if (chkMarcame.isChecked){

            }
            if (it is CheckBox) {
                if (it.isChecked)
                    chkMarcame.text = "Checkbox marcado!"
                else
                    chkMarcame.text = "Checkbox desmarcado!"
            }
        }

        chkMarcame.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                chkMarcame.text = "Checkbox marcado!"
            else
                chkMarcame.text = "Checkbox desmarcado!"
        }




        var grbGrupo1:RadioGroup = findViewById(R.id.grbGrupo1)
        grbGrupo1.clearCheck()
        grbGrupo1.check(R.id.rbOpcion1)
        val idSeleccionado = grbGrupo1.checkedRadioButtonId


        var lblMensaje: TextView = findViewById(R.id.lblMensaje)

        var option1: RadioButton = findViewById(R.id.rbOpcion1)
        var option2: RadioButton = findViewById(R.id.rbOpcion2)

        val handler = View.OnClickListener { view ->
            if (view is RadioButton) {
                var opcion = ""
                when (view.getId()) {
                    R.id.rbOpcion1 ->
                        opcion = "opción 1"
                    R.id.rbOpcion2 ->
                        opcion = "opción 2"
                }
                lblMensaje.text = "Opción seleccionada: $opcion"
            }
        }
        option1.setOnClickListener(handler)


        grbGrupo1 = findViewById(R.id.grbGrupo1)
        grbGrupo1.setOnCheckedChangeListener { _, checkedId ->
            var opcion = ""
            when (checkedId) {
                R.id.rbOpcion1 ->
                    opcion = "opción 1"
                R.id.rbOpcion2 ->
                    opcion = "opción 2"
            }
            lblMensaje.text = "Opción seleccionada: $opcion"
        }



    }
}