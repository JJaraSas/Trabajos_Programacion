package negocio;

/**
 *
 * @author Carlos
 */

public class Parqueadero {

    private int k_parqueadero;
    private String nombre;
    private int tipo;
    private String zona;
    private String direccion;
    private int cupos;
    private double k_empresa;
    
    public Parqueadero(){
        
    }

    public int getK_parqueadero() {
        return k_parqueadero;
    }

    public void setK_parqueadero(int k_parqueadero) {
        this.k_parqueadero = k_parqueadero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public double getK_empresa() {
        return k_empresa;
    }
    
    public void setK_empresa(double k_empresa){
        this.k_empresa = k_empresa;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }
    
    
}
