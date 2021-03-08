package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Area;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class AreaDAO {
    
    private Area miArea;
    
    public AreaDAO(){
        miArea = new Area();
    }
    
    public void insertarArea() throws CaException {
        
        try{
            
            String strSQL = "INSERT INTO area (i_tipo, i_cupo_disp, "
                    + "k_parqueadero) VALUES(?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, miArea.getTipo()); 
            prepStmt.setInt(2, miArea.getCupo_disp()); 
            prepStmt.setInt(3, miArea.getK_parqueadero());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException( "AreaDAO", "No pudo crear el Area " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }
    
    public ArrayList<Area> consultarAreas() throws CaException{
        
        ArrayList<Area> areas;
        
        try{
            
            areas = new ArrayList<>();
            
            String strSQL = "SELECT * FROM area";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                miArea = new Area();
                miArea.setK_area(rs.getInt(1));
                miArea.setTipo(rs.getInt(2));
                miArea.setCupo_disp(rs.getInt(3));
                miArea.setK_parqueadero(rs.getInt(4));
                
                areas.add(miArea);
            }
            
        }catch(SQLException e){
            throw new CaException("AreaDAO", "No pudo recuperar el Area " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
        
        return areas;
    }

    public Area getArea() {
        return miArea;
    }

    public void setArea(Area miArea) {
        this.miArea = miArea;
    }
    
    
}
