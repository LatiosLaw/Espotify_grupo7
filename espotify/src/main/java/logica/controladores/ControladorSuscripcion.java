package logica.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.PersistenceException;
import logica.Suscripcion;
import logica.Cliente;
import logica.dt.DataSus;



import persistencia.DAO_Suscripcion;

public class ControladorSuscripcion implements IControladorSuscripcion {
    @Override
    public void agregarSus(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = new Suscripcion(nick);
        
        Cliente cli = new Cliente();
        cli.setNickname(nick);
        
        sus.setUser(cli);
        try {
            daoSus.save(sus);
            System.out.println("Suscripcion agregada exitosamente.");
           // return new DataErrorBundle(true, null);
        } catch (PersistenceException e) {
            System.out.println("Error al guardar la Suscripcion: " + e.getMessage());
           /* if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
            return new DataErrorBundle(true, null);*/
        }
        
    }
    @Override
    public void agregarSus(String nick, String esrado){
        
    }
    @Override
    public void agregarSus(String nick, String esrado, LocalDate fecha){
        
    }
    @Override
    public DataSus retornarSus(String nick){
        
        DataSus sus = new DataSus();
        
        
        
        
        return sus;
    }
    @Override
    public void modificarFechaSus(String nick, LocalDate fecha){
        
    }
    @Override
    public void cambiarEstadoPendienteSus(String nick){
        
    }
    @Override
    public void cambiarEstadoVigenteSus(String nick){
         
     }
    @Override
    public void cambiarEstadoVencidaSus(String nick){
        
    }
    @Override
    public void cambiarEstadoCancelarSus(String nick){
        
    }
    @Override
    public void eliminarSus(String nick){
        
    }
    
    
    
}
