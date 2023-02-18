using System.Collections;
using UnityEngine;

public class Jugador : MonoBehaviour {

    //1. Declaración de variables
    [Range(1, 10)] public float velocidad; //Velocidad del jugador
    Rigidbody2D rb2d;
    SpriteRenderer spRd;


    /*** AÑADIR EN LA DECLARACIÓN DE VARIABLES ***/
    private Animator animator; //Para campturar el componente Animator del Jugador



    /**** AÑADIR EN LA DECLARACIÓN DE VARIABLES ****/
    bool isJumping = false; //Para comprobar si ya está saltando
    [Range(1, 500)] public float potenciaSalto; //Potencia de salto del jugador


    void Start () {
       //2. Capturo y asocio los componentes Rigidbody2D y Sprite Renderer del Jugador
       rb2d = GetComponent<Rigidbody2D>();
       spRd = GetComponent<SpriteRenderer>();

        /*** AÑADIR EN EL MÉTODO START  ***/
        //Capturo y asocio el componente Animator del Jugador
        animator = GetComponent<Animator>();


    }
    
    void FixedUpdate () {

       //3. Movimiento horizontal
       float movimientoH = Input.GetAxisRaw("Horizontal");
       rb2d.velocity = new Vector2(movimientoH * velocidad, rb2d.velocity.y);

       //4. Sentido horizontal (para girar el render del jugador)
       if (movimientoH > 0)
       {
           spRd.flipX = false;
       }
       else if (movimientoH < 0)
       {
           spRd.flipX = true;
       }


       /**** AÑADIR EN FIXED UPDATE ****/
       //Si pulso la tecla de salto (espacio) y no estaba saltando
       if (Input.GetButton("Jump") && !isJumping)
       {
           //Le aplico la fuerza de salto
           rb2d.AddForce(Vector2.up * potenciaSalto);
           //Digo que está saltando (para que no pueda volver a saltar)
           isJumping = true;
        }


        /*** AÑADIR EN EL MÉTODO FIXED UPDATE ***/
        //Animación de andar
        if (movimientoH != 0)
        {
           animator.SetBool("isWalking", true); //Si se está moviendo, reproduzco la animación
        }
        else
        {
            animator.SetBool("isWalking", false); //Si no, la paro
        }


        /*** AÑADIR EN EL MÉTODO FIXED UPDATE ***/
        //Atacar
        if (Input.GetButton("Fire1"))
        {
           animator.SetBool("isAttacking", true); //SI pulsa el botón de disparo, ataco
        }
        else
        {
           animator.SetBool("isAttacking", false); //Si no, dejo de atacar
        }

   }

   /**** AÑADIR COMO NUEVO MÉTODO (ANTES DE LA ÚLTIMA LLAVE DE CIERRE } DE LA CLASE ****/
   private void OnCollisionEnter2D(Collision2D other)
    {
        //Si el jugador colisiona con un objeto con la etiqueta suelo
        if (other.gameObject.CompareTag("Suelo"))
        {
            //Digo que no está saltando (para que pueda volver a saltar)
            isJumping = false;
            //Le quito la fuerza de salto remanente que tuviera
            rb2d.velocity = new Vector2(rb2d.velocity.x, 0);
        }
    }


    /**** AÑADIR COMO NUEVO MÉTODO (ANTES DE LA ÚLTIMA LLAVE DE CIERRE } DE LA CLASE ****/
    private void OnTriggerEnter2D(Collider2D other)
    {
       //Si el jugador pisa  un objeto con la etiqueta trampa
       if (other.gameObject.CompareTag("Trampa"))
       {
           //Reproduzco la animación de morir
           animator.SetBool("isDead", true);
       }
    }


}