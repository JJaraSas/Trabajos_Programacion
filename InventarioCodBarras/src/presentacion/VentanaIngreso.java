package presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Insets;
import java.awt.Font;

/**
* @author SuspDesing
*/

@SuppressWarnings("serial")
public class VentanaIngreso extends JFrame implements ActionListener{
	
	private Modelo modelo;
	private ControladorIngreso controlador;

	private JPanel panelPrincipal;
	private JPanel panelAux;
	
	private JButton btnAdministrador;
	private JButton btnBodega;
	
	private JLabel lblLogo;
	
	//Ingreso Admin
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;
	private JLabel lblPassword;
	private JLabel lblLogin;
	private JButton btnLoginAdm;
	private JButton btnLoginBod;
	private JButton btnAtras;
	private JLabel lblDocumento;
	private JTextField txtDocumento;

	public VentanaIngreso(Modelo mod) {
		
		modelo = mod;
		
		setTitle("UDStock v0.8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		lblLogo = new JLabel("Logo");
		lblLogo.setIcon(new ImageIcon(VentanaIngreso.class.getResource("/img/stock.png")));
		lblLogo.setBounds(30, 50, 200, 200);
		panelPrincipal.add(lblLogo);
		
		panelAux = new JPanel();
		panelAux.setBounds(242, 13, 278, 277);
		panelPrincipal.add(panelAux);
		panelAux.setLayout(null);
		
		//Control del panel que se muestra al iniciar la aplicacion
		panelBotonesSeleccion();
		//panelLoginAdmin();
		//panelLoginBodega();

	}
	
	
	//Funcion para mostrar los botones de seleccion
	public void panelBotonesSeleccion() {
		
		panelAux.removeAll();
		
		btnAdministrador = new JButton("Administrador");
		btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnAdministrador.setBounds(23, 25, 232, 95);
		panelAux.add(btnAdministrador);
		btnAdministrador.addActionListener(getControl());
		
		btnBodega = new JButton("Bodega");
		btnBodega.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnBodega.setBounds(23, 151, 232, 95);
		panelAux.add(btnBodega);
		btnBodega.addActionListener(getControl());
		
        panelAux.revalidate();
        panelAux.repaint();
		
	}
	
	//Funcion para mostrar componentes Login Admin
	public void panelLoginAdmin() {
		
		panelAux.removeAll();
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(12, 116, 75, 25);
		panelAux.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUsuario.setBounds(12, 145, 254, 25);
		panelAux.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(12, 180, 75, 25);
		panelAux.add(lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		pwdPassword.setBounds(12, 209, 254, 25);
		pwdPassword.addKeyListener(getControl());
		panelAux.add(pwdPassword);
		
		lblLogin = new JLabel("Admin");
		lblLogin.setIcon(new ImageIcon(VentanaIngreso.class.getResource("/img/admin.png")));
		lblLogin.setBounds(99, 13, 90, 90);
		panelAux.add(lblLogin);
		
		btnLoginAdm = new JButton("Login");
		btnLoginAdm.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoginAdm.setBounds(92, 244, 97, 25);
		panelAux.add(btnLoginAdm);
		btnLoginAdm.addActionListener(getControl());
		
		btnAtras = new JButton("<-");
		btnAtras.setMargin(new Insets(2, 14, 2, 2));
		btnAtras.setToolTipText("Atras");
		btnAtras.setIcon(new ImageIcon(VentanaIngreso.class.getResource("/img/atras.png")));
		btnAtras.setBounds(12, 13, 30, 30);
		panelAux.add(btnAtras);
		btnAtras.addActionListener(getControl());
		
		 
		panelAux.revalidate();
		panelAux.repaint();
		
	}
	
	//Funcion para mostrar componentes Login Bodega
	public void panelLoginBodega() {
		
        panelAux.removeAll();
		
        lblLogin = new JLabel("Admin");
        lblLogin.setIcon(new ImageIcon(VentanaIngreso.class.getResource("/img/bodega.png")));
        lblLogin.setBounds(99, 13, 90, 90);
        panelAux.add(lblLogin);

        btnLoginBod = new JButton("Ingresar");
        btnLoginBod.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLoginBod.setBounds(92, 244, 97, 25);
        panelAux.add(btnLoginBod);
        btnLoginBod.addActionListener(getControl());

        btnAtras = new JButton("<-");
        btnAtras.setMargin(new Insets(2, 14, 2, 2));
        btnAtras.setToolTipText("Atras");
        btnAtras.setIcon(new ImageIcon(VentanaIngreso.class.getResource("/img/atras.png")));
        btnAtras.setBounds(12, 13, 30, 30);
        panelAux.add(btnAtras);
        btnAtras.addActionListener(getControl());

        lblDocumento = new JLabel("No. Documento:");
        lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDocumento.setBounds(83, 141, 120, 25);
        panelAux.add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
        txtDocumento.setBounds(83, 177, 116, 25);
        txtDocumento.addKeyListener(getControl());
        panelAux.add(txtDocumento);
        txtDocumento.setColumns(10);
		
        panelAux.revalidate();
        panelAux.repaint();
		
	}
	
    //Manejo de los eventos Eventos
    public void actionPerformed(ActionEvent event) {
    	   	
    }
    

    //Metodos get para acceder a los componentes privados 
    
    public ControladorIngreso getControl() {
        if(controlador == null){
            controlador = new ControladorIngreso(this);
        }
        return controlador;
    }
    
    public Modelo getModelo() {
    	return modelo;
    }

	public JButton getBtnAdministrador() {
		return btnAdministrador;
	}
    
	public JButton getBtnBodega() {
		return btnBodega;
	}
	
	public JButton getBtnLoginAdm() {
		return btnLoginAdm;
	}
	
	public JButton getBtnLoginBod() {
		return btnLoginBod;
	}
	
	public JButton getBtnAtras() {
		return btnAtras;
	}


	public JTextField getTxtUsuario() {
		return txtUsuario;
	}


	public JPasswordField getPwdPassword() {
		return pwdPassword;
	}


	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	
	
}
