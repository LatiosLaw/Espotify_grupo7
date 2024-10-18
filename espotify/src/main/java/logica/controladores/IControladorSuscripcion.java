package logica.controladores;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import logica.Suscripcion;
import logica.Usuario;
import logica.dt.DataSus;

public interface IControladorSuscripcion {
    
    public void agregarSus(String nick);
    
    public void agregarSus(String nick, String esrado);
    
    public void agregarSus(String nick, String esrado, LocalDate fecha);
    
    public DataSus retornarSus(String nick);
    
    public void modificarFechaSus(String nick, LocalDate fecha);
    
    public void cambiarEstadoPendienteSus(String nick);
    
    public void cambiarEstadoVigenteSus(String nick);
     
    public void cambiarEstadoVencidaSus(String nick);
    
    public void cambiarEstadoCancelarSus(String nick);
    
    public void eliminarSus(String nick);
    
    public boolean isVigente(String nick);
    
    public void actualizarEstado(String nick, String nuevoEstado);
    
    public void actualizarSusCliente(String nick, String nuevoEstado);
    
    public void cancelarAutomatic(String nick);
    
    public Collection <String> retornarSuscripcionesString();
    
    public Collection<String> findPendientesString();
    
    public void cancelarAutomaticAll();
}
