package datos;

import java.sql.*;

import javax.swing.JOptionPane;

import presentacion.PanelCategoria;

public class CategoriaDOA {
	
	private ConexionDB db;
	private PanelCategoria panelCategoria;
	
	Statement stmt = null;
	
	//Variables que se les asigna la informacion
	private int id;
	private String nombre;
        private String descripcion;

	public CategoriaDOA(PanelCategoria pCategoria){
            panelCategoria=pCategoria;	
        }
    public boolean registrarCategoria(){
		id=Integer.parseInt(panelCategoria.getTxtId().getText());
                nombre=panelCategoria.getTxtNombre().getText();
                descripcion=panelCategoria.getTxtrDescripcion().getText();
        
		boolean ingresando = false;
	
		try {
			db = new ConexionDB();
			
                        db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			stmt.executeUpdate( "INSERT INTO Categoria VALUES ("+
                                id+",'"+ nombre + "','"+ descripcion + "');" );
			db.getC().commit();
			stmt.close();
			db.getC().close();
			System.out.println("Consulta Satisfactoria");
			ingresando=true;
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return ingresando;
	}
	
	//Buscar un producto
	public boolean buscarCategoria(){
		
		boolean existe = false;
                id=Integer.parseInt(panelCategoria.getTxtIngreseId().getText());
                        
		try {
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Categoria Proveedor(nombre T, rut I, telefono I))
			//Eje--SELECT * FROM Proveedor WHERE rut=10000000001; 
			
			ResultSet rs = stmt.executeQuery( 
                                "SELECT count(*) FROM Categoria WHERE id="+id + 
                                        //panelProveedor.getTxtRut()
                                        ";" );
			//Si existe el producto
			if(rs.getInt("count(*)") > 0) {
				rs.close();
				//Consulta una categoria
				 rs = stmt.executeQuery( "SELECT * FROM Categoria WHERE id=" + id + ";" );
				
				nombre = rs.getString("nombre");
				descripcion = rs.getString("descripcion");
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
	
	//modificar Categoria
	public boolean modificarCategoria(){
		
		boolean act = false;
                id=Integer.parseInt(panelCategoria.getTxtId().getText());
                nombre=panelCategoria.getTxtNombre().getText();
                descripcion=panelCategoria.getTxtrDescripcion().getText();
                
		try {
			db = new ConexionDB();
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//Categoria categoria(id I, nomb T, descr T)
			//Eje--UPDATE Categoria SET rut = 2122312541515, nombre = 'dw' WHERE id=1;
			stmt.executeUpdate( "UPDATE Categoria SET nombre='"
                                + nombre + "', descripcion='"+descripcion+
                                "' WHERE id="+id+";" );
                        db.getC().commit();
                        stmt.close();
                        db.getC().close();
			
			System.out.println("Consulta Satisfactoria");
			
                        act=true;
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return act;	
        }
    	//Eliminar Registro
	public boolean eliminarRegistro() {
		
		id = Integer.parseInt(panelCategoria.getTxtId().getText());
		
		boolean eliminado = false;
		boolean hayProducto =existeProducto();
		if(registroExiste() && !hayProducto){
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro desea eliminar la categoria?", "Alerta!", JOptionPane.YES_NO_OPTION) == 0) {
				try {
					db = new ConexionDB();
					
					db.getC().setAutoCommit(false);
					stmt = db.getC().createStatement();
					//System.out.println( "DELETE from COMPANY where ID='"+ codBarras + "';" );
					
					//Borrar primero de tabla de ExistenciaProductoBodega
					stmt.executeUpdate( "DELETE FROM Categoria WHERE id="+ id + ";" );
					
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
                id=Integer.parseInt(panelCategoria.getTxtId().getText());
            
		boolean existe = false;
		
		try {
			
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Consulta que verifica que el producto no exista
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Categoria WHERE id="
                                + id +";" );

			//Si la categoria existe arroja verdadero, de lo contrario sera falso
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
		
		boolean existe = false;
		
		try {
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Consulta que verifica que el producto no exista
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Producto WHERE idCategoria="
                                + id +";" );

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
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
	    
}
