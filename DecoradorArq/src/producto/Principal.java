package producto;

public class Principal {

	public static void main(String[] args) {
		
		//Laptop sin accesorios
		Component laptopSimple = new Laptop();
		mostrarInfo(laptopSimple);
		
		//Laptop con mouse
		Component laptopEquipada = new Mouse(new Laptop());
		mostrarInfo(laptopEquipada);
		
		//Laptop con mouse y base refrigerante
		Component laptopFullEquipada = new Mouse(new BaseRefrigerante(new Laptop()));
		mostrarInfo(laptopFullEquipada);

	}
	
	static void mostrarInfo(Component component) {
		System.out.println(component.getNombrePrecio());
		System.out.println("Costo Total: " + component.getCostoTotal());
		System.out.println("----------//-------");
	}

}
