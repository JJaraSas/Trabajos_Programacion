package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import datos.*;

public class ControladorCategoria implements ActionListener{
	
	private final PanelCategoria panelCategoria;
	private CategoriaDOA categoria;
	
	public ControladorCategoria(PanelCategoria vCategoria) {
		panelCategoria = vCategoria;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
        		//Evento boton Buscar Bodega
                        
    	if(event.getSource() == panelCategoria.getBtnBuscarCategoria()) {
    		
    		categoria = new CategoriaDOA(panelCategoria);
    		//Mostrar datos en el panel
    		if(categoria.buscarCategoria()){
    			panelCategoria.getTxtNombre().setText(categoria.getNombre());
    			panelCategoria.getTxtId().setText(String.valueOf(categoria.getId()));
    			panelCategoria.getTxtrDescripcion().setText(categoria.getDescripcion());
    		}else {
    			JOptionPane.showMessageDialog(null, "Categoria no existe");
    		}
    	}
    	
    	//Evento boton Guardar
    	if(event.getSource() == panelCategoria.getBtnGuardar()) {
            categoria = new CategoriaDOA(panelCategoria);
            if(categoria.registroExiste()) {
    			System.out.println("bool si");
        		//modificar Categoria
        		if(categoria.modificarCategoria())
        			JOptionPane.showMessageDialog(null, "Registro modificado");
    		}else {
    			System.out.println("bool no");
    			//Insertar Producto
        		if(categoria.registrarCategoria())
        			JOptionPane.showMessageDialog(null, "Registro ingresado");
    		}
    	}
    	
    	//Evento boton Eliminar
    	if(event.getSource() ==panelCategoria.getBtnEliminar()) {
            if(categoria.existeProducto()) {
    			System.out.println("bool si");
        		//modificar Categoria
        		JOptionPane.showMessageDialog(null, "Hay productos con esa categoria");
    		}else {
    			System.out.println("bool no");
    			//Insertar Producto
        		if(categoria.eliminarRegistro())
        			JOptionPane.showMessageDialog(null, "Categoria Eliminada");
    		}
    	}	
    }	
}