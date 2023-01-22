package com.miteris.holatu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnChangeActivity.setOnClickListener { checkValue() }
    }

    //Comprobamos si el texto esta vacio
    fun checkValue(){
        if(etName.text.toString().isEmpty()){
            Toast.makeText(this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this,ShowNameActivity::class.java)
            intent.putExtra("name",etName.text.toString())
            startActivity(intent)
        }
    }
}