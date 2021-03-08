package presentacion;

/**
 *
 * @author Jeison
 */

public class Modelo implements Runnable {
    
    private VentanaPrincipal miVentana;
    //private VentanaBuscaminas miBuscaminas;
    //private Buscaminas miSistema;
    private Thread hiloDibujo;

    // Se crea el hilo de dibujo
    public Modelo() {
    	hiloDibujo = new Thread(this);
    }
	
    // Se verifica si VentanaPrincipal ya esta creada con anterioridad
    public VentanaPrincipal getMiVentana() {
        if (miVentana == null) {
            miVentana = new VentanaPrincipal();
	}
	return miVentana;
    }
	
    //Crea la logica de la ventana de buscaminas
    /*public Buscaminas getMiSistema() {
	    if (miSistema == null) {
	        miSistema = new Buscaminas();
	    }
	    return miSistema;
    }*/

    // Hace visible la ventana principal
    public void iniciar() {
		getMiVentana().setVisible(true);
		//getMiSistema();
		//getMiSistema().crearTablero();
		//hiloDibujo.start();

    }

    /*
    // Metodo usado en e el buscaminas original
    public void update(){ 
		dibujar(); 
    }
    */

    //Fumcion que recive los valores del boton pulsado y las coordenadas
    /*public void botonPulsado(int boton, int x, int y){
        getMiSistema().botonPresionado(boton, x, y);
        //getMiBuscaminas().getCanvas().repaint();
    }*/
	
    // Hilo de dibujo
    @Override
    public void run() {
        while (true) {
            try {
		Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            //dibujar();

	}
    }
}
