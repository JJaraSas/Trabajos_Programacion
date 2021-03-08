package producto;

public class Laptop implements Component {

	public String getNombrePrecio() {
		return "Laptop: " + getCostoTotal();
	}

	public double getCostoTotal() {
		return 800000;
	}

}
