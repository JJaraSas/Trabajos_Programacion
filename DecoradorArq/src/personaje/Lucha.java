package personaje;

public class Lucha extends Habilidad{
	private String estiloLucha;

	public Lucha(Personaje personaje) {
		super(personaje);
	}
	
	public int nivel() {
		return super.nivel() + 3;
	}
	
	public String descripcion() {
		this.estiloLucha = " | Lucha con espada";
		return super.descripcion() + estiloLucha;
	}

}
