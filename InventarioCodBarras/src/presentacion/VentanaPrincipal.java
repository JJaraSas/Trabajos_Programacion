package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements ActionListener {
    private Modelo modelo;
    private ControladorVPrincipal controlador;
    
    private JPanel panelPrincipal;
    private JPanel panelMenu;
    private PanelReloj panelReloj;
    private JPanel panelAux;

    
    private JButton btnProducto;
    private JButton btnCategoria;
    private JButton btnProveedor;
    private JButton btnBodega;
    private JButton btnSalir;
    
    private JButton btnIngresarProd;
    private JButton btnRetirarProd;


    private JLabel lblUdstock;
    private JLabel lblUsuario;
    private JLabel lblMostrarDocumento;
    private JLabel lblMostrarBodega;
    private JLabel lblBodega;
    private JButton btnTrabajador;
    

	
    public VentanaPrincipal(Modelo mod, String cargo) {
        
    	modelo = mod;
    	
    	//Implementacion del panel principal
        setTitle("ParqueaSistem 0.1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 970, 700);
        setResizable(false);
        //setUndecorated(true);
        panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);
        
        panelReloj = new PanelReloj();
        panelPrincipal.add(panelReloj);
        
    	panelMenu = new JPanel();
    	panelMenu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
    	panelMenu.setBounds(10, 10, 778, 100);
    	panelPrincipal.add(panelMenu);
    	panelMenu.setLayout(null);
    	
    	datosUsuario();

    	//Cargar componentes segun cargo
        System.out.println(cargo);
        if(cargo == "Admin")
        	componentesAdmin();
        else
        	componentesBodega();
        	
        panelAux();
    }
    
    //Carga del panel Auxiliar
    public void panelAux() {
    	    	
		panelAux = new JPanel();
		panelAux.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAux.setBounds(10, 120, 936, 531);
		panelPrincipal.add(panelAux);
		panelAux.setLayout(null);
		
		//System.out.println("Borrar panelAux");	
		
		lblUdstock = new JLabel("UdStock");
		lblUdstock.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/udStock.png")));
		lblUdstock.setBounds(12, 13, 912, 505);
		panelAux.add(lblUdstock);
		
    }
    
    //Carga de componentes si ingresa un Administrador
    public void componentesAdmin(){

    	panelMenu.removeAll();
    	
    	//Botones 
		btnProducto = new JButton("");
		btnProducto.setToolTipText("Registrar Producto");
		btnProducto.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnProducto.png")));
		btnProducto.setBounds(10, 10, 80, 80);
		btnProducto.addActionListener(getControl());
		panelMenu.add(btnProducto);
			
		btnCategoria = new JButton("");
		btnCategoria.setToolTipText("Registrar Categoria");
		btnCategoria.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnCategoria.png")));
		btnCategoria.setBounds(100, 10, 80, 80);
		btnCategoria.addActionListener(getControl());
		panelMenu.add(btnCategoria);
			
		btnBodega = new JButton("");
        btnBodega.setToolTipText("Registrar Bodega");
        btnBodega.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnBodega.png")));
		btnBodega.setBounds(190, 10, 80, 80);
        btnBodega.addActionListener(getControl());
		panelMenu.add(btnBodega);
		
		btnProveedor = new JButton("");
		btnProveedor.setToolTipText("Registrar Proveedor");
		btnProveedor.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnProveedor.png")));
	    btnProveedor.setBounds(280, 10, 80, 80);
		btnProveedor.addActionListener(getControl());
		panelMenu.add(btnProveedor);
			
		btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnSalir.png")));
		btnSalir.setBounds(462, 10, 80, 80);
		btnSalir.addActionListener(getControl());
		panelMenu.add(btnSalir);
		
		btnTrabajador = new JButton("");
		btnTrabajador.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnTrabajador.png")));
		btnTrabajador.setToolTipText("Personal");
		btnTrabajador.setBounds(370, 10, 80, 80);
		btnTrabajador.addActionListener(getControl());
		panelMenu.add(btnTrabajador);
		
		datosUsuario();
		
		panelMenu.revalidate();
		panelMenu.repaint();
    	
    }

    //Carga de componentes si ingresa personal de Bodega
    public void componentesBodega(){
    	  	
    	panelMenu.removeAll();
    	
		btnIngresarProd = new JButton("");
		btnIngresarProd.setToolTipText("Ingresar producto");
		btnIngresarProd.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnIngresarProd.png")));
		btnIngresarProd.setBounds(10, 10, 80, 80);
		btnIngresarProd.addActionListener(getControl());
		panelMenu.add(btnIngresarProd);
			
		btnRetirarProd = new JButton("");
		btnRetirarProd.setToolTipText("Retirar Producto");
		btnRetirarProd.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnRetirarProd.png")));
		btnRetirarProd.setBounds(100, 10, 80, 80);
		btnRetirarProd.addActionListener(getControl());
		panelMenu.add(btnRetirarProd);
			
		btnSalir = new JButton("");
		btnSalir.setToolTipText("Salir");
		btnSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/btnSalir.png")));
		btnSalir.setBounds(190, 10, 80, 80);
		btnSalir.addActionListener(getControl());
		panelMenu.add(btnSalir);
		
		datosUsuario();
		
		panelMenu.revalidate();
		panelMenu.repaint();
		
    }
    
    //Carga labels que muestra informacion del usuario que inicio secion
    public void datosUsuario() {
    	lblUsuario = new JLabel("Usuario:");
    	lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
    	lblUsuario.setBounds(566, 13, 83, 25);
    	panelMenu.add(lblUsuario);
    	
    	lblMostrarDocumento = new JLabel("Documento");
    	lblMostrarDocumento.setForeground(new Color(0, 128, 128));
    	lblMostrarDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
    	lblMostrarDocumento.setBounds(661, 13, 105, 25);
    	panelMenu.add(lblMostrarDocumento);
    	
    	lblBodega = new JLabel("Bodega:");
    	lblBodega.setFont(new Font("Tahoma", Font.BOLD, 14));
    	lblBodega.setBounds(566, 42, 83, 25);
    	panelMenu.add(lblBodega);
    	
    	lblMostrarBodega = new JLabel("Bodega");
    	lblMostrarBodega.setForeground(new Color(0, 128, 128));
    	lblMostrarBodega.setFont(new Font("Tahoma", Font.BOLD, 14));
    	lblMostrarBodega.setBounds(661, 42, 105, 25);
    	panelMenu.add(lblMostrarBodega);
    }
    
    //Llamar al panel para busqueda/edicion/ingreso de un productos
    public void panelProducto() {
        panelAux.removeAll();
        
    	PanelProducto panelProd = new PanelProducto();
    	panelProd.getTxtFechaingreso().setText(panelReloj.getLblFecha().getText());
    	
        panelAux = panelProd;
        panelPrincipal.add(panelAux);
        panelAux.revalidate();
        panelAux.repaint();
        
    }
    
    //Llamar al panel para busqueda/edicion/ingreso de una categoria
    public void panelCategoria() {
    	PanelCategoria panelCategoria = new PanelCategoria();
        panelAux.removeAll(); 
        panelAux = panelCategoria;
        panelPrincipal.add(panelAux);
        panelAux.revalidate();
        panelAux.repaint();
    }
    
    //Llamar al panel para busqueda/edicion/ingreso de una bodega
    public void panelBodega() {
    	PanelBodega panelBodega = new PanelBodega(this);
        panelAux.removeAll();
        panelAux = panelBodega;
        panelPrincipal.add(panelAux);      
        panelAux.revalidate();
        panelAux.repaint();  
    }
    
    //Llamar al panel para busqueda/edicion/ingreso de un proveedor
    public void panelProveedor() {
    	PanelProveedor panelProveedor = new PanelProveedor();
        panelAux.removeAll();
        panelAux = panelProveedor;
        panelPrincipal.add(panelAux);      
        panelAux.revalidate();
        panelAux.repaint();
    }
    
    //Llamar al panel para busqueda/edicion/ingreso de un trabajador
    public void panelTrabajador() {
    	PanelTrabajador panelTrabajador = new PanelTrabajador();
        panelAux.removeAll();
        panelAux = panelTrabajador;
        panelPrincipal.add(panelAux);      
        panelAux.revalidate();
        panelAux.repaint();
    }
    
    //Llamar al panel para ingresar un producto
    public void panelIngProducto() {
    	PanelIngProducto panelIngProducto = new PanelIngProducto(this);
        panelAux.removeAll();
        panelAux = panelIngProducto;
        panelPrincipal.add(panelAux);      
        panelAux.revalidate();
        panelAux.repaint();
    }
    
    //Llamar al panel para retirar un producto
    public void panelRetProducto() {
    	PanelRetProducto panelRetProducto = new PanelRetProducto(this);
        panelAux.removeAll();
        panelAux = panelRetProducto;
        panelPrincipal.add(panelAux);      
        panelAux.revalidate();
        panelAux.repaint(); 
    }
    
    //Manejo de los eventos
	public void actionPerformed(ActionEvent event) {
    }
	
	//Funciones get
    public ControladorVPrincipal getControl() {
        if(controlador == null){
            controlador = new ControladorVPrincipal(this);
        }
        return controlador;
    }
        
    public Modelo getModelo() {
    	return modelo;
    }
    public JButton getBtnProducto() {
        return btnProducto;
    }

    public JButton getBtnCategoria() {
        return btnCategoria;
    }

    public JButton getBtnProveedor() {
        return btnProveedor;
    }

    public JButton getBtnBodega() {
        return btnBodega;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnIngresarProd() {
        return btnIngresarProd;
    }

    public JButton getBtnRetirarProd() {
        return btnRetirarProd;
    }   
    public JPanel getPanelAux() {
        return panelAux;
    }

	public PanelReloj getPanelReloj() {
		return panelReloj;
	}

	public void setPanelReloj(PanelReloj panelReloj) {
		this.panelReloj = panelReloj;
	}

	public JLabel getLblMostrarDocumento() {
		return lblMostrarDocumento;
	}

	public void setLblMostrarDocumento(JLabel lblMostrarDocumento) {
		this.lblMostrarDocumento = lblMostrarDocumento;
	}

	public JLabel getLblMostrarBodega() {
		return lblMostrarBodega;
	}

	public void setLblMostrarBodega(JLabel lblMostrarBodega) {
		this.lblMostrarBodega = lblMostrarBodega;
	}

	public JButton getBtnTrabajador() {
		return btnTrabajador;
	}
}
