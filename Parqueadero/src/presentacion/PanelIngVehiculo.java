package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import negocio.*;
import util.CaException;

/**
 *
 * @author Carlos
 */

public class PanelIngVehiculo extends JPanel implements ActionListener {
    
    private Manager miManager;
    
    private JLabel lblIngresarCarro;
    private JLabel lblPlaca;
    private JLabel lblHoraDeIngreso;
    private JLabel lblTipoDeVehiculo;
    private JLabel lblImgcarro;
    private JLabel lblImgmoto;
    private JLabel lblImgbici;
    private JLabel lblContrato;
    private JLabel lblTipoContrato;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblColor;
    private JLabel lblNombreProp;
    private JLabel lblApellidoProp;
    private JLabel lblCedulaProp;
    
    private JTextField txtPlaca;
    private JTextField txtHoraIngreso;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtColor;
    private JTextField txtNombreProp;
    private JTextField txtApellidoProp;
    private JTextField txtCedulaProp;
    
    private JButton btnBotonIngresar;
    
    private JRadioButton rdbtnAuto;
    private JRadioButton rdbtnMoto;
    private JRadioButton rdbtnBici;
    private JRadioButton rdbtnContratoSi;
    private JRadioButton rdbtnContratoNo;
    
    private ButtonGroup selectVehiculo;
    private ButtonGroup selectContrato;
    
    private JComboBox<String> cbxTipoContrato;
    
    public int parqueaderoSel;
    public String fecha;
    
    public PanelIngVehiculo(){
        
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(10, 120, 630, 531);
        this.setLayout(null);
        
        lblIngresarCarro = new JLabel("INGRESAR CARRO");
		lblIngresarCarro.setForeground(Color.GRAY);
		lblIngresarCarro.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresarCarro.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIngresarCarro.setBounds(61, 26, 451, 24);
		this.add(lblIngresarCarro);
			
		lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaca.setBounds(60, 80, 45, 13);
		this.add(lblPlaca);
			
		txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtPlaca.setBounds(194, 75, 96, 22);
		this.add(txtPlaca);
		txtPlaca.setColumns(10);
		
	//	lblHoraDeIngreso = new JLabel("Hora de Ingreso:");
	//	lblHoraDeIngreso.setFont(new Font("Tahoma", Font.BOLD, 13));
	//	lblHoraDeIngreso.setBounds(60, 112, 124, 13);
	//	this.add(lblHoraDeIngreso);
			
	//	txtHoraIngreso = new JTextField();
	//	txtHoraIngreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
	//	txtHoraIngreso.setBounds(194, 107, 96, 22);
	//	this.add(txtHoraIngreso);
	//	txtHoraIngreso.setColumns(10);
			
		lblTipoDeVehiculo = new JLabel("Tipo de Vehiculo:");
		lblTipoDeVehiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeVehiculo.setBounds(60, 144, 124, 13);
		this.add(lblTipoDeVehiculo);
			
		lblImgcarro = new JLabel("");
		lblImgcarro.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgCarro.png")));
		lblImgcarro.setBounds(194, 139, 30, 30);
		this.add(lblImgcarro);
			
		selectVehiculo = new ButtonGroup();
			
		rdbtnAuto = new JRadioButton("Auto");
		rdbtnAuto.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnAuto.setBounds(231, 140, 59, 21);
		this.add(rdbtnAuto);
		selectVehiculo.add(rdbtnAuto);
			
		lblImgmoto = new JLabel("");
		lblImgmoto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgMoto.png")));
		lblImgmoto.setBounds(305, 139, 30, 30);
		this.add(lblImgmoto);
			
		rdbtnMoto = new JRadioButton("Moto");
		rdbtnMoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnMoto.setBounds(341, 139, 59, 21);
		this.add(rdbtnMoto);
		selectVehiculo.add(rdbtnMoto);
			
		lblImgbici = new JLabel("");
		lblImgbici.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgBici.png")));
		lblImgbici.setBounds(417, 139, 30, 30);
		this.add(lblImgbici);
		
		rdbtnBici = new JRadioButton("Bici");
		rdbtnBici.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnBici.setBounds(453, 140, 59, 21);
		this.add(rdbtnBici);
		selectVehiculo.add(rdbtnBici);
			
		lblContrato = new JLabel("Contrato:");
		lblContrato.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrato.setBounds(60, 181, 70, 13);
		this.add(lblContrato);
		
		//Elements para posible registro de contrato
		selectContrato = new ButtonGroup();
			
		rdbtnContratoSi = new JRadioButton("Si");
		rdbtnContratoSi.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnContratoSi.setBounds(194, 178, 45, 21);
		this.add(rdbtnContratoSi);
		rdbtnContratoSi.addActionListener(this);
		selectContrato.add(rdbtnContratoSi);
		
		rdbtnContratoNo = new JRadioButton("No");
		rdbtnContratoNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnContratoNo.setBounds(241, 177, 45, 21);
		this.add(rdbtnContratoNo);
		rdbtnContratoNo.addActionListener(this);
		selectContrato.add(rdbtnContratoNo);
		rdbtnContratoNo.setSelected(true);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(60, 204, 452, 13);
		this.add(separator);
			
		lblTipoContrato = new JLabel("Tipo Contrato: ");
		lblTipoContrato.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoContrato.setBounds(60, 217, 124, 13);
		this.add(lblTipoContrato);
		
		cbxTipoContrato = new JComboBox<String>();
		cbxTipoContrato.setEnabled(false);
		cbxTipoContrato.setBounds(194, 213, 125, 22);
		cbxTipoContrato.setModel(new DefaultComboBoxModel<String>(new String[] {
	            "Dia", "Semana", "Mes", "año"}));
		this.add(cbxTipoContrato);
			
		lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMarca.setBounds(61, 346, 45, 13);
		this.add(lblMarca);
			
		txtMarca = new JTextField();
		txtMarca.setEnabled(false);
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMarca.setBounds(194, 341, 125, 22);
		this.add(txtMarca);
		txtMarca.setColumns(10);
			
	//	lblModelo = new JLabel("Modelo:");
	//	lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
	//	lblModelo.setBounds(61, 314, 70, 13);
	//	this.add(lblModelo);
	//		
	//	txtModelo = new JTextField();
	//	txtModelo.setEnabled(false);
	//	txtModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
	//	txtModelo.setBounds(194, 309, 125, 22);
	//	this.add(txtModelo);
	//	txtModelo.setColumns(10);
		
		lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblColor.setBounds(61, 378, 70, 13);
		this.add(lblColor);
			
		txtColor = new JTextField();
		txtColor.setEnabled(false);
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtColor.setBounds(194, 373, 125, 22);
		this.add(txtColor);
		txtColor.setColumns(10);
		
		lblNombreProp = new JLabel("Nombre:");
		lblNombreProp.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreProp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreProp.setBounds(61, 250, 107, 13);
		this.add(lblNombreProp);
		
		txtNombreProp = new JTextField();
		txtNombreProp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombreProp.setEnabled(false);
		txtNombreProp.setColumns(10);
		txtNombreProp.setBounds(194, 245, 125, 22);
		this.add(txtNombreProp);
        
        lblApellidoProp = new JLabel("Apellido:");
        lblApellidoProp.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellidoProp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoProp.setBounds(61, 282, 107, 13);
		this.add(lblApellidoProp);
        
        txtApellidoProp = new JTextField();
		txtApellidoProp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellidoProp.setEnabled(false);
		txtApellidoProp.setColumns(10);
		txtApellidoProp.setBounds(194, 277, 125, 22);
		this.add(txtApellidoProp);
        
        lblCedulaProp = new JLabel("Cedula:");
		lblCedulaProp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCedulaProp.setBounds(61, 314, 45, 13);
		this.add(lblCedulaProp);
			
		txtCedulaProp = new JTextField();
		txtCedulaProp.setEnabled(false);
		txtCedulaProp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCedulaProp.setBounds(194, 309, 125, 22);
		this.add(txtCedulaProp);
		txtCedulaProp.setColumns(10);
        
        btnBotonIngresar = new JButton("Ingresar");
        btnBotonIngresar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBotonIngresar.setBounds(160, 410, 102, 22);
        btnBotonIngresar.addActionListener(this);
        this.add(btnBotonIngresar);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int tipo_veh = 1;
        boolean contrato = false;
        //Evento Ingresar Vehiculo
        if(event.getSource() == btnBotonIngresar){
            boolean estado = true;
            
            try{
                miManager = Manager.getInstancia();

                Espacio e = miManager.getEspacio();
                Vehiculo v = miManager.getVehiculo();
                Registro r = miManager.getRegistro();
                Contrato c = miManager.getContrato();
                Cliente cl = miManager.getCliente();

                // DATOS DEL VEHICULO
                String placa = txtPlaca.getText();
                String marca = txtMarca.getText();
                String color = txtColor.getText();

                v.setPlaca(placa);
                v.setTipo(tipo_veh);
                v.setMarca(marca);
                v.setColor(color);
                System.err.println("Insertando vehiculo..");
                miManager.insertarVehiculo();
                System.err.println("Insertado");

                // DATOS DEL REGISTRO
                System.err.println("consultando Espacio con "+parqueaderoSel);
                miManager.consultarEspacio(parqueaderoSel, tipo_veh);
                int k_espacio = e.getK_espacio();
                System.err.println("Consultado.");
                System.err.println("k_espacio = " + k_espacio);
                r.setK_espacio(k_espacio);
                r.setK_vehiculo(placa);
                System.err.println("Insertando registro...");
                miManager.insertarRegistro();
                System.err.println("Insertado");
                
                if(contrato){
                    //DATOS CONTRATO
                    int tipo = cbxTipoContrato.getSelectedIndex()+1;
                    String fecha_inicio = fecha;
                    String fecha_final;
                    int[] fecha2 = new int[3];
                    char[] fecha3 = fecha_inicio.toCharArray();
                    
                }
                
            }catch (CaException ex) {
                Logger.getLogger(PanelRegParqueadero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Evento RadioButton Carro
        if(event.getSource() == rdbtnAuto){
            tipo_veh = 1;
            txtPlaca.setEnabled(true);
        }
        
        //Evento RadioButton Moto
        if(event.getSource() == rdbtnMoto){
            tipo_veh = 2;
            txtPlaca.setEnabled(true);
        }
        
        //Evento RadioButton Carro
        if(event.getSource() == rdbtnBici){
            tipo_veh = 3;
            txtPlaca.setEnabled(false);
        }
        
        //Evento Radiobutton ContratoNo
	if(event.getSource() == rdbtnContratoNo){
            contrato = false;
            txtNombreProp.setEnabled(false);
            txtApellidoProp.setEnabled(false);
            txtCedulaProp.setEnabled(false);
            txtColor.setEnabled(false);
//            txtModelo.setEnabled(false);
            txtMarca.setEnabled(false);
            cbxTipoContrato.setEnabled(false);
	}
		
	//Evento Radiobutton ContratoSi
	if(event.getSource() == rdbtnContratoSi){
            contrato = true;
            txtNombreProp.setEnabled(true);
            txtApellidoProp.setEnabled(true);
            txtCedulaProp.setEnabled(true);
            txtColor.setEnabled(true);
//            txtModelo.setEnabled(true);
            txtMarca.setEnabled(true);
            cbxTipoContrato.setEnabled(true);
	}
    }
}
