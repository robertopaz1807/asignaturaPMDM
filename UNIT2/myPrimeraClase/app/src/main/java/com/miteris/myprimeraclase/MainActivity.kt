package com.miteris.myprimeraclase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val pepe = Programmer("Pepe", 32, arrayOf(Programmer.Languaje.KOTLIN, Programmer.Languaje.SWIFT))
    println(pepe.name)
    pepe.age= 42

    val marta = Programmer("Marta", 26, arrayOf(Programmer.Languaje.JAVA))

    pepe.code()
    marta.code()


    val antonio = Programmer("Antonio", 26, arrayOf(Programmer.Languaje.JAVA), arrayOf(marta))

    println("${antonio.name} tiene un amigo que se llama ${antonio.friends?.first()?.name} ")


    }
}