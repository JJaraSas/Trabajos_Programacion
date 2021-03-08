package presentacion;

/**
* @author SuspDesing
*/

public class Modelo{
    
    private VentanaIngreso venIngreso;
    private VentanaPrincipal venPrincipal;
    
    private String usuario;

    // Hace visible la ventana de ingreso
    public void iniciar() {
    	//Limpiar ventanas para que queden limpias por si se a salido de una sesion anterior
    	//venPrincipal = null;
    	venIngreso = null;
    	getVenIngreso().setVisible(true);
    }
    
    // Hace visible la ventana de admin
    public void admin() {
    	getVenPrincipal("Admin").setVisible(true);
    }
    
    // Hace visible la ventana de bodega
    public void bodega() {
    	getVenPrincipal("Bodega").setVisible(true);
    }
    
    
    // Se verifica si VentanaIngreso ya esta creada con anterioridad
    public VentanaIngreso getVenIngreso() {
        if (venIngreso == null) {
            venIngreso = new VentanaIngreso(this);
        }       
        return venIngreso;
    }
    
    // Se verifica si VentanaIngreso ya esta creada con anterioridad
    public VentanaPrincipal getVenPrincipal(String cargo) {
    	//Si la ventana no se ha creado, es creada, de lo contrario se carga los componentes necesarios segun cargo
        if (venPrincipal == null) {
            venPrincipal = new VentanaPrincipal(this, cargo);
        }else {
        	if(cargo == "Admin")
            	venPrincipal.componentesAdmin();
            else
            	venPrincipal.componentesBodega();
        }
        
        venPrincipal.panelAux();
        
        return venPrincipal;
    }

    //get y set
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public VentanaPrincipal getVenPrincipal() {
		return venPrincipal;
	}

	public void setVenPrincipal(VentanaPrincipal venPrincipal) {
		this.venPrincipal = venPrincipal;
	}

	public void setVenIngreso(VentanaIngreso venIngreso) {
		this.venIngreso = venIngreso;
	}

}

