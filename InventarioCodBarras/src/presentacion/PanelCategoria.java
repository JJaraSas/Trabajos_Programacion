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
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PanelCategoria extends JPanel implements ActionListener{

    ControladorCategoria controlador;
    
    private JLabel lblProducto;
    private JLabel lblIngreseId;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblDescripcion;
    private JLabel lblInfo;
    
    private JButton btnBuscarCategoria;
    private JButton btnGuardar;
    private JButton btnEliminar;    
    private JSeparator separador;
    
    private JTextField txtIngreseId;
    private JTextField txtId;
    private JTextField txtNombre;    
   
    private JTextArea txtrDescripcion;
	
	public PanelCategoria() {
		
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(10, 120, 936, 531);
        this.setLayout(null);
		
		//PRODUCTO

		lblProducto = new JLabel("CATEGORIA");
		lblProducto.setForeground(new Color(158, 88, 61));
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblProducto.setBounds(211, 13, 150, 20);
		this.add(lblProducto);
		
		lblIngreseId = new JLabel("Ingrese ID:");
		lblIngreseId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIngreseId.setBounds(133, 74, 100, 25);
		this.add(lblIngreseId);
		
		txtIngreseId = new JTextField();
		txtIngreseId.setBounds(245, 75, 116, 25);
		this.add(txtIngreseId);
		txtIngreseId.setColumns(10);
		
		btnBuscarCategoria = new JButton("Buscar Categoria");
		btnBuscarCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarCategoria.setBounds(373, 74, 160, 25);
		btnBuscarCategoria.addActionListener(getControl());
		this.add(btnBuscarCategoria);
		
		separador = new JSeparator();
		separador.setBounds(12, 141, 624, 2);
		this.add(separador);
		
		lblId = new JLabel("Codigo de ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(160, 172, 130, 25);
		this.add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(302, 172, 150, 25);
		this.add(txtId);
		txtId.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(160, 209, 135, 25);
		this.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(302, 210, 150, 25);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(160, 247, 140, 25);
		this.add(lblDescripcion);
		
		new ButtonGroup();
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(245, 469, 97, 25);
		btnGuardar.addActionListener(getControl());
		this.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(354, 470, 97, 25);
		btnEliminar.addActionListener(getControl());
		this.add(btnEliminar);
		
		
		lblInfo = new JLabel("Info");
		lblInfo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/infoCategoria.png")));
		lblInfo.setBounds(648, 13, 276, 505);
		this.add(lblInfo);
		
		txtrDescripcion = new JTextArea();
		txtrDescripcion.setBounds(302, 254, 150, 116);
		add(txtrDescripcion);
	}

	
	//Manejo de los eventos
	public void actionPerformed(ActionEvent event) {
		
		//Evento boton Buscar Categoria
    	if(event.getSource() == btnBuscarCategoria) {
    		//Se activa la aparecion del boton de eliminar si se encuentra la categoria
    	}
    	
    	//Evento boton Guardar
    	if(event.getSource() == btnGuardar) {

    	}
    	
    	//Evento boton Eliminar
    	if(event.getSource() == btnEliminar) {

    	}
		
    }
    public ControladorCategoria getControl() {
        if(controlador == null){
            controlador = new ControladorCategoria(this);
        }
        return controlador;
    }
    public JButton getBtnBuscarCategoria() {
        return btnBuscarCategoria;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JTextField getTxtIngreseId() {
        return txtIngreseId;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextArea getTxtrDescripcion() {
        return txtrDescripcion;
    }    
}