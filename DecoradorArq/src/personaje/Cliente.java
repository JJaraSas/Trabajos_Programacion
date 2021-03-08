package personaje;

public class Cliente {

	public static void main(String[] args) {
		
		//Enemigo simple
		Personaje enemigoSimple = new Enemigo();
		mostrarInfo(enemigoSimple);
		
		//Enemigo con habilidades de lucha
		Personaje enemigoLucha = new Lucha(new Enemigo());
		mostrarInfo(enemigoLucha);
		
		//Enemigo con habilidades de lucha y Autocuracion
		Personaje enemigoLuchaCuracion = new AutoCuracion(new Lucha(new Enemigo()));
		mostrarInfo(enemigoLuchaCuracion);

	}
	
	static void mostrarInfo(Personaje personaje) {
		System.out.println(personaje.descripcion());
		System.out.println("Nivel dificultad: "+ personaje.nivel());
		System.out.println("----------//-------");
	}

}