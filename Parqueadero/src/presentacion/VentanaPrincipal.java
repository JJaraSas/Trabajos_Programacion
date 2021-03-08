package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import negocio.Manager;
import negocio.Parqueadero;
import util.CaException;

/**
 *
 * @author Jeison
 */

public class VentanaPrincipal extends JFrame implements ActionListener {

    private Manager miManager;
    private ArrayList<Parqueadero> parqueaderos;
    
    private JPanel panelPrincipal;
    private JPanel panelMenu;
    private JPanel panelAux;
    private JPanel paneSelParqueadero;
    private PanelReloj panelReloj;
		
    private JButton btnBotonParq;
    private JButton btnBotonIngVehiculo;
    private JButton btnBotonBuscar;
    private JButton btnBotonSalir;
    private JButton btnBotonSalCarro;
    private JButton btnActualizar;
    private JLabel lblNombreP;
    private JLabel lblNombreR;
    private JLabel lblUbicacion;
    private JLabel lblUbicacionR;
    private JLabel lblDireccion;
    private JLabel lblDireccionR;
    private JLabel lblTipo;
    private JLabel lblTipoR;
    private JLabel lblCupos;
    private JLabel lblCuposR;
    private JComboBox<String> cbxSelParqueadero;

    public VentanaPrincipal() {
        
	    miManager = Manager.getInstancia();
	    
	    setTitle("ParqueaSistem 0.1");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 970, 700);
	    setResizable(false);
	    //setUndecorated(true);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
			
		panelMenu = new JPanel();
		panelMenu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMenu.setBounds(10, 10, 778, 100);
		panelPrincipal.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnBotonParq = new JButton("");
		btnBotonParq.setToolTipText("Registrar Parqueadero");
		btnBotonParq.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/ImgBtn1.png")));
		btnBotonParq.setBounds(10, 10, 80, 80);
		btnBotonParq.addActionListener(this);
		panelMenu.add(btnBotonParq);
			
		btnBotonIngVehiculo = new JButton("");
		btnBotonIngVehiculo.setToolTipText("Ingresar Vehiculo");
		btnBotonIngVehiculo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtn2.png")));
		btnBotonIngVehiculo.setBounds(100, 10, 80, 80);
		btnBotonIngVehiculo.addActionListener(this);
		panelMenu.add(btnBotonIngVehiculo);
			
		btnBotonBuscar = new JButton("");
		btnBotonBuscar.setToolTipText("Buscar Vehiculo");
		btnBotonBuscar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtn3.png")));
	    btnBotonBuscar.setBounds(280, 10, 80, 80);
		btnBotonBuscar.addActionListener(this);
		panelMenu.add(btnBotonBuscar);
			
		btnBotonSalCarro = new JButton("");
	    btnBotonSalCarro.setToolTipText("Salida de vehiculo");
	    btnBotonSalCarro.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtn4.png")));
		btnBotonSalCarro.setBounds(190, 10, 80, 80);
	    btnBotonSalCarro.addActionListener(this);
		panelMenu.add(btnBotonSalCarro);
			
		btnBotonSalir = new JButton("");
		btnBotonSalir.setToolTipText("Salir");
		btnBotonSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBtnSalir.png")));
		btnBotonSalir.setBounds(370, 10, 80, 80);
		btnBotonSalir.addActionListener(this);
		panelMenu.add(btnBotonSalir);
			
		panelAux = new JPanel();
		panelAux.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAux.setBounds(10, 120, 630, 531);
		panelPrincipal.add(panelAux);
		panelAux.setLayout(null);
		
		paneSelParqueadero = new JPanel();
		paneSelParqueadero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paneSelParqueadero.setBounds(650, 120, 296, 531);
		panelPrincipal.add(paneSelParqueadero);
		paneSelParqueadero.setLayout(null);
		
	
		panelSelParqueadero();
	    
	    panelReloj = new PanelReloj();
	    panelPrincipal.add(panelReloj);
	    /*
	    try {
	        //Al iniciar el programa actualizar la lista de parqueaderos
	        actualizarParqueaderos();
	    } catch (CaException ex) {
	        Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
	    }
	    */
        
    }
	
	
    //Manejo del panel de registro de parqueadero
    public void panelRegParqueaderos() throws CaException {
	
        PanelRegParqueadero miPanel = new PanelRegParqueadero();
        miPanel.empresas = miManager.consultarEmpresa();
        miPanel.pintarEmpresa();
        
        panelAux = miPanel;
        panelPrincipal.add(panelAux);
		
    }

    public void panelIngVehiculo() {
        PanelIngVehiculo miPanel = new PanelIngVehiculo();
        miPanel.parqueaderoSel = cbxSelParqueadero.getSelectedIndex()+1;
        miPanel.fecha = panelReloj.fecha;
        
        panelAux = miPanel;
        panelPrincipal.add(panelAux);
    }
    
    public void panelSalVehiculo() {
        
        panelAux = new PanelSalVehiculo();
        panelPrincipal.add(panelAux);
    }
	
    public void panelSelParqueadero() {
		
		JLabel lblSelecioneParqueadero = new JLabel("Selecione Parqueadero");
		lblSelecioneParqueadero.setForeground(Color.GRAY);
		lblSelecioneParqueadero.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneParqueadero.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelecioneParqueadero.setBounds(10, 10, 276, 20);
		paneSelParqueadero.add(lblSelecioneParqueadero);
			
		cbxSelParqueadero = new JComboBox<String>();
		cbxSelParqueadero.setBounds(10, 43, 276, 21);
		cbxSelParqueadero.addActionListener(this);
		paneSelParqueadero.add(cbxSelParqueadero);
		
		lblNombreP = new JLabel("Nombre:");
		lblNombreP.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreP.setBounds(10, 90, 79, 20);
		paneSelParqueadero.add(lblNombreP);
		
		lblNombreR = new JLabel("NombreR");
		lblNombreR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreR.setBounds(99, 90, 139, 20);
		paneSelParqueadero.add(lblNombreR);
		
		lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUbicacion.setBounds(10, 120, 79, 20);
		paneSelParqueadero.add(lblUbicacion);
		
		lblUbicacionR = new JLabel("UbicacionR");
		lblUbicacionR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUbicacionR.setBounds(99, 120, 139, 20);
		paneSelParqueadero.add(lblUbicacionR);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccion.setBounds(10, 150, 79, 20);
		paneSelParqueadero.add(lblDireccion);
		
		lblDireccionR = new JLabel("DireccionR");
		lblDireccionR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDireccionR.setBounds(99, 150, 139, 20);
		paneSelParqueadero.add(lblDireccionR);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(10, 180, 79, 20);
		paneSelParqueadero.add(lblTipo);
		
		lblTipoR = new JLabel("TipoR");
		lblTipoR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoR.setBounds(99, 180, 139, 20);
		paneSelParqueadero.add(lblTipoR);
		
		lblCupos = new JLabel("Cupos:");
		lblCupos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCupos.setBounds(10, 210, 79, 20);
		paneSelParqueadero.add(lblCupos);
			
		lblCuposR = new JLabel("CuposR");
		lblCuposR.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCuposR.setBounds(99, 210, 139, 20);
		paneSelParqueadero.add(lblCuposR);
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnActualizar.setBounds(80, 260, 102, 22);
        btnActualizar.addActionListener(this);
        paneSelParqueadero.add(btnActualizar);
	
    }

    public void panelBusqueda() {
    	panelAux = new PanelBusqueda();
        panelPrincipal.add(panelAux);
    }
    
    public void actualizarParqueaderos() throws CaException{
        parqueaderos = miManager.consultarParqueadero();
        String[] nomParqueadero = new String[parqueaderos.size()];
        for (int i=0; i<parqueaderos.size(); i++){
            nomParqueadero[i] = parqueaderos.get(i).getNombre();
        }
        cbxSelParqueadero.setModel(new DefaultComboBoxModel<String>(nomParqueadero));
        
        int index = cbxSelParqueadero.getSelectedIndex();
        lblNombreR.setText(parqueaderos.get(index).getNombre());
        lblUbicacionR.setText(parqueaderos.get(index).getZona());
        lblDireccionR.setText(parqueaderos.get(index).getDireccion());
        switch(parqueaderos.get(index).getTipo()){
            case 1: lblTipoR.setText("En altura o subterraneo"); break;
            case 2: lblTipoR.setText("Subterraneo con un nivel"); break;
            case 3: lblTipoR.setText("A nivel"); break;
            case 4: lblTipoR.setText("A nivel, pisos en césped"); break;
        }
        lblCuposR.setText(String.valueOf(parqueaderos.get(index).getCupos()));
    }
	
    //Manejo de los eventos Eventos
    public void actionPerformed(ActionEvent event) {
 		
 	//Evento Boton Registrar Parqueaderos
	if(event.getSource() == btnBotonParq){
            panelAux.removeAll();
            try {
                panelRegParqueaderos();
            } catch (CaException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            panelAux.revalidate();
            panelAux.repaint();
	}
		
 	//Evento Boton Ingresar Vehiculo
	if(event.getSource() == btnBotonIngVehiculo){
            panelAux.removeAll();
            panelIngVehiculo();
            panelAux.revalidate();
            panelAux.repaint();
	}
        
    //Evento Boton Salida de Vehiculo
    if(event.getSource() == btnBotonSalCarro){
        panelAux.removeAll();
        panelSalVehiculo();
        panelAux.revalidate();
        panelAux.repaint();
    }
		
 	//Evento Boton Buscar
	if(event.getSource() == btnBotonBuscar){
            panelAux.removeAll();
            panelBusqueda();
            panelAux.revalidate();
            panelAux.repaint();
	}
		
	//Evento Boton Salir
	if(event.getSource() == btnBotonSalir){
			
            dispose();	
            
	}
	
        
    //Evento Boton Actualizar
    if(event.getSource() == btnActualizar){
        try {
            actualizarParqueaderos();
        } catch (CaException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    //Seleccion del parqueadero
    if(event.getSource() == cbxSelParqueadero){
        int index = cbxSelParqueadero.getSelectedIndex();
        lblNombreR.setText(parqueaderos.get(index).getNombre());
        lblUbicacionR.setText(parqueaderos.get(index).getZona());
        lblDireccionR.setText(parqueaderos.get(index).getDireccion());
        switch(parqueaderos.get(index).getTipo()){
            case 1: lblTipoR.setText("En altura o subterraneo"); break;
            case 2: lblTipoR.setText("Subterraneo con un nivel"); break;
            case 3: lblTipoR.setText("A nivel"); break;
            case 4: lblTipoR.setText("A nivel, pisos en césped"); break;
        }
        lblCuposR.setText(String.valueOf(parqueaderos.get(index).getCupos()));
    }
		
    }
}
