/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

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
    joinColumns=@JoinColumn(name="id_seguidor"),
    inverseJoinColumns=@JoinColumn(name="id_seguido"))
    protected Collection<Usuario> seguidos = new ArrayList<Usuario>();
    
    public Cliente(){
        
    }

    public Cliente(String nickname, String nombre, String apellido, String email, String fecha_naci) {
        super(nickname, nombre, apellido, email, fecha_naci);
    }
    
    public void Seguir(Usuario usuario) {
        this.seguidos.add(usuario);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " " + apellido);
    }
}
