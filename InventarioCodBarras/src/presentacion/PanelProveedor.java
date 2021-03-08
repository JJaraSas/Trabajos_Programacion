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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelProveedor extends JPanel implements ActionListener{

    private ControladorProveedor controlador;
    
    private JLabel lblProveedor;
    private JLabel lblBusRut;
    private JTextField txtBusRut;
    
    private JButton btnBuscarProveedor;
    private JSeparator separador;
    private JLabel lblRut;
    private JTextField txtRut;
    private JLabel lblTelefono;
    private JTextField txtTelefono;
    private JLabel lblNombre;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JLabel lblInfo;
    private JTextField txtNombre;

	public PanelProveedor() {
		
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(10, 120, 936, 531);
        this.setLayout(null);

		lblProveedor = new JLabel("PROVEEDOR");
		lblProveedor.setForeground(new Color(158, 145, 61));
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProveedor.setBounds(211, 13, 150, 20);
		this.add(lblProveedor);
		
		lblBusRut = new JLabel("RUT:");
		lblBusRut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBusRut.setBounds(133, 74, 100, 25);
		this.add(lblBusRut);
		
		txtBusRut = new JTextField();
		txtBusRut.setBounds(245, 75, 116, 25);
		this.add(txtBusRut);
		txtBusRut.setColumns(10);
		
		btnBuscarProveedor = new JButton("Buscar Proveedor");
		btnBuscarProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarProveedor.setBounds(373, 74, 160, 25);
		btnBuscarProveedor.addActionListener(getControlador());
		this.add(btnBuscarProveedor);
		
		separador = new JSeparator();
		separador.setBounds(12, 141, 624, 2);
		this.add(separador);
		
		lblRut = new JLabel("RUT:");
		lblRut.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRut.setBounds(160, 172, 130, 25);
		this.add(lblRut);
		
		txtRut = new JTextField();
		txtRut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRut.setBounds(302, 172, 150, 25);
		this.add(txtRut);
		txtRut.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(160, 209, 135, 25);
		this.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setBounds(302, 210, 150, 25);
		this.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(160, 247, 140, 25);
		this.add(lblNombre);
		
		new ButtonGroup();
		
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
		lblInfo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/infoProveedor.png")));
		lblInfo.setBounds(648, 13, 276, 505);
		this.add(lblInfo);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(302, 248, 150, 25);
		add(txtNombre);
	}

	
	//Manejo de los eventos
	public void actionPerformed(ActionEvent event) {
		
	
		
	}
            public ControladorProveedor getControlador() {
       if(controlador == null){
            controlador = new ControladorProveedor(this);
        }
        return controlador;
    }

    public JButton getBtnBuscarProveedor() {
        return btnBuscarProveedor;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }
    public JTextField getTxtBusRut() {
        return txtBusRut;
    }

    public JTextField getTxtRut() {
        return txtRut;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }    
    
}