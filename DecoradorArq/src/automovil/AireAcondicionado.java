package automovil;

public class AireAcondicionado extends Extra{

	public AireAcondicionado(Vehiculo vehiculo) {
		super(vehiculo);
	}
	
	public float getPrecio() {
		return super.getPrecio() + 500;
	}
	
    public String descripcion() {
    	return super.descripcion() + comportamientoAdicional();
    }
    
    public String comportamientoAdicional() {
    	return "\nEste vehiculo cuenta con Aire Acondicionado";
    }

}
