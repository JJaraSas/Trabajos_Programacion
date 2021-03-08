
package Logica;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
//import logica.Timbiriche.Estado;


public class SistemaServer implements Runnable{
    private ServerSocket server;
    private Socket client;
    private int puerto;
    private Thread hiloConexiones;
    private boolean esperandoConexiones;
    
    private StringBuffer sbMensajes;
    private ArrayList <Cliente> listaClientes;

    public SistemaServer() {
        listaClientes = new ArrayList<Cliente>();        
        sbMensajes = new StringBuffer();
        esperandoConexiones = true;
    }    
    
    public void activarEsperaConexiones() throws IOException{
        server = new ServerSocket(puerto);
        hiloConexiones = new Thread(this);        
        hiloConexiones.start();
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public StringBuffer getSbMensajes() {
        return sbMensajes;
    }  

    public void enviarMensaje(String msg) throws IOException {        
        // Enviar este mensaje a todos los clientes
        Cliente host;
        sbMensajes.append(msg + "\n");
        for(int c = 0; c < listaClientes.size(); c++){
            host = listaClientes.get(c);
        }
    }

    @Override
    public void run() {
        while(esperandoConexiones){
            try {
                
                client = server.accept(); //espera a que alguien se conecte   
                /*Cliente nuevoCliente = new Cliente(this, client );
                listaClientes.add(nuevoCliente);
                nuevoCliente.start();
                enviarMensaje("Se ha conectado " + nuevoCliente.getClienteConectado());*/
                enviarMensaje("Se ha conectado " +client.getInetAddress().getHostName());
            }catch (IOException ex){
            }            
        }
    }

    public boolean isEsperandoConexiones() {
        return esperandoConexiones;
    }

    public void setEsperandoConexiones(boolean esperandoConexiones) {
        this.esperandoConexiones = esperandoConexiones;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void detenerConexiones() throws IOException {
        Cliente host;
        
        for(int c = 0; c < listaClientes.size(); c++){
            host = listaClientes.get(c);
            host.terminarConexiones();
        }
    }   
}
