package com.miteris.appbarexplicita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


     //   val tbar = findViewById<Toolbar>(R.id.appbar)
     //   setSupportActionBar(tbar)
    }
}