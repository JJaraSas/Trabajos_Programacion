package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import datos.*;

public class ControladorIngreso implements ActionListener, KeyListener{
	
	private final VentanaIngreso venIngreso;
	private LoginDAO login;
	
	public ControladorIngreso(VentanaIngreso vIngreso) {
		venIngreso = vIngreso;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
		
     	//Evento boton Administrador (Cargar login para administrador)
    	if(event.getSource() == venIngreso.getBtnAdministrador()){
    		venIngreso.panelLoginAdmin();
    	}
    	
    	//Evento boton Bodega (Cargar login para bodegueros)
    	if(event.getSource() == venIngreso.getBtnBodega()){
    		venIngreso.panelLoginBodega();     
    	}
    	
    	//Evento boton Login Admin
    	if(event.getSource() == venIngreso.getBtnLoginAdm()) {
    		//Llamado a la consulta de la BD
    		login = new LoginDAO(venIngreso);
			
    		if(login.loginAdmin()) {
	    		venIngreso.getModelo().getVenIngreso().dispose();	//Cierra la ventana actual
	    		venIngreso.getModelo().admin();
	    		venIngreso.getModelo().setUsuario(venIngreso.getTxtUsuario().getText());
	    		
	    		//Asignar a los botones labels de informacion de usuario
	    		venIngreso.getModelo().getVenPrincipal().getLblMostrarDocumento().setText(venIngreso.getModelo().getUsuario());
	    		venIngreso.getModelo().getVenPrincipal().getLblMostrarBodega().setText("Admin");
    		}else {
    			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
    		}
    		
    	}
    	
    	//Evento boton Login Bodega
    	if(event.getSource() == venIngreso.getBtnLoginBod()) {
    		//Llamado a la consulta de la BD 
    		login = new LoginDAO(venIngreso);
			
    		if(login.loginBodega()){
    			
    			login.consultaUsuario();
    			
    			venIngreso.getModelo().getVenIngreso().dispose();	//Cierra la ventana actual
        		venIngreso.getModelo().bodega();
        		venIngreso.getModelo().setUsuario(venIngreso.getTxtDocumento().getText());
        		
        		//Asignar a los botones labels de informacion de usuario
	    		venIngreso.getModelo().getVenPrincipal().getLblMostrarDocumento().setText(venIngreso.getModelo().getUsuario());
	    		venIngreso.getModelo().getVenPrincipal().getLblMostrarBodega().setText(login.getBodega());
	    		
    		}else {
    			JOptionPane.showMessageDialog(null, "Documento incorrecto");
    		}
    		
    	}
    	
    	//Evento boton Atras
    	if(event.getSource() == venIngreso.getBtnAtras()) {
    		venIngreso.panelBotonesSeleccion();
    	}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(KeyEvent.getKeyText(e.getKeyCode()) == "Intro") {
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}