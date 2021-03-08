package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Parqueadero;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class ParqueaderoDAO {
    
    private Parqueadero miParqueadero;
    
    public ParqueaderoDAO(){
        miParqueadero = new Parqueadero();
    }
    
    public void insertarParqueadero() throws CaException{
        
        try{
            String strSQL = "INSERT INTO parqueadero (n_nombre, i_cupos, i_tipo_parq, "
                    + "i_zona, i_direccion, k_empresa) VALUES(?,?,?,?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL); 
            prepStmt.setString(1, miParqueadero.getNombre());
            prepStmt.setInt(2, miParqueadero.getCupos());
            prepStmt.setInt(3, miParqueadero.getTipo()); 
            prepStmt.setString(4, miParqueadero.getZona());
            prepStmt.setString(5, miParqueadero.getDireccion());
            prepStmt.setDouble(6, miParqueadero.getK_empresa());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
        }catch(SQLException e){
            throw new CaException( "ParqueaderoDAO", "No pudo crear el parqueadero " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }
    
    public void modificarParqueadero(){
      
    }
    
    public void eliminarParqueadero(){
      
    }
    
    public void buscarParqueadero() throws CaException{
        try{
            String strSQL = "SELECT k_parqueadero, n_nombre, i_cupos, i_tipo_parq, i_zona, i_direccion, k_empresa "
                    + "FROM parqueadero WHERE k_parqueadero = ?";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1,miParqueadero.getK_parqueadero());
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                miParqueadero.setK_parqueadero(rs.getInt(1));
                miParqueadero.setNombre(rs.getString(2));
                miParqueadero.setTipo(rs.getInt(3));
                miParqueadero.setZona(rs.getString(4));
                miParqueadero.setDireccion(rs.getString(5));
                miParqueadero.setK_empresa(rs.getDouble(6));
                miParqueadero.setCupos(rs.getInt(7));
            }
        }
        catch(SQLException e){
            throw new CaException("ParqueaderoDAO", "No pudo recuperar el Parqueadero " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
      
    }
    
    public ArrayList<Parqueadero> consultarParqueadero() throws CaException{
        
        ArrayList<Parqueadero> parqueaderos;
        
        try{
            
            parqueaderos = new ArrayList<>();
            
            String strSQL = "SELECT * FROM parqueadero";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                miParqueadero = new Parqueadero();
                miParqueadero.setK_parqueadero(rs.getInt(1));
                miParqueadero.setNombre(rs.getString(2));
                miParqueadero.setCupos(rs.getInt(3));
                miParqueadero.setTipo(rs.getInt(4));
                miParqueadero.setZona(rs.getString(5));
                miParqueadero.setDireccion(rs.getString(6));
                miParqueadero.setK_empresa(rs.getDouble(7));
                
                parqueaderos.add(miParqueadero);
            }
            
        }catch(SQLException e){
            throw new CaException("ParqueaderoDAO", "No pudo recuperar el Parqueadero " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
        
        return parqueaderos;
    }

    public void actualizarParqueadero() throws CaException {

    }
    
    public Parqueadero getParqueadero(){
        return miParqueadero;
    }
    
    public void setParqueadero(Parqueadero miParqueadero){
        this.miParqueadero = miParqueadero;
    }
    
}
