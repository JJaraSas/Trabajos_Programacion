package negocio;

/**
 *
 * @author Carlos
 */

public class Tarifa {
 
    private int tipo_vehiculo;
    private double valor;
    private int k_parqueadero;
    
    public Tarifa(){
        
    }

    public int getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(int tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getK_parqueadero() {
        return k_parqueadero;
    }

    public void setK_parqueadero(int k_parqueadero) {
        this.k_parqueadero = k_parqueadero;
    }
    
    
}
