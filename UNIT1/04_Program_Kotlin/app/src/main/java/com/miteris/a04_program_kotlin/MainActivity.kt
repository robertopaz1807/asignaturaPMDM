package com.miteris.a04_program_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    @override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lección 1
        //variablesYConstantes()

        // Lección 2
        //tiposDeDatos()

        // Lección 3
        //operacionesAritmeticas()

        //Lección 4
        //concatenacion()

        // Lección 5 -Funciones-
/*      showMyName()
        showMyLastName()
        showMyAge()
        showMyInformation("Roberto", "Paz", 24)*/
        //var result = add(5, 10)
        //println(result)

        //anidar funciones
        //var result2 = add(5, add(5, 10))
        //println(result2)

        // Lección 6
        //sentenciaIf()

        // Lección 7
        //sentenciaWhen()

        // Lección 8
        //arrays()

        // Lección 9
        listas()

        // Lección 10
        //mapas()

        // Lección 11
        //loops()

        // Lección 12
        //nullSafety()

        // Lección x
        //classes()
    }

    /*
    Aquí vamos a hablar de variables y constantes
     */
    private fun variablesYConstantes() {

        // Variables (Siempre en cameCase)

        var myFirstVariable = "Hello Miteris!"
        var myFirstNumber = 1

        println("Imprimiendo variable de texto:" + myFirstVariable)
        println("Imprimiendo variable de numérica:" + myFirstNumber)

        myFirstVariable = "Bienvenidos al curso de Android."

        println(myFirstVariable)

        // No podemos asignar un tipo Int a una variable de tipo String
        //myFirstVariable = 1

        var mySecondVariable = "Enganchate al curso!"

        println(mySecondVariable)

        mySecondVariable = myFirstVariable

        println(mySecondVariable)

        myFirstVariable = "¿Ya te has enganchado?"

        println(myFirstVariable)

        // Constantes

        val myFirstConstant = "¿Te ha gustado tu primera toma de contacto con Kotlin?"

        println(myFirstConstant)

        // Una constante no puede modificar su valor
        //myFirstConstant = "Si te ha gustado, dale a LIKE"

        val mySecondConstant = myFirstVariable

        println(mySecondConstant)
    }

    /*
    Aquí vamos hablar de tipos de datos (data types)
     */
    private fun tiposDeDatos() {

        // String

        val myString: String = "Hola Miteris!"
        val myString2 = "Bienvenidos a MoureDev"
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


    /*
 Aquí vamos a hablar de los operadores Aritmeticas
  */
    private fun operacionesAritmeticas() {

/*        var a: Float = 10.5f
        var b: Int = 5
        var resultado = a + b
        println("SUMA: " + resultado)*/

        var a: Float = 10.5f
        var b: Int = 5
        var resultado: Int

        //Esto no funciona
        //resultado =  a + b

        //Esto sí
        resultado = a.toInt() + b
        println("SUMA: " + resultado)

    }

    /*
 Aquí vamos a hablar de los operadores Aritmeticas
  */
    private fun concatenacion() {

        //Concatenar sin el +
        val greeting = "Hola, me llamo"
        val name = "Roberto"
        println("$greeting $name")

        //Concatenacon compleja
        val introduction = "El resultado de"
        val plus = "más"
        val firstNumber = 2
        val secondNumber = 5
        println("$introduction $firstNumber $plus $secondNumber es: ${firstNumber + secondNumber}")


    }


    /*
    Aquí vamos a hablar de las funciones
     */
    fun showMyName() {
        println("Me llamo Roberto")
    }

    fun showMyLastName() {
        println("Mi Apellido es Paz")
    }

    fun showMyAge() {
        println("Tengo xx años")
    }


    fun showMyInformation(name: String, lastName: String, age: Int) {
        println("Me llamo $name $lastName y tengo $age años.")
    }


    fun add(firsNumber: Int, secondNumber: Int): Int {
        return firsNumber + secondNumber
    }


    // fun add(firsNumber: Int, secondNumber: Int): Int = firsNumber + secondNumber


/*
    // Funciones con un valor de retorno
    fun sumTwoNumbers(firstNumber: Int, secondNumber: Int): Int {
        val sum = firstNumber + secondNumber
        return sum

        println(add(10, add(5, 5)))


    }
*/


    /*
    Aquí vamos a hablar de la sentencia if
     */
    private fun sentenciaIf() {

        val myNumber = 71

        // Operadores condicionales
        // > mayor que
        // < menor que
        // >= (> =) mayor o igual que
        // <= (< =) menor o igual que
        // == (= =) igualdad
        // != (! =) desigualdad

        // Operadores lógicos
        // && operador "y"
        // || operador "o"
        // ! operador "no"

        //reutilizamos la funcion add
        var result = add(5, 10)
        if (result > 10) {
            println("El resultado es mayor que 10")
        }

        var name = "Aris"
        if (name == ("Aris")) {
            println("Se llama Aris")
        }

        var name2 = "Arístides"
        if (name2 == ("Aris")) {
            println("Se llama Aris")
        } else {
            println("No se llama Aris")
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

        animal = "dog"
        var raza = "labrador"

        //solo entrará si cumple ambas condiciones
        if (animal == "dog" && raza == "labrador") {
            println("Es un perro de raza labrador")
        }

        //Entrará si es verdadera una de las condiciones
        if (animal == "dog" || animal == "gato") {
            println("Es un perro o un gato")
        }
    }


    /*
    Aquí vamos a hablar de la sentencia when
     */
    fun sentenciaWhen() {


        // When sencillo
        var month = 9

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
            1, 2, 3 -> println("Primer trimestre del año")
            4, 5, 6 -> println("Segundo trimestre del año")
            7, 8, 9 -> println("Tercer trimestre del año")
            10, 11, 12 -> println("Cuarto trimestre del año")
        }

        when (month) {
            in 1..6 -> println("Primer semestre")
            in 7..12 -> println("Segundo semestre")
            !in 1..12 -> println("No es un mes válido")
        }

        val response: String = when (month) {
            in 1..6 -> "Primer semestre"
            in 7..12 -> "segundo semestre"
            !in 1..12 -> "no es un mes válido"
            else -> "error"
        }
        println(response)


        // When con String
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

        // When con Int
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

    /*
    Aquí vamos a hablar de arrays o arreglos
     */
    fun arrays() {

        //Array simple
        val weekDays =
            arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

        //println(weekDays)
        println(weekDays[0])
        println(weekDays.get(0))
        println(weekDays.get(1))
        println(weekDays.get(2))
        println(weekDays.get(3))
        println(weekDays.get(4))
        println(weekDays.get(5))
        println(weekDays.get(6))
        //  println(weekDays.get(7))  // que imprime esto??

        weekDays.set(0, "Horrible lunes") //Contenía Lunes
        weekDays.set(4, "Por fin viernes") //Contenía Viernes

        for (weekDay in weekDays) {
            println(weekDay)
        }

        for ((posicion, valor) in weekDays.withIndex()) {
            println("La posición $posicion contiene el valor $valor")
        }

        for (weekDay in weekDays) {
            println(weekDay)
        }

        weekDays.forEach {
            println(it)
        }

        println("--------")
        // Recorrer datos
        println(weekDays.first())
        println(weekDays.last())

        println("--------")
        weekDays.sort()
        weekDays.forEach {
            println(it)
        }
    }

    /*
    Aquí vamos a hablar de listas, también llamados diccionarios
    */
    fun listas() {

        //listas inmutables
        val readOnly: List<String> =
            listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

        println(readOnly.size)//Muestra el tamaño de la lista
        println(readOnly.get(3)) //Devuelve el valor de la posición 3
        println(readOnly.first()) //Devuelve el primer valor
        println(readOnly.last()) //Devuelve el último valor
        println(readOnly) //[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo]


        val a = readOnly.filter { it == "Lunes" || it == "Juernes" }
        println(a)





















        // listams mutables
        var mutableList: MutableList<String> = mutableListOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")
        println(mutableList) //[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado]
        mutableList.add("domingo")
        println(mutableList)

        mutableList.add(0, "Semana: ")
        println(mutableList)


        var mutableList2: MutableList<String> = mutableListOf()
        mutableList2.none() //Nos devuelve un true si está vacía la lista
        mutableList2.firstOrNull() //Nos devolverá el primer campo, y si no hay, un null.
        mutableList2.elementAtOrNull(2) //El elemento del índice 2, si no hay, devolverá un null
        mutableList2.lastOrNull() //Último valor de la lista o null


        for (item in mutableList) {
            println(item)
        }

        for ((indice, item) in mutableList.withIndex()) {
            println("La posición $indice contiene $item")
        }


        val newListEmpty: MutableList<String> = mutableListOf()
        mutableList.forEach {
            newListEmpty.add(it+":")
        }
        println(newListEmpty)

    }


    /*
    Aquí vamos a hablar de mapas, también llamados diccionarios
     */
    fun mapas() {

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
        // println(userSettings.getOrDefault("email", "Sin email")) // Sin email
        println(userSettings.isEmpty()) // false
        println("name" in userSettings) // true
        println("Español" in userSettings.values ) // true


        //Matas mutables
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
        //println(booksMap)


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

    /*
    Aquí vamos a hablar de loops, también llamados bucles
    */
    private fun loops() {

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

    /*
    Aquí vamos a hablar de seguridad contra nulos (Null Safety)
     */
    fun nullSafety() {

        //var a: String = "abc"

        //var a: String = "abc"
        //a = null // error de compilador

        var a: String? = "abc"
        a = null // el compilador lo permite
        println(a)

        val x: Int? = null
        //val h = x.toDouble()

        if (x != null) {
            val h = x.toDouble()
            println(h)
        }else{
            println("La variable es nula")
        }

        var z: String? = "abc"
        z = null // bien
        z?.length // NULL

        var y: String? = "abc"
        //y = null // bien
        y!!.length // NULLPointerException

        y = null
        val l = y?.length ?: -1
        println(l)
    }


    /*
    Aquí vamos a hablar de las clases
    */
    fun classes() {

        val brais = Programmer("Brais", 32, arrayOf(Programmer.Languaje.KOTLIN, Programmer.Languaje.SWIFT))
        println(brais.name) // añadir val para poder acceder a ellas

        brais.age = 40  // debemos cambiar val por var
        brais.code()

        val sara = Programmer("Sara", 35, arrayOf(Programmer.Languaje.JAVA))
        sara.code()

        val antonio = Programmer("ANTONIO", 33, arrayOf(Programmer.Languaje.PHP), arrayOf(brais))

        println("${antonio.friends?.first()?.name} es amigo de ${antonio.name}")
    }

}