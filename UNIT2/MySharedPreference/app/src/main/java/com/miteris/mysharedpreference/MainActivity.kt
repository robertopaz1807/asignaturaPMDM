package com.miteris.mysharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val EMPTY_VALUE = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvName = findViewById<TextView>(R.id.tvName)
        val btnDeleteValue = findViewById<Button>(R.id.btnDeleteValue)
        val etName = findViewById<EditText>(R.id.etName)
        val btnSaveValue = findViewById<Button>(R.id.btnSaveValue)

        fun showProfile() {
            tvName.visibility = View.VISIBLE
            tvName.text = "Hola ${SharedApp.prefs.name}"
            btnDeleteValue.visibility = View.VISIBLE

            etName.visibility = View.INVISIBLE
            btnSaveValue.visibility = View.INVISIBLE
        }

        fun showGuest() {
            etName.visibility = View.VISIBLE
            btnSaveValue.visibility = View.VISIBLE

            tvName.visibility = View.INVISIBLE
            btnDeleteValue.visibility = View.INVISIBLE
        }

        fun isSavedName(): Boolean {
            val myName = SharedApp.prefs.name
            return myName != EMPTY_VALUE
        }

        fun configView() {
            if (isSavedName()) showProfile() else showGuest()
        }

        btnSaveValue.setOnClickListener {
            SharedApp.prefs.name = etName.text.toString()
            configView()
        }
        btnDeleteValue.setOnClickListener {
            SharedApp.prefs.name = EMPTY_VALUE
            configView()
        }
    }
}