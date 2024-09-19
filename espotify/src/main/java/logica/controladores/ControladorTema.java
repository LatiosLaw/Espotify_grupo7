package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import logica.Album;
import logica.tema;
import logica.dt.DataAlbum;
import logica.dt.DataTema;
import logica.dt.errorBundle;
import persistencia.DAO_Album;
import persistencia.DAO_Tema;

public class ControladorTema implements IControladorTema {

    @Override
    public errorBundle crearTemaDefault(String nombre_tema, int duracion, String metodo_de_acceso, String archivo, String nombre_album) {
        tema nuevo_tema = new tema(nombre_tema, duracion, metodo_de_acceso, archivo);
        DAO_Tema persistence = new DAO_Tema();
        if (persistence.find(nuevo_tema) != null) { // Existe un tema con el mismo nombre en la BD
            if(persistence.find(nuevo_tema).getNickname() != nuevo_tema.getNickname() && persistence.find(nuevo_tema).getAlbum().getNombre() != nombre_album){
                persistence.save(nuevo_tema);
            if (persistence.find(nuevo_tema) != null) {
                System.out.println("El tema con nickname " + nuevo_tema.getNickname() + " fue persistido correctamente.");
                return new errorBundle(true, null);
            } else {
                System.out.println("Un error ha ocurrido.");
                return new errorBundle(false, 2);
            }
            }else{
              System.out.println("El tema ya existe.");
            return new errorBundle(false, 1);  
            }
        } else {
            persistence.save(nuevo_tema);
            if (persistence.find(nuevo_tema) != null) {
                System.out.println("El tema con nickname " + nuevo_tema.getNickname() + " fue persistido correctamente.");
                return new errorBundle(true, null);
            } else {
                System.out.println("Un error ha ocurrido.");
                return new errorBundle(false, 2);
            }
        }
    }
    
    @Override
    public boolean crearTemaCompleto(String nombre_tema, int duracion, String metodo_de_acceso, String archivo, Integer posicion, DataAlbum album) {
        DAO_Album persistence_alb = new DAO_Album();
        tema nuevo_tema = new tema(nombre_tema, duracion, metodo_de_acceso, archivo, posicion, persistence_alb.findAlbumByName(album.getNombre()));
        DAO_Tema persistence = new DAO_Tema();
        if (persistence.find(nuevo_tema) != null) {
            System.out.println("El tema ya existe.");
            return false;
        } else {
            persistence.save(nuevo_tema);
            if (persistence.find(nuevo_tema) != null) {
                System.out.println("El tema con nickname " + nuevo_tema.getNickname() + " fue persistido correctamente.");
                return true;
            } else {
                System.out.println("Un error ha ocurrido.");
                return false;
            }
        }
    }

    @Override
    public DataTema retornarTema(String nickname, String nombre_album) {
        tema retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.find(new tema(nickname, nombre_album));
        if (retorno != null) {
            return new DataTema(retorno.getNickname(), retorno.getDuracion(), new DataAlbum("placeholder"), retorno.getAcceso(), retorno.getArchivo());
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
    public Collection<DataTema> retornarTemasDeLaLista(String nombre_lista, Integer tipo_lista){
        if(tipo_lista == 1){ // CASO POR DEFECTO
            Collection<DataTema> listaDeTemas = new ArrayList<>();
        List<tema> retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.findFromListaDefecto(nombre_lista);
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
        }else{ // CASO PARTICULAR
            Collection<DataTema> listaDeTemas = new ArrayList<>();
        List<tema> retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.findFromListaParticular(nombre_lista);
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
    public void BorrarTema(String nombre_tema, String nombre_album) {
        DAO_Tema persistence = new DAO_Tema();
        persistence.delete(new tema(nombre_tema, nombre_album));
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
