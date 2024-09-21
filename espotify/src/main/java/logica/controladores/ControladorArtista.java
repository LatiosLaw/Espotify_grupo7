package logica.controladores;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.PersistenceException;
import logica.Artista;
import logica.Usuario;
import logica.dt.DataArtista;
import logica.dt.DataErrorBundle;
import persistencia.DAO_Usuario;

public class ControladorArtista implements IControladorArtista {

    @Override
    public DataArtista retornarArtista(String nickname) {
        Usuario retorno;
        DAO_Usuario persistence = new DAO_Usuario();
        try {
            retorno = persistence.findUsuarioByNick(nickname);
            if (retorno != null && retorno instanceof Artista artista) {
                return new DataArtista(
                        retorno.getNickname(),
                        retorno.getNombre(),
                        retorno.getApellido(),
                        retorno.getEmail(),
                        retorno.getFoto(),
                        retorno.getNacimiento(),
                        artista.getBiografia(),
                        artista.getDirWeb());
            } else {
                System.out.println("El usuario con nickname " + nickname + " no es un Artista.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al buscar el artista: " + e.getMessage());
            return null;
        }
    }

    @Override
    public DataErrorBundle agregarArtista(String nickname, String nombre, String apellido, String mail, String foto, LocalDate fechaNac, String biografia, String dirWeb) {
        DAO_Usuario persistence = new DAO_Usuario();
        if (persistence.findUsuarioByNick(nickname) != null) {
            System.out.println("El nickname: " + nickname + " ya esta en uso. Por favor, elige otro.");
            return new DataErrorBundle(false, 1);
        }
        if (persistence.findUsuarioByMail(mail) != null) {
            System.out.println("El correo electronico: " + mail + " ya esta en uso. Por favor, elige otro.");
            return new DataErrorBundle(false, 2);
        }
        // Crear el nuevo artista
        Artista nuevoArtista = new Artista(nickname, nombre, apellido, mail, foto, fechaNac, biografia, dirWeb);
        // Guardar el artista en la base de datos
        try {
            persistence.save(nuevoArtista);
            System.out.println("Artista agregado exitosamente.");
            return new DataErrorBundle(true, null);
        } catch (PersistenceException e) {
            System.out.println("Error al guardar el artista: " + e.getMessage());
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
            return new DataErrorBundle(true, null);
        }
    }

    @Override
    public Collection<DataArtista> mostrarArtistas() {
        Collection<DataArtista> lista = new ArrayList<>();
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> artist = persistence.findAll();
        Iterator<Usuario> iterator = artist.iterator();
        while (iterator.hasNext()) {
            Usuario art = iterator.next();
            if (art instanceof Artista arti) {
                lista.add(new DataArtista(arti.getNickname(), arti.getNombre(), arti.getApellido(), arti.getEmail(), art.getFoto(), arti.getNacimiento(), arti.getBiografia(), arti.getBiografia()));
            }
        }
        return lista;
    }

    @Override
    public Collection<String> mostrarNicksArtistas() {
        Collection<String> lista = new ArrayList<>();
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> artist = persistence.findAll();
        Iterator<Usuario> iterator = artist.iterator();
        while (iterator.hasNext()) {
            Usuario art = iterator.next();
            if (art instanceof Artista arti) {
                lista.add(arti.getNickname());
            }
        }
        return lista;
    }

    @Override
    public int obtenerNumeroSeguidores(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerCantidadSeguidores(nick);
    }

    @Override
    public Collection<String> obtenerAlbumsArt(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerAlbumArt(nick);
    }

    @Override
    public Collection<String> obtenerSeguidoresArt(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerSeguidoresDeUsuario(nick);
    }
}
