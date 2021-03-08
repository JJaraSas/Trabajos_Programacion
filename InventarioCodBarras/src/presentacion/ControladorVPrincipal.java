package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVPrincipal implements ActionListener{
	
	private final VentanaPrincipal venPrincipal;

	
	public ControladorVPrincipal(VentanaPrincipal vPrincipal) {
		venPrincipal = vPrincipal;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
        //Evento boton Producto (Admin)
    	if(event.getSource() == venPrincipal.getBtnProducto()) {
            venPrincipal.panelProducto(); 
            System.out.println("Controlador producto");
    	}
    	
    	//Evento boton Categoria (Admin)
    	if(event.getSource() == venPrincipal.getBtnCategoria()) {           
            venPrincipal.panelCategoria();
    	}
    	
    	//Evento boton Bodega (Admin)
    	if(event.getSource() == venPrincipal.getBtnBodega()) {
            venPrincipal.panelBodega();
    	}
    	
    	//Evento boton Proveedor
    	if(event.getSource() == venPrincipal.getBtnProveedor()) {
            venPrincipal.panelProveedor();
        }
    	
    	//Evento boton Retirar Producto (Bodega)
    	if(event.getSource() == venPrincipal.getBtnTrabajador()) {
            venPrincipal.panelTrabajador(); 
    	}
    	
    	//Evento boton Ingresar Producto (Bodega)
    	if(event.getSource() == venPrincipal.getBtnIngresarProd()) {
            venPrincipal.panelIngProducto();
             
    	}
    	
    	//Evento boton Retirar Producto (Bodega)
    	if(event.getSource() == venPrincipal.getBtnRetirarProd()) {
            venPrincipal.panelRetProducto();
            
    	}
    	
    	//Evento boton Salir
    	if(event.getSource() == venPrincipal.getBtnSalir()) {
    		venPrincipal.getPanelAux().removeAll();
    		venPrincipal.dispose();
    		venPrincipal.getModelo().iniciar();
    	}	
    }	
}