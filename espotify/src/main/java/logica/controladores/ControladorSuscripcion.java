package logica.controladores;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
        int idSus = 0;
        sus.setUser(cli);
        
        if(daoSus.findAllInteger() == null){
            idSus = 1;
        }else{
            idSus = daoSus.darIdSus();
            idSus ++;
        }
        sus.setId(idSus);
        
        
        
        
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
            int idSus = 0;
        if(daoSus.findAllInteger() == null){
            idSus = 1;
        }else{
            idSus = daoSus.darIdSus();
            idSus ++;
        }
        sus.setId(idSus);
        
        
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
        int idSus = 0;
        if(daoSus.findAllInteger() == null){
            idSus = 1;
        }else{
            idSus = daoSus.darIdSus();
            idSus ++;
        }
        sus.setId(idSus);
        
        
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
    public DataSus retornarSus(int id){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(id);
        DataSus re_sus = new DataSus(sus.getUserNick(), sus.getFecha(), sus.getEstado());
        return re_sus;
    }
    @Override
    public void modificarFechaSus(int id, LocalDate fecha){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(id);
        sus.setFecha(fecha);
        daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoPendienteSus(int id){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(id);
        sus.setEstado("Pendiente");
        LocalDate currentDate = LocalDate.now();
        sus.setFecha(currentDate);
        daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoVigenteSus(int id){
         DAO_Suscripcion daoSus = new DAO_Suscripcion();
         Suscripcion sus = daoSus.find(id);
         sus.setEstado("Vigente");
         LocalDate currentDate = LocalDate.now();
         sus.setFecha(currentDate);
         daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoVencidaSus(int id){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(id);
        sus.setEstado("Vencida");
        LocalDate currentDate = LocalDate.now();
        sus.setFecha(currentDate);
        daoSus.update(sus);
    }
    @Override
    public void cambiarEstadoCancelarSus(int id){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
         Suscripcion sus = daoSus.find(id);
         sus.setEstado("Cancelada");
         LocalDate currentDate = LocalDate.now();
         sus.setFecha(currentDate);
         daoSus.update(sus);
    }
    @Override
    public void eliminarSus(int id){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        daoSus.delete(id);
    }
    
    @Override
    public boolean isVigente(int id){
       
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        boolean tokenSus = false;
        Suscripcion sus = daoSus.find(id);
        if(sus != null && "Vigente".equals(sus.getEstado())){
            tokenSus = true;
        } 
        return tokenSus;
    }
    @Override
    public void actualizarEstado(int id, String nuevoEstado){
        switch (nuevoEstado) {
            case "Cancelada":
                System.out.println("Entro al if de cancelada");
                this.cambiarEstadoCancelarSus(id);
                break;
            case "Vigente":
                System.out.println("Entro al if de Vigente");
                this.cambiarEstadoVigenteSus(id);
                break;
            default:
                System.out.println("No se entro a ningun case");
                break;
        }
  
    }
    @Override
    public void actualizarSusCliente(int id, String nuevoEstado){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(id);
        System.out.println(sus.getId() + "/" + sus.getEstado());
         System.out.println(nuevoEstado);
        if("Pendiente".equals(sus.getEstado())){
            if(nuevoEstado.equals("Cancelada")){
                this.cambiarEstadoCancelarSus(id);
            }
        }else if("Vencida".equals(sus.getEstado())){
            if(nuevoEstado.equals("Cancelada")){
                this.cambiarEstadoCancelarSus(id);
            }else if(nuevoEstado.equals("Vigente")){
                this.cambiarEstadoVigenteSus(id);
            }
        }
    }
    @Override
    public void cancelarAutomatic(int id){
        boolean token = false;
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Suscripcion sus = daoSus.find(id);
        LocalDate fecha = sus.getFecha();
        LocalDate fechaHoy =  LocalDate.now(); 

      long chronoTriggerYears = ChronoUnit.YEARS.between(fecha,fechaHoy);
      long chronoTriggerMonths = ChronoUnit.MONTHS.between(fecha,fechaHoy);
      long chronoTriggerWeeks = ChronoUnit.WEEKS.between(fecha,fechaHoy);

        if(sus.getTipo() == "Anual"){
            token = true;
             if(chronoTriggerYears > 0){
                this.cambiarEstadoCancelarSus(id);
            }
        }else if(sus.getTipo() == "Mensual"){
            token = true;
            if(chronoTriggerMonths > 0){
                this.cambiarEstadoCancelarSus(id);
            }
        }else if(sus.getTipo() == "Semanal"){
            token = true;
             if(chronoTriggerWeeks > 0){
                this.cambiarEstadoCancelarSus(id);
            }
        }
        if(token == false){
           System.out.println("No pasó sificiente tiempo para cancelar la sus de:" + sus.getUserNick() + ". De tipo: " + sus.getTipo());
        }
    }
    @Override
    public Collection <Integer> retornarSuscripcionesInteger(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Collection<Integer> cola = daoSus.findAllPorNombre(nick);

        return cola; 
    }
    @Override
    public boolean tieneSusValida(String nick){
        boolean isValida = false;
        Collection <Integer> cole = retornarSuscripcionesInteger(nick);
        
        for(Integer sus:cole){
            if(this.isVigente(sus) == true){
                isValida = true;
                return isValida;
            }
        }
        return isValida;
    }
    
    
    
    @Override
    public Collection<String> findPendientesString(String nick){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Collection<Suscripcion> cole = daoSus.findPendientesString(nick);
        Collection<String> colestring = new ArrayList<>();
        for(Suscripcion sus:cole){
            colestring.add(String.valueOf(sus.getId()));
        }
        
        return colestring;
        
    }
    @Override
     public Collection<DataSus> findPendientesVencidasString(String nick){
         DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Collection<Suscripcion> cole = daoSus.findPendientesVencidasString(nick);
        Collection<DataSus> coleData = new ArrayList<>();
        for(Suscripcion sus:cole){
            DataSus susiData = new DataSus(sus.getUserNick(),sus.getFecha(),sus.getEstado(),sus.getTipo(),sus.getId());
            coleData.add(susiData);
        }
        
        return coleData;
     }
    @Override
    public Collection<DataSus> findAllSus(String nick){
         DAO_Suscripcion daoSus = new DAO_Suscripcion();
        Collection<Suscripcion> cole = daoSus.findAllPorCliente(nick);
        Collection<DataSus> coleData = new ArrayList<>();
        for(Suscripcion sus:cole){
            DataSus susiData = new DataSus(sus.getUserNick(),sus.getFecha(),sus.getEstado(),sus.getTipo(),sus.getId());
            coleData.add(susiData);
        }
        
        return coleData;
     }
    
    
    
    @Override
    public void cancelarAutomaticAll(){
        DAO_Suscripcion daoSus = new DAO_Suscripcion();
        
        Collection<Suscripcion> coleSus = daoSus.findVigentes();
      //  Iterator<Suscripcion> ite = coleSus.iterator();
        
        for(Suscripcion coso : coleSus){
            Suscripcion sus = coso;
            this.cancelarAutomatic(sus.getId());
        }
    }
    
    
    
    
    
}
