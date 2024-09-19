package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import logica.Album;
import logica.tema;
import logica.dt.DataAlbum;
import logica.dt.DataTema;
import persistencia.DAO_Tema;

public class ControladorTema implements IControladorTema {

    @Override
    public boolean crearTemaDefault(String nombre_tema, int duracion, String metodo_de_acceso) {
        tema nuevo_tema = new tema(nombre_tema, duracion, metodo_de_acceso);
        DAO_Tema persistence = new DAO_Tema();
        if (persistence.find(nuevo_tema.getNickname()) != null) {
            System.out.println("El tema ya existe.");
            return false;
        } else {
            persistence.save(nuevo_tema);
            if (persistence.find(nuevo_tema.getNickname()) != null) {
                System.out.println("El tema con nickname " + nuevo_tema.getNickname() + " fue persistido correctamente.");
                return true;
            } else {
                System.out.println("Un error ha ocurrido.");
                return false;
            }
        }
    }

    @Override
    public DataTema retornarTema(String nickname) {
        tema retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.find(nickname);
        if (retorno != null) {
            return new DataTema(retorno.getNickname(), retorno.getDuracion(), new DataAlbum("placeholder"), retorno.getAcceso());
        } else {
            throw new IllegalArgumentException("El tema con nickname " + nickname + " no existe.");
        }
    }

    @Override
    public Collection<DataTema> retornarTemasDeAlbum(String nombre_album) {
        Collection<DataTema> listaDeTemas = new ArrayList<>();
        List<tema> retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.findFromAlbum(nombre_album);
        if (retorno != null) {
            Iterator<tema> iterator = retorno.iterator();
            while (iterator.hasNext()) {
                tema temazo = iterator.next();
                listaDeTemas.add(new DataTema(temazo.getNickname(), temazo.getDuracion()));
            }
            return listaDeTemas;
        } else {
            return null;
        }
    }

    @Override
    public void actualizarTema(DataTema tema, DataAlbum album) {
        Album alb = new Album(album.getNombre(), album.getAnioCreacion());
        tema tem = new tema(tema.getNickname(), tema.getDuracion());
        tem.setAlbum(alb);
        DAO_Tema persistence = new DAO_Tema();
        persistence.update(tem);
    }

    @Override
    public void BorrarTema(String nombre_tema) {
        DAO_Tema persistence = new DAO_Tema();
        persistence.delete(nombre_tema);
    }
    
    @Override
    public Collection<String> retornarTemasDeAlbumStringEdition(String nombre_album) {
        Collection<String> listaDeTemas = new ArrayList<>();
        List<tema> retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.findFromAlbum(nombre_album);
        if (retorno != null) {
            Iterator<tema> iterator = retorno.iterator();
            while (iterator.hasNext()) {
                tema temazo = iterator.next();
                listaDeTemas.add(temazo.getNickname());
            }
            return listaDeTemas;
        } else {
            return null;
        }
    }
    
    
    
}
