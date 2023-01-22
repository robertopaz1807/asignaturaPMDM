package com.miteris.imagetexteditradiocheck

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.style.StyleSpan
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cambiarImagen()
        cambiarTextView()
        cambiarEditText()

        var chkMarcame: CheckBox = findViewById(R.id.checkBox)

        chkMarcame.setOnClickListener {
            if (chkMarcame.isChecked){
                chkMarcame.text = "ACEPTADO !!"
            }else{
                chkMarcame.text = "Aceptame"
            }

/*            if (it is CheckBox) {
                if (it.isChecked)
                    chkMarcame.text = "ACEPTADO !!"
                else
                    chkMarcame.text = "Aceptame"
            }*/
        }

/*        chkMarcame.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                chkMarcame.text = "ACEPTADO !!"
            else
                chkMarcame.text = "Aceptame"
        }*/



        var grbGrupo1: RadioGroup = findViewById(R.id.radioGroup)
        grbGrupo1.clearCheck()
        grbGrupo1.check(R.id.radioButton)
        grbGrupo1.checkedRadioButtonId


        //Añadir TextViev que ponga el texto. Ha seleccionado

        var lblMensaje: TextView = findViewById(R.id.textView2)
        grbGrupo1 = findViewById(R.id.radioGroup)

        grbGrupo1.setOnCheckedChangeListener { _, checkedId ->
            var opcion = ""
            when (checkedId) {
                R.id.radioButton ->  opcion = "Playa"
                R.id.radioButton2 -> opcion = "Montaña"
            }
            lblMensaje.text = "Opción seleccionada: $opcion"
        }



    }

    private fun cambiarEditText() {

        val txtBasico: EditText = findViewById(R.id.editTextTextPersonName)

        txtBasico.setText("Escriba su Teléfono. Gracias")

        val str = Editable.Factory.getInstance().newEditable("Escriba su Teléfono. Gracias")
        str.setSpan(StyleSpan(Typeface.BOLD), 11, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        txtBasico.text = str

    }

    private fun cambiarTextView() {

        val lblEtiqueta: TextView = findViewById(R.id.textView)

        val texto = lblEtiqueta.text.toString()
        lblEtiqueta.text = "$texto Viernes"
        lblEtiqueta.setBackgroundColor(Color.LTGRAY)

    }

    private fun cambiarImagen() {
        val mylogo: ImageView = findViewById(R.id.imageView2)
        mylogo.setImageResource(R.drawable.logo_miteris)

    }
}