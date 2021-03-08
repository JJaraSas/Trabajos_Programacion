package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Espacio;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class EspacioDAO {
    
    private Espacio miEspacio;
    
    public EspacioDAO(){
        miEspacio = new Espacio();
    }
    
    public void insertarEspacio() throws CaException{
        
        try{
            String strSQL = "INSERT INTO espacio (n_espacio, i_disponible, "
                    + "k_area) VALUES(?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL); 
            prepStmt.setString(1, miEspacio.getNombre()); 
            prepStmt.setString(2, miEspacio.getDisponible()); 
            prepStmt.setInt(3, miEspacio.getK_area());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
        }catch(SQLException e){
            throw new CaException( "EspacioDAO", "No pudo crear el Espacio " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }
    
    public void consultarEspacio(int k_parqueadero, int tipo) throws CaException{
        
        try{
            String strSQL = "SELECT e.k_espacio, e.n_espacio, e.i_disponible, e.k_area FROM espacio e, "
                    + "area a, parqueadero p WHERE p.k_parqueadero = ? AND "
                    + "p.k_parqueadero = a.k_parqueadero AND a.I_TIPO = ? AND "
                    + "a.K_AREA = e.K_AREA AND e.I_DISPONIBLE = 'S'";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL); 
            prepStmt.setInt(1,k_parqueadero);
            prepStmt.setInt(2,tipo);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                miEspacio.setK_espacio(rs.getInt(1));
                miEspacio.setNombre(rs.getString(2));
                miEspacio.setDisponible(rs.getString(3));
                miEspacio.setK_area(rs.getInt(4));
            }
            
        }catch(SQLException e){
            throw new CaException( "EspacioDAO", "No pudo consultar el Espacio" + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }
    
    public void actualizarEspacio() throws CaException {
        
        try{
            String strSQL = "UPDATE espacio SET i_disponible = ? WHERE n_nombre = ? AND k_Area = ?";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL); 
            prepStmt.setString(1,miEspacio.getDisponible());
            prepStmt.setString(2,miEspacio.getNombre());
            prepStmt.setInt(3,miEspacio.getK_area());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException( "EspacioDAO", "No se pudo actualizar el Espacio" + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }

    public Espacio getEspacio() {
        return miEspacio;
    }

    public void setEspacio(Espacio miEspacio) {
        this.miEspacio = miEspacio;
    }
        
}
