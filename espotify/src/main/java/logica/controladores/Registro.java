/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.*;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 *
 * @author Urbina
 */
@Entity
public class Registro implements Serializable {
    
    @Id
    protected int id;
    protected String userNick;
    protected String os; 
    protected LocalDate  fehca;
    protected String nave; 
    
    @OneToOne
    Cliente cli;
    public Registro(){
        
    }
    public Registro(String usrNick){
        this.userNick = usrNick;
        this.fehca = LocalDate.now(); 
    }
    
    public Registro(String usrNick, String os, String nave){
        this.userNick = usrNick;
        this.fehca = LocalDate.now(); 
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
    public int getId(){
        return this.id;
    }

}
