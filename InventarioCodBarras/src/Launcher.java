

import presentacion.Modelo;

/**
* @author SuspDesing
*/

public class Launcher {
    
    Modelo miSistema;
    
    public static void main(String []args){
        new Launcher();
    }
    
    //se obtiene el modelo
    public Modelo getMiSistema(){
        if (miSistema == null){
            miSistema = new Modelo();
        }
        return miSistema;
    }
    
    // el constructor llama la funcion iniciar del modelo
    public Launcher(){
        miSistema = getMiSistema();
        miSistema.iniciar();
    }
}
