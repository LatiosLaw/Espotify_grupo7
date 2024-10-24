package logica.controladores;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import logica.Suscripcion;
import logica.Usuario;
import logica.dt.DataErrorBundle;
import logica.dt.DataSus;

public interface IControladorSuscripcion {
    
    public void agregarSus(String nick);
    
    public void agregarSus(String nick, String tipo);
    
    public DataErrorBundle agregarSus(String nick, String esrado, LocalDate fecha, String tipo);
    
    public DataSus retornarSus(int id);
    
    public void modificarFechaSus(int id, LocalDate fecha);
    
    public void cambiarEstadoPendienteSus(int id);
    
    public void cambiarEstadoVigenteSus(int id);
     
    public void cambiarEstadoVencidaSus(int id);
    
    public void cambiarEstadoCancelarSus(int id);
    
    public void eliminarSus(int id);
    
    public boolean isVigente(int id);
    
    public void actualizarEstado(int id, String nuevoEstado);
    
    public void actualizarSusCliente(int id, String nuevoEstado);
    
    public void cancelarAutomatic(int id);
    
    public Collection <Integer> retornarSuscripcionesInteger(String nick);
    
    public Collection<String> findPendientesString(String nick);
    
    public Collection<DataSus> findPendientesVencidasString(String nick);
    
    public void cancelarAutomaticAll();
    
    public boolean tieneSusValida(String nick);
}
