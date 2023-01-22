package com.miteris.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //VAriables y constantes
        //variableYConstantes()

        //Operaciones Aritmeticas
        //oeracionesAritmeticas()

        //Concatenación
        //concatenacion()

        //funciones
        //showMyName()
        //showMyLastName()
        //showMyAge()

        //Funcion con parametros
/*      showMyInformation("Roberto", "Paz", 24)
        showMyInformation("Andres", "Perez")

        //Funciones con Salida
        var result = add(5, 10)
        println(result)

        var result2 = add(5, add(5, 10))
        println(result2)*/

        //Sentencia IF y when
        //sentenciaIF()

        //TipoArray
        //elTipoArray()

        //TipoLista
        //elTipoLista()

        //tipoMapa
        //elMapa()

        //Bucles
        //losBlucles()

        //NUlos
        //losNUlos()

        var c: Float = 10.5f
        var d: Int = 5
        var resultado = c + d
        println (resultado)


        //val brais = Programmer("Brais", 32, arrayOf("KOTLIN", "SWIFT"))
/*      val brais = Programmer("Brais", 32, arrayOf(Programmer.Languaje.KOTLIN, Programmer.Languaje.SWIFT))
        println(brais.name) // añadir val para poder acceder a ellas

        brais.age = 40  // debemos cambiar val por var

        //val sara = Programmer("Sara", 35, arrayOf("JAVA"))
        val sara = Programmer("Sara", 35, arrayOf(Programmer.Languaje.JAVA))

        brais.code()
        sara.code()


        val antonio = Programmer("ANTONIO", 33, arrayOf(Programmer.Languaje.PHP), arrayOf(brais))

        println("${antonio.friends?.first()?.name} es amigo de ${antonio.name}")*/

    }

    private fun losNUlos() {

        var a: String? = "abc"
        a = null

        val x:Int? = null

        //val h= x.toDouble()

        if (x != null) {
            val h = x.toDouble()
            println(h)
        }else{
            println("La variable es nula")
        }



        var y: String? = "abc"
        y = null
        val l = y?.length ?: -1
        println(l)

    }

    private fun losBlucles() {

        // Bucles

        val myArray = listOf("Hola", "Bienvenidos al tutorial", "Suscríbete!")
        val myMap = mutableMapOf("Brais" to 1, "Pedro" to 2, "Sara" to 5)

        // For

        for (myString in myArray) {
            println(myString)
        }

        for (myElement in myMap) {
            println("${myElement.key}-${myElement.value}")
        }

        for (x in 0..10) {
            println(x)
        }

        for (x in 9 until 30) {
            println(x)
        }

        for (x in 0..10 step 2) {
            println(x)
        }

        for (x in 10 downTo 0 step 3) {
            println(x)
        }

        val myNumericArray = (0..20)
        for (myNum in myNumericArray) {
            println(myNum)
        }

        // While

        var x = 0

        while (x < 10) {
            println(x)
            x += 2
        }



    }


    private fun elMapa() {

        // Sintaxis mapOf no se podrian añadir
        var myMap: Map<String, Int> = mapOf("Brais" to 1, "Pedro" to 2, "Sara" to 5)
        println(myMap)

        val userSettings: Map<String, String> = mapOf(
            "name" to "Catrina",
            "language" to "Español",
            "logo" to "logo.png",
            "website" to "www.site.com"
        )
        println("$userSettings")


        // funciones
        println(userSettings.size) // 4
        println(userSettings.entries) // [name=Catrina, language=Español, logo=logo.png, website=www.site.com]
        println(userSettings.keys) // [name, language, logo, website]
        println(userSettings.values) // [Catrina, Español, logo.png, www.site.com]


        // metodos de lectura
        println(userSettings["logo"]) // logo.png
        println(userSettings.get("web")) // null
        //println(userSettings.getOrDefault("email", "Sin email")) // Sin email
        println(userSettings.isEmpty()) // false
        println("name" in userSettings) // true
        println("Español" in userSettings.values ) // true


        //Mapas mutables
        val booksMap = mutableMapOf(
            "Sinsajo" to 2010,
            "Yo, Robot" to 1950,
            "Crimen y castigo" to 1935,
            "Cien años de soledad" to 1991
        )
        println(booksMap)

        booksMap.put("La máquina del tiempo", 1890)
        booksMap["La máquina del tiempo"] = 1895
        println(booksMap)


        booksMap.remove("Sinsajo")
        println(booksMap)

        //println(booksMap.remove("Cien años de soledad", 2015))
        println(booksMap)


        //Recorrer un mapa
        val operationsMap = mapOf(
            "Suma" to '+',
            "Resta" to '-',
            "Multiplicación" to 'x',
            "División" to '÷'
        )

        for ((operation, symbol) in operationsMap) {
            println("$operation -> $symbol")
        }

        operationsMap.forEach { (k, v) -> println("$k -> $v") }


    }

    private fun elTipoLista() {

        val readOnly: List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
        println(readOnly.size)//Muestra el tamaño de la lista
        println(readOnly.get(3)) //Devuelve el valor de la posición 3
        println(readOnly.first()) //Devuelve el primer valor
        println(readOnly.last()) //Devuelve el último valor
        println(readOnly) //[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo]


        var mutableList: MutableList<String> = mutableListOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")
        val mutableListx = mutableListOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")

        println(mutableList)
        mutableList.add("domingo")
        println(mutableList)
        mutableList.remove("Lunes")
        println(mutableList)

        mutableList.add(0, "Semana: ")
        println(mutableList)




        var mutableList2: MutableList<String> = mutableListOf()
        mutableList2.none() //Nos devuelve un true si está vacía la lista
        mutableList2.firstOrNull() //Nos devolverá el primer campo, y si no hay, un null.
        mutableList2.elementAtOrNull(2) //El elemento del índice 2, si no hay, devolverá un null
        mutableList2.lastOrNull() //Último valor de la lista o null

        //REcorrer listas
        for (item in mutableList) {
            println(item)
        }

        //Recorrer listas 2
        for ((indice, item) in mutableList.withIndex()) {
            println("La posición $indice contiene $item")
        }

        //REcorer listas 2
        val newListEmpty: MutableList<String> = mutableListOf()
        mutableList.forEach {
            newListEmpty.add(it+":")
        }
        println(newListEmpty)




    }

    private fun elTipoArray() {

        val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
        println(weekDays)

        println(weekDays[0])
        println(weekDays.get(0))
        println(weekDays.get(1))
        println(weekDays.get(2))
        println(weekDays.get(3))
        println(weekDays.get(4))
        println(weekDays.get(5))
        println(weekDays.get(6))
      //  println(weekDays.get(7))

        weekDays.set(0, "Horrible lunes") //Contenía Lunes
        weekDays.set(4, "Por fin viernes") //Contenía Viernes

        weekDays[6] = "Peor día de la semana."


        for (weekDay in weekDays) {
            println(weekDay)
        }

        weekDays.forEach {
            println(it)
        }

        for ((posicion, valor) in weekDays.withIndex()) {
            println("La posición $posicion contiene el valor $valor")
        }

        println(weekDays.first())
        println( weekDays.last())


    }





    private fun sentenciaIF() {

        var result = add(5, 10)
        if (result > 10) {
            println("El resultado es mayor que 10")
        }

        var name = "Aris"
        if (name == ("Aris")) {
            println("Se llama Aris")
        }

        var animal = "bird"

        if (animal == "dog") {
            println("Es un perro")
        } else if (animal == "cat") {
            println("Es un gato")
        } else if (animal == "bird") {
            println("Es un pájaro")
        } else {
            println("Es otro animal")
        }



        var animal2 = "dog"
        var raza = "labrador"

        //solo entrará si cumple ambas condiciones
        if (animal2 == "dog" && raza == "labrador") {
            println("Es un perro de raza labrador")
        }

        //Entrará si es verdadera una de las condiciones
        if (animal2 == "dog" || animal2 == "gato") {
            println("Es un perro o un gato")
        }

        var month = 1
        when (month) {
            1 -> println("Enero")
            2 -> println("Febrero")
            3 -> println("Marzo")
            4 -> println("Abril")
            5 -> println("Mayo")
            6 -> println("Junio")
            7 -> println("Julio")
            8 -> println("Agosto")
            9 -> println("Septiembre")
            10 -> println("Octubre")
            11 -> println("Noviembre")
            12 -> println("Diciembre")
            else -> {
                println("No corresponde a ningún mes del año")
            }
        }


        when (month) {
            1,2,3 -> println("Primer trimestre del año")
            4,5,6 -> println("Segundo trimestre del año")
            7,8,9 -> println("Tercer trimestre del año")
            10,11,12 -> println("Cuarto trimestre del año")
            else -> {
                println("No corresponde a ningún trimeste valido")
            }
        }

        when (month) {
            in 1..6 -> println("Primer semestre")
            in 7..12 -> println("Segundo semestre")
            !in 1..12 -> println("No es un mes válido")
        }

        val response : String = when (month) {
            in 1..6 -> "Primer semestre"
            in 7..12 -> "segundo semestre"
            !in 1..12 -> "no es un mes válido"
            else ->  "error"
        }
        println(response)


        val country = "Italia"
        when (country) {
            "España", "Mexico", "Perú", "Colombia", "Argentina" -> {
                println("El idioma es Español")
            }
            "EEUU" -> {
                println("El idioma es Inglés")
            }
            "Francia" -> {
                println("El idioma es Francés")
            }
            else -> {
                println("No conocemos el idioma")
            }
        }



        val age = 100
        when (age) {
            0, 1, 2 -> {
                println("Eres un bebé")
            }
            in 3..10 -> {
                println("Eres un niño")
            }
            in 11..17 -> {
                println("Eres un adolescente")
            }
            in 18..69 -> {
                println("Eres adulto")
            }
            in 70..99 -> {
                println("Eres anciano")
            }
            else -> {
                println("😱")
            }
        }






    }





    fun add(firsNumber: Int, secondNumber: Int): Int {
        return firsNumber + secondNumber
    }

    fun add2(firsNumber: Int, secondNumber: Int): Int = firsNumber + secondNumber

    fun showMyInformation(name: String, lastName: String, age: Int = 0) {
        println("Me llamo $name $lastName y tengo $age años.")
    }

    fun showMyName() {
        println("Me llamo Roberto")
    }

    private fun showMyLastName() {
        println("Mi Apellido es Paz")
    }

    fun showMyAge() {
        println("Tengo xx años")
    }

    private fun concatenacion() {

        //Concatenar sin el +
        val greeting = "Hola, me llamo"
        val name = "Roberto"
        println("$greeting $name")

//Concatenación compleja
        val introduction = "El resultado de"
        val plus = "más"
        val firstNumber = 2
        val secondNumber = 5
        println(
            "$introduction $firstNumber " +
                    "$plus $secondNumber es: " +
                    "${firstNumber + secondNumber}"
        )

    }

    private fun oeracionesAritmeticas() {

        var a = 10
        var b = 5

        println("Suma'+': ${a + b}")
        println("Resta: ${a - b}")
        println("Multiplicación: ${a * b}")
        println("División: ${a / b}")
        println("Resto: ${a % b}")

        var c: Float = 10.5f
        var d: Int = 5
        var resultado = c + d
        println("SUMA: " + resultado)
        println("SUMA: $resultado")
        println("SUMA: ${c + d}")


    }


    private fun variableYConstantes() {

        var myFirstVariable = "Hola soy coco"
        var myFirstNumber = 1

        println("Esto lo imprimo por pantalla- " + myFirstVariable)
        println("Esto lo imprimo por pantalla $myFirstVariable")

        var MyFerstConst = "Soy tu constante"
        val MySecondConst = myFirstVariable

        //myFirstVariable = 1

        MyFerstConst = "Soy tu constante"
        println(MyFerstConst)

        // String
        val myString: String = "Hola Miteris!"
        val myString2 = "Bienvenidos al curso de Andriod"
        val myString3 = myString + " " + myString2
        println(myString3)

        // Enteros (Byte, Short, Int, Long)
        val myInt: Int = 1
        val myInt2 = 2
        val myInt3 = myInt + myInt2
        println(myInt3)

        // Decimales (Float, Double)
        val myFloat: Float = 1.5f
        val myDouble = 1.5
        val myDouble2 = 2.6
        val myDouble3 = 1 // En realidad este es Int
        val myDouble4 = myDouble + myDouble2 + myDouble3
        println(myDouble4)

        // Boolean (Bool)
        val myBool: Boolean = true
        val myBool2 = false
        //val myBool3 = myBool + myBool2
        println(myBool == myBool2)
        println(myBool && myBool2)
    }


}