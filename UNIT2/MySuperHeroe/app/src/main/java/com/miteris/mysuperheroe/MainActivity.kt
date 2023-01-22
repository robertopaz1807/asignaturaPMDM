package com.miteris.mysuperheroe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val batman: SuperHero = SuperHero(
            "Batman", "DC",
            "Bruce Wayne",
            "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"
        )


        var batmanName = batman.realName
        println(batmanName)

        // batman.realName = "Pepe"
        batman.photo = "www.google.es"


        // copia del objeto modificando atributos
        val superBatman: SuperHero = batman.copy(superhero = "SuperBatman")
        superBatman.toString()
        println(superBatman)


        //Acceso a los datos del objeto
        println(batman.component1()) //Batman
        println(batman.component2()) //DC
        println(batman.component3()) //Bruce Wayne
        println(batman.component4()) //https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg

        // leemos el objeto a varibles/constantes individuales
        val (superheroFav, publisherFav, realNameFav, photoFav) = batman

        println(superheroFav) //Batman
        println(publisherFav) //DC
        println(realNameFav)  //Bruce Wayne
        println(photoFav)     //https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg
        println(photoFav)


        var superheros:MutableList<SuperHero> = mutableListOf()
        superheros.add(SuperHero("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(SuperHero("Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(SuperHero("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(SuperHero("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(SuperHero("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(SuperHero("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(SuperHero("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(SuperHero("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))

    }
}