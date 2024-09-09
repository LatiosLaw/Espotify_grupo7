/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Nico
 */
@Entity
public class ListaParticular extends ListaReproduccion implements Serializable {

    private boolean visibilidad;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "creador_nickname")
    private Cliente creador;

    public ListaParticular() {

    }
    
    public ListaParticular(String nombre, boolean visibilidad) {
        super(nombre);
        this.visibilidad = visibilidad;
    }

    public ListaParticular(String nombre, Cliente cliente) {
        super(nombre);
        this.creador = cliente;
    }

    public ListaParticular(String nombre, boolean visibilidad, Cliente creador) {
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
