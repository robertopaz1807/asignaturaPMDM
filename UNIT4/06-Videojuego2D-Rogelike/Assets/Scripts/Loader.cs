using UnityEngine;

public class Loader : MonoBehaviour
{
    public GameObject gameManager;          //Prefab Game Manager a instanciar.


    void Awake()
    {
        //Si no hay un script GameManager asignado o  está vacío
        if (GameManager.instance == null){

            //Lo instancio
            Instantiate(gameManager);

        }

    }

}
