package producto;

public class Mouse extends Decorator {

	public Mouse(Component componente) {
		super(componente);
		nombreAccesorio = "Mouse";
		precioAccesorio = 30000;
	}

}
