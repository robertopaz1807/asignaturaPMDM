package com.miteris.mybotonesii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        containedButton.setOnClickListener {
            textView.text="La la la"
        }

        toggleButton.addOnButtonCheckedListener { toggleButton, checkedId, isChecked ->

            if (isChecked) {

                textView.text = "Has Activado $checkedId $toggleButton"
            } else {
                textView.text = "Has DesAtivado $checkedId "
            }

        }
    }
}