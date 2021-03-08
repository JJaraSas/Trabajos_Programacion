package negocio;

/**
 *
 * @author Carlos
 */

public class Registro {

    private double consecutivo;
    private String fecha_entrada;
    private String fecha_salida;
    private double valor_total;
    private int k_espacio;
    private String k_vehiculo;
    
    public Registro(){
        
    }

    public double getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(double consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public int getK_espacio() {
        return k_espacio;
    }

    public void setK_espacio(int k_espacio) {
        this.k_espacio = k_espacio;
    }

    public String getK_vehiculo() {
        return k_vehiculo;
    }

    public void setK_vehiculo(String k_vehiculo) {
        this.k_vehiculo = k_vehiculo;
    }
    
}
