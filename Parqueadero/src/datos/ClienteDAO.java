package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Cliente;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class ClienteDAO {
    
    private Cliente miCliente;
    
    public ClienteDAO(){
        miCliente = new Cliente();
    }
    
    public void ingresarCliente() throws CaException {
        
        try{
            
            String strSQL = "INSERT INTO cliente (k_cedula, n_nom_cliente, "
                    + "n_ape_cliente, i_telefono) VALUES(?,?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setDouble(1, miCliente.getCedula());
            prepStmt.setString(2, miCliente.getNombre());
            prepStmt.setString(3, miCliente.getApellido());
            prepStmt.setDouble(4, miCliente.getTelefono());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException( "ClienteDAO", "No pudo crear el Cliente " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }

    public Cliente getCliente() {
        return miCliente;
    }

    public void setCliente(Cliente miCliente) {
        this.miCliente = miCliente;
    }
    
    
}
