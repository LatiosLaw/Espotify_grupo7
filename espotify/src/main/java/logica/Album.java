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
import javax.persistence.ManyToOne;
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
    @ManyToOne
    private Artista creador;
    
    @ManyToMany(mappedBy = "albumes_del_genero", cascade = CascadeType.PERSIST)
    private Collection<Genero> generos = new ArrayList<Genero>();
    
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Collection<Tema> temas = new ArrayList<Tema>();

    public Album(){
        
    }
    
    public Album(String nombre, int anioCreacion){
        this.nombre = nombre;
        this.anioCreacion = anioCreacion;
    }
    
    public Album(String nombre, int anioCreacion, Artista artista){
        this.nombre = nombre;
        this.anioCreacion = anioCreacion;
        this.creador = artista;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCreador(Artista artista) {
        this.creador = artista;
    }
    
    public void agregarTema(Tema t) {
        t.setAlbum(this);
        this.temas.add(t);
    }
    
    public void agregarGenero(Genero g) {
        g.agregarAlbumDelGenero(this);
        this.generos.add(g);
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
