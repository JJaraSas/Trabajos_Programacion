package datos;

import java.sql.*;

import javax.swing.JOptionPane;

import presentacion.PanelProducto;

public class ProductoDAO {
	
	private ConexionDB db;
	private PanelProducto panelProducto;
	
	Statement stmt = null;
	
	//Variables que se les asigna la informacion
	private String nombre;
	private String fecha;
	private String codBarras;
	private int perecedero;
	//private String sPerecedero;
	private int categoria;
	//private String sCategoria;
	private int proveedor;
	//private String sProveedor;
	private int cantidad;
	
	public ProductoDAO(PanelProducto pProducto){
		 panelProducto = pProducto;
		
	}
	
	//Buscar un producto
	public boolean buscarProducto(){
		
		boolean existe = false;
		codBarras = panelProducto.getTxtIngreseCodigoBarras().getText();
	
		try {
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//producto(nomb T, fIng T, codB T, perec I, idC I, idP I)
			//Eje--SELECT * FROM Producto WHERE codBarras='ARI01'; 
			System.out.println( "SELECT sum(*) FROM ExistenciaProductoBodega WHERE idProducto='" + codBarras + "';" );
			
			//Consulta si producto existe
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM ExistenciaProductoBodega WHERE idProducto='" + codBarras + "';" );
			
			//Si existe el producto
			if(rs.getInt("count(*)") > 0) {
				rs.close();
				//Consulta un producto
				 rs = stmt.executeQuery( "SELECT * FROM Producto WHERE codBarras='" + codBarras + "';" );
				
				nombre = rs.getString("nombre");
				fecha = rs.getString("fIngreso");
				codBarras = rs.getString("codBarras");
				perecedero = rs.getInt("perecedero");
				categoria = rs.getInt("idCategoria");
				proveedor = rs.getInt("idProveedor");
				rs.close();
				
				rs = stmt.executeQuery( "SELECT sum(cantidad) FROM ExistenciaProductoBodega WHERE idProducto='" + codBarras + "';" );
				cantidad = rs.getInt("sum(cantidad)");
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
	public boolean modificarProducto(){
		
		boolean actualizado = false;
		
		nombre = panelProducto.getTxtNombre().getText();
		fecha = panelProducto.getTxtFechaingreso().getText();
		codBarras = panelProducto.getTxtCodigobarras().getText();
		if(panelProducto.getRdbPerecederoSi().isSelected()==true)
			perecedero = 1;
		else
			perecedero = 0;
		categoria = Integer.parseInt(panelProducto.getTxtCategoria().getText());
		proveedor = Integer.parseInt(panelProducto.getTxtProveedor().getText());
	
		try {
			db = new ConexionDB();
			
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//producto(nomb T, fIng T, codB T, perec I, idC I, idP I)
			//Eje--UPDATE table_name SET column1 = value1, column2 = value2	WHERE condition;
						
			stmt.executeUpdate( "UPDATE Producto SET nombre='" + nombre + "', fIngreso='" + fecha 
											+ "', perecedero=" + perecedero + ", idCategoria=" + categoria + ", idProveedor=" 
											+ proveedor + " WHERE codBarras='" + codBarras + "';" );
			db.getC().commit();
			stmt.close();
			db.getC().close();
			System.out.println("Consulta Satisfactoria");
			
			actualizado = true;
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return actualizado;
		
	}
	
	
	//Registrar un nuevo producto
	public boolean registrarProducto(){
		
		nombre = panelProducto.getTxtNombre().getText();
		fecha = panelProducto.getTxtFechaingreso().getText();
		codBarras = panelProducto.getTxtCodigobarras().getText();
		if(panelProducto.getRdbPerecederoSi().isSelected()==true)
			perecedero = 1;
		else
			perecedero = 0;
		categoria = Integer.parseInt(panelProducto.getTxtCategoria().getText());
		proveedor = Integer.parseInt(panelProducto.getTxtProveedor().getText());
		
		boolean ingresado = false;
	
		try {
			db = new ConexionDB();
			
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//producto(nomb T, fIng T, codB T, perec I, idC I, idP I)
			//Eje--INSERT INTO Producto VALUES ('ariel ropa color','14-03-2020','ARI01',1,1,200000002);
			System.out.println("INSERT INTO Producto VALUES ('"+ nombre + "', '"
					+ fecha + "', '"+ codBarras + "', "+ perecedero + ", " + categoria + ", "
					+ proveedor + ");");
			
			stmt.executeUpdate( "INSERT INTO Producto VALUES ('"+ nombre + "', '"
								+ fecha + "', '"+ codBarras + "', "+ perecedero + ", " + categoria + ", "
								+ proveedor + ");" );
						
			//stmt.executeUpdate( "INSERT INTO ExistenciaProductoBodega VALUES " ('ARI01','BOD01',NULL);
			
			db.getC().commit();
			stmt.close();
			db.getC().close();

			
			
			ingresado = true;

		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		return ingresado;
		
	}
	
	
	//Eliminar Registro
	public boolean eliminarRegistro() {
		
		codBarras = panelProducto.getTxtCodigobarras().getText();
		
		boolean eliminado = false;
		
		if(registroExiste()){
			
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro desea eliminar el producto?", "Alerta!", JOptionPane.YES_NO_OPTION) == 0) {
			
				try {
					
					db = new ConexionDB();
					
					db.getC().setAutoCommit(false);
					stmt = db.getC().createStatement();
					
					//producto(nomb T, fIng T, codB T, perec I, idC I, idP I)
					//Eje--INSERT INTO Producto VALUES ('ariel ropa color','14-03-2020','ARI01',1,1,200000002);
					System.out.println( "DELETE from COMPANY where ID='"+ codBarras + "';" );
					
					//Borrar primero de tabla de ExistenciaProductoBodega
					stmt.executeUpdate( "DELETE FROM ExistenciaProductoBodega WHERE idProducto='"+ codBarras + "';" );
					
					//Borrar primero de tabla Producto
					stmt.executeUpdate( "DELETE FROM Producto WHERE codBarras='"+ codBarras + "';" );
					
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
		
		codBarras = panelProducto.getTxtCodigobarras().getText();
		
		boolean existe = false;
		
		try {
			
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//Consulta que verifica que el producto no exista
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Producto WHERE codBarras='"+ codBarras +"';" );

			//Si la cuenta existe arroja verdadero, de lo contrario sera falso
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

	
	//Get y set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public int getPerecedero() {
		return perecedero;
	}

	public void setPerecedero(int perecedero) {
		this.perecedero = perecedero;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
