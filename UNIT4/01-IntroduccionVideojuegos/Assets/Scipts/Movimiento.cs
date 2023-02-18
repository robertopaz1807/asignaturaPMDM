using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movimiento : MonoBehaviour
{
   //Declaro una variable para la velocidad de movimiento (Serialized para verla en la Inspector window)
   [SerializeField] private float velocidad = 15;

   // Update is called once per frame
   void Update()
   {
       //Capturo el movimiento de los ejes
       float h = Input.GetAxisRaw("Horizontal");
       float v = Input.GetAxisRaw("Vertical");

       //Construyo el vector de movimiento
       Vector2 movimiento = new Vector2(h, v);

       //Aplico ese movimiento al rigidbody del sprite (multiplicado por la velocidad)
       GetComponent<Rigidbody2D>().velocity = movimiento * velocidad;
   }
}


