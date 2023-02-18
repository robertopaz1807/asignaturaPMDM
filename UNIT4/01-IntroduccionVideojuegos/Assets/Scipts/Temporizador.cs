using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Temporizador : MonoBehaviour
{
   //Declaración de variables
   [SerializeField] private Text textoTiempo;
   private float tiempo = 60; //1 minuto en segundos
  
   // Update is called once per frame
   void Update()
   {
       //Decremento el tiempo transcurrido
       tiempo -= Time.deltaTime; //Le quita a la variable tiempo el tiempo de un frame
       //Actualizo la caja de texto del tiempo
       textoTiempo.text = FormatearTiempo(tiempo);

        /* Llamada añadida para cambio de color */
        //Compuebo el color que le toca
        ColorTexto(tiempo);
   }
  
   string FormatearTiempo(float tiempo){

       //Formateo minutos y segundos a dos dígitos
       string minutos = Mathf.Floor(tiempo / 60).ToString("00");
       string segundos = Mathf.Floor(tiempo % 60).ToString("00");
  
       //Devuelvo el string formateado con : como separador
       return minutos + ":" + segundos;
   }


   /* función añadida al final de la clase, para el cambio de color */
    void ColorTexto(float tiempo)
   {
       //Si llega a 0
       if (tiempo < 1)
       {
           //Color rojo
           textoTiempo.color = Color.red;
           //Parar el tiempo
           Time.timeScale = 0;
           //Me aseguro de que no haya valores negativos
           tiempo = 0;
       }
       else if (tiempo <= 10)
       {
           //Color naranja (RGB 255, 127, 0)
           textoTiempo.color = new Color(1, 0.5f, 0);
       }
   }


}


