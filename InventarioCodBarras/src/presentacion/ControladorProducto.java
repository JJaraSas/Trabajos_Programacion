package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import datos.*;

public class ControladorProducto implements ActionListener{
	
	private final PanelProducto panelProducto;
	private ProductoDAO producto;
	
	public ControladorProducto(PanelProducto pProducto) {
		panelProducto = pProducto;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
		
        //Evento boton Buscar Producto
    	if(event.getSource() == panelProducto.getBtnBuscarProducto()) {
    		
    		producto = new ProductoDAO(panelProducto);
    		
    		//Mostrar datos en el panel
    		if(producto.buscarProducto()){
    			
    			panelProducto.getTxtNombre().setText(producto.getNombre());
    			panelProducto.getTxtFechaingreso().setText(producto.getFecha());
    			panelProducto.getTxtCodigobarras().setText(producto.getCodBarras());
    			System.out.println("Perecedero:" + producto.getPerecedero());
    			if(producto.getPerecedero()==1)
    				panelProducto.getRdbPerecederoSi().setSelected(true);
    			else
    				panelProducto.getRdbPerecederoNo().setSelected(true);
    			panelProducto.getTxtCategoria().setText( String.valueOf(producto.getCategoria() ));
    			panelProducto.getTxtProveedor().setText( String.valueOf(producto.getProveedor() ));
    			panelProducto.getTxtCantidad().setText( String.valueOf(producto.getCantidad() ));
    		}else {
    			JOptionPane.showMessageDialog(null, "Producto no existe");
    		}		
    			
    	}
    	
    	//Evento boton Guardar/Insertar
    	if(event.getSource() == panelProducto.getBtnGuardar()) {
    		
    		producto = new ProductoDAO(panelProducto);
    		
    		if(producto.registroExiste()) {
         		//modificar Producto
        		if(producto.modificarProducto())
        			JOptionPane.showMessageDialog(null, "Registro modificado"); 		
    		}else {
    			//Insertar Producto
        		if(producto.registrarProducto())
        			JOptionPane.showMessageDialog(null, "Registro ingresado");
    		}
    			
    		

    		
    	}
    	
    	//Evento boton Eliminar
    	if(event.getSource() == panelProducto.getBtnEliminar()) {
    		
    		producto = new ProductoDAO(panelProducto);
    		
    		if(producto.eliminarRegistro())
    			JOptionPane.showMessageDialog(null, "Registro eliminado"); 
    		else
    			JOptionPane.showMessageDialog(null, "Operacion no realizada"); 
    		
    	}
    }	
	
}