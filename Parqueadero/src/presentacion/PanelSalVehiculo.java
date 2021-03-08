package presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

public class PanelSalVehiculo extends JPanel implements ActionListener {
    
    private JLabel lblSalidaVehiculo;
    private JLabel lblNumeroFactura;
    
    private JTextField txtNumeroFactura;
    
    private JButton btnBotonSalir;
    
    public PanelSalVehiculo(){
        
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	this.setBounds(10, 120, 630, 531);
	this.setLayout(null);
        
        lblSalidaVehiculo = new JLabel("SALIDA DE VEHICULO");
	lblSalidaVehiculo.setBackground(Color.GRAY);
	lblSalidaVehiculo.setForeground(Color.GRAY);
	lblSalidaVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
	lblSalidaVehiculo.setFont(new Font("Tahoma", Font.BOLD, 24));
	lblSalidaVehiculo.setBounds(60, 26, 429, 24);
	this.add(lblSalidaVehiculo);
        
        lblNumeroFactura = new JLabel("No de factura:");
        lblNumeroFactura.setFont(new Font("Tahoma", Font.BOLD, 13));
	lblNumeroFactura.setBounds(60, 80, 100, 13);
	this.add(lblNumeroFactura);
        
        txtNumeroFactura = new JTextField();
	txtNumeroFactura.setFont(new Font("Tahoma", Font.PLAIN, 13));
        txtNumeroFactura.setBounds(194, 75, 120, 22);
	this.add(txtNumeroFactura);
	txtNumeroFactura.setColumns(10);
        
        btnBotonSalir = new JButton("Retirar");
        btnBotonSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
	btnBotonSalir.setBounds(160, 120, 102, 22);
        btnBotonSalir.addActionListener(this);
	this.add(btnBotonSalir);
        
        JSeparator separator = new JSeparator();
	separator.setBounds(60, 160, 452, 13);
	this.add(separator);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
