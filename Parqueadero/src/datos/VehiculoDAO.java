package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Vehiculo;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class VehiculoDAO {
    
    private Vehiculo miVehiculo;
    
    public VehiculoDAO(){
        miVehiculo = new Vehiculo();
    }
    
    public void insertarVehiculo() throws CaException {
        try{
            String strSQL = "INSERT INTO vehiculo (k_placa, i_tipo_vehiculo, "
                    + "i_marca, i_color) VALUES(?,?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, miVehiculo.getPlaca());
            prepStmt.setInt(2, miVehiculo.getTipo());
            prepStmt.setString(3, miVehiculo.getMarca());
            prepStmt.setString(4, miVehiculo.getColor());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException( "VehiculoDAO", "No pudo crear el Vehiculo " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }
    
    public Vehiculo getVehiculo(){
        return miVehiculo;
    }
    
    public void setVehiculo(Vehiculo miVehiculo){
        this.miVehiculo = miVehiculo;
    }
}
