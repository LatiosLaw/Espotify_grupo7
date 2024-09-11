/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import java.time.LocalDate;
import logica.dt.DataAlbum;
import logica.dt.DataCliente;
import logica.dt.DataListaReproduccion;
import logica.dt.DataTema;
import logica.dt.DataUsuario;

/**
 *
 * @author Nico
 */
public interface IControladorCliente {
    
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, String foto, LocalDate fechaNac);
    
    
    /**
     * 
     * @param nick1 nickname de la persona que sigue
     * @param nick2 nickname de la persona que es seguida
     */
    public void seguirUsuario(DataCliente nick1, DataUsuario nick2);
    
    public void dejarDeSeguirUsuario(DataCliente nick1, DataUsuario nick2);
    
    public DataCliente consultarPerfilCliente(String nick_cli);
    
    public void agregarTema(DataCliente nickcli, DataTema nicktem);
    
    public void agregarLista(DataCliente nickcli, DataListaReproduccion nomlista);
    
    public void agregarAlbum(DataCliente nickcli, DataAlbum nomalbum);
    
    public void eliminarTema(DataCliente nickcli, DataTema nicktem);
    
    public void eliminarLista(DataCliente nickcli, DataListaReproduccion nomlista);
    
    public void eliminarAlbum(DataCliente nickcli, DataAlbum nomalbum);
    
    public void consultarListaReproduccion(String nickname);
    
}
