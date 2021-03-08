package datos;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import presentacion.PanelTrabajador;

public class TrabajadorDAO {
	
	private ConexionDB db;
	private PanelTrabajador panelTrabajador;
	
	Statement stmt = null;
	
	//Variables que se les asigna la informacion
	private int id;
	private String nombre;
	private int edad;
	private String sexo;
	private String idBodega;
	private String idBodegaResp;
	
	public TrabajadorDAO(PanelTrabajador pTrabajador){
		setPanelTrabajador(pTrabajador);
	}
	
	//Buscar un Trabajador
	public boolean buscarTrabajador(){
		
		id = Integer.parseInt(panelTrabajador.getTxtBusDocumento().getText());
        
		boolean existe = false;
		
		if(trabajadorExiste()) {
			System.out.println("Trabajador Existe");
			try {
				db = new ConexionDB();
				
				stmt = db.getC().createStatement();
				
				ResultSet rs = stmt.executeQuery( "SELECT * FROM Trabajador WHERE id='" + id + "';" );
				
				id = rs.getInt("id");
				nombre = rs.getString("nombre");
				edad = rs.getInt("edad");
				sexo = rs.getString("sexo");
				
				rs = stmt.executeQuery( "SELECT idBodega FROM InventarioBodega WHERE idTrabajador='" + id + "';" );
				idBodega = rs.getString("idBodega");
				
				idBodegaResp = idBodega;
								
				rs.close();
				stmt.close();
				db.getC().close();
				System.out.println("Consulta Satisfactoria");
				
				existe = true;
				
			}catch ( Exception e ) {
			   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
		   	}
		}
	
		
		return existe;
		
	}
	
	
	//Registrar una nueva bodega
	public boolean registrarTrabajador(){
		
		System.out.println("idBodegaResp: " + idBodegaResp);
		
		id = Integer.parseInt(panelTrabajador.getTxtDocumento().getText());
		nombre = panelTrabajador.getTxtNombre().getText();
		edad = Integer.parseInt(panelTrabajador.getTxtEdad().getText());
		if(panelTrabajador.getRdbHombre().isSelected()==true)
			sexo = "M";
		else
			sexo = "F";
		idBodega = panelTrabajador.getTxtBodega().getText();
		
        boolean registrado = false;
        
        
        if(!trabajadorExiste()) {
        	
	        if(cuposBodega()) {
	        	try {
	    			db = new ConexionDB();
	    			db.getC().setAutoCommit(false);
	    			stmt = db.getC().createStatement();
	    			
	    			//--Trabajador   trabajador(id I, nomb T, edad I, sexo T)
	                //INSERT INTO Trabajador VALUES (1000000001,"Juan Perez",20,'M');
	    			
	    			System.out.println( "INSERT INTO Trabajador VALUES ("+ id + ",'" + nombre + "', "
										+ edad + ",'" + sexo + "');" );
	    			
	    			stmt.executeUpdate( "INSERT INTO Trabajador VALUES ("+ id + ",'" + nombre + "', "
	    								+ edad + ",'" + sexo + "');" );	
	    			
	    			System.out.println( "INSERT INTO InventarioBodega VALUES ("+ id + ", '" + idBodega + "', " + "NULL" + ");" );
	    					
	    			stmt.executeUpdate( "INSERT INTO InventarioBodega VALUES ("+ id + ", '" + idBodega + "', " + "NULL" + ");" );	
	    			
	    			db.getC().commit();
	    			stmt.close();
	    			db.getC().close();
	    			System.out.println("Consulta Satisfactoria");
	    			
	    			registrado = true;
	    			
	    		}catch ( Exception e ) {
	    		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	    	   	}
	        }else {
	        	JOptionPane.showMessageDialog(null, "No se pueden asignar mas trabajadores a esta bodega");
	        	registrado = false;
	        }
	       
        }else {
        	
        	if(modificarTrabajador())
        		registrado = true;
        	else
        		registrado = false;
        }
        
		
		return registrado;
	}
	
	//modificar Trabajador
	public boolean modificarTrabajador(){
		
		boolean modificado = false;
		
		id = Integer.parseInt(panelTrabajador.getTxtDocumento().getText());
        System.out.println("tabajador existe");
		try {
			db = new ConexionDB();
			db.getC().setAutoCommit(false);
			stmt = db.getC().createStatement();
			
			//Borrar de Inventario bodega
			//DELETE FROM InventarioBodega WHERE id=1000000005;
            stmt.executeUpdate( "DELETE FROM InventarioBodega WHERE idTrabajador=" + id + ";");
            db.getC().commit();
            System.out.println("idBodegaResp: " + idBodegaResp);
            if(cuposBodega()) {
            	//Actualizar Trabajador
            	db = new ConexionDB();
    			db.getC().setAutoCommit(false);
    			stmt = db.getC().createStatement();
            	
            	System.out.println( "UPDATE Trabajador SET nombre='"+ nombre +"', edad=" + edad 
                        + ", sexo='" + sexo + "' WHERE id=" +id+";" );
            	
            	stmt.executeUpdate( "UPDATE Trabajador SET nombre='"+ nombre +"', edad=" + edad 
                        + ", sexo='" + sexo + "' WHERE id=" +id+";" );
            	
            	//Insertar de nuevo en InventarioBodega
            	System.out.println(  "INSERT INTO InventarioBodega VALUES ("+ id + ", '" + idBodega + "', " + "NULL" + ");" );
            	
            	stmt.executeUpdate( "INSERT INTO InventarioBodega VALUES ("+ id + ", '" + idBodega + "', " + "NULL" + ");" );
            	
            	modificado=true;
            	
            }else {
            	
            	db = new ConexionDB();
    			db.getC().setAutoCommit(false);
    			stmt = db.getC().createStatement();
    			
            	System.out.println(   "INSERT INTO InventarioBodega VALUES ("+ id + ", '" + idBodegaResp + "', " + "NULL" + ");" );
            	
            	//Vuelve a poner los datos de inventarioBodega pues no se puede reasignar bodega al usuario
            	stmt.executeUpdate( "INSERT INTO InventarioBodega VALUES ("+ id + ", '" + idBodegaResp + "', " + "NULL" + ");" );
            	
            	JOptionPane.showMessageDialog(null, "No se pueden asignar mas usuario a esta bodega");
            	
            	modificado=false;
            }
            	
            db.getC().commit();
            stmt.close();
            db.getC().close();
			
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
	   	
	   	return modificado;
	}  
	
	//Obtiene los cupos de una bodega
	public boolean cuposBodega() {
		
		idBodega = panelTrabajador.getTxtBodega().getText();
		
		boolean conCupo = false;
		
		try {
			
			db = new ConexionDB();
			stmt = db.getC().createStatement();
			
			//Consulta que verifica que la bodega tenga cupos
			//--InventarioBodega InvBode(idT I, idB T, nTrab I)
			//INSERT INTO InventarioBodega VALUES(1000000003,'BOD01',NULL);
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM InventarioBodega WHERE idBodega='"
                                + idBodega +"';" );

			//Si la bodega existe arroja verdadero, de lo contrario sera falso
			if(rs.getInt("count(*)") < 2)
				conCupo = true;
			else
				conCupo = false;
			
			rs.close();
			stmt.close();
			db.getC().close();
			
			System.out.println("conCupo: " + conCupo);
		}catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   JOptionPane.showMessageDialog(null, "Base de datos no disponible en el momento");
	   	}
		
		return conCupo;
	}
	
	//verifica si el trabajador ya existe
	public boolean trabajadorExiste() {
		System.out.println("id:" + id);
		
		boolean existe = false;
		
		try {
			
			db = new ConexionDB();
			
			stmt = db.getC().createStatement();
			
			System.out.println(  "SELECT count(*) FROM Trabajador WHERE id=" + id + ";"  );
			//Consulta que verifica que la bodega exista
			ResultSet rs = stmt.executeQuery( "SELECT count(*) FROM Trabajador WHERE id=" + id + ";" );

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
		System.out.println("existe: "+ existe);
		return existe;

	}

	public boolean eliminarRegistro() {
		
		id = Integer.parseInt(panelTrabajador.getTxtDocumento().getText());
		
		boolean eliminado = false;
		
		if(trabajadorExiste()){
			
			if(JOptionPane.showConfirmDialog(null, "¿Esta seguro desea eliminar el T?", "Alerta!", JOptionPane.YES_NO_OPTION) == 0) {
			
				try {
					
					db = new ConexionDB();
					
					db.getC().setAutoCommit(false);
					stmt = db.getC().createStatement();
					
					//producto(nomb T, fIng T, codB T, perec I, idC I, idP I)
					//Eje--INSERT INTO Producto VALUES ('ariel ropa color','14-03-2020','ARI01',1,1,200000002);
					System.out.println( "DELETE FROM InventarioBodega WHERE idTrabajador="+ id+ ";" );
					System.out.println( "DELETE FROM Trabajador WHERE id='"+ id + "';" );
					
					//Borrar primero de tabla de ExistenciaProductoBodega
					stmt.executeUpdate( "DELETE FROM InventarioBodega WHERE idTrabajador="+ id+ ";" );
					
					//Borrar primero de tabla Producto
					stmt.executeUpdate( "DELETE FROM Trabajador WHERE id='"+ id + "';" );
					
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
	
	//Get y set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getIdBodega() {
		return idBodega;
	}
	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}


	public PanelTrabajador getPanelTrabajador() {
		return panelTrabajador;
	}


	public void setPanelTrabajador(PanelTrabajador panelTrabajador) {
		this.panelTrabajador = panelTrabajador;
	}

	public String getIdBodegaResp() {
		return idBodegaResp;
	}

	public void setIdBodegaResp(String idBodegaResp) {
		this.idBodegaResp = idBodegaResp;
	}

}
