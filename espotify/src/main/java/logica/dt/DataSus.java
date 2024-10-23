package logica.dt;

import java.time.LocalDate;

public class DataSus {

    protected int id;
   protected String userNick;
    protected String estado;
    protected LocalDate ultiFechaHabi;
    protected String tipoSus;
    
    
    public DataSus(){

    }
   public DataSus(String usrNick){
        this.userNick = usrNick;
   }
    public DataSus(String usrNick, LocalDate fecha){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
    }
    public DataSus(String usrNick, LocalDate fecha, String estado){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = estado;
    }
    public DataSus(String usrNick, LocalDate fecha, String estado, String tipo){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = estado;
        this.tipoSus = tipo;
    }
     public DataSus(String usrNick, LocalDate fecha, String estado, String tipo, int id){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = estado;
        this.tipoSus = tipo;
        this.id = id;
    }
    
    
     public DataSus(String usrNick, String tipo){
        this.userNick = usrNick;
        this.tipoSus = tipo;
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
    public String getTipo(){
        return this.tipoSus;
    }
    public int getid(){
        return this.id;
    }
    
    
}
