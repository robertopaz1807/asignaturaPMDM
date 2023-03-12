using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Disparador : MonoBehaviour {

    //Declaro la variable oculta para capturar el objeto a acoultar/mostrar
    public GameObject oculta;

    void Start () {
        //Oculto la plataforma al arrancar el juego
        oculta.SetActive(false);
    }

    //Se ejecuta al colisionar con el objeto
    void OnCollisionEnter (Collision colision){

       if(colision.gameObject.name == "Jugador"){
           //Muestro la plataforma
            oculta.SetActive(true);
       }
   }
}