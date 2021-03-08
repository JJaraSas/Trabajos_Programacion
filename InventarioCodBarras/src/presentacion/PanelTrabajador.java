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
public class PanelTrabajador extends JPanel implements ActionListener{

    private ControladorTrabajador controlador;
    
    private JLabel lbTrabajador;
    private JLabel lblBusDocumento;
    private JTextField txtBusDocumento;
    
    private JButton btnBuscarDocumento;
    private JSeparator separador;
    private JLabel lblDocumento;
    private JTextField txtDocumento;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblEdad;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JLabel lblInfo;
    private JTextField txtEdad;
	private JLabel lblSexo;
	private ButtonGroup selectSexo;
	private JRadioButton rdbHombre;
	private JRadioButton rdbMujer;
	private JLabel lblBodega;
	private JTextField txtBodega;


	public PanelTrabajador() {
		
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(10, 120, 936, 531);
        this.setLayout(null);

		lbTrabajador = new JLabel("TRABAJADOR");
		lbTrabajador.setForeground(new Color(141, 158, 61));
		lbTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		lbTrabajador.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbTrabajador.setBounds(211, 13, 182, 20);
		this.add(lbTrabajador);
		
		lblBusDocumento = new JLabel("Documento:");
		lblBusDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBusDocumento.setBounds(133, 74, 100, 25);
		this.add(lblBusDocumento);
		
		txtBusDocumento = new JTextField();
		txtBusDocumento.setBounds(245, 75, 116, 25);
		this.add(txtBusDocumento);
		txtBusDocumento.setColumns(10);
		
		btnBuscarDocumento = new JButton("Buscar Trabajador");
		btnBuscarDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscarDocumento.setBounds(373, 74, 172, 25);
		btnBuscarDocumento.addActionListener(getControlador());
		this.add(btnBuscarDocumento);
		
		separador = new JSeparator();
		separador.setBounds(12, 141, 624, 2);
		this.add(separador);
		
		lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDocumento.setBounds(160, 172, 130, 25);
		this.add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDocumento.setBounds(302, 172, 150, 25);
		this.add(txtDocumento);
		txtDocumento.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(160, 209, 135, 25);
		this.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(302, 210, 150, 25);
		this.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdad.setBounds(160, 247, 140, 25);
		this.add(lblEdad);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSexo.setBounds(160, 285, 140, 25);
		add(lblSexo);
		
		selectSexo = new ButtonGroup();
		
		rdbHombre = new JRadioButton("Hombre");
		rdbHombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbHombre.setBounds(302, 288, 91, 21);
		this.add(rdbHombre);
		selectSexo.add(rdbHombre);
		
		rdbMujer = new JRadioButton("Mujer");
		rdbMujer.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbMujer.setBounds(397, 288, 91, 21);
		this.add(rdbMujer);
		selectSexo.add(rdbMujer);
		
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
		lblInfo.setIcon(new ImageIcon(PanelTrabajador.class.getResource("/img/infoTrabajadores.png")));
		lblInfo.setBounds(648, 13, 276, 505);
		this.add(lblInfo);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEdad.setColumns(10);
		txtEdad.setBounds(302, 248, 150, 25);
		add(txtEdad);
		
		lblBodega = new JLabel("Bodega:");
		lblBodega.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBodega.setBounds(160, 323, 140, 25);
		add(lblBodega);
		
		txtBodega = new JTextField();
		txtBodega.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBodega.setColumns(10);
		txtBodega.setBounds(302, 323, 150, 25);
		add(txtBodega);
		
	}

	
	//Manejo de los eventos
	public void actionPerformed(ActionEvent event) {	
	}
            
	
	public ControladorTrabajador getControlador() {
       if(controlador == null){
    	   controlador = new ControladorTrabajador(this);
        }
        return controlador;
    }

	//Get y set
	public JTextField getTxtBusDocumento() {
		return txtBusDocumento;
	}


	public void setTxtBusDocumento(JTextField txtBusDocumento) {
		this.txtBusDocumento = txtBusDocumento;
	}


	public JButton getBtnBuscarDocumento() {
		return btnBuscarDocumento;
	}


	public void setBtnBuscarDocumento(JButton btnBuscarDocumento) {
		this.btnBuscarDocumento = btnBuscarDocumento;
	}


	public JTextField getTxtDocumento() {
		return txtDocumento;
	}


	public void setTxtDocumento(JTextField txtDocumento) {
		this.txtDocumento = txtDocumento;
	}


	public JTextField getTxtNombre() {
		return txtNombre;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public JTextField getTxtEdad() {
		return txtEdad;
	}


	public void setTxtEdad(JTextField txtEdad) {
		this.txtEdad = txtEdad;
	}


	public JRadioButton getRdbHombre() {
		return rdbHombre;
	}


	public void setRdbHombre(JRadioButton rdbHombre) {
		this.rdbHombre = rdbHombre;
	}


	public JRadioButton getRdbMujer() {
		return rdbMujer;
	}


	public void setRdbMujer(JRadioButton rdbMujer) {
		this.rdbMujer = rdbMujer;
	}


	public JTextField getTxtBodega() {
		return txtBodega;
	}


	public void setTxtBodega(JTextField txtBodega) {
		this.txtBodega = txtBodega;
	}
}