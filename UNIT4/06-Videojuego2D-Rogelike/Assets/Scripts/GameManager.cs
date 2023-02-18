using UnityEngine;

public class GameManager : MonoBehaviour
{

    public static GameManager instance = null;              //Instancia al GameManager para poder acceder desde otro script
    private BoardManager boardScript;                       //Renerencia a BoardManager para configurar el nivel.
    private int level = 10;                                  //Número de nivel, expresado en el juego como "Día 1".

    //Awake es llamado antes de Start()
    void Awake()
    {
        //Si no existe instancia al GameManager
        if (instance == null){

            //La igualo a la actual
            instance = this;

        }

        //Si ya existe y no es esta:
        else if (instance != this){

            //La destruyo para que solo haya una.
            Destroy(gameObject);

        }

        //Le digo que no la destruya durante todo el juego
        DontDestroyOnLoad(gameObject);

        //Inicializo el componente BoardManager
        boardScript = GetComponent<BoardManager>();

        //Inicio el juego
        InitGame();
    }

    //Inicio el juego
    void InitGame()
    {
        //Llamo a la función SetupScene con el nivel actual
        boardScript.SetupScene(level);

    }

}

