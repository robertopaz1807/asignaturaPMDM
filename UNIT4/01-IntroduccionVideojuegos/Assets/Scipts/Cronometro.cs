using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Cronometro : MonoBehaviour
{
   //Declaración de variables
   [SerializeField] private Text textoTiempo;
   private float tiempo = 0;
  
   // Update is called once per frame
   void Update()
   {
       //Incremento el tiempo transcurrido
       tiempo += Time.deltaTime; //Le añade a la variable tiempo el tiempo de un frame
       //Actualizo la caja de texto del tiempo
       textoTiempo.text = FormatearTiempo(tiempo);
   }
  
   string FormatearTiempo(float tiempo){

       //Formateo minutos y segundos a dos dígitos
       string minutos = Mathf.Floor(tiempo / 60).ToString("00");
       string segundos = Mathf.Floor(tiempo % 60).ToString("00");
  
       //Devuelvo el string formateado con : como separador
       return minutos + ":" + segundos;
   }
}