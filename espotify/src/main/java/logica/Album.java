/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Nico
 */
@Entity
public class Album implements Serializable {

    @Id
    private String nombre;
    private int anioCreacion;
    
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Collection<tema> temas = new ArrayList<tema>();

    public Album(){
        
    }
    
    public Album(String nombre, int anioCreacion){
        this.nombre = nombre;
        this.anioCreacion = anioCreacion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarTema(tema t) {
        t.setAlbum(this);
        this.temas.add(t);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }
}
