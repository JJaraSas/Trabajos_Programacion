package producto;

public class BaseRefrigerante extends Decorator {

	public BaseRefrigerante(Component componente) {
		super(componente);
		nombreAccesorio = "Base Refrigerante";
		precioAccesorio = 15000;
	}

}
