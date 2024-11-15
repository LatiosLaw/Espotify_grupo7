/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

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
public class Suscripcion implements Serializable {
    
    @Id
    protected int id;
    protected String userNick;
    protected String estado; // Cancelada, Vigente, Vencida y Pendiente
    protected LocalDate ultiFechaHabi;
    protected String tipoSus; // Anual, Mensual y Semanal
    
    @OneToOne
    Cliente cli;
    public Suscripcion(){
        
    }
    public Suscripcion(String usrNick){
        this.userNick = usrNick;
        this.ultiFechaHabi = LocalDate.now(); 
        this.estado = "Vigente";
    }
    public Suscripcion(String usrNick, LocalDate fecha){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = "Vigente";
    }
    public Suscripcion(String usrNick, LocalDate fecha, String estado){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = estado;
    }
    public Suscripcion(String usrNick, LocalDate fecha, String estado, String tipo){
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha; 
        this.estado = estado;
        this.tipoSus = tipo;
    }
    public Suscripcion(String usrNick, String tipo){
        this.userNick = usrNick;
        this.ultiFechaHabi = LocalDate.now(); 
        this.estado = "Vigente";
        this.tipoSus = tipo;
    }
    
    
    public void setId(int id){
        this.id = id;
    }
    
    
    public void setUserNick(String usrNick){
        this.userNick = usrNick;
    }
    public void setEstado(String estado){
         this.estado = estado;
    }
    public void setFecha(LocalDate fecha){
        this.ultiFechaHabi = fecha; 
    }
    public void setUser(Cliente cli){
        this.cli = cli; 
    }
     public void setTipo(String tipo){
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
    public Cliente getUser(){
        return this.cli; 
    }
    public String getTipo(){
        return this.tipoSus;
    }
    public int getId(){
        return this.id;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userNick != null ? userNick.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscripcion)) {
            return false;
        }
        Suscripcion other = (Suscripcion) object;
        if ((this.userNick == null && other.userNick != null) || (this.userNick!= null && !this.userNick.equals(other.userNick))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.Suscripcion[ userNick=" + userNick + " ]";
    }
    
}
