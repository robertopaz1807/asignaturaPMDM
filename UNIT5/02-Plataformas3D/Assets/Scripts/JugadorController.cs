using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/* Añadir en las librerías que se importan al principio del script */
using UnityEngine.UI;



public class JugadorController : MonoBehaviour {

    //Declaro la variable de tipo RigidBody que luego asociaremos a nuestro Jugador
    private Rigidbody rb;

    //Declaro la variable pública velocidad para poder modificarla desde la Inspector window
    [Range(1,10)]
    public float velocidad = 5;

    /* Añade esta línea en la declaración de veriables */
    //Declaro la variable pública salto para poder modificarla desde la Inspector window
    [Range(1,10)]
    public float salto = 7;

    /* Añadir en la declaración de variables de JugadorController */
    //Límite en Y del Suelo
    int limiteSuelo = 0;
    //Script GameManager
    private GameManager gameManager;
    //Variable para asociar el objeto Texto Vidas
    public Text textoVidas;
    //variable para la posición inicial del jugador
    Vector3 posicionInicial;

    /* Añadir en la declaración de variables */
    //Variable para asociar el objeto Mensajes
    public Text textoMensajes;

    /* Añadir a la declaración de variables */
    //Variable para asociar el objeto Texto Monedas (que mostrará las monedas restantes)
    public Text textoMonedas;

    /* Añadir en la declaración de variables */
    //Variables para contar y activar el tiempo transcurrido de salto extra e incrementar la potencia
    float tiempoSalto = 0;
    bool isSaltoExtra = false;
    int saltoExtra = 3;

    /* Añadir en la declaración de variables */
    //Variable para el sistema de partículas
    public ParticleSystem particulas;

    /* Añadir en la declaración de variables */
    //Booleano para no asignar más de una vida
    bool isVida = false;

    /* Añadir a la declaración de variables */
    //Array o lista de Audio Sources
    public AudioSource audioSalto, audioMoneda, audioSaltoExtra, audioPerderVida, audioGanarVida, audioFinGanar, audioFinPerder;

    void Start () {
        //Capturo el rigidbody del jugador al iniciar el juego
        rb = GetComponent<Rigidbody>();


        /* Añadir en el método Start() */
        //Busco y asocio mi script de GameManager
        gameManager = FindObjectOfType<GameManager>();
        //Inicializo el texto del contador de vidas
        textoVidas.text = "Vidas: " + gameManager.vidas;
        //Capturo la posición inicial del jugador para cuando pierda una vida poder reposicionarlo
        posicionInicial = transform.position;

        /* Añadir en el método Start() */
        //Inicio el texto de mensajes a vacío
        textoMensajes.text = "";

        /* Añadir en el método Start() */
        //Inicializo el texto del contador de monedas
        textoMonedas.text = "Monedas: " + gameManager.monedas;

        /* Añadir en el método Start() */
        //Paro el sistema de partículas del jugador
        particulas.Stop();

        /* Añadir dentro del método Start() */
        //Capturo e inicializo todos los audioSources (es un array de arriba a abajo)
    //    audioSources = GetComponents<AudioSource>();

    //    Debug.Log("Audio: "+audioSources.Length);

    //    audioSalto = audioSources[0];
    //    audioMoneda = audioSources[2];
    //    audioSaltoExtra = audioSources[3];
    //    audioPerderVida = audioSources[4];
    //    audioGanarVida = audioSources[5];
    //    audioFinGanar = audioSources[6];
    //    audioFinPerder = audioSources[6];


    }
    
    /* Sustituir el método FixedUpdate() por el siguiente */
    void FixedUpdate () {

        //Si quedan vidas y monedas, sigue el juego
        if (gameManager.vidas > 0 && gameManager.monedas > 0){

            //Muevo el jugador (si tiene vidas)
            moverJugador();
            //Si ha caído por debajo del suelo, le quito una vida
            if (transform.position.y < limiteSuelo) quitarVida();

            /* Añadir en el método FixedUpdate(), dentro del condicional if que se ejecuta mientars estoy jugando */
            //Compruebo si tiene potencia de salto extra
            if (isSaltoExtra){
                //Incremento tiempo
                tiempoSalto += Time.deltaTime;

                //Compruebo si llega a 10 segundos
                if (tiempoSalto >= 10){
                    salto -= saltoExtra; //Asigno la potencia de salto original
                    tiempoSalto = 0; //Reseteo el contador de tiempo de salto extra
                    isSaltoExtra = false; //Asigno el boole<no de salto extra a false

                    /* Añadir en el método FixedUpdate() justo después de la línea isSaltoExtra = false; */
                    particulas.Stop(); //Paro el sistema de partículas del jugador
                }
            }


            /* Añadir en el método FixedUpdate(), dentro del condicional if que se ejecuya mientras estoy jugando */
            //Compruebo si tengo que añadirle una vida
            if (!isVida && gameManager.monedas <= 5 && gameManager.tiempo <= 30){
                gameManager.vidas++; //Añado una vida
                isVida = true; //Para añadir solo una vida y que ya no añada más
                /* Añadir dentro de FixedUpdate(), justo después de la línea if (!isVida && gameManager.monedas <= 5 && gameManager.tiempo <= 30){ */
                audioGanarVida.Play(); //Reproduzco el audio de ganarVida
            }

        }
        //Si no quedan vidas, pierde
        else if (gameManager.vidas == 0){
            //Muestro mensaje (si no tiene vidas)
            textoMensajes.text = "Juego Terminado";
            //Pongo isJuego a false para que deje de contar el script Tiempo
            gameManager.isJuego = false;
            /* Añadir dentro de FixedUpdate(), justo después de la línea else if (gameManager.vidas == 0){ */
            //Reproduzco el audio de finPerder
            audioFinPerder.Play();
        }
        //Si no quedan monedas, gana
        else if (gameManager.monedas == 0){
            //Muestro mensaje (si ha completado el juego)
            textoMensajes.text = "¡Has completado el juego!";
            textoMensajes.color = new Color(0, 255, 0); //Color verde
            //Pongo isJuego a false para que deje de contar el script Tiempo
            gameManager.isJuego = false;
            /* Añadir dentro de FixedUpdate(), justo después de la línea else if (gameManager.monedas == 0){ */
            //Reproduzco el audio de finGanar
            audioFinGanar.Play();
        }
    }


    /* Añade el siguiente método al final del script, antes de la llave final } que cierra la clase */
    //Compruebo si el jugador está en el suelo antes de saltar (para que no vuele)
    private bool isSuelo(){

        //Genero el array de colisiones de la esfera/jugador pasando su centro y su radio
        Collider[] colisiones = Physics.OverlapSphere(transform.position, 0.5f);
        //Recorro ese array y si está colisionando con el suelo devuelvo true
        foreach (Collider colision in colisiones){
            if (colision.tag == "Suelo"){
                return true;
            }
        }
        return false;
    }


    /* Añadir este método al final de la clase (antes de la llave } de cierre) */
    //Quito una vida y muevo al jugador a la posición inicial
    void quitarVida(){
         //Resto una vida
         gameManager.vidas--;
         //Actualizo el contador de vidas
         textoVidas.text = "Vidas: " + gameManager.vidas;
         //Devuelvo el Jugador a su posición inicial y le quito la fuerza
         transform.position = posicionInicial;
         rb.velocity = Vector3.zero;
         /* Añadir al inicio (pero dentro) del método quitarVida() */
        //Reproduzco el audio de perderVida
        audioPerderVida.Play();
    }


    /* Añadir el método moverJugador() antes de la llave de cierre } de la clase */
    //Lógica necesaria para mover al jugador
    void moverJugador(){

        //Capturo el movimiento en horizontal y vertical de nuestro teclado
        float movimientoH = Input.GetAxis("Horizontal");
        float movimientoV = Input.GetAxis("Vertical"); 

        //Genero el vector de movimiento asociado, teniendo en cuenta la velocidad
        Vector3 movimiento = new Vector3(movimientoH * velocidad, 0.0f, movimientoV * velocidad);
        
        //Aplico ese movimiento al RigidBody del jugador
        rb.AddForce(movimiento);

        //Si pulsa el botón de saltar y está en el suelo
        if (Input.GetButton("Jump") && isSuelo()){
            //Aplico el movimiento vertical con la potencia de salto
            rb.velocity += Vector3.up * salto;
            //Reproduzco el audio de saltar
            audioSalto.Play();
        }
    }


    /* Añadir al final de la clase para recoger las monedas (antes de la llave } final de cierre de clase */
    //Se ejecuta al entrar a un objeto con la opción isTrigger seleccionada
    void OnTriggerEnter(Collider other) {

        if (other.gameObject.CompareTag ("Moneda")){
           //Desactivo el objeto
           other.gameObject.SetActive (false);
           //Decremento el contador de monedas en uno (también se puede hacer como monedas = monedas -1)
           gameManager.monedas--;
           //Actualizo el texto del contador de monedas
           textoMonedas.text = "Monedas: " + gameManager.monedas;
           //Reproduzco el audio de la moneda
            audioMoneda.Play();
        }

        /* Añadir en el método OnTriggerEnter() justo después del if que compara con el tag "Moneda"*/
        else if (other.gameObject.CompareTag ("Capsula")){
            //Desactivo el objeto
            other.gameObject.SetActive (false);
            //Incremento potencia de salto
            salto += saltoExtra;
            //Activo el booleano isSaltoExtra
            isSaltoExtra = true;
            /* Añadir en el método OnTriggerEnter() justo después de la línea isSaltoExtra = true; */
            //Inicio el sistema de partículas del jugador
            particulas.Play();
            //Reproduzco el audio de saltoExtra
            audioSaltoExtra.Play();

        }
    }
}