package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import negocio.*;
import util.CaException;

/**
 *
 * @author Carlos
 */

public class PanelRegParqueadero extends JPanel implements ActionListener {
    
    private Manager miManager;
    public ArrayList<Empresa> empresas;
    public ArrayList<Parqueadero> parqueaderos;
    public ArrayList<Area> areas;
    
    private JLabel lblRegistroParqueadero;
    private JLabel lblEmpresa;
    private JLabel lblNombre;
    private JLabel lblUbicacion;
    private JLabel lblTipo;
    private JLabel lblDireccion;
    private JLabel lblCupos;
    private JLabel lblImgcarro;
    private JLabel lblImgmoto;
    private JLabel lblImgbici;
    private JLabel lblMensaje;
    
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtCuposCarros;
    private JTextField txtCuposMotos;
    private JTextField txtCuposBicis;
    
    private JComboBox<String> cbxEmpresa;
    private JComboBox<String> cbxUbicacion;
    private JComboBox<String> cbxTipo;
    
    private JButton btnGuardar;
    private JButton btnCancelar;
    
    public PanelRegParqueadero(){
        
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	this.setBounds(10, 120, 630, 531);
	this.setLayout(null);
        
        lblRegistroParqueadero = new JLabel("REGISTRO PARQUEADERO");
	lblRegistroParqueadero.setBackground(Color.GRAY);
	lblRegistroParqueadero.setForeground(Color.GRAY);
	lblRegistroParqueadero.setHorizontalAlignment(SwingConstants.CENTER);
	lblRegistroParqueadero.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblRegistroParqueadero.setBounds(60, 26, 429, 24);
	this.add(lblRegistroParqueadero);
        
	lblNombre = new JLabel("Nombre:");
	lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNombre.setBounds(60, 120, 60, 13);
	this.add(lblNombre);
		
	txtNombre = new JTextField();
	txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtNombre.setBounds(180, 115, 253, 22);
	this.add(txtNombre);
	txtNombre.setColumns(10);
	
	lblUbicacion = new JLabel("Ubicacion:");
	lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblUbicacion.setBounds(60, 160, 96, 13);
	this.add(lblUbicacion);
	
	cbxUbicacion = new JComboBox<String>();
	cbxUbicacion.setModel(new DefaultComboBoxModel<String>(new String[] {"Usaquen", "Chapinero", "Santa Fe", "San Cristobal",
            "Usme", "Tunjuelito", "Bosa", "Kennedy", "Fontibon", "Engativa", "Suba", "Barrios Unidos", "Teusaquillo", "Martires", 
            "Antonio Nariño", "Puente Aranda", "Candelaria", "Rafael Uribe Uribe", "Ciudad Bolivar", "Sumapaz"}));
	cbxUbicacion.setBounds(180, 155, 253, 22);
	this.add(cbxUbicacion);
		
	lblTipo = new JLabel("Tipo:");
	lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblTipo.setBounds(60, 240, 45, 13);
	this.add(lblTipo);
		
	cbxTipo = new JComboBox<String>();
	cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {
            "En altura o subterraneo con dos niveles", 
            "Subterraneo con un solo nivel", 
            "A nivel, piso en concreto, asfalto o gravilla", 
            "A nivel, pisos en afrimado o césped"}));
	cbxTipo.setBounds(180, 235, 253, 22);
	this.add(cbxTipo);
		
	lblDireccion = new JLabel("Direccion:");
	lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblDireccion.setBounds(60, 200, 80, 13);
	this.add(lblDireccion);
		
	txtDireccion = new JTextField();
	txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtDireccion.setBounds(180, 195, 253, 22);
	this.add(txtDireccion);
	txtDireccion.setColumns(10);
		
	lblCupos = new JLabel("Cupos:");
	lblCupos.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblCupos.setBounds(60, 280, 45, 13);
	this.add(lblCupos);
	
	lblImgcarro = new JLabel("");
	lblImgcarro.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgCarro.png")));
	lblImgcarro.setBounds(180, 275, 30, 30);
	this.add(lblImgcarro);
		
	txtCuposCarros = new JTextField();
	txtCuposCarros.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtCuposCarros.setBounds(221, 279, 45, 22);
	this.add(txtCuposCarros);
	txtCuposCarros.setColumns(10);
	
	lblImgmoto = new JLabel("");
	lblImgmoto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgMoto.png")));
	lblImgmoto.setBounds(292, 275, 30, 30);
	this.add(lblImgmoto);
	
	txtCuposMotos = new JTextField();
	txtCuposMotos.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtCuposMotos.setBounds(332, 279, 45, 22);
	this.add(txtCuposMotos);
	txtCuposMotos.setColumns(10);
		
	lblImgbici = new JLabel("");
	lblImgbici.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBici.png")));
	lblImgbici.setBounds(404, 275, 30, 30);
	this.add(lblImgbici);
		
	txtCuposBicis = new JTextField();
	txtCuposBicis.setFont(new Font("Tahoma", Font.PLAIN, 13));
	txtCuposBicis.setBounds(444, 279, 45, 22);
	this.add(txtCuposBicis);
	txtCuposBicis.setColumns(10);
	
	btnGuardar = new JButton("Guardar");
	btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnGuardar.setBounds(237, 330, 102, 22);
        btnGuardar.addActionListener(this);
	this.add(btnGuardar);
		
	btnCancelar = new JButton("Cancelar");
	btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnCancelar.setBounds(349, 330, 102, 22);
        btnCancelar.addActionListener(this);
	this.add(btnCancelar);
        
        lblMensaje = new JLabel();        
        lblMensaje.setFont(new Font("Tahoma",Font.BOLD,12));
        lblMensaje.setForeground(Color.red);
        lblMensaje.setBounds(200, 380, 300, 12);
        this.add(lblMensaje);
    }
    
    /*
        Metodo que dibuja el Label de "Empresa:" y 
        el ComboBox de las empresas que hay en la base de datos
    
        No se llama en el constructor para que primero se haga la consulta
        en la base de datos
    */
    public void pintarEmpresa(){
        lblEmpresa = new JLabel("Empresa:");
        lblEmpresa.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEmpresa.setBounds(60, 80, 60, 13);
        this.add(lblEmpresa);
        
        cbxEmpresa = new JComboBox<String>();
        String[] nomEmpresa = new String[empresas.size()];
        for (int i=0; i<empresas.size(); i++){
            nomEmpresa[i] = empresas.get(i).getNombre();
        }
	cbxEmpresa.setModel(new DefaultComboBoxModel<String>(nomEmpresa));
	cbxEmpresa.setBounds(180, 75, 253, 22);
	this.add(cbxEmpresa);
    }
    
    public double calcularTarifa(String zona, int tipo_veh, int tipo_parq){
        double CMPM = 105;
        double FDZ=0, FTV, FNS, VMPM;
        
        String[] zona1 = {"Engativa","Puente Aranda","Rafael Uribe Uribe",
            "Ciudad Bolivar","Sumapaz","San Cristobal","Usme","Tunjuelito","Bosa","Kennedy","Fontibon"};
        String[] zona2 = {"Suba","Barrios Unidos","Teusaquillo","Los Martires",
            "Antonio Nariño","Candelaria","Usaquen","Chapinero","Santa Fe"};
        for(int i=0; i<11; i++){
            if(zona.equals(zona1[i])){
                FDZ = 0.8;
            }
        }
        
        for(int i=0; i<9; i++){
            if(zona.equals(zona2[i])){
                FDZ = 1;
            }
        }
        
        switch(tipo_veh){
            case 1: FTV = 1; break;
            case 2: FTV = 0.8; break;
            case 3: FTV = 0.5; break;
            default: FTV = 0;
        }
        
        switch(tipo_parq){
            case 1: FNS = 1; break;
            case 2: FNS = 0.9; break;
            case 3: FNS = 0.7; break;
            case 4: FNS = 0.5; break;
            default: FNS = 0;
        }
        
        VMPM = FDZ * FTV * FNS * CMPM;
        
        return VMPM;
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        
        if(event.getSource() == btnGuardar){
            boolean estado = true;
            
            try {
                miManager = Manager.getInstancia();
                Parqueadero p = miManager.getParqueadero();
                Tarifa t = miManager.getTarifa();
                Area a = miManager.getArea();
                Espacio e = miManager.getEspacio();
                
                /* Datos para el parqueadero */
                String nombre = txtNombre.getText();
                if(nombre == null) estado = false;
                int tipo_parq = cbxTipo.getSelectedIndex() + 1;
                String zona = (String) cbxUbicacion.getSelectedItem();
                String direccion = txtDireccion.getText();
                if(direccion == null) estado = false;
                /* En k_empresa se guarda el indice de la seleccion
                para luego saber cual es el nit de la empresa seleccionada*/
                int k_empresa = cbxEmpresa.getSelectedIndex();
                
                
                /* Datos para el area */
                int[] cuposAreas = new int[3];
                if(!txtCuposCarros.getText().equals("")){
                    cuposAreas[0] = Integer.parseInt(txtCuposCarros.getText());
                }else{
                    cuposAreas[0] = 0;
                }
                if(!txtCuposMotos.getText().equals("")){
                    cuposAreas[1] = Integer.parseInt(txtCuposMotos.getText());
                }else{
                    cuposAreas[1] = 0;
                }
                if(!txtCuposBicis.getText().equals("")){
                    cuposAreas[2] = Integer.parseInt(txtCuposBicis.getText());
                }else{
                    cuposAreas[2] = 0;
                }
                
                if(estado){
                    int cupos = cuposAreas[0]+cuposAreas[1]+cuposAreas[2];
                    p.setNombre(nombre);
                    p.setZona(zona);
                    p.setTipo(tipo_parq);
                    p.setCupos(cupos);
                    p.setDireccion(direccion);
                    p.setK_empresa(empresas.get(k_empresa).getNit());
                    lblMensaje.setText("Ingresando Parqueadero...");
                    miManager.insertarParqueadero(); // commit del parqueadero
                    parqueaderos = miManager.consultarParqueadero();
                    
                    // Commit de las areas del parqueadero y los espacios
                    for(int i=0; i<3; i++){
                        int cuposA = cuposAreas[i];
                        if(cuposA > 0){
                            int tipo = i+1;
                            a.setTipo(tipo);
                            a.setCupo_disp(cuposA);
                            a.setK_parqueadero(parqueaderos.get(parqueaderos.size()-1).getK_parqueadero());
                            
                            lblMensaje.setText("Ingresando area "+i+"...");
                            miManager.insertarArea();
                            areas = miManager.consultarArea();
                           
                            for(int j=0; j<cuposA; j++){
                                String nomEspacio = "";
                                switch(i){
                                    case 0: nomEspacio = "C"; break;
                                    case 1: nomEspacio = "M"; break;
                                    case 2: nomEspacio = "B"; break;
                                }
                                if(j+1<10) nomEspacio+="0";
                                nomEspacio += j+1;
                                e.setNombre(nomEspacio);
                                e.setDisponible("S");
                                e.setK_area(areas.get(areas.size()-1).getK_area());
                                
                                lblMensaje.setText("Ingresando espacio " +nomEspacio+"...");
                                miManager.insertarEspacio();
                            }
                        }
                    }
                    
                    // Commit de la tarifa
                    for(int i=0; i<3; i++){
                        t.setK_parqueadero(parqueaderos.get(parqueaderos.size()-1).getK_parqueadero());
                        t.setTipo_vehiculo(i+1);
                        t.setValor(calcularTarifa(zona,i+1,tipo_parq));
                        
                        lblMensaje.setText("Ingresando tarifa...");
                        miManager.insertarTarifa();
                    }
                    
                    lblMensaje.setText("Parqueadero ingresado correctamente");
                    
                }else{
                    lblMensaje.setText("No se pudo ingresar el parqueadero");
                }
                
            } catch (CaException ex) {
                Logger.getLogger(PanelRegParqueadero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(event.getSource() == btnCancelar){
            System.err.println("Cancelado...");
        }
    }
}
