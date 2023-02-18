using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Estas tres primeras líneas son librerías que utiliza Unity para diferentes funcionalidades, tales como propiedades
 * físicas, operaciones matemáticas, funciones comunes, fecha, hora, etc.
 *
 * Pondremos comentarios  /* Asi */ 
 // o de una sola linea 
 //Si escribes la palabra todo, el editor entiende que es algo por hacer (to do en inglés) y te cambiará el color.

/* Todos los scripts de Uni empezarán siempre con public class, seguido del nombre del script, que tiene que ser  
 * IDÉNTICO al nombre del fichero (sin la extensión).
 *
 * A continuación, veremos que por defecto aparece : MonoBehaviour, que significa que este script o clase hereda de
 * una clase superior una serie de propiedades comunes. 
 */


public class Informacion : MonoBehaviour
{
    /*
     * Start es una función o método por defecto incluido en todos los scripts de Unity
     *
     * Un método es una pieza de código que se ejecuta cuando lo solicita el programador, o que se ejecuta
     * automáticamente en un momento determinado por el programa.
     *
     * Por ejemplo, el método Start se ejecutará siempre en el primer frame tras darle al Play y que se cargue la escena
     * en la que se encuentre el objeto que contiene el script, y ya no se volverá a ejecutar.
     *
     * El método Start se utiliza para asignar valores al arrancar el juego, inicializar contadores, 
     * buscar dependencias, etc.
     *
     * Antes del nombre del método, hay una palabra reservada que indica qué tipo de valor devuelve esa función.
     * Por ejemplo, este método Start no devuelve nada, por eso se utiliza la palabra void, pero nos encontraremos
     * métodos que devuelven textos (string), núemeros enteros (int), decimales (float) u otro tipo de datos.
     *
     * Si antes de la palabra reservada void no se escribe nada, se entiende que el método es privado (se escribiría la
     * palabra private, que no es obligatoria), y quiere decir que solo se usa en este script y no se puede acceder a él
     * desde otro sitio.
     *
     * Por el contrario, si delante de void escribiéramos la palabra public, el método podría estar accesible desde 
     * otros scripts, tal y como necesitaremos más adelante para mejorar la interactividad de nuestros juegos. 
     */

    void Start()
    {
        
    }

      /*
     * Update es otra función o método por defecto incluido en todos los scripts de Unity, y se ejecuta una vez 
     * cadaframe del juego (normalmente 60 veces por segundo si el juego es a 60fps)
     *
     * Este método se utiliza para gestionar la física del juego, el tiempo, los movimientos y, en general, aquello 
     * que puede ocurrir durante el juego pero que no sabemos en qué momento se va a producir (por ejemplo, a 
     * priori no sabemoscuándo el usuario va a pulsar las teclas de movimiento)
     */

    void Update()
    {
        
    }
}
