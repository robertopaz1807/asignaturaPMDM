using System.Collections;
using UnityEngine;

public class Estrella : MonoBehaviour {

    //Declaro las variables necesarias
    [Range(5f, 15f)]
    public float velocidad;
    Material material;

    void Start () {

        //Capturo el material de la estrella
        material = GetComponent<SpriteRenderer>().material;
    }
    
    void Update () {

        //Llamo a la rutina que cambia la opacidad de forma continua
        StartCoroutine(Opacidad(1, 0.5f));
    }


    //Cambio opacidad con fade in/out
    private IEnumerator Opacidad(float opacidadIn, float opacidadOut)
    {
        //Fade out
        material.color = new Color(material.color.r, material.color.g, material.color.b, opacidadIn); 
        //opacidad inicial
        while (material.color.a >= opacidadOut)
        {
            //Voy decrementando la opacidad hasta llegar a opacidad final
            material.color = new Color(material.color.r, material.color.g, material.color.b, material.color.a - velocidad * Time.deltaTime);
            yield return null;
        }

        //Fade in
        material.color = new Color(material.color.r, material.color.g, material.color.b, opacidadOut); 
        //opacidad final
        while (material.color.a <= opacidadIn)
        {
            //Voy incrementando la opacidad hasta llegar a opacidad inicial
            material.color = new Color(material.color.r, material.color.g, material.color.b, material.color.a + velocidad * Time.deltaTime);
            yield return null;
        }
    }
}