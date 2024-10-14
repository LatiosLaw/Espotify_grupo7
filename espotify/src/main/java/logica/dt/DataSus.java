package logica.dt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class DataSus {

   protected String userNick;
    protected String estado;
    protected LocalDate ultiFechaHabi;
    
    
    
    public DataSus(){

    }
   public DataSus(String usrNick){
        this.userNick = usrNick;
        this.ultiFechaHabi = LocalDate.now(); 
        this.estado = "Vigente";
    }
    public DataSus(String usrNick, LocalDate fecha){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = "Vigente";
    }
    public DataSus(String usrNick, LocalDate fecha, String estado){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = estado;
    }
    
    public String getUserNick(){
        return this.userNick;
    }
    public String getEstado(){
        return this.estado;
    }
    public LocalDate getFecha(){
        return this.ultiFechaHabi;
    }
}
