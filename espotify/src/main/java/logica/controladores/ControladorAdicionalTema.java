package logica.controladores;

import java.util.Collection;
import logica.Registro_tema;
import persistencia.DAO_RegistroTema;

public class ControladorAdicionalTema implements IControladorAdicionalTema {

    @Override
    public Registro_tema devolverRegistroTema(String nombre_tema, String nombre_album_tema) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema nuevo = persistence.find(nombre_tema, nombre_album_tema);
        return nuevo;
    }

    @Override
    public void crearRegistroTema(String nombre_tema, String nombre_album_tema) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema nuevo = new Registro_tema(nombre_tema, nombre_album_tema);
        persistence.save(nuevo);
    }

    @Override
    public void incrementarInfoReproduccion(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.sumarRepro();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public void incrementarInfoAgregadoALista(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.sumarListas();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public void incrementarInfoFavorito(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.sumarFavoritos();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public void incrementarInfoDescarga(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.sumarDescarga();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public void reducirInfoReproduccion(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.restarRepro();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public void reducirInfoAgregadoALista(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.restarListas();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public void reducirInfoFavorito(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.restarFavoritos();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public void reducirInfoDescarga(String nombre_tema, String nombre_album) {
        DAO_RegistroTema persistence = new DAO_RegistroTema();
        Registro_tema verif = persistence.find(nombre_tema, nombre_album);
        if (verif != null) {
            verif.restarDescarga();
            persistence.update(verif);
        } else {
            // Por si pinta hacer algo con el caso de que el registro no exista.
        }
    }

    @Override
    public Collection<Registro_tema> buscarLos100MasPopulares() {
        DAO_RegistroTema persistence = new DAO_RegistroTema();

        return persistence.buscarLos100MasPopulares();
    }
}
