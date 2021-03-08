package personaje;

public class AutoCuracion extends Habilidad{

	public AutoCuracion(Personaje personaje) {
		super(personaje);
	}
	
	public int nivel() {
		return super.nivel() + 2;
	}
	
	public String descripcion() {
		return super.descripcion() + recuperarSalud();
	}
	
	public String recuperarSalud() {
		return " | Recupera salud 1 unidad/segundo";
	}

}
