package datos;

import java.sql.*;

import javax.swing.JOptionPane;

import presentacion.PanelProveedor;

public class ProveedorDOA {
	
	private ConexionDB db;
	private PanelProveedor panelProveedor;
	
	Statement stmt = null;
	
	//Variables que se les asigna la informacion
	private String nombre;
	private int rut;
	private int telefono;
	
	public ProveedorDOA(PanelProveedor pProveedor){
		panelProveedor=pProveedor;
		
	}
	
	//Registrar una nueva categoria
	public boolean registrarProveedor(){
		
        nombre= panelProveedor.getTxtNombre().getText();
        rut=Integer.parseInt(panelProveedor.getTxtRut().getText());
        telefono=Integer.parseInt(panelProveedor.getTxtTelefono().getText());
        
		boolean existe = false;
	
		try {
			db = new ConexionDB();
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//--Proveedor  proveedor(nomb T, rut  I, telefono I)
                        //Eje--INSERT INTO Proveedor VALUES ('estes',1000000001,12141523);
			
			stmt.executeUpdate( "INSERT INTO Proveedor VALUES ('"
                                + nombre + "',"+ rut + ","+ telefono + ");" );
			db.getC().commit();
			stmt.close();
			db.getC().close();
			System.out.println("Consulta Satisfactoria");
			
			existe = true;
			
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return existe;
	}
	
	//Buscar un producto
	public boolean buscarProveedor(){
		rut=Integer.parseInt(panelProveedor.getTxtBusRut().getText());
		boolean existe = false;
		try {
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			ResultSet rs = stmt.executeQuery( 
                                "SELECT count(*) FROM Proveedor WHERE rut=" + 
                                        rut+";" );
			if(rs.getInt("count(*)") > 0) {
				rs.close();
				//Consulta una categoria
				 rs = stmt.executeQuery( "SELECT * FROM Proveedor WHERE rut="
                                         + rut + ";" );
				
				nombre = rs.getString("nombre");
				telefono = rs.getInt("telefono");
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
	
	//modificar producto
	public boolean modificarProveedor(){
		nombre= panelProveedor.getTxtNombre().getText();
                rut=Integer.parseInt(panelProveedor.getTxtRut().getText());
                telefono=Integer.parseInt(panelProveedor.getTxtTelefono().getText());
		
		boolean existe = false;
	
		try {
			db = new ConexionDB();
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//Proveedor(nomb T, rut I, tel I)
			//Eje--UPDATE Proveedor SET rut = 2122312541515, nombre = 'dw' WHERE id=1;
			
            stmt.executeUpdate( "UPDATE Proveedor SET nombre='"
                    + nombre + "', telefono="+telefono+
                    " WHERE rut="+rut+";" );
            db.getC().commit();
            stmt.close();
            db.getC().close();
			System.out.println("Consulta Satisfactoria");
			existe=true;
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return existe;	
        }
    //Eliminar Registro
	public boolean eliminarRegistro() {
		rut=Integer.parseInt(panelProveedor.getTxtRut().getText());
                
		boolean eliminado = false;
		boolean hayProducto =existeProducto();
		if(registroExiste() && !hayProducto){
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro desea eliminar el proveedor?", "Alerta!", JOptionPane.YES_NO_OPTION) == 0) {
				try {
					db = new ConexionDB();
					
					db.getC().setAutoCommit(false);
					stmt = db.getC().createStatement();
					//System.out.println( "DELETE from COMPANY where ID='"+ codBarras + "';" );
					
					//Borrar primero de tabla de ExistenciaProductoBodega
					stmt.executeUpdate( "DELETE FROM Proveedor WHERE rut="
                                                + rut + ";" );
					
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
                rut=Integer.parseInt(panelProveedor.getTxtRut().getText());
                
		boolean existe = false;
		
		try {
			
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Consulta que verifica que el producto no exista
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Proveedor WHERE rut="
                                + rut +";" );

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
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Producto WHERE idProveedor="
                                + rut +";" );

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
    public String getNombre() {
        return nombre;
    }

    public int getRut() {
        return rut;
    }

    public int getTelefono() {
        return telefono;
    }
        
}