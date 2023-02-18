using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Colision : MonoBehaviour
{
    /*
     * Este método se ejecuta cuando dos objetos que tienen Collider (y al menos uno de ellos Rigidbody) entran en
     * contacto el uno con el otro.
     * La variable other, de tipo Collision2D, tiene información acerca de la colisión, tal como el nombre del objeto
     * con el que me he chocado, el instante y el lugar en el que ha ocurrido.
     */
    private void OnCollisionEnter2D(Collision2D other)
    {
        /*
         * La instrucción Debug.Log me permite escribir un mensaje por la consola, de forma que dentro de los 
         * paréntesis y ente comillas, escribiré el texto que quiero mostrar. Además, si quiero añadir el valor 
         * de una variable a dicho texto, la encadeno con el símbolo +
         *
         * Una variables es un dato que almaceno en el juego para identificar cualquier tipo de valor: una velocidad,
         * el número de vidas, el tiempo transcurrido, un objeto, su nombre, el tipo de colisión, una caja de texto,
         * un color, etc.
         */
        Debug.Log("Se ha producido una colisión");
        Debug.Log("Yo soy " + gameObject.name); //gameObject.name es el nombre del objeto que tiene este script
        Debug.Log("Me he chocado con " + other.gameObject.name); 
                      //other.gameObject.name es el nombre del objeto con el que me he chocado

        //Cambio el color del objeto que tiene este script
        GetComponent<SpriteRenderer>().color = Color.magenta;

        //Cambio el color al objeto con el que me he chocado
        other.gameObject.GetComponent<SpriteRenderer>().color = Color.cyan;
    }
}