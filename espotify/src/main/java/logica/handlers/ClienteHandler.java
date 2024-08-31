/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import java.time.LocalDate;

/**
 *
 * @author Nico
 */
public class ClienteHandler implements IClienteHandler{
    
    @Override
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac){
    
    }
    
    @Override
    public void seguirUsuario(String nickname1, String nickname2){
        
    }
    
    @Override
    public void dejarDeSeguirUsuario(String nickname1, String nickname2){
    
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
