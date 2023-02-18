using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Fondo : MonoBehaviour {

    //Declaro las variables necesarias
    [Range(0.05f,0.15f)]
    public float velocidad1, velocidad2, velocidad3;
    private GameObject fondo, colina11, colina12, colina21, colina22, colina31, colina32;
    private float anchoJuego;

    void Start () {

        //Capturo el objeto del fondo y, partir de sus límites (bounds) el ancho del juego
        fondo = GameObject.Find("Fondo");
        anchoJuego = fondo.GetComponent<SpriteRenderer>().bounds.extents.x * 2;

        //Capturo las 6 colinas implicadas
        colina11 = GameObject.Find("Colina 11");
        colina12 = GameObject.Find("Colina 12");
        colina21 = GameObject.Find("Colina 21");
        colina22 = GameObject.Find("Colina 22");
        colina31 = GameObject.Find("Colina 31");
        colina32 = GameObject.Find("Colina 32");
    }
    
    void Update () {

        //COLINA 1
        //Calculo el vector de movimiento en X en base a la velocidad y el deltaTime
        Vector2 movimiento1 = new Vector2(Time.deltaTime * velocidad1, 0);

        //Muevo las dos copias de Colina 1 con ese vector
        colina11.transform.Translate(movimiento1);
        colina12.transform.Translate(movimiento1);

        //Si la colina 11 se sale completamente de la escena por la derecha, la recoloco a la izquierda de colina 12
        if (colina11.transform.position.x > anchoJuego)
        {
            colina11.transform.position = new Vector2(-anchoJuego + 0.01f, colina11.transform.position.y);
        }


        //Si la colina 12 se sale completamente de la escena por la derecha, la recoloco a la izquierda de colina 11
        if (colina12.transform.position.x > anchoJuego)
        {
            colina12.transform.position = new Vector2(-anchoJuego + 0.01f, colina12.transform.position.y);
        }


        //COLINA 2
        //Calculo el vector de movimiento en X en base a la velocidad y el deltaTime
        Vector2 movimiento2 = new Vector2(-Time.deltaTime * velocidad2, 0);

        //Muevo las dos copias de Colina 2 con ese vector
        colina21.transform.Translate(movimiento2);
        colina22.transform.Translate(movimiento2);

        //Si la colina 21 se sale completamente de la escena por la izquierda, la recoloco a la derecha de colina 22
        if (colina21.transform.position.x < -anchoJuego)
        {
            colina21.transform.position = new Vector2(anchoJuego - 0.01f, colina21.transform.position.y);
        }

        //Si la colina 22 se sale completamente de la escena por la izquierda, la recoloco a la derecha de colina 21
        if (colina22.transform.position.x < -anchoJuego)
        {
            colina22.transform.position = new Vector2(anchoJuego - 0.01f, colina22.transform.position.y);
        }


        //COLINA 3
        //Calculo el vector de movimiento en X en base a la velocidad y el deltaTime
        Vector2 movimiento3 = new Vector2(Time.deltaTime * velocidad3, 0);

        //Muevo las dos copias de Colina 32 con ese vector
        colina31.transform.Translate(movimiento3);
        colina32.transform.Translate(movimiento3);

        //Si la colina 31 se sale completamente de la escena por la derecha, la recoloco a la izquierda de colina 32
        if (colina31.transform.position.x > anchoJuego)
        {
            colina31.transform.position = new Vector2(-anchoJuego + 0.01f, colina31.transform.position.y);
        }

        //Si la colina 32 se sale completamente de la escena por la derecha, la recoloco a la izquierda de colina 31
        if (colina32.transform.position.x > anchoJuego)
        {
            colina32.transform.position = new Vector2(-anchoJuego + 0.01f, colina32.transform.position.y);
        }
    }
}

