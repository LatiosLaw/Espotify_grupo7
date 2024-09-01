/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import java.time.LocalDate;
import logica.Artista;
import logica.Usuario;
import persistencia.DAO_Usuario;

/**
 *
 * @author Nico
 */
public class ArtistaHandler implements IArtistaHandler{
    @Override
    public Artista retornarArtista(String nickname){
        Usuario retorno;
        DAO_Usuario persistence = new DAO_Usuario();
        retorno = persistence.findUsuarioByNick(nickname);
         if (retorno instanceof Artista) {
            return (Artista) retorno; // Casting dinámico
        } else {
            throw new IllegalArgumentException("El usuario con nickname " + nickname + " no es un Artista.");
        }
    }
    
    @Override
    public void agregarArtista(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac, String biografia, String dirWeb){
    Artista art = new  Artista(nickname, nombre, apellido, mail, fechaNac, biografia, dirWeb);
    }
    
    
}
