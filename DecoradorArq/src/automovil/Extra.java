package automovil;

public abstract class Extra implements Vehiculo{
	private Vehiculo vehiculo;
	
	public Extra(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public float getPrecio() {
		return vehiculo.getPrecio();
	}
	
    public String descripcion() {
    	return vehiculo.descripcion();
    }

}
