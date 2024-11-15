package logica.dt;

import java.time.LocalDate;
import logica.Cliente;

public class DataRegi {

   
    protected int id;
    protected String userNick;
    protected String os; 
    protected LocalDate  fehca;
    protected String nave;
    protected Cliente cli = null;
    protected String ip;
    protected String url;

    public DataRegi(){
        
    }
    public DataRegi(String usrNick){
        this.userNick = usrNick;
        this.fehca = LocalDate.now(); 
    }
    
    public DataRegi(String usrNick, String os, String nave){
        this.userNick = usrNick;
        this.fehca = LocalDate.now(); 
        this.os = os;
        this.nave = nave;
    }
     public DataRegi(int id, String usrNick, String os, String nave, LocalDate fecha){
        this.id = id;
        this.userNick = usrNick;
        this.fehca = fecha; 
        this.os = os;
        this.nave = nave;
        
    }
    
    public void setId(int id){
        this.id = id;
    }
  
    public void setUserNick(String usrNick){
        this.userNick = usrNick;
    }
    public void setOs(String os){
         this.os = os;
    }
     public void setUrl(String url){
         this.url = url;
    }
    public void setFecha(LocalDate fecha){
        this.fehca = fecha; 
    }
    public void setUser(Cliente cli){
        this.cli = cli; 
    }
     public void setNave(String nave){
        this.nave = nave; 
    }
     public String getUserNick(){
        return this.userNick;
    }
    public String getOs(){
        return this.os;
    }
    public LocalDate getFecha(){
        return this.fehca;
    }
    public Cliente getUser(){
        return this.cli; 
    }
    public String getNave(){
        return this.nave;
    }
    public String getUrl(){
        return this.url;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setIp(String ip) {
       this.ip = ip;
    }
    
    public String getIp(){
        return this.ip;
    }
}
