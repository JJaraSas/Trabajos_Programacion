package datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Empresa;

import oracle.jdbc.driver.OracleConnection;

import util.CaException;
import util.ConexionDB;

/**
 *
 * @author Carlos
 */

public class EmpresaDAO {
    
    private Empresa miEmpresa;
    
    public EmpresaDAO(){
        miEmpresa = new Empresa();
    }
    
    public ArrayList<Empresa> consultarEmpresas() throws CaException{
        
        ArrayList<Empresa> empresas;
        
        try{
            
            empresas = new ArrayList<>();
            
            String strSQL = "SELECT k_nit, n_razon_social FROM empresa";
            Connection conexion = ConexionDB.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()){
                miEmpresa = new Empresa();
                miEmpresa.setNit(rs.getDouble(1));
                miEmpresa.setNombre(rs.getString(2));
                
                empresas.add(miEmpresa);
            }
            
        }catch(SQLException e){
            throw new CaException("EmpresaDAO", "No pudo recuperar la Empresa " + e.getMessage());
        }finally{
            ConexionDB.getInstance().liberarConexion();
        }
        
        return empresas;
    }

    public Empresa getEmpresa() {
        return miEmpresa;
    }

    public void setEmpresa(Empresa miEmpresa) {
        this.miEmpresa = miEmpresa;
    }
    
    
}
