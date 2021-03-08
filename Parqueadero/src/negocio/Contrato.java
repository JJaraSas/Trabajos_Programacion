package negocio;

/**
 *
 * @author Carlos
 */

public class Contrato {
    
    private double k_contrato;
    private int tipo;
    private String fecha_inicio;
    private String fecha_final;
    private double valor;
    private String k_vehiculo;
    private double k_cliente; 
    
    public Contrato(){
        
    }

    public double getK_contrato() {
        return k_contrato;
    }

    public void setK_contrato(double k_contrato) {
        this.k_contrato = k_contrato;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getK_vehiculo() {
        return k_vehiculo;
    }

    public void setK_vehiculo(String k_vehiculo) {
        this.k_vehiculo = k_vehiculo;
    }

    public double getK_cliente() {
        return k_cliente;
    }

    public void setK_cliente(double k_cliente) {
        this.k_cliente = k_cliente;
    }
    
    
}
