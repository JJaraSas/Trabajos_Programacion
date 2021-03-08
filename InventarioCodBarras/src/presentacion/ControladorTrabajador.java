package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import datos.TrabajadorDAO;

public class ControladorTrabajador implements ActionListener{
	
	private final PanelTrabajador panelTrabajador;
	private TrabajadorDAO trabajador;
	private String IdBodRes;
	
	public ControladorTrabajador(PanelTrabajador pTrabajador) {
		panelTrabajador = pTrabajador;
	}

	//Manejo de los eventos que vienen de la ventana
	public void actionPerformed(ActionEvent event) {
		//buscar Proveedor
       	if(event.getSource() == panelTrabajador.getBtnBuscarDocumento()) {
    		
    		trabajador = new TrabajadorDAO(panelTrabajador);
    		
    		if(trabajador.buscarTrabajador()) {
    			
    			IdBodRes = trabajador.getIdBodegaResp();
    			
    			panelTrabajador.getTxtNombre().setText(trabajador.getNombre());
    			panelTrabajador.getTxtDocumento().setText( String.valueOf(trabajador.getId() ));
    			panelTrabajador.getTxtEdad().setText( String.valueOf(trabajador.getEdad() ));
    			if(trabajador.getSexo()=="M")
    				panelTrabajador.getRdbHombre().setSelected(true);
    			else
    				panelTrabajador.getRdbMujer().setSelected(true);
    			panelTrabajador.getTxtBodega().setText( trabajador.getIdBodega() );

    		}else {
    			JOptionPane.showMessageDialog(null, "Trabajador no existe");
    		}	
    			

    	}
    	
    	//Evento boton Guardar
    	if(event.getSource() == panelTrabajador.getBtnGuardar()) {
    		    		
            trabajador = new TrabajadorDAO(panelTrabajador);
            
            trabajador.setIdBodegaResp(IdBodRes);
            
            if(trabajador.registrarTrabajador())
            	JOptionPane.showMessageDialog(null, "Trabajador registrado");

    	}
    	
    	//Evento boton Eliminar
    	if(event.getSource() ==panelTrabajador.getBtnEliminar()) {
    		
    		trabajador = new TrabajadorDAO(panelTrabajador);
            
            trabajador.setIdBodegaResp(IdBodRes);
            
            if(trabajador.eliminarRegistro())
            	JOptionPane.showMessageDialog(null, "Trabajador eliminado");
            
    	}	
    	
    }	
}