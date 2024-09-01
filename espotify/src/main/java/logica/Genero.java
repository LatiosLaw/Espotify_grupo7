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
import javax.persistence.ManyToMany;

/**
 *
 * @author Law
 */
@Entity
public class Genero implements Serializable {

    @Id
    private String nombre;
    private Collection<Genero> subgenero = new ArrayList<Genero>();
    
    @ManyToMany
    private Collection<Album> albumes_del_genero = new ArrayList<Album>();
            
    public Genero(){
    
    }

    public Genero(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarSubgenero(Genero g) {
        this.subgenero.add(g);
    }
    
    public void agregarAlbumDelGenero(Album album) {
        this.albumes_del_genero.add(album);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }
}
