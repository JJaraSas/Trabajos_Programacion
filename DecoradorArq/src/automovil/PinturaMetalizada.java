package automovil;

public class PinturaMetalizada extends Extra{
	private String propiedadAdicional;

	public PinturaMetalizada(Vehiculo vehiculo) {
		super(vehiculo);
	}
	
	public float getPrecio() {
		return super.getPrecio() + 400;
	}
	
    public String descripcion() {
    	this.propiedadAdicional = " + Pintura Metalizada ";
    	return super.descripcion() + propiedadAdicional;
    }

}
