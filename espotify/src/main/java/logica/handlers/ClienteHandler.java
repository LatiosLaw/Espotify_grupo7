/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import javax.persistence.PersistenceException;
import logica.Cliente;
import logica.Usuario;
import persistencia.DAO_Usuario;

/**
 *
 * @author Nico
 */
public class ClienteHandler implements IClienteHandler{
    
    @Override
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac) {
        // Verificar si el nickname o el correo electronico ya estan en uso
        DAO_Usuario persistence = new DAO_Usuario();

        if (persistence.findUsuarioByNick(nickname) != null) {
            System.out.println("El nickname: " + nickname + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        if (persistence.findUsuarioByMail(mail) != null) {
            System.out.println("El correo electronico: " + mail + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        // Crear el nuevo cliente
        Cliente nuevoCliente = new Cliente(nickname, nombre, apellido, mail, fechaNac);

        // Guardar el cliente en la base de datos
        try {
            persistence.save(nuevoCliente);
            System.out.println("Cliente agregado exitosamente.");
        } catch (PersistenceException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
        }
    }
    
    @Override
    public void seguirUsuario(Cliente nick1, Usuario nick2){
        DAO_Usuario persistence = new DAO_Usuario();
        nick1.seguir(nick2);
        persistence.update(nick1);
    }
    
    @Override
    public void dejarDeSeguirUsuario(Cliente nick1, Usuario nick2){
        DAO_Usuario persistence = new DAO_Usuario();
        nick1.dejarDeSeguir(nick2);
        persistence.update(nick1);
    }
    
    @Override
    public void consultarPerfilCliente(){
    
    }
    
    @Override
    public void consultarPerfilArtista(){
    
    }
    
    @Override
    public void agregarTema(String nickname){
    
    }
    
    @Override
    public void agregarLista(String nickname){
    
    }
    
    @Override
    public void agregarAlbum(String nickname){
    
    }
    
    @Override
    public void eliminarTema(String nickname){
    
    }
    
    @Override
    public void eliminarLista(String nickname){
    
    }
    
    @Override
    public void eliminarAlbum(String nickname){
    
    }
    
    @Override
    public void consultarListaReproduccion(String nickname){
     
    }
}
