package negocio;

import datos.*;
import java.util.ArrayList;
import util.CaException;

/**
 *
 * @author Carlos
 */

public class Manager {
    
    private static Manager instancia;
    
    private final ParqueaderoDAO miParqueaderoDAO;
    private final EmpresaDAO miEmpresaDAO;
    private final TarifaDAO miTarifaDAO;
    private final AreaDAO miAreaDAO;
    private final EspacioDAO miEspacioDAO;
    private final RegistroDAO miRegistroDAO;
    private final VehiculoDAO miVehiculoDAO;
    private final ContratoDAO miContratoDAO;
    private final ClienteDAO miClienteDAO;
    
    private Manager(){
        miParqueaderoDAO = new ParqueaderoDAO();
        miEmpresaDAO = new EmpresaDAO();
        miTarifaDAO = new TarifaDAO();
        miAreaDAO = new AreaDAO();
        miEspacioDAO = new EspacioDAO();
        miRegistroDAO = new RegistroDAO();
        miVehiculoDAO = new VehiculoDAO();
        miContratoDAO = new ContratoDAO();
        miClienteDAO = new ClienteDAO();
    }
    
    /* Patron Singleton implementado para 
    solo tener una instancia de esta clase */
    public static Manager getInstancia() {
        if (instancia == null) {
            instancia = new Manager();
        }
        return instancia;
    }
    
    
    // FUNCIONES PARA EL PARQUEADERO
    public void insertarParqueadero() throws CaException{
        miParqueaderoDAO.insertarParqueadero();
    }
    
    public ArrayList<Parqueadero> consultarParqueadero() throws CaException{
        return miParqueaderoDAO.consultarParqueadero();
    }
    
    public Parqueadero getParqueadero(){
        return miParqueaderoDAO.getParqueadero();
    }
    
    // FUNCIONES PARA LA EMPRESA
    public ArrayList<Empresa> consultarEmpresa() throws CaException{
        return miEmpresaDAO.consultarEmpresas();
    }
    
    public Empresa getEmpresa(){
        return miEmpresaDAO.getEmpresa();
    }
    
    // FUNCIONES PARA LA TARIFA
    public void insertarTarifa() throws CaException{
        miTarifaDAO.insertarTarifa();
    }
    
    public Tarifa getTarifa(){
        return miTarifaDAO.getTarifa();
    }
    
    // FUNCIONES PARA EL AREA
    public void insertarArea() throws CaException{
        miAreaDAO.insertarArea();
    }
    
    public ArrayList<Area> consultarArea() throws CaException{
        return miAreaDAO.consultarAreas();
    }
    
    public Area getArea(){
        return miAreaDAO.getArea();
    }
    
    // FUNCIONES PARA EL ESPACIO
    public void insertarEspacio() throws CaException{
        miEspacioDAO.insertarEspacio();
    }
    
    public void consultarEspacio(int k_parqueadero, int tipo) throws CaException{
        miEspacioDAO.consultarEspacio(k_parqueadero, tipo);
    }
    
    public Espacio getEspacio(){
        return miEspacioDAO.getEspacio();
    }
    
    // FUNCIONES PARA EL REGISTRO
    public void insertarRegistro() throws CaException{
        miRegistroDAO.insertarRegistro();
    }
    
    public void actualizarRegistro() throws CaException{
         miRegistroDAO.actualizarRegistro();
    }
    
    public Registro getRegistro(){
        return miRegistroDAO.getRegistro();
    }
    
    // FUNCIONES PARA EL VEHICULO
    public void insertarVehiculo() throws CaException{
        miVehiculoDAO.insertarVehiculo();
    }
    
    public Vehiculo getVehiculo(){
        return miVehiculoDAO.getVehiculo();
    }
    
    // FUNCIONES PARA EL CONTRATO
    public void insertarContrato() throws CaException{
        miContratoDAO.insertarContrato();
    }
    
    public Contrato getContrato(){
        return miContratoDAO.getContrato();
    }
    
    // FUNCIONES PARA EL CLIENTE
    public void insertarCliente() throws CaException{
        miClienteDAO.ingresarCliente();
    }
    
    public Cliente getCliente(){
        return miClienteDAO.getCliente();
    }
}
