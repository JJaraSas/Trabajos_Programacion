package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import datos.ProveedorDOA;

public class ControladorProveedor implements ActionListener{
	
	private final PanelProveedor panelProveedor;
	private ProveedorDOA proveedor;
	
	public ControladorProveedor(PanelProveedor vProveedor) {
		panelProveedor = vProveedor;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
		//buscar Proveedor
       	if(event.getSource() == panelProveedor.getBtnBuscarProveedor()) {
    		
    		proveedor = new ProveedorDOA(panelProveedor);
    		//Mostrar datos en el panel
    		if(proveedor.buscarProveedor()){
    			panelProveedor.getTxtNombre().setText(proveedor.getNombre());
    			panelProveedor.getTxtRut().setText(String.valueOf(proveedor.getRut()));
    			panelProveedor.getTxtTelefono().setText(String.valueOf(proveedor.getTelefono()));
    		}else {
    			JOptionPane.showMessageDialog(null, "Proveedor no existe");
    		}
    	}
    	
    	//Evento boton Guardar
    	if(event.getSource() == panelProveedor.getBtnGuardar()) {
            proveedor = new ProveedorDOA(panelProveedor);
            if(proveedor.registroExiste()) {
    			System.out.println("bool si");
        		//modificar Categoria
        		if(proveedor.modificarProveedor())
        			JOptionPane.showMessageDialog(null, "Proveedor modificado");
    		}else {
    			System.out.println("bool no");
    			//Insertar Producto
        		if(proveedor.registrarProveedor())
        			JOptionPane.showMessageDialog(null, "Proveedor ingresado");
    		}
    	}
    	
    	//Evento boton Eliminar
    	if(event.getSource() ==panelProveedor.getBtnEliminar()) {
            if(proveedor.existeProducto()) {
    			System.out.println("bool si");
        		//modificar Categoria
        		JOptionPane.showMessageDialog(null, "¡Hay productos con ese proveedor, no se puede eliminar!");
    		}else {
    			System.out.println("bool no");
    			//Insertar Producto
        		if(proveedor.eliminarRegistro())
        			JOptionPane.showMessageDialog(null, "Categoria Eliminada");
    		}
    	}	
    }	
}