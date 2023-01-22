package com.miteris.a04_program_kotlin

///sin val no podremos acceder a ellas desde otra clase/

class Programmer(val name: String,
                 var age: Int,
                 val languajes: Array<Languaje>,
                 val friends: Array<Programmer>? = null) {

    enum class Languaje {
        KOTLIN,
        SWIFT,
        JAVA,
        JAVASCRIPT,
        PHP
    }

    fun code() {
        for (languaje: Languaje in languajes) {
            println("Estoy programando en $languaje")
        }
    }

}