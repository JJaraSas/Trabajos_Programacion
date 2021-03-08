package personaje;

public abstract class Habilidad implements Personaje{
	private Personaje personaje;
	
	public Habilidad(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public int nivel() {
		return personaje.nivel();
	}
	
	public String descripcion() {
		return personaje.descripcion();
	}

}
