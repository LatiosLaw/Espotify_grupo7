package logica.controladores;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.PersistenceException;
import logica.Artista;
import logica.ArtistasEliminados;
import logica.Cliente;
import logica.Usuario;
import logica.dt.DataArtista;
import logica.dt.DataArtistaEli;
import logica.dt.DataCliente;
import logica.dt.DataErrorBundle;
import logica.dt.DataUsuario;
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
                        retorno.getContra(),
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
    public DataErrorBundle agregarArtista(String nickname, String nombre, String apellido, String contra, String mail, String foto, LocalDate fechaNac, String biografia, String dirWeb) {
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
        Artista nuevoArtista = new Artista(nickname, nombre, apellido, contra, mail, foto, fechaNac, biografia, dirWeb);
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
                lista.add(new DataArtista(arti.getNickname(), arti.getNombre(), arti.getApellido(), arti.getContra(), arti.getEmail(), art.getFoto(), arti.getNacimiento(), arti.getBiografia(), arti.getBiografia()));
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
     @Override
     public void eliminarDelMapaArtista2(String nickArt, ControladorAlbum controlAl,ControladorTema controlTema, ControladorCliente controlCli, 
            ControladorListaParticular controlLipa, ControladorListaPorDefecto controlLipo){
         DAO_Usuario dao = new DAO_Usuario();
         Usuario retorno = dao.findUsuarioByNick(nickArt);
            if (retorno != null && retorno instanceof Artista artista) {
                Collection<String> coleAlb = dao.obtenerAlbumArt(nickArt);
                System.out.println("eliminarDelMapaAlbums()");
                controlAl.eliminarDelMapaAlbums(coleAlb,controlTema,controlCli,controlLipa,controlLipo);
                controlCli.eliminarDeTodosAlrtista(nickArt);
                
                dao.delete2(retorno.getNickname());
               // System.out.println("Se elimino el Artista: " + retorno.getNickname());
            } else {
                System.out.println("El usuario con nickname " + nickArt + " no es un Artista.");
            }
         
         
         
     }
     @Override
     public void agregarArtistaAeliminados(String nickArt, ControladorAlbum controlAl,ControladorTema controlTema, ControladorCliente controlCli){
         DAO_Usuario dao = new DAO_Usuario();
         DataArtista art = this.retornarArtista(nickArt);

         ArtistasEliminados artEl = new ArtistasEliminados(art.getNickname(),art.getNombre(),art.getApellido(),art.getCorreo(),art.getContra(),art.getFechaNac(),art.getBiografia(), art.getDirWeb());
         if(artEl != null){
             
              int idEl = 0;

        if(dao.findAllIntegerEli() == null){
            idEl = 1;
        }else{
            idEl = dao.darIdEli();
            idEl ++;
        }
        artEl.setId(idEl);
            artEl.setFechaEli(LocalDate.now());
            try {
             dao.saveEli(artEl);
            System.out.println("Eliminado guardado(Artista: "+artEl.getNickname() + ") exitosamente.");
        } catch (PersistenceException e) {
            System.out.println("Error al guardar el eliminado: " + e.getMessage());
        }  
             
          
         
         //-------------------------------
         
         Collection<String> coleAlbums =  dao.obtenerAlbumArt(nickArt);
         
         controlAl.agregarAlbumAeliminados(coleAlbums,controlTema,artEl);
         
         }else{System.out.println("Es nulo el artista");}
         
         
         
     }
     @Override
     public void eliminarArtitsta(String nickArt, ControladorAlbum controlAl,ControladorTema controlTema, ControladorCliente controlCli, 
            ControladorListaParticular controlLipa, ControladorListaPorDefecto controlLipo){
         
         //copiar
         this.agregarArtistaAeliminados(nickArt, controlAl, controlTema, controlCli);
         
         //eliminar
         this.eliminarDelMapaArtista2(nickArt, controlAl, controlTema, controlCli, controlLipa, controlLipo);
         
     }
     
     @Override
    public DataUsuario retornarUsuario(String nickname){
        Usuario retorno;
        DAO_Usuario persistence = new DAO_Usuario();
        try {
            retorno = persistence.findUsuarioByNick(nickname);
            if (retorno != null && retorno instanceof Artista artista) {
                return new DataArtista(
                        retorno.getNickname(),
                        retorno.getNombre(),
                        retorno.getApellido(),
                        retorno.getContra(),
                        retorno.getEmail(),
                        retorno.getFoto(),
                        retorno.getNacimiento(),
                        artista.getBiografia(),
                        artista.getDirWeb());
            } else if (retorno != null && retorno instanceof Cliente cliente){
                return new DataCliente(
                        retorno.getNickname(),
                        retorno.getNombre(),
                        retorno.getApellido(),
                        retorno.getContra(),
                        retorno.getEmail(),
                        retorno.getFoto(),
                        retorno.getNacimiento());
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
     public Collection<DataArtistaEli> findAllEli(){
         
         DAO_Usuario dao = new DAO_Usuario();
          Collection<ArtistasEliminados> cole =  dao.findAllStringEli();
          Collection<DataArtistaEli> coleString = new ArrayList<>();
         for(ArtistasEliminados eli: cole){
             DataArtistaEli arti =  new DataArtistaEli(eli.getNickname(), eli.getNombre(),eli.getApellido(),eli.getContra(),eli.getEmail(),eli.getFoto(),eli.getNacimiento(),eli.getBiografia(),eli.getDirWeb(), eli.getFechaEli());
             arti.setId(eli.getId());
             coleString.add(arti);
         }
         return  coleString;
     }
     @Override
     public DataArtistaEli findEli(String nick){
        DAO_Usuario dao = new DAO_Usuario();
         ArtistasEliminados eli = dao.findEli(nick);
         DataArtistaEli arti = new DataArtistaEli(eli.getNickname(), eli.getNombre(),eli.getApellido(),eli.getContra(),eli.getEmail(),eli.getFoto(),eli.getNacimiento(),eli.getBiografia(),eli.getDirWeb(), eli.getFechaEli());
         arti.setId(eli.getId());

//String nickname, String nombre, String apellido, String contraseña, String correo, String foto_perfil, LocalDate fechaNac, String biografia, String dirWeb) {
       
         
         return arti;
     }
     @Override
     public Collection<String> listarTemasEli(String nick){
          DAO_Usuario dao = new DAO_Usuario();
         
          Collection<String> cole = dao.findTemasFavStringEli(nick);
          
         return cole;
     }
     @Override
     public Collection<String> listarAlbumsEli(String nick){
          DAO_Usuario dao = new DAO_Usuario();
         Collection<String> cole = dao.findAlbumsFavStringEli(nick);
          return cole;
     }
}
