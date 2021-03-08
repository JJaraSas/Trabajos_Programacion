package personaje;

public class Enemigo implements Personaje{
	private String nombre = "Guerrero de la Revelion";

	public int nivel() {
		return 5;
	}

	public String descripcion() {
		return "Personaje: " + nombre;
	}
	
}
