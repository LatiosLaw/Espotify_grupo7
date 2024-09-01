/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import java.time.LocalDate;
import logica.Cliente;
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
    
    public void agregarTema(String nickname);
    
    public void agregarLista(String nickname);
    
    public void agregarAlbum(String nickname);
    
    public void eliminarTema(String nickname);
    
    public void eliminarLista(String nickname);
    
    public void eliminarAlbum(String nickname);
    
    public void consultarListaReproduccion(String nickname);
    
}
