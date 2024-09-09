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
import persistencia.DAO_Usuario;

/**
 *
 * @author Nico
 */
public class ControladorArtista implements IControladorArtista{

    @Override
    public DataArtista retornarArtista(String nickname){
        Usuario retorno;
        DAO_Usuario persistence = new DAO_Usuario();
        retorno = persistence.findUsuarioByNick(nickname);
         if (retorno instanceof Artista artista) {
            return new DataArtista(retorno.getNickname(),retorno.getNombre(),retorno.getApellido(), retorno.getEmail(), retorno.getNacimiento(),artista.getBiografia(), artista.getDirWeb());
        } else {
            throw new IllegalArgumentException("El usuario con nickname " + nickname + " no es un Artista.");
        }
    }
    
    @Override
    public void agregarArtista(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac, String biografia, String dirWeb) {
        // Verificar que el nickname y el mail no esten en uso
        DAO_Usuario persistence = new DAO_Usuario();

        if (persistence.findUsuarioByNick(nickname) != null) {
            System.out.println("El nickname: " + nickname + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        if (persistence.findUsuarioByMail(mail) != null) {
            System.out.println("El correo electronico: " + mail + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        // Crear el nuevo artista
        Artista nuevoArtista = new Artista(nickname, nombre, apellido, mail, fechaNac, biografia, dirWeb);

        // Guardar el artista en la base de datos
        try {
            persistence.save(nuevoArtista);
            System.out.println("Artista agregado exitosamente.");
        } catch (PersistenceException e) {
            System.out.println("Error al guardar el artista: " + e.getMessage());
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
        }
    }
    
    @Override
    public Collection<DataArtista> mostrarArtistas(){
        Collection<DataArtista> lista = new ArrayList<>();
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> artist = persistence.findAll();
        Iterator<Usuario> iterator = artist.iterator();
        while (iterator.hasNext()) {
            Usuario art = iterator.next();
            if(art instanceof Artista arti){
              lista.add(new DataArtista(arti.getNickname(),arti.getNombre(),arti.getApellido(), arti.getEmail(), arti.getNacimiento(),arti.getBiografia(), arti.getBiografia()));
            }
        }
        return lista;
    }
    
}
