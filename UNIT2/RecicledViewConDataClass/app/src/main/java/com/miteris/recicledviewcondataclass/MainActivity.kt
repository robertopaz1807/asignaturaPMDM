package com.miteris.recicledviewcondataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val batman:Superhero = Superhero("Batman",
                    "DC",
                    "Bruce Wayne",
                    "https://pixabay.com/es/photos/batman-proteccion-corona-4946610/")

        val batmanRealName = batman.realName //Recuperamos "Bruce Wayne"
        println(batmanRealName)
      //  batman.realName = "Soy Batman" //Cambiamos "Brece Wayne" por "Soy Batman"
        batman.toString() //Devolverá todos los atributos con su valor
        println(batman)

        val superBatman:Superhero = batman.copy(superhero = "SuperBatman")
        superBatman.toString() //Devolverá todos los atributos con su valor
        println(superBatman)

        batman.component1() //Batman
        batman.component2() //DC
        batman.component3() //Bruce Wayne
        batman.component4() //https://pixabay.com/es/photos/batman-proteccion-corona-4946610/
        println(batman.component4())

        val (superheroFav, publisherFav, realNameFav, photoFav) = batman
        superheroFav //Batman
        publisherFav //DC
        realNameFav //Bruce Wayne
        photoFav //https://pixabay.com/es/photos/batman-proteccion-corona-4946610/
        println(photoFav)

        var superheros:MutableList<Superhero> = mutableListOf()
        superheros.add(Superhero("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"))
        superheros.add(Superhero("Daredevil", "Marvel", "Matthew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"))
        superheros.add(Superhero("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"))
        superheros.add(Superhero("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"))
        superheros.add(Superhero("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg"))
        superheros.add(Superhero("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png"))
        superheros.add(Superhero("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"))
        superheros.add(Superhero("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg"))


    }
}