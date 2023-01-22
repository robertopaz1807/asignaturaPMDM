package com.miteris.myimagetextedit

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.Spannable
import android.text.style.StyleSpan
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mylogo: ImageView = findViewById(R.id.imgLogo2)
        mylogo.setImageResource(R.drawable.logo_miteris)

        val lblEtiqueta: TextView = findViewById(R.id.lblEtiqueta)
        val textoAct = lblEtiqueta.text.toString()
        lblEtiqueta.text = "$textoAct (modificado)"
        lblEtiqueta.setBackgroundColor(Color.RED)

        val txtBasico: EditText = findViewById(R.id.txtBasico)
        val mitexto = txtBasico.text.toString()
        txtBasico.setText("Otro texto")

        //Creamos un nuevo objeto de tipo Editable
        //Y marcamos cono fuente negrita la palabra "simulacro" (caracteres del 11-19)
        val str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.")
        str.setSpan(StyleSpan(Typeface.BOLD), 11, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        txtBasico.text = str


        val texto = txtBasico.text;
        val ini = txtBasico.selectionStart;
        val fin = txtBasico.selectionEnd;
        texto.setSpan(
            StyleSpan(Typeface.BOLD),
            ini, fin,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //Convertir a HTML el contenido del control
        val aux2 = Html.toHtml(txtBasico.text, Html.TO_HTML_PARAGRAPH_LINES_INDIVIDUAL);

        //Asigna texto con formato HTML
        txtBasico.setText(
            Html.fromHtml("<p>Esto es un <b>simulacro</b> de negrita.</p>", Html.FROM_HTML_MODE_LEGACY),
            TextView.BufferType.SPANNABLE);

    }
}