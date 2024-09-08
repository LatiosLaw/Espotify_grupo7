/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.Album;
import logica.Artista;
import logica.Tema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataTema;
import persistencia.DAO_Tema;

/**
 *
 * @author Nico
 */
public class ControladorTema implements IControladorTema {

    @Override
    public boolean crearTemaDefault(String nombre_tema, int duracion) {
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
    public DataTema retornarTema(String nickname) {
        Tema retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.find(nickname);
        if (retorno != null) {
            Album albu_ret = retorno.getAlbum();
            Artista arti = albu_ret.getCreador();
            DataAlbum alb = new DataAlbum(albu_ret.getNombre(), albu_ret.getanioCreacion(), new DataArtista(arti.getNickname(), arti.getNombre(), arti.getApellido(), arti.getEmail(), arti.getNacimiento(), arti.getBiografia(), arti.getDirWeb()));
            return new DataTema(retorno.getNickname(), retorno.getDuracion(), alb);
        } else {
            throw new IllegalArgumentException("El tema con nickname " + nickname + " no existe.");
        }
    }

    @Override
    public void actualizarTema(DataTema tema, DataAlbum album) {
        Album alb = new Album();
        Tema tem = new Tema();
        tem.setAlbum(alb);
        DAO_Tema persistence = new DAO_Tema();
        persistence.update(tem);
    }
}
