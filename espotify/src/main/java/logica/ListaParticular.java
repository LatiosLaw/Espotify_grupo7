/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nico
 */
@Entity
public class ListaParticular extends ListaReproduccion implements Serializable {

    private boolean visibilidad;
    private Cliente creador;
    
    public ListaParticular(){
    
    }
    
    
    public ListaParticular(String nombre, boolean visibilidad, Cliente creador){
        super(nombre);
        this.visibilidad = visibilidad;
        this.creador = creador;
    }

    public boolean getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(boolean visibilidad) {
        this.visibilidad = visibilidad;
    }

  

    @Override
    public String toString() {
        return "logica.ListaParticular[ visibilidad=" + visibilidad + " ]";
    }
    
}
