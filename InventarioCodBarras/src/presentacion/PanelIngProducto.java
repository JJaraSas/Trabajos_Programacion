package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelIngProducto extends JPanel implements ActionListener{

    ControladorIngProducto controlador;
    //PRODUCTO
    private JLabel lblProducto;
    private JLabel lblCodigoBarras;
    private JTextField txtCodigobarras;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblFechaingreso;
    private JTextField txtFechaingreso;
    private JLabel lblCategoria;
    private JTextField txtCategoria;
    private JLabel lblProveedor;
    private JTextField txtProveedor;
    private JLabel lblCantidadDisponible;
    private JTextField txtCantidad;
    private JLabel lblPerecedero;
    private ButtonGroup selectPerecedero;
    private JRadioButton rdbPerecederoSi;
    private JRadioButton rdbPerecederoNo;
    private JButton btnIngresar;
    private JButton btnVerificar;
    private JLabel lblInfo;
    private VentanaPrincipal ventanaPrincipal;
	
	public PanelIngProducto(VentanaPrincipal vPrincipal) {
		
		setVentanaPrincipal(vPrincipal);
		
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(10, 120, 936, 531);
        this.setLayout(null);
		
		//PRODUCTO

		lblProducto = new JLabel("INGRESAR PRODUCTO");
		lblProducto.setForeground(new Color(181, 125, 79));
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProducto.setBounds(176, 13, 286, 20);
		this.add(lblProducto);
		
		lblCodigoBarras = new JLabel("Codigo de Barras:");
		lblCodigoBarras.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoBarras.setBounds(170, 125, 130, 25);
		this.add(lblCodigoBarras);
		
		txtCodigobarras = new JTextField();
		txtCodigobarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigobarras.setBounds(312, 125, 150, 25);
		txtCodigobarras.addKeyListener(getControl());
		this.add(txtCodigobarras);
		txtCodigobarras.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(170, 162, 135, 25);
		this.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(312, 163, 150, 25);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblFechaingreso = new JLabel("Fecha de Ingreso:");
		lblFechaingreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaingreso.setBounds(170, 200, 140, 25);
		this.add(lblFechaingreso);
		
		txtFechaingreso = new JTextField();
		txtFechaingreso.setEditable(false);
		txtFechaingreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaingreso.setBounds(312, 201, 150, 25);
		this.add(txtFechaingreso);
		txtFechaingreso.setColumns(10);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(170, 238, 135, 25);
		this.add(lblCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCategoria.setBounds(312, 240, 150, 22);
		this.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProveedor.setBounds(170, 276, 135, 25);
		this.add(lblProveedor);
		
		txtProveedor = new JTextField();
		txtProveedor.setEditable(false);
		txtProveedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProveedor.setBounds(312, 275, 150, 25);
		this.add(txtProveedor);
		txtProveedor.setColumns(10);
		
		lblCantidadDisponible = new JLabel("Cantidad Disp.:");
		lblCantidadDisponible.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidadDisponible.setBounds(170, 314, 135, 25);
		this.add(lblCantidadDisponible);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCantidad.setBounds(312, 315, 150, 25);
		this.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblPerecedero = new JLabel("Perecedero:");
		lblPerecedero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerecedero.setBounds(170, 352, 135, 25);
		this.add(lblPerecedero);
		
		selectPerecedero = new ButtonGroup();
		
		rdbPerecederoNo = new JRadioButton("No");
		rdbPerecederoNo.setEnabled(false);
		rdbPerecederoNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbPerecederoNo.setBounds(312, 355, 59, 21);
		this.add(rdbPerecederoNo);
		selectPerecedero.add(rdbPerecederoNo);
		
		rdbPerecederoSi = new JRadioButton("Si");
		rdbPerecederoSi.setEnabled(false);
		rdbPerecederoSi.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbPerecederoSi.setBounds(383, 355, 59, 21);
		this.add(rdbPerecederoSi);
		selectPerecedero.add(rdbPerecederoSi);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBounds(316, 419, 97, 25);
		btnIngresar.addActionListener(getControl());
		this.add(btnIngresar);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVerificar.setBounds(474, 125, 97, 25);
		btnVerificar.addActionListener(getControl());
		this.add(btnVerificar);
		
		
		lblInfo = new JLabel("Info");
		lblInfo.setIcon(new ImageIcon(PanelIngProducto.class.getResource("/img/infoIngProducto.png")));
		lblInfo.setBounds(648, 13, 276, 505);
		this.add(lblInfo);
	}

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public JButton getBtnVerificar() {
        return btnVerificar;
    }
    
    public ControladorIngProducto getControl() {
        if(controlador == null){
            controlador = new ControladorIngProducto(this);
        }
        return controlador;
    }
	
	//Manejo de los eventos
	public void actionPerformed(ActionEvent event) {
	}

	//Get y set
	public JTextField getTxtCodigobarras() {
		return txtCodigobarras;
	}

	public void setTxtCodigobarras(JTextField txtCodigobarras) {
		this.txtCodigobarras = txtCodigobarras;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtFechaingreso() {
		return txtFechaingreso;
	}

	public void setTxtFechaingreso(JTextField txtFechaingreso) {
		this.txtFechaingreso = txtFechaingreso;
	}

	public JTextField getTxtCategoria() {
		return txtCategoria;
	}

	public void setTxtCategoria(JTextField txtCategoria) {
		this.txtCategoria = txtCategoria;
	}

	public JTextField getTxtProveedor() {
		return txtProveedor;
	}

	public void setTxtProveedor(JTextField txtProveedor) {
		this.txtProveedor = txtProveedor;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(JTextField txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public JRadioButton getRdbPerecederoSi() {
		return rdbPerecederoSi;
	}

	public void setRdbPerecederoSi(JRadioButton rdbPerecederoSi) {
		this.rdbPerecederoSi = rdbPerecederoSi;
	}

	public JRadioButton getRdbPerecederoNo() {
		return rdbPerecederoNo;
	}

	public void setRdbPerecederoNo(JRadioButton rdbPerecederoNo) {
		this.rdbPerecederoNo = rdbPerecederoNo;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

}