package presentacion;

import java.awt.Font;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Carlos
 */

public class PanelReloj extends JPanel implements Runnable{
    
    String hora, minutos, fecha;
    Calendar calendario;
    Thread h1;
    
    private JLabel lblFecha;
    private JLabel lblHora;
    
    public PanelReloj(){
        
        h1 = new Thread(this);
        h1.start();
        
        this.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setBounds(798, 10, 148, 100);
        this.setLayout(null);
        
        lblHora = new JLabel();
        lblHora.setFont(new Font("Tahoma", Font.BOLD, 34));
        lblHora.setBounds(24, 18, 110, 34);
        this.add(lblHora);
        
        lblFecha = new JLabel();
        lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblFecha.setBounds(29, 70, 90, 14);
        this.add(lblFecha);
        
    }
    
    @Override
    public void run() {
        
        Thread ct = Thread.currentThread();
        while(ct==h1){
            calcular();
            lblHora.setText(hora + ":" + minutos);
            lblFecha.setText(fecha);
            try{
                h1.sleep(1000);
            }catch(InterruptedException e){
                System.err.println("Error--> " + e);
            }
        }
    }
    
    public void calcular(){
        
        calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        
        calendario.setTime(fechaHoraActual);
        int h = calendario.get(Calendar.HOUR_OF_DAY);
        if(h < 9) hora = "0" + String.valueOf(h);
        if(h > 9) hora = String.valueOf(h);
        int m = calendario.get(Calendar.MINUTE);
        if(m < 9) minutos = "0" + String.valueOf(m);
        if(m > 9) minutos = String.valueOf(m);
        
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int ano = calendario.get(Calendar.YEAR);
        fecha = String.valueOf(dia) + "/";
        if(mes < 9) fecha += "0" + String.valueOf(mes) + "/";
        if(mes > 9) fecha += String.valueOf(mes) + "/";
        fecha += String.valueOf(ano);
    }
}
