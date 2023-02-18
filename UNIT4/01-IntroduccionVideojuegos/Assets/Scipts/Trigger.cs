using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Trigger : MonoBehaviour
{
   //Se dispara cuando un objeto entra en un collider con la propiedad Is Trigger activada
   private void OnTriggerEnter2D(Collider2D other)
   {
       //Digo como se llama el objeto que tiene este script
       Debug.Log("Yo soy " + gameObject.name);
      
       //Digo como se llama el objeto que ha atravesado
       Debug.Log("He atravesado a " + other.gameObject.name);
      
       //Oculto el objeto que he atravesado
       other.gameObject.SetActive(false);
      
   }
}

