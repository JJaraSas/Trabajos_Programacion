package datos;

import java.sql.*;

import javax.swing.JOptionPane;

import presentacion.PanelIngProducto;

public class IngProductoDAO {
	
	private ConexionDB db;
	private PanelIngProducto panelIngProducto;
	
	Statement stmt = null;
	
	//Variables que se les asigna la informacion
	private String codBarras;	
	private String idBodega;
	private String nombre;
	private String fecha;
	private int perecedero;
	//private String sPerecedero;
	private int categoria;
	//private String sCategoria;
	private int proveedor;
	//private String sProveedor;
    private int cantidad;
    
	public IngProductoDAO(PanelIngProducto pIngProducto){
		panelIngProducto=pIngProducto;
	}
	
	
	//Buscar un producto
	public boolean buscarProducto(){
		
		boolean existe = false;
		codBarras = panelIngProducto.getTxtCodigobarras().getText();
	
		try {
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//producto(nomb T, fIng T, codB T, perec I, idC I, idP I)
			//Eje--SELECT * FROM Producto WHERE codBarras='ARI01'; 
			System.out.println( "SELECT sum(*) FROM Producto WHERE codBarras='" + codBarras + "';" );
			
			//Consulta si producto existe
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Producto WHERE codBarras='" + codBarras + "';" );
			
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
				
				//Calcula la cantidad para asignarla a "cantidad"
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
	
	//Sumar producto a existencia
	public boolean ingresarProducto(){
		
		
		codBarras = panelIngProducto.getTxtCodigobarras().getText();
		idBodega = panelIngProducto.getVentanaPrincipal().getLblMostrarBodega().getText();

		boolean ingresado = false;
			
		//Si ya hay existencias del producto en bodega , aumenta en uno la cantidad
		if(registroExiste()) {
			
			try {
				db = new ConexionDB();
				db.getC().setAutoCommit(false);
				stmt = db.getC().createStatement();
	
				System.out.println("UPDATE ExistenciaProductoBodega SET cantidad=cantidad+1 WHERE idProducto='" + codBarras + "' AND idBodega='" + idBodega + "';");
				//UPDATE ExistenciaProductoBodega SET cantidad=cantidad+1 WHERE idProducto='CAN01';
				stmt.executeUpdate( "UPDATE ExistenciaProductoBodega SET cantidad=cantidad+1 WHERE idProducto='" + codBarras + "' AND idBodega='"
									+ idBodega + "';" );
				
				db.getC().commit();
				stmt.close();
				db.getC().close();
				System.out.println("Consulta Satisfactoria");
			}catch ( Exception e ) {
				System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
		   	}
			ingresado = true;
			
		//Si no existe en la bodega, se registra en la tabla ExistenciaProductoBodega y la cantidad seria 1
		}else {
			try {
				db = new ConexionDB();
				db.getC().setAutoCommit(false);
				stmt = db.getC().createStatement();
				
				//--ExtProd(idP T, idB T, can I )
				//Eje--INSERT INTO ExistenciaProductoBodega VALUES ('BOD01','AS23',++);
				
				stmt.executeUpdate( "INSERT INTO ExistenciaProductoBodega VALUES ('"
	                                + codBarras + "','"+ idBodega + "', 1);" );	

				db.getC().commit();
				stmt.close();
				db.getC().close();
				System.out.println("Consulta Satisfactoria");
				
			}catch ( Exception e ) {
			   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
		   	}
			
			ingresado = true;
		}
		
		return ingresado;
		
	}
	
	//Verificar si registro existe en una bodega
	public boolean registroExiste() {
		//Obtener el codigo de barras del producto y el id de la bodega asignada al bodegero
		codBarras = panelIngProducto.getTxtCodigobarras().getText();
		idBodega = panelIngProducto.getVentanaPrincipal().getLblMostrarBodega().getText();
		
		boolean existe = false;
		
		try {
			
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			//SELECT cantidad FROM ExistenciaProductoBodega WHERE idProducto='ARI01' AND idBodega= 'BOD01';
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM ExistenciaProductoBodega WHERE idProducto='"+ codBarras 
											+ "' AND idBodega='" + idBodega + "';" );

			//Si la cuenta existe arroja verdadero, de lo contrario sera falso
			if(rs.getInt("count(*)") > 0)
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
	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}

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