package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos
 */

public class PanelBusqueda extends JPanel implements ActionListener {
    
    private JLabel lblCriterio;
    private JLabel lblBusqueda;
    private JLabel lblBuscarVehiculo;
    private JLabel lblPlaca;
    private JLabel lblNoPlaca;
    private JLabel lblHoraDeIngreso;
    private JLabel lblHoraDelIngreso;
    private JLabel lblTipoDeVehiculo;
    private JLabel lblImgtipov;
    private JLabel lblTieneContrato;
    private JLabel lblTieneCon;
    private JLabel lblTipoContrato;
    private JLabel lblTipoCon;
    private JLabel lblFechaContrato;
    private JLabel lblFechaCon;
    private JLabel lblPropietario;
    private JLabel lblInfoPropietario;
    private JLabel lblMarca;
    private JLabel lblInfoMarca;
    private JLabel lblModelo;
    private JLabel lblInfoModelo;
    private JLabel lblColor;
    private JLabel lblInfoColor;
    
    private JTextField txtBusqueda;
    
    private JButton btnBuscar;
    
    private JComboBox<String> cbxCriterio;
    
    public PanelBusqueda(){
        
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	this.setBounds(10, 120, 630, 531);
	this.setLayout(null);
        
        lblCriterio = new JLabel("Criterio:");
	lblCriterio.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblCriterio.setBounds(60, 79, 69, 20);
	this.add(lblCriterio);
		
	cbxCriterio = new JComboBox<String>();
	cbxCriterio.setBounds(161, 75, 252, 26);
	cbxCriterio.setModel(new DefaultComboBoxModel<String>(new String[] {
            "No. Placa", 
            "No. Contrato", 
            "No. Estacionamiento"}));
	this.add(cbxCriterio);
		
	lblBusqueda = new JLabel("Busqueda:");
	lblBusqueda.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblBusqueda.setBounds(60, 115, 69, 20);
	this.add(lblBusqueda);
		
	txtBusqueda = new JTextField();
	txtBusqueda.setBounds(161, 111, 252, 26);
	this.add(txtBusqueda);
	txtBusqueda.setColumns(10);
		
	lblBuscarVehiculo = new JLabel("BUSCAR VEHICULO");
	lblBuscarVehiculo.setForeground(Color.GRAY);
	lblBuscarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
	lblBuscarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblBuscarVehiculo.setBounds(60, 30, 363, 20);
	this.add(lblBuscarVehiculo);
		
	JSeparator separator = new JSeparator();
	separator.setBounds(15, 147, 540, 7);
	this.add(separator);
	
	lblPlaca = new JLabel("Placa:");
	lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPlaca.setBounds(60, 164, 45, 20);
	this.add(lblPlaca);
		
	lblNoPlaca = new JLabel("No. Placa");
	lblNoPlaca.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblNoPlaca.setBounds(203, 164, 95, 20);
	this.add(lblNoPlaca);
	
	lblHoraDeIngreso = new JLabel("Hora de Ingreso:");
	lblHoraDeIngreso.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblHoraDeIngreso.setBounds(60, 200, 124, 20);
	this.add(lblHoraDeIngreso);
		
	lblHoraDelIngreso = new JLabel("Hora del Ingreso");
	lblHoraDelIngreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblHoraDelIngreso.setBounds(203, 197, 95, 20);
	this.add(lblHoraDelIngreso);
		
	lblTipoDeVehiculo = new JLabel("Tipo de Vehiculo:");
	lblTipoDeVehiculo.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblTipoDeVehiculo.setBounds(60, 236, 124, 20);
	this.add(lblTipoDeVehiculo);
	
	lblImgtipov = new JLabel("");
	lblImgtipov.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/imgTipo.png")));
	lblImgtipov.setBounds(203, 227, 30, 30);
	this.add(lblImgtipov);
	
	lblTieneContrato = new JLabel("Tiene Contrato:");
	lblTieneContrato.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblTieneContrato.setBounds(59, 272, 125, 20);
	this.add(lblTieneContrato);
		
	lblTieneCon = new JLabel("Tiene Contrato");
	lblTieneCon.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblTieneCon.setBounds(203, 272, 95, 20);
	this.add(lblTieneCon);
	
	lblTipoContrato = new JLabel("Tipo Contrato:");
	lblTipoContrato.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblTipoContrato.setBounds(60, 452, 125, 20);
	this.add(lblTipoContrato);
	
	lblTipoCon = new JLabel("Tipo Cont");
	lblTipoCon.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblTipoCon.setBounds(204, 452, 69, 20);
	this.add(lblTipoCon);
		
	lblFechaContrato = new JLabel("Fecha Contrato:");
	lblFechaContrato.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblFechaContrato.setBounds(60, 488, 125, 20);
	this.add(lblFechaContrato);
	
	lblFechaCon = new JLabel("Fecha Cont");
	lblFechaCon.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblFechaCon.setBounds(204, 488, 69, 20);
	this.add(lblFechaCon);
	
	btnBuscar = new JButton("Buscar");
	btnBuscar.setBounds(441, 110, 115, 29);
	this.add(btnBuscar);
	
	lblPropietario = new JLabel("Propietario:");
	lblPropietario.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblPropietario.setBounds(60, 308, 95, 20);
	this.add(lblPropietario);
		
	lblInfoPropietario = new JLabel("Prop");
	lblInfoPropietario.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblInfoPropietario.setBounds(203, 308, 45, 20);
	this.add(lblInfoPropietario);
	
	lblMarca = new JLabel("Marca:");
	lblMarca.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblMarca.setBounds(60, 344, 69, 20);
	this.add(lblMarca);
		
	lblInfoMarca = new JLabel("Marc");
	lblInfoMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblInfoMarca.setBounds(203, 344, 45, 20);
	this.add(lblInfoMarca);
	
	lblModelo = new JLabel("Modelo:");
	lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblModelo.setBounds(60, 380, 69, 20);
	this.add(lblModelo);
	
	lblInfoModelo = new JLabel("Model");
	lblInfoModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblInfoModelo.setBounds(203, 380, 45, 13);
	this.add(lblInfoModelo);
		
	lblColor = new JLabel("Color:");
	lblColor.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblColor.setBounds(60, 416, 45, 20);
	this.add(lblColor);
		
	lblInfoColor = new JLabel("Col");
	lblInfoColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblInfoColor.setBounds(203, 416, 45, 20);
	this.add(lblInfoColor);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
