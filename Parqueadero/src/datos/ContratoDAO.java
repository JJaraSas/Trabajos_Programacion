package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Contrato;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class ContratoDAO {
    private Contrato miContrato;
    
    public ContratoDAO(){
        miContrato = new Contrato();
    }
    
    public void insertarContrato() throws CaException {
        try{
            String strSQL = "INSERT INTO contrato (i_tipo, f_inicio, f_final, "
                    + "v_valor, k_vehiculo, k_cliente) VALUES(?,?,?,?,?,?)";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            prepStmt.setInt(1, miContrato.getTipo());
            prepStmt.setString(2, miContrato.getFecha_inicio());
            prepStmt.setString(3, miContrato.getFecha_final());
            prepStmt.setDouble(4, miContrato.getValor());
            prepStmt.setString(5, miContrato.getK_vehiculo());
            prepStmt.setDouble(6, miContrato.getK_cliente());
            prepStmt.executeUpdate();
            prepStmt.close();
            ConexionDB.getInstance().commit();
            
        }catch(SQLException e){
            throw new CaException( "ContratoDAO", "No pudo crear el Contrato " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
    }

    public Contrato getContrato() {
        return miContrato;
    }

    public void setContrato(Contrato miContrato) {
        this.miContrato = miContrato;
    }
    
    
}
