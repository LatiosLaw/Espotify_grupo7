/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Nico
 */
@Entity
public class Cliente extends Usuario {
    
    @ManyToMany
    @JoinTable(name="seguidos",
    joinColumns=@JoinColumn(name="nick_seguidor"),
    inverseJoinColumns=@JoinColumn(name="nick_seguido"))
    protected Collection<Usuario> seguidos = new ArrayList<Usuario>();
    @ManyToMany
    @JoinTable(name="temas_favoritos",
    joinColumns=@JoinColumn(name="nick_cliente"),
    inverseJoinColumns=@JoinColumn(name="nombre_tema"))
    protected Collection<Tema> temas_favoritos = new ArrayList<Tema>();
    @ManyToMany
    @JoinTable(name="albumes_favoritos",
    joinColumns=@JoinColumn(name="nick_cliente"),
    inverseJoinColumns=@JoinColumn(name="nombre_album"))
    protected Collection<Album> albumes_favoritos = new ArrayList<Album>();
    @ManyToMany
    @JoinTable(name="listas_favoritas",
    joinColumns=@JoinColumn(name="nick_cliente"),
    inverseJoinColumns=@JoinColumn(name="nombre_lista"))
    protected Collection<ListaReproduccion> listas_favoritas = new ArrayList<ListaReproduccion>();
    
    public Cliente(){
        
    }

    public Cliente(String nickname, String nombre, String apellido, String email, LocalDate fecha_naci) {
        super(nickname, nombre, apellido, email, fecha_naci);
    }
    
    public void seguir(Usuario usuario) {
        this.seguidos.add(usuario);
    }
    
    public void dejarDeSeguir(Usuario usuario) {
        this.seguidos.remove(usuario);
    }
    
    public void temaFav(Tema tema) {
        this.temas_favoritos.add(tema);
    }
    
    public void albumFav(Album album) {
        this.albumes_favoritos.add(album);
    }
    
    public void listasFav(ListaReproduccion lista) {
        this.listas_favoritas.add(lista);
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " " + apellido);
    }
}
