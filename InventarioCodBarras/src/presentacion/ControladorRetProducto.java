package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import datos.*;

public class ControladorRetProducto implements ActionListener, KeyListener{
	
	private final PanelRetProducto panRetProducto;
	private RetProductoDAO retProducto;
	
	public ControladorRetProducto(PanelRetProducto pRetProducto) {
		panRetProducto = pRetProducto;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
		
		retProducto = new RetProductoDAO(panRetProducto);
		
        //Evento boton Retirar
    	if(event.getSource() == panRetProducto.getBtnVerificar()) {
    		//Mostrar datos en el panel
    		if(retProducto.buscarProducto()){
    			
    			panRetProducto.getTxtNombre().setText(retProducto.getNombre());
    			panRetProducto.getTxtFechaingreso().setText(retProducto.getFecha());
    			panRetProducto.getTxtCodigobarras().setText(retProducto.getCodBarras());
    			System.out.println("Perecedero:" + retProducto.getPerecedero());
    			if(retProducto.getPerecedero()==1)
    				panRetProducto.getRdbPerecederoSi().setSelected(true);
    			else
    				panRetProducto.getRdbPerecederoNo().setSelected(true);
    			panRetProducto.getTxtCategoria().setText( String.valueOf(retProducto.getCategoria() ));
    			panRetProducto.getTxtProveedor().setText( String.valueOf(retProducto.getProveedor() ));
    			panRetProducto.getTxtCantidad().setText( String.valueOf(retProducto.getCantidad() ));
    		}else {
    			JOptionPane.showMessageDialog(null, "Producto no existe");
    		}		
    	}
    	
    	//Evento boton Verificar
    	if(event.getSource() == panRetProducto.getBtnRetirar()) {

    		//Mostrar datos en el panel
    		if(retProducto.buscarProducto()){
    			if(retProducto.retirarProducto())
    				JOptionPane.showMessageDialog(null, "Producto retirado");
    			else
    				JOptionPane.showMessageDialog(null, "No hay unidades de este producto");
    		}else {
    			JOptionPane.showMessageDialog(null, "Producto no existe");
    		}
    		
    	}	
    }

	@Override
	public void keyPressed(KeyEvent e) {
		
		retProducto = new RetProductoDAO(panRetProducto);
		
		if(KeyEvent.getKeyText(e.getKeyCode()) == "Intro") {
			if(retProducto.buscarProducto()){
    			
    			panRetProducto.getTxtNombre().setText(retProducto.getNombre());
    			panRetProducto.getTxtFechaingreso().setText(retProducto.getFecha());
    			panRetProducto.getTxtCodigobarras().setText(retProducto.getCodBarras());
    			System.out.println("Perecedero:" + retProducto.getPerecedero());
    			if(retProducto.getPerecedero()==1)
    				panRetProducto.getRdbPerecederoSi().setSelected(true);
    			else
    				panRetProducto.getRdbPerecederoNo().setSelected(true);
    			panRetProducto.getTxtCategoria().setText( String.valueOf(retProducto.getCategoria() ));
    			panRetProducto.getTxtProveedor().setText( String.valueOf(retProducto.getProveedor() ));
    			panRetProducto.getTxtCantidad().setText( String.valueOf(retProducto.getCantidad() ));
    		}else {
    			JOptionPane.showMessageDialog(null, "Producto no existe");
    		}
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
