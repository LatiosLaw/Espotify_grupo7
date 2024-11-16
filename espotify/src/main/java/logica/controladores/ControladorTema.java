package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import logica.Album;
import logica.tema;
import logica.dt.DataAlbum;
import logica.dt.DataTema;
import persistencia.DAO_Album;
import persistencia.DAO_Tema;

public class ControladorTema implements IControladorTema {

    @Override
    public boolean crearTemaDefault(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo) {
        tema nuevo_tema = new tema(nombre_tema, nombre_album, duracion, metodo_de_acceso, archivo);
        DAO_Tema persistence = new DAO_Tema();
        if (persistence.find(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum()) != null) {
            System.out.println("El tema ya existe.");
            return false;
        } else {
            persistence.save(nuevo_tema);
            if (persistence.find(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum()) != null) {
                System.out.println("El tema con nickname " + nuevo_tema.getNickname() + " fue persistido correctamente.");
                IControladorAdicionalTema registro = new ControladorAdicionalTema();
                System.out.println("NOMBRE " + nuevo_tema.getNickname());
                System.out.println("ALBUM " + nuevo_tema.getNombreAlbum());
                registro.crearRegistroTema(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum());
                return true;
            } else {
                System.out.println("Un error ha ocurrido.");
                return false;
            }
        }
    }
    
    @Override
    public boolean crearTemaCasiCompleto(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo, Integer posicion) {
        tema nuevo_tema = new tema(nombre_tema, nombre_album, duracion, metodo_de_acceso, archivo, posicion);
        DAO_Tema persistence = new DAO_Tema();
        if (persistence.find(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum()) != null) {
            System.out.println("El tema ya existe.");
            return false;
        } else {
            persistence.save(nuevo_tema);
            if (persistence.find(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum()) != null) {
                System.out.println("El tema con nickname " + nuevo_tema.getNickname() + " fue persistido correctamente.");
                IControladorAdicionalTema registro = new ControladorAdicionalTema();
                registro.crearRegistroTema(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum());
                return true;
            } else {
                System.out.println("Un error ha ocurrido.");
                return false;
            }
        }
    }
    
    @Override
    public boolean crearTemaCompleto(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo, Integer posicion, DataAlbum album) {
        DAO_Album persistence_alb = new DAO_Album();
        tema nuevo_tema = new tema(nombre_tema, nombre_album, duracion, metodo_de_acceso, archivo, posicion, persistence_alb.findAlbumByName(album.getNombre()));
        DAO_Tema persistence = new DAO_Tema();
        if (persistence.find(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum()) != null) {
            System.out.println("El tema ya existe.");
            return false;
        } else {
            persistence.save(nuevo_tema);
            if (persistence.find(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum()) != null) {
                System.out.println("El tema con nickname " + nuevo_tema.getNickname() + " fue persistido correctamente.");
                IControladorAdicionalTema registro = new ControladorAdicionalTema();
                registro.crearRegistroTema(nuevo_tema.getNickname(), nuevo_tema.getNombreAlbum());
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
        retorno = persistence.find(nickname, nombre_album);
        if (retorno != null) {
            return new DataTema(retorno.getNickname(), retorno.getNombreAlbum(), retorno.getDuracion(), new DataAlbum(retorno.getNombreAlbum()), retorno.getAcceso(), retorno.getArchivo(), retorno.getPos());
        } else {
            throw new IllegalArgumentException("El tema con nickname " + nickname + " no existe.");
        }
    }
     @Override
    public DataTema retornarTema2LaSecuela(String nickname, String nombre_album) {
        tema retorno;
        DAO_Tema persistence = new DAO_Tema();
        retorno = persistence.find(nickname, nombre_album);
        if (retorno != null) {
            return new DataTema(retorno.getNickname(), retorno.getNombreAlbum(), retorno.getDuracion(), new DataAlbum(retorno.getNombreAlbum()), retorno.getAcceso(), retorno.getArchivo());
        } else {
            return null;
           
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
                listaDeTemas.add(new DataTema(temazo.getNickname(), temazo.getNombreAlbum(), temazo.getDuracion(), temazo.getArchivo(), temazo.getAcceso()));
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
                    listaDeTemas.add(new DataTema(temazo.getNickname(), temazo.getNombreAlbum(), temazo.getDuracion(), temazo.getArchivo()));
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
                    listaDeTemas.add(new DataTema(temazo.getNickname(), temazo.getNombreAlbum(), temazo.getDuracion(), temazo.getArchivo()));
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
        DAO_Tema persistence = new DAO_Tema();
        tema tem = persistence.find(tema.getNickname(), album.getNombre());
        tem.setAlbum(alb);
        persistence.update(tem);
    }

    @Override
    public void BorrarTema(String nickname, String nombre_album) {
        DAO_Tema persistence = new DAO_Tema();
        persistence.delete(nickname, nombre_album);
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
                listaDeTemas.add(temazo.getNickname().concat("/").concat(temazo.getNombreAlbum()));
            }
            return listaDeTemas;
        } else {
            return null;
        }
    }
    
    
    
}
