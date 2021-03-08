package datos;

import java.sql.*;

@SuppressWarnings("unused")
public class ConexionDB {
	
	private Connection c = null;

	public ConexionDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite::resource:CodBarras.db");
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	//Metodo get y set de c
	public Connection getC() {
		return c;
	}

	public void setC(Connection c) {
		this.c = c;
	}
	
}
