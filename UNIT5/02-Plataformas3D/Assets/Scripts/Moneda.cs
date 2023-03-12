using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Moneda : MonoBehaviour {

    void Update () {

        //Rota la moneda una cantidad diferente en cada dirección y en cada intervalo de tiempo
        transform.Rotate(new Vector3(0,0,90) * Time.deltaTime);
    }
}