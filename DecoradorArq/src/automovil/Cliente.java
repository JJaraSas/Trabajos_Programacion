package automovil;

public class Cliente {

	public static void main(String[] args) {
		
		//Vehiculo sin extras
		Vehiculo vehiculoSimple = new Deportivo();
		mostrarInfo(vehiculoSimple);
		
		//Vehiculo con pintura metalizada
		Vehiculo vehiculoPintura = new PinturaMetalizada(new Deportivo());
		mostrarInfo(vehiculoPintura);
		
		//Vehiculo con pintura metalizada y aire acondicionado
		Vehiculo vehiculoPinturaAire = new AireAcondicionado(new PinturaMetalizada(new Deportivo()));
		mostrarInfo(vehiculoPinturaAire);

	}
	
	static void mostrarInfo(Vehiculo vehiculo) {
		System.out.println(vehiculo.descripcion());
		System.out.println("Costo Total: " + vehiculo.getPrecio());
		System.out.println("----------//-------");
	}

}