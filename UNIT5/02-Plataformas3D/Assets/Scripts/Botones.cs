using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Botones : MonoBehaviour
{
   //1. Declaración de variables
   private GameManager gameManager;
   //Referencias a los botones (public para poder asignarlas en la Inspector window)
   public Button BotonInicio, BotonJugar, BotonOpciones, BotonCreditos, BotonSalir;
   // Start is called before the first frame update
   void Start()
   {
       //2. Busco y asocio mi script de GameManager
       gameManager = FindObjectOfType<GameManager>();
      
       //3. Acciones de cada botón
       //Botón inicio (si existe)
       if (BotonInicio)
       {
           //Le añado la acción a ejecutar (cambiar a la escena de Inicio)
           BotonInicio.GetComponent<Button>().onClick.AddListener(() => gameManager.cambiarEscena("Inicio"));
       }
      
       //Botón jugar (si existe)
       if (BotonJugar)
       {
           //Le añado la acción a ejecutar (cambiar a la escena de Jugar)
           BotonJugar.GetComponent<Button>().onClick.AddListener(() => gameManager.cambiarEscena("Jugar"));
       }
      
       //Botón opciones (si existe)
       if (BotonOpciones)
       {
           //Le añado la acción a ejecutar (cambiar a la escena de Opciones)
           BotonOpciones.GetComponent<Button>().onClick.AddListener(() => gameManager.cambiarEscena("Opciones"));
       }
      
       //Botón creditos (si existe)
       if (BotonCreditos)
       {
           //Le añado la acción a ejecutar (cambiar a la escena de Creditos)
           BotonCreditos.GetComponent<Button>().onClick.AddListener(() => gameManager.cambiarEscena("Creditos"));
       }
      
       //Botón salir (si existe)
       if (BotonSalir)
       {
           //Le añado la acción a ejecutar (salir del juego)
           //Este botón no funcionará en el Editor de Unity, pero sí al hacer la Build
           BotonSalir.GetComponent<Button>().onClick.AddListener(() => Application.Quit());
       }
   }
}