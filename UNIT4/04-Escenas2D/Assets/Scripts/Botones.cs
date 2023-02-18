using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class Botones : MonoBehaviour {


    //Objeto Game Manager
    private GameManager gameManager;
    //Botones
    public Button botonInicio, botonJugar, botonOpciones, botonCreditos, botonSalir;


    void Start () {


        //Busco mi objeto Game Manager
        gameManager = FindObjectOfType<GameManager>();


        //Añado al botonInicio la acción a ejecutar al hacer clic (cambiar a la escena Inicio desde el Game Manager)
        if (botonInicio){
            botonInicio.GetComponent<Button>().onClick.AddListener(() => gameManager.cambiarEscena("Inicio"));
        }


        //Añado al botonJugar la acción a ejecutar al hacer clic (cambiar a la escena Jugar desde el Game Manager)
        if (botonJugar){
            botonJugar.GetComponent<Button>().onClick.AddListener(() => gameManager.cambiarEscena("Jugar"));
        }


        //Añado al botonOpciones la acción a ejecutar al hacer clic (cambiar a la escena Opciones desde el Game Manager)
        if (botonOpciones){
            botonOpciones.GetComponent<Button>().onClick.AddListener(() => gameManager.cambiarEscena("Opciones"));
        }


        //Añado al botonCreditos la acción a ejecutar al hacer clic (cambiar a la escena Creditos desde el Game Manager)
        if (botonCreditos){
             botonCreditos.GetComponent<Button>().onClick.AddListener(() =>gameManager.cambiarEscena("Creditos"));
        }


        //Añado al botonSalir la acción a ejecutar al hacer clic (salir de la aplicación)
        //Este botón no funcionará en el Editor de Unity, pero si al hacr el Build del Juego.
        if (botonSalir){
            botonSalir.GetComponent<Button>().onClick.AddListener(() => Application.Quit());
        }
    }
}