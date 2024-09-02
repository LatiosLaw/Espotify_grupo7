/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import logica.Album;
import logica.Tema;
import persistencia.DAO_Tema;

/**
 *
 * @author Nico
 */
public class TemaHandler implements ITemaHandler{
    
    @Override
    public boolean crearTemaDefault(String nombre_tema, int duracion){
        Tema nuevo_tema = new Tema(nombre_tema, duracion);
        DAO_Tema persistence = new DAO_Tema();
        if (persistence.find(nuevo_tema.getNickname()) != null) {
        System.out.println("El tema ya existe.");
        return false;
    } else {
        persistence.save(nuevo_tema);
        if (persistence.find(nuevo_tema.getNickname()) != null) {
        System.out.println("El tema con nickname" + nuevo_tema.getNickname() + " fue persistido correctamente.");
        return true;
    } else {
        System.out.println("Un error ha ocurrido.");
        return false;
    }
    }
    }
    
    @Override
    public Tema retornarTema(String nickname){
        Tema retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.find(nickname);
         if (retorno != null) {
            return retorno;
        } else {
            throw new IllegalArgumentException("El tema con nickname " + nickname + " no existe.");
        }
    }
    
    @Override
    public void actualizarTema(Tema tema, Album album){
        tema.setAlbum(album);
        DAO_Tema persistence = new DAO_Tema();
        persistence.update(tema);
    }
}
