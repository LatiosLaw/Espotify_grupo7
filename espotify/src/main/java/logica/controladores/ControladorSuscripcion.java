package logica.controladores;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import javax.persistence.PersistenceException;
import logica.Suscripcion;
import logica.Cliente;
import logica.Usuario;
import logica.dt.DataErrorBundle;
import logica.dt.DataSus;

import persistencia.DAO_Suscripcion;
import persistencia.DAO_Usuario;

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
    public void agregarSus(String nick, String tipo){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = new Suscripcion(nick, tipo);
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
    public DataErrorBundle agregarSus(String nick, String estado, LocalDate fecha, String tipo) {
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = new Suscripcion(nick, fecha, estado, tipo);

        DAO_Usuario daoUser = new DAO_Usuario();

        Usuario cliente = daoUser.findUsuarioByNick(nick);

        if (cliente instanceof Cliente cli) {
            sus.setUser(cli);
            try {
                daoSus.save(sus);
                System.out.println("Suscripcion agregada exitosamente.");
                return new DataErrorBundle(true, 0);
                // return new DataErrorBundle(true, null);
            } catch (PersistenceException e) {
                System.out.println("Error al guardar la Suscripcion: " + e.getMessage());
                /* if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
            return new DataErrorBundle(true, null);*/
            }
        }
        return new DataErrorBundle(false, 1);
    }
    @Override
    public DataSus retornarSus(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(nick);
        DataSus re_sus = new DataSus(sus.getUserNick(), sus.getFecha(), sus.getEstado());
        return re_sus;
    }
    @Override
    public void modificarFechaSus(String nick, LocalDate fecha){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(nick);
        sus.setFecha(fecha);
        daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoPendienteSus(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(nick);
        sus.setEstado("Pendiente");
        LocalDate currentDate = LocalDate.now();
        sus.setFecha(currentDate);
        daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoVigenteSus(String nick){
         DAO_Suscripcion daoSus = new DAO_Suscripcion();
         Suscripcion sus = daoSus.find(nick);
         sus.setEstado("Vigente");
         LocalDate currentDate = LocalDate.now();
         sus.setFecha(currentDate);
         daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoVencidaSus(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(nick);
        sus.setEstado("Vencida");
        LocalDate currentDate = LocalDate.now();
        sus.setFecha(currentDate);
        daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoCancelarSus(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
         Suscripcion sus = daoSus.find(nick);
         sus.setEstado("Cancelada");
         LocalDate currentDate = LocalDate.now();
         sus.setFecha(currentDate);
         daoSus.update(sus);
    }
    @Override
    public void eliminarSus(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        daoSus.delete(nick);
    }
    
    @Override
    public boolean isVigente(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        boolean tokenSus = false;
        Suscripcion sus = daoSus.find(nick);
        if("Vigente".equals(sus.getEstado())){
            tokenSus = true;
        } 
        return tokenSus;
    }
    @Override
    public void actualizarEstado(String nick, String nuevoEstado){
        switch (nuevoEstado) {
            case "Cancelada":
                System.out.println("Entro al if de cancelada");
                this.cambiarEstadoCancelarSus(nick);
                break;
            case "Vigente":
                System.out.println("Entro al if de Vigente");
                this.cambiarEstadoVigenteSus(nick);
                break;
            default:
                System.out.println("No se entro a ningun case");
                break;
        }
  
    }
    @Override
    public void actualizarSusCliente(String nick, String nuevoEstado){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(nick);
        if("Pendiente".equals(sus.getEstado())){
            if(nuevoEstado.equals("Cancelada")){
                this.cambiarEstadoCancelarSus(nick);
            }
        }else if("Vencida".equals(sus.getEstado())){
            
        }
    }
    @Override
    public void cancelarAutomatic(String nick){
        boolean token = false;
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(nick);
        LocalDate fecha = sus.getFecha();
        LocalDate fechaHoy =  LocalDate.now(); 

      long chronoTriggerYears = ChronoUnit.YEARS.between(fecha,fechaHoy);
      long chronoTriggerMonths = ChronoUnit.MONTHS.between(fecha,fechaHoy);
      long chronoTriggerWeeks = ChronoUnit.WEEKS.between(fecha,fechaHoy);

        if(sus.getTipo() == "Anual"){
            token = true;
             if(chronoTriggerYears > 0){
                this.cambiarEstadoCancelarSus(nick);
            }
        }else if(sus.getTipo() == "Mensual"){
            token = true;
            if(chronoTriggerMonths > 0){
                this.cambiarEstadoCancelarSus(nick);
            }
        }else if(sus.getTipo() == "Semanal"){
            token = true;
             if(chronoTriggerWeeks > 0){
                this.cambiarEstadoCancelarSus(nick);
            }
        }
        if(token == false){
           System.out.println("No pasó sificiente tiempo para cancelar la sus de:" + sus.getUserNick() + ". De tipo: " + sus.getTipo());
        }
    }
    @Override
    public Collection <String> retornarSuscripcionesString(){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        return daoSus.findAllString();
        
    }
    @Override
    public Collection<String> findPendientesString(){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        return daoSus.findPendientesString();
        
    }
    @Override
    public void cancelarAutomaticAll(){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        
        Collection<Suscripcion> coleSus = daoSus.findVigentes();
      //  Iterator<Suscripcion> ite = coleSus.iterator();
        
        for(Suscripcion coso : coleSus){
            Suscripcion sus = coso;
            this.cancelarAutomatic(sus.getUserNick());
        }
    }
    
    
    
    
    
}
