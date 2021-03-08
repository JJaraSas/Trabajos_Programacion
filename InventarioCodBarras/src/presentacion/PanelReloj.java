package presentacion;

import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

/**
 * @author Carlos
 */

@SuppressWarnings("serial")
public class PanelReloj extends JPanel{
    
    private JLabel lblRotFecha;
    private JLabel lblFecha;
    
    public PanelReloj(){
    	        
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(798, 10, 148, 100);
        this.setLayout(null);
              
        lblRotFecha = new JLabel("");
        lblRotFecha.setHorizontalAlignment(SwingConstants.CENTER);
        lblRotFecha.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblRotFecha.setBounds(12, 13, 124, 49);
        this.add(lblRotFecha);   
        lblRotFecha.setText("FECHA");
        
        lblFecha = new JLabel("");
        lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblFecha.setBounds(12, 62, 124, 25);
        this.add(lblFecha);
        lblFecha.setText(obtenerFecha());
    }
    
    public static String obtenerFecha() {
    	String formato = "dd-MM-yyyy";
    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
    	LocalDateTime ahora = LocalDateTime.now();
    	return formateador.format(ahora);
    }

	public JLabel getLblFecha() {
		return lblFecha;
	}
}
