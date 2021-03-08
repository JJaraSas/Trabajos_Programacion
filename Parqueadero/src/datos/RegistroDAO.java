package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Registro;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class RegistroDAO {
    
    private Registro miRegistro;
    
    public RegistroDAO(){
        miRegistro = new Registro();
    }
    
    public void insertarRegistro() throws CaException {
        try{
            String strSQL = "INSERT INTO registro (k_consecutivo, f_entrada, k_espacio, "
                    + "k_vehiculo) VALUES(?,?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1,3);
            prepStmt.setString(2, "06/06/18");
           // prepStmt.setInt(3, miRegistro.getK_espacio());
            prepStmt.setInt(3, 40);
            prepStmt.setString(4, miRegistro.getK_vehiculo());
            System.out.println(strSQL);
            System.out.println(prepStmt.toString());
            prepStmt.executeUpdate();
            
            prepStmt.close();
            ConexionDB.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException( "RegistroDAO", "No pudo crear el Registro " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }
    
    public void actualizarRegistro() throws CaException {
        try{
            String strSQL = "UPDATE registro SET f_salida = ?, v_total = ? "
                    + "WHERE k_consecutivo = ?";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setString(1, "SYSDATE");
            prepStmt.setDouble(2, miRegistro.getValor_total());
            prepStmt.setDouble(3, miRegistro.getConsecutivo());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException( "RegistroDAO", "No pudo crear el Registro " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }

    public Registro getRegistro() {
        return miRegistro;
    }

    public void setRegistro(Registro miRegistro) {
        this.miRegistro = miRegistro;
    }
    
    
}
