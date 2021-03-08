package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Logica.*;

public class Modelo implements Runnable{

    private SistemaServer miSistemaServer;
    private Sistema miSistema;
    private Cliente miCliente;
    //private Timbiriche Juego;
            
    private VentanaPrincipal vistaPrincipal;
    private Inicio VistaInicial;
    
    private int Puerto;
    private String Estado;
    private String Host;
    private Thread hiloDibujo;
    private Thread Mensajes;
    
    private boolean conectado;
    
    public Sistema getMiCliente() {
        if(miSistema == null){
            miSistema = new Sistema();
        }
        return miSistema;
    }
    
    public SistemaServer getMiServer() {
        if(miSistemaServer == null){
            miSistemaServer = new SistemaServer();
        }
        return miSistemaServer;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        if(vistaPrincipal == null){
            vistaPrincipal = new VentanaPrincipal(this);
        }
        return vistaPrincipal;
    }
    
    public Inicio getVentanaInicio() {
        if(VistaInicial == null){
            VistaInicial = new Inicio(this);
        }
        return VistaInicial;
    }
    //************representacion de cU
    public void iniciar() {
        getVentanaInicio().setSize(480, 360);
        getVentanaInicio().setVisible(true);
        Estado ="No tiene";
    }
    
    public void iniciarServidor(int PuertoEntra, String HostEntra){
        getVentanaPrincipal().setSize(660,530);
        getVentanaPrincipal().setVisible(true);
        getVentanaInicio().setVisible(false);
        getVentanaPrincipal().getLblEnunciado().setText("CreandoPartida");
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
        conectado = false;
        Puerto = PuertoEntra;
        Host = HostEntra;
        Estado = "Servidor";
        esperarConexion();       
    }
    
    public void iniciarCliente(int PuertoEntra, String HostEntra){
        getVentanaPrincipal().setSize(660,530);
        getVentanaPrincipal().setVisible(true);        
        getVentanaInicio().setVisible(false);
        conectado = false;
        getVentanaPrincipal().getLblEnunciado().setText("Buscando Partida");
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
        Puerto = PuertoEntra;
        Host = HostEntra;
        Estado = "Cliente";
        conectar();
        
    }
    
    public void esperarConexion(){                
        try {
            //getMiServer().setPuerto(Puerto);
            getMiServer().activarEsperaConexiones();
            getVentanaPrincipal().getLblEnunciado().setText("Buscando partida...");
            Mensajes = new Thread(this);
            Mensajes.start();
            
            //getVentanaPrincipal().getBtnEscuchar().setText("Detener");
            //getVentanaPrincipal().getTxtPuerto().setEnabled(false);
        }catch (IOException ex) {
            System.out.println("el error es, en esperando conexion:"+ex.getMessage());
            mostrarError(ex.getMessage());
        }  
        getVentanaPrincipal().getLblEnunciado().setText("Conectado...");
    }
    
    void terminarConexion() {
        try {
            getMiServer().setEsperandoConexiones(false);
            getMiServer().detenerConexiones();           
            //getVentanaPrincipal().getTxtPuerto().setEnabled(true);
        } catch (IOException ex) {
        }
    }
 
    public void conectar(){
        try {
            System.out.println("Host: "+Host);
            getMiCliente().conectar(Host, Puerto);
            System.out.println("Sirve");
            conectado = true;
            Mensajes = new Thread(this);

            //getVentanaInicial().getTxtHost().setEnabled(false);
            //getVentanaInicial().getTxtPuerto().setEnabled(false);
            //getVentanaInicial().getBtnConectar().setText("Desconectar");
            getVentanaPrincipal().getLblEnunciado().setText("Conectado...");
            getVentanaPrincipal().getTxaMensajes().setEnabled(true);
            getVentanaPrincipal().getTxtMensaje().setEnabled(true);
            getVentanaPrincipal().getBtnEnviar().setEnabled(true);


            //getMiTablero().crearTablero();
            Mensajes.start();

        } catch (IOException ex) {
            System.out.println("el error es en conectar:"+ex.getMessage());
            mostrarError(ex.getMessage());
        }   
    }
    
    public void desconectar(){
        try {
            getMiCliente().desconectar();
            conectado = false;
            hiloDibujo = null;
        } catch (IOException ex) {
            mostrarError(ex.getMessage());            
        }
        getVentanaPrincipal().getTxaMensajes().setEnabled(false);
        getVentanaPrincipal().getTxtMensaje().setEnabled(false);
        getVentanaPrincipal().getBtnEnviar().setEnabled(false);
        getVentanaPrincipal().getTxaMensajes().setEditable(false);
    }
    
    public void recibirMensajes(){
        getVentanaPrincipal().getTxaMensajes().setText(getMiServer().getSbMensajes().toString());
    }
 
     private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(vistaPrincipal, msg, "Error de datos", JOptionPane.ERROR_MESSAGE);
    }
    
   public void enviarMensaje(){
        String mensaje;
        mensaje = getVentanaPrincipal().getTxtMensaje().getText();
        if (mensaje.isEmpty()) {
            mostrarError("El campo de mensaje no debe estar vacio");
            return;
        }
        try {
            if(Estado == "Cliente")
                getMiCliente().enviarMensaje(mensaje);
            else
                getMiServer().enviarMensaje(mensaje);
        } catch (IOException ex) {
            mostrarError(ex.getMessage());
        }
    }
    
    public void mostrarMensajes(){
            getVentanaPrincipal().getTxaMensajes().setText(getMiCliente().getMensajes().toString());
    }
    
    @Override    
    public void run(){  
        Thread ct = Thread.currentThread();
        while(true){
            try{
                Thread.sleep(30);        
                mostrarMensajes();
                recibirMensajes();
            }catch(InterruptedException ex){}
        }
    }
}