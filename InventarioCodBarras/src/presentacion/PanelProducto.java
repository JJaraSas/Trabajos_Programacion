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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelProducto extends JPanel implements ActionListener{

    private ControladorProducto controlador;
    //PRODUCTO
    private JLabel lblProducto;
    private JLabel lblIngreseCodigoBarras;
    private JTextField txtIngreseCodigoBarras;
    private JButton btnBuscarProducto;
    private JSeparator separador;
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
    private JLabel lblCantidad;
    private JTextField txtCantidad;
    private JLabel lblPerecedero;
    private ButtonGroup selectPerecedero;
    private JRadioButton rdbPerecederoSi;
    private JRadioButton rdbPerecederoNo;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JLabel lblInfo;
	
	public PanelProducto() {
		
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(10, 120, 936, 531);
        this.setLayout(null);
		
		//PRODUCTO

		lblProducto = new JLabel("PRODUCTO");
		lblProducto.setForeground(new Color(0, 128, 0));
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProducto.setBounds(211, 13, 150, 20);
		this.add(lblProducto);
		
		lblIngreseCodigoBarras = new JLabel("Ingrese Codigo Barras:");
		lblIngreseCodigoBarras.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngreseCodigoBarras.setBounds(72, 74, 161, 25);
		this.add(lblIngreseCodigoBarras);
		
		txtIngreseCodigoBarras = new JTextField();
		txtIngreseCodigoBarras.setBounds(245, 75, 116, 25);
		this.add(txtIngreseCodigoBarras);
		txtIngreseCodigoBarras.setColumns(10);
		
		btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarProducto.setBounds(373, 74, 150, 25);
		btnBuscarProducto.addActionListener(getControlador());
		this.add(btnBuscarProducto);
		
		separador = new JSeparator();
		separador.setBounds(12, 141, 624, 2);
		this.add(separador);
		
		lblCodigoBarras = new JLabel("Codigo de Barras:");
		lblCodigoBarras.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodigoBarras.setBounds(160, 172, 130, 25);
		this.add(lblCodigoBarras);
		
		txtCodigobarras = new JTextField();
		txtCodigobarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigobarras.setBounds(302, 172, 150, 25);
		this.add(txtCodigobarras);
		txtCodigobarras.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(160, 209, 135, 25);
		this.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(302, 210, 150, 25);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblFechaingreso = new JLabel("Fecha de Ingreso:");
		lblFechaingreso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFechaingreso.setBounds(160, 247, 140, 25);
		this.add(lblFechaingreso);
		
		txtFechaingreso = new JTextField();
		txtFechaingreso.setEditable(false);
		txtFechaingreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaingreso.setBounds(302, 248, 150, 25);
		this.add(txtFechaingreso);
		txtFechaingreso.setColumns(10);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(160, 285, 135, 25);
		this.add(lblCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCategoria.setBounds(302, 287, 150, 22);
		this.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProveedor.setBounds(160, 323, 135, 25);
		this.add(lblProveedor);
		
		txtProveedor = new JTextField();
		txtProveedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtProveedor.setBounds(302, 322, 150, 25);
		this.add(txtProveedor);
		txtProveedor.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidad.setBounds(160, 361, 135, 25);
		this.add(lblCantidad);
		
		txtCantidad = new JTextField("0");
		txtCantidad.setEditable(false);
		txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCantidad.setBounds(302, 362, 150, 25);
		this.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblPerecedero = new JLabel("Perecedero:");
		lblPerecedero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerecedero.setBounds(160, 399, 135, 25);
		this.add(lblPerecedero);
		
		selectPerecedero = new ButtonGroup();
		
		rdbPerecederoNo = new JRadioButton("No");
		rdbPerecederoNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbPerecederoNo.setBounds(302, 402, 59, 21);
		this.add(rdbPerecederoNo);
		selectPerecedero.add(rdbPerecederoNo);
		
		rdbPerecederoSi = new JRadioButton("Si");
		rdbPerecederoSi.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbPerecederoSi.setBounds(373, 402, 59, 21);
		this.add(rdbPerecederoSi);
		selectPerecedero.add(rdbPerecederoSi);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(245, 469, 97, 25);
		btnGuardar.addActionListener(getControlador());
		this.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(354, 470, 97, 25);
		btnEliminar.addActionListener(getControlador());
		this.add(btnEliminar);
		
		
		lblInfo = new JLabel("Info");
		lblInfo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/infoProducto.png")));
		lblInfo.setBounds(648, 13, 276, 505);
		this.add(lblInfo);
	}

	
	//Metodos set y get
	public JTextField getTxtIngreseCodigoBarras() {
		return txtIngreseCodigoBarras;
	}


	public void setTxtIngreseCodigoBarras(JTextField txtIngreseCodigoBarras) {
		this.txtIngreseCodigoBarras = txtIngreseCodigoBarras;
	}


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


	public void setBtnBuscarProducto(JButton btnBuscarProducto) {
		this.btnBuscarProducto = btnBuscarProducto;
	}


	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnBuscarProducto() {
		return btnBuscarProducto;
	}


	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public ControladorProducto getControlador() {
		if(controlador == null){
			controlador = new ControladorProducto(this);
        }
        return controlador;
    }
	
	//Manejo de los eventos
	public void actionPerformed(ActionEvent event) {
	}

}
