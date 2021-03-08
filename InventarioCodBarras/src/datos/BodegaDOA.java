package datos;

import java.sql.*;

import javax.swing.JOptionPane;

import presentacion.PanelBodega;

public class BodegaDOA {
	
	private ConexionDB db;
	private PanelBodega panelBodega;
	
	Statement stmt = null;
	
	//Variables que se les asigna la informacion
	private String idBodega;
	private int idAdministrador;
	private int capacidad;
        
	public BodegaDOA(PanelBodega pBodega){
		panelBodega=pBodega;		
	}
	
	//Registrar una nueva bodega
	public boolean registrarBodega(){
		idBodega= panelBodega.getTxtNoBodega().getText();
                capacidad=Integer.parseInt(panelBodega.getTxtCapacidad().getText());
                idAdministrador=Integer.parseInt(panelBodega.getVentanaPrincipal().getLblMostrarDocumento().getText());
		boolean existe = false;
	
		try {
			db = new ConexionDB();
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//--Bodega bodega(idB T, idAd I, capc I)
                        //Eje--INSERT INTO Bodega VALUES ('BOD01',1000000001,400);
			
			stmt.executeUpdate( "INSERT INTO Bodega VALUES ('"
                                + idBodega + "',"+ idAdministrador + ","+ capacidad + ");" );			
			db.getC().commit();
			stmt.close();
			db.getC().close();
			System.out.println("Consulta Satisfactoria");
			
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return existe;
	}
	
	//Buscar un producto
	public boolean buscarBodega(){
		idBodega=panelBodega.getTxtBusBodega().getText();
            
		boolean existe = false;
	
		try {
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Bodega bodega(idB T, idAd I, capc I)
			//Eje--SELECT * FROM Bodega WHERE idBodega='BOD23'; 
			
			ResultSet rs = stmt.executeQuery( 
                                "SELECT count(*) FROM Bodega WHERE idBodega='"
                                        +idBodega+"';" );
			if(rs.getInt("count(*)") > 0) {
				rs.close();
				//Consulta una categoria
				 rs = stmt.executeQuery( "SELECT * FROM Bodega WHERE idBodega='"
                                         + idBodega + "';" );
				
				idAdministrador = rs.getInt("idAdmin");
				capacidad = rs.getInt("capacidad");
				rs.close();
				
				existe = true;
			}else {
				rs.close();
				existe = false;
			}
			stmt.close();
			db.getC().close();
			System.out.println("Consulta Satisfactoria");
			
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return existe;
		
	}
	
	//modificar Bodega
	public boolean modificarBodega(){
		boolean existe = false;
	        idBodega= panelBodega.getTxtNoBodega().getText();
                idAdministrador=idAdministrador=Integer.parseInt(panelBodega.getTxtAdmin().getText());
                capacidad=Integer.parseInt(panelBodega.getTxtCapacidad().getText());
		try {
			db = new ConexionDB();
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//bodega(idB T, idAd I, capc I)
			//Eje--UPDATE Proveedor SET rut = 2122312541515, nombre = 'dw' WHERE id=1;
			
                        stmt.executeUpdate( "UPDATE Bodega SET capacidad="+capacidad+" WHERE idBodega='"
                                +idBodega+"';" );
                        db.getC().commit();
                        stmt.close();
                        db.getC().close();
                        existe=true;
			System.out.println("Consulta Satisfactoria");
			
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return existe;	
        }        
            //Eliminar Registro
	public boolean eliminarRegistro() {
                            idBodega= panelBodega.getTxtNoBodega().getText();
		boolean eliminado = false;
		boolean hayProducto =existeProducto();
		if(registroExiste() && !hayProducto){
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro desea eliminar la bodega?", "Alerta!", JOptionPane.YES_NO_OPTION) == 0) {
				try {
					db = new ConexionDB();
					
					db.getC().setAutoCommit(false);
					stmt = db.getC().createStatement();
					//System.out.println( "DELETE from COMPANY where ID='"+ codBarras + "';" );
					
					//Borrar primero de tabla de ExistenciaProductoBodega
					stmt.executeUpdate( "DELETE FROM Bodega WHERE idBodega='"
                                                + idBodega + "';" );
					
                                        db.getC().commit();
					stmt.close();
					db.getC().close();
					
					eliminado = true;
	
				}catch ( Exception e ) {
				   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
			   	}
				
			}
				
		}else {
                    eliminado = false;
		}
		
		return eliminado;
    } 
	//Verificar si registro existe
	public boolean registroExiste() {
                                idBodega= panelBodega.getTxtNoBodega().getText();
		boolean existe = false;
		
		try {
			
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Consulta que verifica que la bodega exista
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Bodega WHERE idBodega='"
                                + idBodega +"';" );

			//Si la bodega existe arroja verdadero, de lo contrario sera falso
			if(rs.getInt("count(*)") == 1)
				existe = true;
			else
				existe = false;
			
			rs.close();
			stmt.close();
			db.getC().close();
				
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		
		return existe;
		
	}

	//Verificar si existe un producto con esa categoria
	public boolean existeProducto() {
		                idBodega= panelBodega.getTxtNoBodega().getText();
		boolean existe = false;
		
		try {
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Consulta que verifica que el producto no exista
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM ExistenciaProductoBodega WHERE idBodega='"
                                + idBodega +"';" );

			//Si el producto existe arroja verdadero, de lo contrario sera falso
			if(rs.getInt("count(*)") >= 1)
				existe = true;
			else
				existe = false;
			
			rs.close();
			stmt.close();
			db.getC().close();
				
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		
		return existe;	
	}
    public String getIdBodega() {
        return idBodega;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public int getCapacidad() {
        return capacidad;
    }        
}
