package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import codigo.Control;

import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame {

	private JPanel panelPrincipal;
	public JTextArea txtIngreso;
	public JTextArea txtConsola;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		Font FuenteIngreso=new Font("Dialog", Font.PLAIN, 20);
		Font FuenteConsola=new Font("Dialog", Font.PLAIN, 16);
		
		setTitle("SintaxUD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		//---------Panel Botones--------------
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(12, 13, 758, 106);
		panelPrincipal.add(panelBotones);
		panelBotones.setLayout(null);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/correr.png")));
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control cont = new Control();
				try {
					cont.guardar(txtIngreso.getText());
					cont.analisis();
					txtConsola.setText(cont.consola());
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnCorrer.setBounds(12, 13, 97, 80);
		panelBotones.add(btnCorrer);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/limpiar.png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtConsola.setText("");
				txtIngreso.setText("");
			}
		});
		btnLimpiar.setBounds(121, 13, 97, 80);
		panelBotones.add(btnLimpiar);

		//--------Panel Texto----------------
		txtIngreso = new JTextArea();
		txtIngreso.setBounds(12, 13, 758, 394);
		txtIngreso.setFont(FuenteIngreso);
		
		JScrollPane scrollTextArea = new JScrollPane(txtIngreso);
		scrollTextArea.setBounds(12, 132, 758, 350);
		panelPrincipal.add(scrollTextArea);
		
		//---------Panel Consola-------------
		JTabbedPane tabPaneLConsola = new JTabbedPane(JTabbedPane.TOP);
		tabPaneLConsola.setBounds(12, 495, 758, 245);
		panelPrincipal.add(tabPaneLConsola);
		
		txtConsola = new JTextArea();
		txtConsola.setBounds(12, 549, 758, 191);
		txtConsola.setFont(FuenteConsola);
		
		JScrollPane scrollConsola = new JScrollPane(txtConsola);
		tabPaneLConsola.addTab("Consola", null, scrollConsola, null);
			
	}
}
