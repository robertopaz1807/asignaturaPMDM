package com.miteris.mybotones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        containedButton.setOnClickListener {
            textView.text = "Botón 1 pulsado"
        }

        outlinedButton.setOnClickListener{
            //La acción que quisiéramos hacer
        }

        textButton.setOnClickListener{
            //La acción que quisiéramos hacer
        }


        toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->
            if (isChecked) {
                textView.text = "isCheckued"
            } else {
                textView.text = "no is Checked"
            }

        }
    }
}


