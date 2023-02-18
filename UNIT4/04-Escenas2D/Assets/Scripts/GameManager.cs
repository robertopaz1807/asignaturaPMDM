using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour {

    //Objeto GameManager
    private GameObject gameManager;

    void Start () {
        
        //Busco el objeto llamado GameManager
        GameObject gameManager = GameObject.Find("GameManager");


        //Le indico que no se destruya al cargar otra escena 
        DontDestroyOnLoad(gameManager);


        //Cargo la escena de inicio
        SceneManager.LoadScene("Inicio");
    }

    public void cambiarEscena(string nombreEscena){
        SceneManager.LoadScene(nombreEscena);
    }

}