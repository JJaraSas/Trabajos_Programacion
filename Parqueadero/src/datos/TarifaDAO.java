package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Tarifa;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class TarifaDAO {

    private Tarifa miTarifa;

    public TarifaDAO(){
        miTarifa = new Tarifa();
    }
    
    public void insertarTarifa() throws CaException{
        
        try{
            String strSQL = "INSERT INTO tarifa (i_tipo_vehiculo, v_tarifa, "
                    + "k_parqueadero) VALUES(?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL); 
            prepStmt.setInt(1, miTarifa.getTipo_vehiculo()); 
            prepStmt.setDouble(2, miTarifa.getValor()); 
            prepStmt.setInt(3, miTarifa.getK_parqueadero());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
        }catch(SQLException e){
            throw new CaException( "TarifaDAO", "No pudo crear la Tarifa " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }
    
    public void consultarTarifa() throws CaException{
        
        try{
            String strSQL = "SELECT i_tipo_vehiculo, v_tarifa, k_parqueadero "
                    + "FROM tarifa WHERE k_parqueadero = ? AND i_tipo_vehiculo = ?";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL); 
            prepStmt.setInt(1,miTarifa.getK_parqueadero());
            prepStmt.setInt(2, miTarifa.getTipo_vehiculo());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                miTarifa.setTipo_vehiculo(rs.getInt(1));
                miTarifa.setValor(rs.getInt(2));
                miTarifa.setK_parqueadero(rs.getInt(3));
            }
        }catch(SQLException e){
            throw new CaException( "TarifaDAO", "No pudo encontrar la Tarifa " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }

    public Tarifa getTarifa() {
        return miTarifa;
    }

    public void setTarifa(Tarifa miTarifa) {
        this.miTarifa = miTarifa;
    }
    
    
}
