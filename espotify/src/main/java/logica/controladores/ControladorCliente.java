package logica.controladores;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import javax.persistence.PersistenceException;
import logica.Album;
import logica.Artista;
import logica.Cliente;
import logica.ListaParticular;
import logica.ListaPorDefecto;
import logica.ListaReproduccion;
import logica.Registro;
import logica.Suscripcion;
import logica.tema;
import logica.Usuario;
import logica.dt.DT_IdTema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataCliente;
import logica.dt.DataListaParticular;
import logica.dt.DataListaReproduccion;
import logica.dt.DataTema;
import logica.dt.DataErrorBundle;
import logica.dt.DataGenero;
import logica.dt.DataListaPorDefecto;
import logica.dt.DataRegi;
import logica.dt.DataSus;
import logica.dt.DataUsuario;
import persistencia.DAO_Album;
import persistencia.DAO_ListaReproduccion;
import persistencia.DAO_Tema;
import persistencia.DAO_Usuario;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class ControladorCliente implements IControladorCliente {

    @Override
    public DataErrorBundle agregarCliente(String nickname, String nombre, String apellido, String contra, String mail, String foto, LocalDate fechaNac) {
        DAO_Usuario persistence = new DAO_Usuario();
        if (persistence.findUsuarioByNick(nickname) != null) {
            System.out.println("El nickname: " + nickname + " ya esta en uso. Por favor, elige otro.");
            return new DataErrorBundle(false, 1);
        }
        if (persistence.findUsuarioByMail(mail) != null) {
            System.out.println("El correo electronico: " + mail + " ya esta en uso. Por favor, elige otro.");
            return new DataErrorBundle(false, 2);
        }
        // Crear el nuevo cliente
        Cliente nuevoCliente = new Cliente(nickname, nombre, apellido, contra, mail, foto, fechaNac);
        // Guardar el cliente en la base de datos
        try {
            persistence.save(nuevoCliente);
            System.out.println("Cliente agregado exitosamente.");
            return new DataErrorBundle(true, null);
        } catch (PersistenceException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
            return new DataErrorBundle(true, null);
        }
    }

    @Override
    public void seguirUsuario(String nick1, String nick2) {
        DAO_Usuario persistence = new DAO_Usuario();
        // Obtener Usuario usando nick1
        Usuario usuarioBase = persistence.findUsuarioByNick(nick1);
        if (usuarioBase == null) {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }
        // Hacer el cast a Cliente
        if (!(usuarioBase instanceof Cliente cliente)) {
            throw new IllegalArgumentException("El usuario encontrado no es un cliente.");
        }
        Usuario usuario = persistence.findUsuarioByNick(nick2);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario a seguir no encontrado.");
        }
        if (usuario instanceof Cliente dataCliente) {
            cliente.seguir(new Cliente(dataCliente.getNickname(), dataCliente.getNombre(), dataCliente.getApellido(), dataCliente.getContra(), dataCliente.getEmail(), dataCliente.getFoto(), dataCliente.getNacimiento()));
        } else if (usuario instanceof Artista dataArtista) {
            cliente.seguir(new Artista(dataArtista.getNickname(), dataArtista.getNombre(), dataArtista.getApellido(), dataArtista.getContra(), dataArtista.getEmail(), dataArtista.getFoto(), dataArtista.getNacimiento(), dataArtista.getBiografia(), dataArtista.getDirWeb()));
        } else {
            // Manejar el caso donde usuario no es ni un DataCliente ni un DataArtista
            throw new IllegalArgumentException("El usuario a seguir no es ni un cliente ni un artista.");
        }
        persistence.update(cliente);
    }

    @Override
    public boolean seguirUsuarioWeb(String nick1, String nick2) {
        DAO_Usuario persistence = new DAO_Usuario();

        // Obtener Usuario usando nick1
        Usuario usuarioBase = persistence.findUsuarioByNick(nick1);
        if (usuarioBase == null) {
            return false; // Usuario no encontrado
        }

        // Hacer el cast a Cliente
        if (!(usuarioBase instanceof Cliente cliente)) {
            return false; // El usuario encontrado no es un cliente
        }

        Usuario usuario = persistence.findUsuarioByNick(nick2);
        if (usuario == null) {
            return false; // Usuario a seguir no encontrado
        }

        try {
            if (usuario instanceof Cliente dataCliente) {
                cliente.seguir(new Cliente(dataCliente.getNickname(), dataCliente.getNombre(), dataCliente.getApellido(), dataCliente.getContra(), dataCliente.getEmail(), dataCliente.getFoto(), dataCliente.getNacimiento()));
            } else if (usuario instanceof Artista dataArtista) {
                cliente.seguir(new Artista(dataArtista.getNickname(), dataArtista.getNombre(), dataArtista.getApellido(), dataArtista.getContra(), dataArtista.getEmail(), dataArtista.getFoto(), dataArtista.getNacimiento(), dataArtista.getBiografia(), dataArtista.getDirWeb()));
            } else {
                return false;
            }

            persistence.update(cliente);
            return true;
        } catch (Exception e) {
            System.err.println("Error al seguir al usuario: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void dejarDeSeguirUsuario(String nick1, String nick2) {
        DAO_Usuario persistence = new DAO_Usuario();
        // Obtener Usuario usando nick1
        Usuario usuarioBase = persistence.findUsuarioByNick(nick1);
        if (usuarioBase == null) {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }
        // Hacer el cast a Cliente
        if (!(usuarioBase instanceof Cliente cliente)) {
            throw new IllegalArgumentException("El usuario encontrado no es un cliente.");
        }
        Usuario usuario = persistence.findUsuarioByNick(nick2);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario a dejar de seguir no encontrado.");
        }
        cliente.dejarDeSeguir(usuario);
        // Actualizar la tabla
        persistence.update(cliente);
    }

    @Override
    public boolean dejarDeSeguirUsuarioWeb(String nick1, String nick2) {
        DAO_Usuario persistence = new DAO_Usuario();
        // Obtener Usuario usando nick1
        Usuario usuarioBase = persistence.findUsuarioByNick(nick1);
        if (usuarioBase == null) {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }
        // Hacer el cast a Cliente
        if (!(usuarioBase instanceof Cliente cliente)) {
            throw new IllegalArgumentException("El usuario encontrado no es un cliente.");
        }
        Usuario usuario = persistence.findUsuarioByNick(nick2);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario a dejar de seguir no encontrado.");
        }
        cliente.dejarDeSeguir(usuario);
        // Actualizar la tabla
        persistence.update(cliente);
        return true;
    }

    @Override
    public DataCliente consultarPerfilCliente(String nick_cli) {
        Usuario retorno;
        DAO_Usuario persistence = new DAO_Usuario();
        try {
            retorno = persistence.findUsuarioByNick(nick_cli);
            if (retorno != null && retorno instanceof Cliente cliente) {
                return new DataCliente(
                        retorno.getNickname(),
                        retorno.getNombre(),
                        retorno.getApellido(),
                        retorno.getContra(),
                        retorno.getEmail(),
                        retorno.getFoto(),
                        retorno.getNacimiento());
            } else {
                System.out.println("El usuario con nickname " + nick_cli + " no es un Cliente.");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error al buscar el cliente: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void agregarTema(DataCliente nickcli, DataTema nicktem) {
        DAO_Usuario persistence = new DAO_Usuario();
        DAO_Tema persistence2 = new DAO_Tema();
        Usuario cli = persistence.findUsuarioByNick(nickcli.getNickname());
        if (cli != null) {
            if (cli instanceof Cliente cliente) {
                tema t = persistence2.find(nicktem.getNickname(), nicktem.getNomAlb());
                IControladorAdicionalTema registro = new ControladorAdicionalTema();
                registro.incrementarInfoFavorito(t.getNickname(), t.getNombreAlbum());
                cliente.temaFav(t);
                persistence.update(cli);
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    @Override
    public void agregarLista(DataCliente nickcli, DataListaReproduccion nomlista) {
        DAO_Usuario persistence = new DAO_Usuario();
        Usuario cli = persistence.findUsuarioByNick(nickcli.getNickname());
        if (cli != null) {
            DAO_ListaReproduccion listaPersistence = new DAO_ListaReproduccion();
            ListaReproduccion lis;
            //if (lis == null) {
                if (nomlista instanceof DataListaParticular) {
                     lis = listaPersistence.findListaReproduccionPorNombre(nomlista.getNombre(), nomlista.getCreador().getNickname());
                     if (lis == null) {
                          lis = new ListaParticular(nomlista.getNombre(), ((DataListaParticular) nomlista).getVisibilidad());
                     }
                } else {
                    lis = listaPersistence.findListaReproduccionPorNombre(nomlista.getNombre(), "none");
                     if (lis == null) {
                           lis = new ListaPorDefecto(nomlista.getNombre());
                     }
                }
                listaPersistence.save(lis);
           // }
            if (cli instanceof Cliente cliente) {
                cliente.listasFav(lis);
                persistence.update(cli);
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    @Override
    public void agregarAlbum(DataCliente nickcli, DataAlbum nomalbum) {
        DAO_Usuario persistence = new DAO_Usuario();
        Usuario cli = persistence.findUsuarioByNick(nickcli.getNickname());
        if (cli != null) {
            if (cli instanceof Cliente cliente) {
                Album alb = new Album(nomalbum.getNombre(), nomalbum.getAnioCreacion());
                cliente.albumFav(alb);
                persistence.update(cli);
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    @Override
    public void eliminarTema(DataCliente nickcli, DataTema nicktem) {
        DAO_Usuario persistence = new DAO_Usuario();
        Usuario cli = persistence.findUsuarioByNick(nickcli.getNickname());
        if (cli != null) {
            DAO_Tema temaPersistence = new DAO_Tema();
            tema tem = temaPersistence.find(nicktem.getNickname(), nicktem.getNomAlb());
            if (tem != null) {
                if (cli instanceof Cliente cliente) {
                    cliente.quitarTemaFav(tem);
                    IControladorAdicionalTema registro = new ControladorAdicionalTema();
                    registro.reducirInfoFavorito(tem.getNickname(), tem.getNombreAlbum());
                    persistence.update(cliente);
                }
            } else {
                System.out.println("El tema no existe.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    @Override
    public void eliminarTemaDeTodos(DataTema nicktem) {
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> usrs = persistence.findAll();
        for(Usuario usr:usrs){
            if (usr instanceof Cliente cliente) {
                
                eliminarTema(this.consultarPerfilCliente(usr.getNickname()),nicktem);
                
            }
        }
    }
    
    @Override
    public void eliminarLista(DataCliente nickcli, DataListaReproduccion nomlista) {
        DAO_Usuario persistence = new DAO_Usuario();
        Usuario cli = persistence.findUsuarioByNick(nickcli.getNickname());
        if (cli != null) {
            DAO_ListaReproduccion listaPersistence = new DAO_ListaReproduccion();
            ListaReproduccion lis = listaPersistence.findListaReproduccionPorNombre(nomlista.getNombre(),nomlista.getCreador().getNickname());
            if (lis != null) {
                if (cli instanceof Cliente cliente) {
                    cliente.quitarListasFav(lis);
                }
                persistence.update(cli);
            } else {
                System.out.println("La lista no existe.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    @Override
    public void eliminarAlbum(DataCliente nickcli, DataAlbum nomalbum) {
          DAO_Usuario persistence = new DAO_Usuario();
        Usuario cli = persistence.findUsuarioByNick(nickcli.getNickname());
        if (cli != null) {
            DAO_Album Persistence2 = new DAO_Album();
            Album alb = Persistence2.findAlbumByName(nomalbum.getNombre());
            if (alb != null) {
                if (cli instanceof Cliente cliente) {
                    System.out.println("EliminarAlbum");
                    System.out.println("**************************************");
                      System.out.print("Album a eliminar:");
                      System.out.println(alb.getNombre());
                      System.out.print("Del cliente:");
                      System.out.println(cliente.getNickname());
                      System.out.println("**************************************");
                    cliente.quitarAlbumFav(alb);
                    Collection<Album> alms = cliente.getAlbumFav();
                    System.out.println("Albums post eliminar");
                    System.out.println("------------------------------------------");
                    for(Album album: alms){
                        
                        System.out.println(album.getNombre());
                        
                    }
                    System.out.println("------------------------------------------");
                    persistence.update(cliente);
                }
            } else {
                System.out.println("El Album no existe.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    @Override
    public void eliminarAlbum2(DataCliente nickcli, DataAlbum nomalbum) {
      
    }
    @Override
    public void eliminarAlbumDeTodos(DataAlbum nomalbum) {
        DAO_Usuario persistence = new DAO_Usuario();

        Collection<Usuario> usrs = persistence.findAll();
        for(Usuario usr:usrs){
            if (usr instanceof Cliente cliente) {
                
                this.eliminarAlbum(this.consultarPerfilCliente(usr.getNickname()), nomalbum);
                
            }
        }  
   
    }
    
    @Override
    public void consultarListaReproduccion(String nickname) {

    }

    @Override
    public int obtenerNumeroSeguidores(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerCantidadSeguidores(nick);
    }

    @Override
    public Collection<String> obtenerSeguidoresUsuario(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerSeguidoresDeUsuario(nick);
    }

    @Override
    public Collection<String> obtenerSeguidosUsuario(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        Usuario usr;
        Collection<String> cole = dao.obtenerSeguidosDeUsuario(nick);
        Collection<String> cole2 = new ArrayList<>();
        for (String elemento : cole) {
            usr = dao.findUsuarioByNick(elemento);
            if (usr instanceof Cliente cli) {
                cole2.add(cli.getNickname() + "/Cliente");
            } else {
                cole2.add(usr.getNickname() + "/Artista");
            }
        }
        return cole2;
    }

    @Override
    public Collection<String> obtenerListasDeUsuario(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerListasDeUsuario(nick);
    }

    @Override
    public Collection<DataCliente> mostrarClientes() {
        Collection<DataCliente> lista = new ArrayList<>();
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> cliente = persistence.findAll();
        Iterator<Usuario> iterator = cliente.iterator();
        while (iterator.hasNext()) {
            Usuario usr = iterator.next();
            if (usr instanceof Cliente cli) {
                lista.add(new DataCliente(cli.getNickname(), cli.getNombre(), cli.getApellido(), cli.getFoto(), cli.getEmail(), cli.getFoto(), cli.getNacimiento()));
            }
        }
        return lista;
    }

    @Override
    public Collection<String> obtenerListasFavCliente(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        Collection<String> listDef = dao.obtenerListasFavPorDefectoCliente(nick);
        Collection<String> listPar = dao.obtenerListasParticularesFavCliente(nick);
        
        Collection<String> listaDefi = new ArrayList<>();
         for (String elemento : listDef) {
            listaDefi.add(elemento + "/Por Defecto");
        }
        for (String elemento : listPar) {
            listaDefi.add(elemento);
        }
         
         
         return listaDefi;
    }

    @Override
    public Collection<String> obtenerTemaFavCliente(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        Collection<DT_IdTema> lista =  dao.obtenerTemaFavCliente(nick);
        Collection<String> retornable = new ArrayList<>();
        Iterator<DT_IdTema> iterator = lista.iterator();
                while (iterator.hasNext()) {
                    DT_IdTema temazo = iterator.next();
                    retornable.add(temazo.getNombreTema().concat("/").concat(temazo.getNombreAlbumTema()));
        }
                return retornable;
    }

    @Override
    public Collection<String> obtenerAlbumFavCliente(String nick) {
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerAlbumFavCliente(nick);
    }

    @Override
    public Collection<String> mostrarUsuarios() {
        Collection<String> lista = new ArrayList<>();
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> usuario = persistence.findAll();
        Iterator<Usuario> iterator = usuario.iterator();
        while (iterator.hasNext()) {
            Usuario usr = iterator.next();
            lista.add(usr.getNickname());
        }
        return lista;
    }

    @Override
    public DataErrorBundle iniciarSesion(String nickOmail, String pass) {
        DAO_Usuario persistence = new DAO_Usuario();

        Usuario usr = persistence.findUsuarioByNickOrMail(nickOmail);

        if (usr != null) {
            if (usr.verificarContraseña(pass)) {
                System.out.println("User logged in successfully:");
                System.out.println("Nickname: " + usr.getNickname());
                System.out.println("Email: " + usr.getEmail());

                return new DataErrorBundle(true, null);
            } else {

                System.out.println("Invalid password for user: " + usr.getNickname());
                return new DataErrorBundle(false, 2);
            }
        } else {
            
            System.out.println("No user found with nickname/email: " + nickOmail);
            return new DataErrorBundle(false, 1);
        }
    }

    @Override
    public boolean corroborarSiEstaenSeguidos(String nickCliente, String nickSeguido) {
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<String> cole = persistence.obtenerSeguidosDeUsuario(nickCliente);
        boolean token = false;
        for (String elemento : cole) {
            String nick = elemento;
            if (nick.equals(nickSeguido)) {
                token = true;
                break;
            }
        }
        return token;
    }
     @Override
     public DataSus devolverSus(String nick){
         DAO_Usuario persistence = new DAO_Usuario();
         Suscripcion sus = persistence.devovlerSus(nick);
         DataSus dtSus = new DataSus(sus.getUser().getNickname(),sus.getFecha() ,sus.getEstado());
         //dtSus.
         
         return dtSus;
         
     }
     
     @Override
     public String corroborarTemaEnFav(String nombreTema, Collection<String> temasCole){
        String tieneLaik = "noFav";
                    for(String temEnFav : temasCole){
                        String[] partesDeTemEnFav = temEnFav.split("/");
                        String temaDeVerda = partesDeTemEnFav[0];
                        
                        System.out.println("*************************************************");
                        System.out.println("Nombre del tema: " +nombreTema);
                        System.out.println("Nombre del tema sacdo de la lista: " +temaDeVerda);
                        System.out.println("*************************************************");
                        if(temaDeVerda.equals(nombreTema)){
                            tieneLaik = "fav";
                        }
                    }
        return tieneLaik;
     }
     
    @Override
    public String corroborarAlbumEnFav(String nombreAlbum, Collection<String> albumCole){
          String tieneLaik = "noFav";
                    for(String albEnFav : albumCole){
                            System.out.println("en fav:" + albEnFav);
                            System.out.println("nombre album:" + nombreAlbum);
                        if(albEnFav.equals(nombreAlbum)){
                            tieneLaik = "fav";
                        }
                    }
        return tieneLaik;
 
    }
    
    @Override
    public String corroborarListaEnFav(String nombreLista, String nombreUsuario, Collection<String> listasCole){
       String tieneLaik = "noFav";
                    for(String temEnFav : listasCole){
                        String[] partesDeTemEnFav = temEnFav.split("/");
                        String nombreListaDeVerda = partesDeTemEnFav[0];
                        String nombreCreador = partesDeTemEnFav[1];
                        /*
                        System.out.println("NombreLista: " +nombreLista);
                         System.out.println("NombreUsuario: " +nombreUsuario);
                          System.out.println("Nombre Lista De Verda: " +nombreLista);
                           System.out.println("NombreCreador: " +nombreCreador);
                         
                         */
                        
                        if(nombreListaDeVerda.equals(nombreLista) && nombreUsuario.equals(nombreCreador)){
                            tieneLaik = "fav";
                        }
                    }
        return tieneLaik;
        

        
        
    }
     
     
    @Override
    public void agregarRegistro(String nick, String os, String nave, String ip, String url){
         DAO_Usuario persistence = new DAO_Usuario();
         
        Registro regi = new Registro();
        
        Cliente cli = new Cliente();
        cli.setNickname(nick);
        int idSus = 0;
        regi.setUser(cli);
        regi.setOs(os);
        regi.setNave(nave);
        regi.setUserNick(nick);
        regi.setFecha(LocalDate.now());
        regi.setIp(ip);
        regi.setUrl(url);
        if(persistence.findAllRegi() == null){
            idSus = 1;
        }else{
            idSus = persistence.darIdRegi();
            idSus ++;
        }
        regi.setId(idSus);
        //System.out.println("id-" + regi.getId());
       // System.out.println("id-" + regi.getUserNick());
        //System.out.println("Nave-" + regi.getNave());
       // System.out.println("OS-" + regi.getOs());
        
        try {
            persistence.saveRegi(regi);
            System.out.println("Registro agregado exitosamente.");
        } catch (PersistenceException e) {
            System.out.println("Error al guardar la Registro: " + e.getMessage());
        }
         
        
        
    }
    @Override
    public Collection<DataRegi> retornarRegistros(){
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Registro> regis = persistence.retornarRegistrosOrdenados();
        
        Collection<DataRegi> dataRegis = new ArrayList<>();
        for(Registro reg:regis){
            DataRegi newRegi = new DataRegi(reg.getId(),reg.getUserNick(), reg.getOs(),reg.getNave(), reg.getFecha());
            newRegi.setIp(reg.getIp());
            newRegi.setUrl(reg.getUrl());
            dataRegis.add(newRegi);
        }
        
        return dataRegis;
    }
    
    @Override
    public void nukearAlosViejos(){
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Registro> regis = persistence.retornarRegistrosOrdenados();
        if( regis != null){
            for(Registro regi:regis){
            
            long chronoTriggerDays = ChronoUnit.DAYS.between(regi.getFecha(), LocalDate.now());
            System.out.println("Chrono Trigger: " + chronoTriggerDays);
            if(chronoTriggerDays>=30){
                persistence.deleteRegi(regi.getId());
            }
        }
        }else{System.out.println("Is empty");}
        
    }
    @Override
    public void controlDePoblacion(){
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Registro> regis = persistence.retornarRegistrosOrdenados();
        if(regis != null){
          int cantidad = regis.size();
         if(cantidad >9999){
            for(Registro regi:regis){
                persistence.deleteRegi(regi.getId());
            }  
         }  
        }else{System.out.println("Is empty");}
         
    }
    
    @Override
    public void hiroshimaYnagasaki(){
         controlDePoblacion();
         nukearAlosViejos();
    }
    @Override
    public void eliminarDeTodosAlrtista(String nickArt){
        
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> clis = persistence.findAll();
        for(Usuario usr : clis){
            if (usr != null && usr instanceof Cliente cliente) {
                if(corroborarSiEstaenSeguidos(usr.getNickname(),nickArt) == true){
                    this.dejarDeSeguirUsuario(usr.getNickname(), nickArt);
                }
            }
        }
    }
    @Override
     public Collection<DataUsuario> listarUsuariosPorFama(){
        DAO_Usuario persistence = new DAO_Usuario();
        
        Collection<Usuario> cole = persistence.findAll();
        ArrayList<Usuario> cole2 = new ArrayList<>();
        for(Usuario usrrr:cole){
            Usuario user = usrrr;
            cole2.add(user);
        }

        ArrayList<Usuario> coleOrdenada = new ArrayList<>();
        Usuario token = new Cliente();
        
        token.setNickname("Sir.Token");
        coleOrdenada.add(token);
        Collection<DataUsuario> coleDef = new ArrayList<>();
        
        for(int i = 0; i<cole2.size();i++){
                    int size2 =coleOrdenada.size();
                    for(int n = 0; n<size2;n++){
                        if(cole2.get(i).getNumSeguidores() > coleOrdenada.get(n).getNumSeguidores()){
                            coleOrdenada.add(n, cole2.get(i));
                       
                            break;
                        }else if(cole2.get(i).getNumSeguidores() == 0){
                            coleOrdenada.add(cole2.get(i));
                            break;
                        }
                    }
                
            
        }
        coleOrdenada.remove(token);
        for(int i = 0; i<coleOrdenada.size(); i++){
            System.out.println("Nickanme: " + coleOrdenada.get(i).getNickname() + "/Cant Seguidores: " + coleOrdenada.get(i).getNumSeguidores());
            
            DataUsuario tokenDta = new DataUsuario();
            
            tokenDta.setNickname(coleOrdenada.get(i).getNickname());
            
            tokenDta.setFoto(coleOrdenada.get(i).getFoto());
            
            coleDef.add(tokenDta);
        }
        
         return coleDef;
     }
    
    
    
    @Override
    public Collection<DataAlbum> obtenerDataAlbumesFavoritos(String nickname){
        DAO_Usuario persistence = new DAO_Usuario();
         
         Collection<Album> albumesObjeto = persistence.obtenerAlbumFavCliente2(nickname);
         Collection<DataAlbum> albumes = new ArrayList<>();
         
         for(Album album : albumesObjeto){
             albumes.add(new DataAlbum(album.getNombre(), album.getImagen(), album.getanioCreacion(), new DataArtista(album.getCreador().getNickname())));
         }
         
         return albumes;
    }
    
    @Override
    public Collection<DataListaParticular> obtenerDataListasDeClientes(String nickname){
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();

        Collection<ListaParticular> listasObjeto = persistence.findListaPorCliente(nickname);

        Collection<DataListaParticular> listas = new ArrayList<>();

        for (ListaParticular lista : listasObjeto) {
            listas.add(new DataListaParticular(lista.getNombreLista(), new DataCliente(lista.getCliente().getNickname()), lista.getFoto(), lista.getVisibilidad()));
        }
        return listas;
    }
    
    @Override
    public Collection<DataListaParticular> obtenerDataListasParticularesFavoritas(String nickname){
        DAO_Usuario persistence = new DAO_Usuario();

        Collection<ListaParticular> listasObjeto = persistence.obtenerListasParticularesFavCliente2(nickname);

        Collection<DataListaParticular> listas = new ArrayList<>();

        for (ListaParticular lista : listasObjeto) {
            listas.add(new DataListaParticular(lista.getNombreLista(), new DataCliente(lista.getCliente().getNickname()), lista.getFoto(), lista.getVisibilidad()));
        }
        return listas;
    }
    
    @Override
    public Collection<DataListaPorDefecto> obtenerDataListasPorDefectoFavoritas(String nickname){
        DAO_Usuario persistence = new DAO_Usuario();

        Collection<ListaPorDefecto> listasObjeto = persistence.obtenerListasFavPorDefectoCliente2(nickname);

        Collection<DataListaPorDefecto> listas = new ArrayList<>();

        for (ListaPorDefecto lista : listasObjeto) {
            listas.add(new DataListaPorDefecto(lista.getNombreLista(), lista.getFoto(), 0, new DataGenero(lista.getGenero().getNombre())));
        }
        return listas;
    }
    
    @Override
    public Collection<DT_IdTema> obtenerDataIdTemasFavoritos(String nickname){
        DAO_Usuario persistence = new DAO_Usuario();
        return persistence.obtenerTemaFavCliente(nickname);
    }
    @Override
    public void mailMomento(){
         final String username = "andresferreira05@gmail.com";
        final String password = "fvly hipq jwom ppqw";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session sessionG = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(sessionG);
            message.setFrom(new InternetAddress("andresferreira05@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("luquitacrespi@gmail.com")
            );
            message.setSubject("Sexo");
            message.setText("Te falta."
                    + "\n\n Fraca");

            Transport.send(message);

            System.out.println("Done");
    }catch (MessagingException e) {
            e.printStackTrace();
        }
    
    }
    
    
}
