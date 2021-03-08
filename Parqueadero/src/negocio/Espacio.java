package negocio;

/**
 *
 * @author Carlos
 */

public class Espacio {
 
    private int k_espacio;
    private String nombre;
    private String disponible;
    private int k_area;
    
    public Espacio(){
        
    }

    public int getK_espacio() {
        return k_espacio;
    }

    public void setK_espacio(int k_espacio) {
        this.k_espacio = k_espacio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public int getK_area() {
        return k_area;
    }

    public void setK_area(int k_area) {
        this.k_area = k_area;
    }
    
    
}
