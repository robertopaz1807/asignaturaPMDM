using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class JugadorController : MonoBehaviour {

    //Declaro la variable de tipo RigidBody que luego asociaremos a nuestro Jugador
    private Rigidbody rb;

    //Declaro la variable pública velocidad para poder modificarla desde la Inspector window
    public float velocidad;

    /** AÑADIR EN LA DECLARACIÓN DE VARIABLES **/
    public float velocidadSalto = 10; //Velocidad de salto

    //Declaro la variable para las animaciones
    private Animator animator;

    //contar tiempo transcurrido andando
    private float tiempoAndar;

    //Variable para capturar el BoxCollider (antes del Start)
    BoxCollider boxCollider;



    void Start () {
        //Capturo esa variable al iniciar el juego
        rb = GetComponent<Rigidbody>();

        //Capturo el componente Animator del Jugador en el método Start()
        animator = GetComponent<Animator>();

       //Capturo el componente boxCollider del Jugador al empezar el juego
       boxCollider = GetComponent<BoxCollider>();
    }
    
    // Update is called once per frame
    void FixedUpdate () {
        //Estas variables nos capturan el movimiento en horizontal y vertical de nuestro teclado
        float movimientoH = Input.GetAxis("Horizontal");
        float movimientoV = Input.GetAxis("Vertical");

        //Un vector 3 es un trío de posiciones en el espacio XYZ, en este caso el que corresponde al movimiento
        Vector3 movimiento = new Vector3(movimientoH, 0, movimientoV);

        //Asigno ese movimiento o desplazamiento al objeto, con su velocidad
        //transform.position += movimiento * velocidad;

        //Saltar
        if (Input.GetButton("Jump") && isSuelo())
        {
              rb.velocity += Vector3.up * velocidadSalto;
              animator.SetBool("isJumping", true);
        }

        //Si está cayendo
        if (rb.velocity.y < 0) 
        {
             animator.SetBool("isJumping", false);
        }


        //Rotar
        //if (movimiento != Vector3.zero)
        //{
        //    transform.rotation = Quaternion.Slerp(transform.rotation, Quaternion.LookRotation(movimiento), 0.15f);
        //}

        //Añade Animación de andar al final del método FixedUpdate():
        if (movimiento != Vector3.zero){
            animator.SetBool("isWalking", true);
        }else{
            animator.SetBool("isWalking", false);
        }


        //Correr con boton
        if (Input.GetButton("Fire3") && movimiento != Vector3.zero)
        {
                velocidad = 0.6f;
                animator.SetBool("isRunning", true);
        }
        else
        {
                velocidad = 0.2f;
                animator.SetBool("isRunning", false);
        }

        //Correr por tiempo
        if(movimientoH != 0 && velocidad == 0.2f || movimientoV != 0 && velocidad == 0.2f)
        {
            tiempoAndar += Time.deltaTime;
            if (tiempoAndar >= 3.0f)
            {
                velocidad = 0.6f;
                animator.SetBool("isRunning", true);
            }
        }

        //Detectar cuando deja de moverse
        if (movimiento == Vector3.zero && !Input.GetButton("Fire3"))
        {
                velocidad = 0.2f;
                animator.SetBool("isRunning", false);
                tiempoAndar = 0.0f;
        }

        //Pegar
        if (Input.GetButton("Fire1"))
        {
                velocidad = 0;
                animator.SetBool("isPunching", true);
        }
        else
        {
                animator.SetBool("isPunching", false);
        }

        //Trabajar
        if (Input.GetButton("Fire2"))
        {
                velocidad = 0;
                animator.SetBool("isWorking", true);
                animator.SetBool("isWalking", false);
                animator.SetBool("isRunning", false);
        }
        else
        {
                animator.SetBool("isWorking", false);
        }

        //Asigno el movimiento (si no está pegando o trabajando)
        if (!Input.GetButton("Fire1") && !Input.GetButton("Fire2"))
        {
            transform.position += movimiento * velocidad;
        }

        //Rotar (si no está pegando o trabajando)
        if (!Input.GetButton("Fire1") && !Input.GetButton("Fire2"))
        {
            if (movimiento != Vector3.zero)
            {
                transform.rotation = Quaternion.Slerp(transform.rotation, Quaternion.LookRotation(movimiento), 0.15f);
            }
        }
    }    

    /** AÑADIR COMO NUEVO MÉTODO **/
    private bool isSuelo(){
        return Physics.Raycast(transform.position, -Vector3.up, 0.9f); 
    }

    //Morir: Se ejecuta al entrar a un objeto con la opción isTrigger seleccionada
    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Trampa"))
        {
            //Reproduzco la animación de morir
            animator.SetBool("isDead", true);
            StartCoroutine(cambiarCollider());
            //Deshabilito el script para que ya no se mueva más
            GetComponent<JugadorController>().enabled = false;
        }

         //Si toca la caja
        if (other.gameObject.CompareTag("Caja")){
        
            //Si está pulsando el botón de pegar
            if (Input.GetButton("Fire1")){
                //Capturo el sistema de partículas de la caja y lo reproduzco
                other.gameObject.GetComponent<ParticleSystem>().Play();
                //Oculto objeto tras un tiempo
                StartCoroutine(ocultarObjeto(other.gameObject));
            }
            else{
                //Reproduzco la animación de morir
                animator.SetBool("isDead", true);
                //Corutina para cambiar el Collider
                StartCoroutine(cambiarCollider());
                //Deshabilito el script par aque ya no se mueva más
                GetComponent<JugadorController>().enabled = false;
            }
        }
    }

    //Esperar
    IEnumerator ocultarObjeto(GameObject objeto){
        
        //Espero 1 segundos
        yield return new WaitForSeconds(1.0f);

        //Oculto objeto
        objeto.SetActive(false);
    }

    //Cambiar tamaño del collider tras un tiempo
    IEnumerator cambiarCollider()
    {
        //Espero 2 segundos
        yield return new WaitForSeconds(2.0f);

        //Cambio el tamaño del collider para que se apoye en el suelo
        boxCollider.size = new Vector3(boxCollider.size.x, 0.66f, boxCollider.size.z);
    }

    //Cambiar tamaño del collider tras un tiempo de forma gradual
    private IEnumerator cambiarColliderGradual()
    {
        //Espero 2 segundos
        yield return new WaitForSeconds(2.0f);
        //Valor final
        float valorFinal = 0.66f;
        while (boxCollider.size.y > valorFinal)
        {
            //Voy bajando el tamaño del size en y
            boxCollider.size -= new Vector3(0, 50 * Time.deltaTime, 0);
            yield return null;
        }
    }




}