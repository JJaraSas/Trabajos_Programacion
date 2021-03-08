package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import datos.*;

public class ControladorBodega implements ActionListener{
	
	private final PanelBodega panelBodega;
	private BodegaDOA bodega;
	
	public ControladorBodega(PanelBodega vBodega) {
		panelBodega = vBodega;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
        		//Evento boton Buscar Bodega
    	if(event.getSource() == panelBodega.getBtnBuscarBodega()) {
    		
    		bodega = new BodegaDOA(panelBodega);
    		//Mostrar datos en el panel
    		if(bodega.buscarBodega()){
    			panelBodega.getTxtNoBodega().setText(bodega.getIdBodega());
    			panelBodega.getTxtAdmin().setText(String.valueOf(bodega.getIdAdministrador()));
    			panelBodega.getTxtCapacidad().setText(String.valueOf(bodega.getCapacidad()));
    		}else {
    			JOptionPane.showMessageDialog(null, "Bodega no existe");
    		}
    	}
    	
    	//Evento boton Guardar
    	if(event.getSource() == panelBodega.getBtnGuardar()) {
            bodega = new BodegaDOA(panelBodega);
            if(bodega.registroExiste()) {
    			System.out.println("bool si");
        		//modificar Categoria
        		if(bodega.modificarBodega())
        			JOptionPane.showMessageDialog(null, "Registro modificado");
    		}else {
    			System.out.println("bool no");
    			//Insertar Producto
        		if(bodega.registrarBodega())
        			JOptionPane.showMessageDialog(null, "Registro ingresado");
    		}
    	}
    	
    	//Evento boton Eliminar
    	if(event.getSource() ==panelBodega.getBtnEliminar()) {
            if(bodega.existeProducto()) {
    			System.out.println("bool si");
        		//modificar Categoria
        		JOptionPane.showMessageDialog(null, "Hay productos en esa bodega");
    		}else {
    			System.out.println("bool no");
    			//Insertar Producto
        		if(bodega.eliminarRegistro())
        			JOptionPane.showMessageDialog(null, "Bodega Eliminada");
    		}
    	}	
    }	
}