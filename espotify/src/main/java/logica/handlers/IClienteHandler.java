/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import java.time.LocalDate;
import logica.Album;
import logica.Cliente;
import logica.ListaReproduccion;
import logica.Tema;
import logica.Usuario;

/**
 *
 * @author Nico
 */
public interface IClienteHandler {
    
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac);
    
    
    /**
     * 
     * @param nick1 nickname de la persona que sigue
     * @param nick2 nickname de la persona que es seguida
     */
    public void seguirUsuario(Cliente nick1, Usuario nick2);
    
    public void dejarDeSeguirUsuario(Cliente nick1, Usuario nick2);
    
    public void consultarPerfilCliente();
    
    public void consultarPerfilArtista();
    
    public void agregarTema(Cliente nickcli, Tema nicktem);
    
    public void agregarLista(Cliente nickcli, ListaReproduccion nomlista);
    
    public void agregarAlbum(Cliente nickcli, Album nomalbum);
    
    public void eliminarTema(Cliente nickcli, Tema nicktem);
    
    public void eliminarLista(Cliente nickcli, ListaReproduccion nomlista);
    
    public void eliminarAlbum(Cliente nickcli, Album nomalbum);
    
    public void consultarListaReproduccion(String nickname);
    
}
