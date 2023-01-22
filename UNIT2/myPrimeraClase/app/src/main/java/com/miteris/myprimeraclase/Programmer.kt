package com.miteris.myprimeraclase

class Programmer ( val name:String,
                   var age:Int,
                   val languajes:Array<Languaje>,
                   val friends:Array<Programmer>? = null) {

    enum class Languaje {
        KOTLIN,
        SWIFT,
        JAVA,
        JAVASCRIPT,
        PHP
    }

    fun code (){

        println("Me llamo $name")
        for (languaje:Languaje in languajes){
            println("Estroy programando en $languaje")
        }

    }
}