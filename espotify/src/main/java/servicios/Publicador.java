package servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import logica.Genero;
import logica.Registro_tema;
import logica.Usuario;
import logica.controladores.ControladorAdicionalTema;
import logica.controladores.ControladorAlbum;
import logica.controladores.ControladorArtista;
import logica.controladores.ControladorCliente;
import logica.controladores.ControladorGenero;
import logica.controladores.ControladorListaParticular;
import logica.controladores.ControladorListaPorDefecto;
import logica.controladores.ControladorSuscripcion;
import logica.controladores.ControladorTema;
import logica.dt.DT_IdTema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataCliente;
import logica.dt.DataErrorBundle;
import logica.dt.DataGenero;
import logica.dt.DataListaParticular;
import logica.dt.DataListaPorDefecto;
import logica.dt.DataListaReproduccion;
import logica.dt.DataSus;
import logica.dt.DataTema;
import logica.dt.DataUsuario;
import persistencia.DAO_Genero;
import persistencia.DAO_Usuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador implements IPublicador { // Implementa la interfaz IPublicador

    private Endpoint endpoint = null; // Variable para almacenar el endpoint

    public Publicador() {

    }

    @Override
    public DataErrorBundle iniciarSesion(String username, String password) {
        DataErrorBundle resultado;
        System.out.println("Usuario recibido: " + username);
        System.out.println("Contra recibida: " + password);
        ControladorCliente cliente = new ControladorCliente();
        resultado = cliente.iniciarSesion(username, password); // Llama al controlador para validar la sesión

        System.out.println("Valor recibido: " + resultado.getValor());
        System.out.println("Numero recibido: " + resultado.getNumero());

        if (resultado.getValor()) {
            return new DataErrorBundle(true, 0); // Éxito
        } else {
            return new DataErrorBundle(false, 1); // Error
        }
    }

    @Override
    public String getTipoUsuario(String username) {
        //Cambiar estas cosas por controladores, ya que no seria lo correcto usar el dao.
        DAO_Usuario dao = new DAO_Usuario();

        String tipo_usuario = dao.findUsuarioByNick(username).getDTYPE();
        System.out.println("El tipo de usuario es: " + tipo_usuario);

        return tipo_usuario;
    }

    @Override
    public Boolean getSuscripcion(String username) {
        ControladorSuscripcion controladorSus = new ControladorSuscripcion();

        Boolean suscrito = controladorSus.tieneSusValida(username);
        System.out.println("La suscripcion es: " + suscrito);

        return suscrito;
    }

    @Override
    public Boolean seguirUsuario(String username1, String username2) {
        System.out.println("WebService: Seguir Usuario");
        ControladorCliente controlador = new ControladorCliente();

        return controlador.seguirUsuarioWeb(username1, username2);
    }

    @Override
    public Boolean dejarDeSeguirUsuario(String username1, String username2) {
        System.out.println("WebService: Dejar De Seguir Usuario");
        ControladorCliente controlador = new ControladorCliente();

        return controlador.dejarDeSeguirUsuarioWeb(username1, username2);
    }

    @Override
    public Collection<String> obtenerSeguidoresDe(String username) {
        System.out.println("WebService: Obtener Seguidores");
        ControladorCliente controlador = new ControladorCliente();

        return controlador.obtenerSeguidoresUsuario(username);
    }

    @Override
    public Collection<String> obtenerSeguidosDe(String username) {
        System.out.println("WebService: Obtener Seguidos");
        ControladorCliente controlador = new ControladorCliente();

        return controlador.obtenerSeguidosUsuario(username);
    }

    @Override
    public DataErrorBundle agregarSuscripcion(String username, String estado, String tipo) {
        System.out.println("WebService: Contratar Suscripcion");
        ControladorSuscripcion controladorSus = new ControladorSuscripcion();

        LocalDate fechaActual = LocalDate.now();

        return controladorSus.agregarSus(username, estado, fechaActual, tipo);
    }

    @Override
    public DataCliente retornarCliente(String username) {
        ControladorCliente controlador = new ControladorCliente();

        DataCliente cliente = controlador.consultarPerfilCliente(username);

        return cliente;
    }

    @Override
    public DataUsuario retornarUsuario(String username) {
        ControladorArtista controlador = new ControladorArtista();

        DataUsuario usuario = controlador.retornarUsuario(username);

        return usuario;
    }

    @Override
    public Collection<DataListaParticular> retornarListasParticularesDeCliente(String username) {
        ControladorListaParticular controlador = new ControladorListaParticular();

        return controlador.devolverListadeCliente(username);
    }

    @Override
    public Boolean publicarLista(String nicknameCliente, String nombreLista) {
        ControladorListaParticular controlador = new ControladorListaParticular();

        return controlador.publicarLista(nicknameCliente, nombreLista);
    }

    @Override
    public DataErrorBundle agregarCliente(String nickname, String nombre, String apellido, String pass, String mail, String fileName, String fechaNac) {
        ControladorCliente controlador = new ControladorCliente();

        LocalDate fechaNacimiento;

        if (fechaNac != null && !fechaNac.isEmpty()) {
            fechaNacimiento = LocalDate.parse(fechaNac);
        } else {
            fechaNacimiento = LocalDate.now();
        }

        return controlador.agregarCliente(nickname, nombre, apellido, pass, mail, fileName, fechaNacimiento);
    }

    @Override
    public DataErrorBundle agregarArtista(String nickname, String nombre, String apellido, String pass, String mail, String fileName, String fechaNac, String biografia, String dirWeb) {
        ControladorArtista controlador = new ControladorArtista();

        LocalDate fechaNacimiento;

        if (fechaNac != null && !fechaNac.isEmpty()) {
            fechaNacimiento = LocalDate.parse(fechaNac);
        } else {
            fechaNacimiento = LocalDate.now();
        }
        return controlador.agregarArtista(nickname, nombre, apellido, pass, mail, fileName, fechaNacimiento, biografia, dirWeb);
    }

    @Override
    public Boolean checkNicknameAvailability(String nickname) {
        DAO_Usuario usr = new DAO_Usuario();
        Usuario usuario = usr.findUsuarioByNick(nickname);
        if (usuario != null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkUCorreoAvailability(String correo) {
        DAO_Usuario usr = new DAO_Usuario();
        Usuario usuario = usr.findUsuarioByMail(correo);
        if (usuario != null) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkAlbumAvailability(String nombreAlbum) {
        ControladorAlbum alb = new ControladorAlbum();
        DataAlbum album = alb.retornarInfoAlbum(nombreAlbum);
        if (!album.getNombre().equals("ALBUM NO EXISTE")) {
            return false;
        }
        return true;
    }

    @Override
    public Collection<String> obtenerGeneros() {
        ControladorGenero controlador = new ControladorGenero();

        return controlador.mostrarGeneros();
    }

    @Override
    public DataAlbum agregarAlbum(String nickname, String nombreAlbum, String fileName, int anioCreacion, Collection<DataTema> temas) {
        ControladorAlbum albumPersistence = new ControladorAlbum();

        return albumPersistence.agregarAlbum(nickname, nombreAlbum, fileName, anioCreacion, temas);
    }

    @Override
    public DataTema retornarTema(String nombreTema, String nombreAlbum) {
        ControladorTema controlador = new ControladorTema();

        return controlador.retornarTema(nombreTema, nombreAlbum);
    }

    @Override
    public DataTema retornarTema2(String nombreTema, String nombreAlbum) {
        ControladorTema controlador = new ControladorTema();

        return controlador.retornarTema2LaSecuela(nombreTema, nombreAlbum);
    }

    @Override
    public void actualizarTema(DataTema tema, DataAlbum album) {
        ControladorTema controlador = new ControladorTema();

        controlador.actualizarTema(tema, album);
    }

    @Override
    public void actualizarGenero(DataGenero genero, Collection<String> albumes, DataAlbum album) {
        ControladorGenero controlador = new ControladorGenero();

        controlador.actualizarGenero(genero, albumes, album);
    }

    @Override
    public void crearTemaCasiCompleto(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo, Integer posicion) {
        ControladorTema controlador = new ControladorTema();

        controlador.crearTemaCasiCompleto(nombre_tema, nombre_album, duracion, null, archivo, posicion);
    }

    @Override
    public Collection<String> retornarAlbumesDelGenero(String nombreGenero) {
        ControladorAlbum albumPersistence = new ControladorAlbum();

        return albumPersistence.retornarAlbumsDelGenero(nombreGenero);
    }

    @Override
    public Collection<DataCliente> obtenerDataClientes() {
        ControladorCliente controlador = new ControladorCliente();

        return controlador.mostrarClientes();
    }

    @Override
    public Collection<DataArtista> obtenerDataArtistas() {
        ControladorArtista controlador = new ControladorArtista();

        return controlador.mostrarArtistas();
    }

    @Override
    public Collection<DataAlbum> obtenerDataAlbumes() {
        ControladorAlbum controlador = new ControladorAlbum();

        return controlador.retornarDataAlbumes();
    }

    @Override
    public Collection<DataListaPorDefecto> obtenerDataListaPorDefecto() {
        ControladorListaPorDefecto controlador = new ControladorListaPorDefecto();

        return controlador.retornarListasPorDefecto();
    }

    @Override
    public Collection<DataListaPorDefecto> obtenerDataListasPorGenero(String nombreGenero) {
        ControladorListaPorDefecto controlador = new ControladorListaPorDefecto();

        return controlador.retornarListasDelGeneroDT(nombreGenero);
    }

    @Override
    public Collection<DataAlbum> obtenerDataAlbumesPorGenero(String nombreGenero) {
        ControladorAlbum controlador = new ControladorAlbum();

        return controlador.retornarAlbumsDelGeneroDT(nombreGenero);
    }

    @Override
    public Collection<DataSus> obtenerDataSuscripciones(String username) {
        ControladorSuscripcion controlador = new ControladorSuscripcion();

        return controlador.findAllSus(username);
    }

    @Override
    public DataSus obtenerDataSuscripcionPorID(Integer identificador) {
        ControladorSuscripcion controlador = new ControladorSuscripcion();

        return controlador.retornarSus(identificador);
    }

    @Override
    public void actualizarSuscripcion(Integer identificador, String estadoSuscripcion) {
        ControladorSuscripcion controlador = new ControladorSuscripcion();

        controlador.actualizarEstado(identificador, estadoSuscripcion);
    }

    @Override
    public DataAlbum obtenerDataAlbum(String nombreAlbum) {
        ControladorAlbum controlador = new ControladorAlbum();

        return controlador.retornarInfoAlbum(nombreAlbum);
    }

    @Override
    public Collection<String> obtenerNombreAlbumesFavCliente(String username) {
        ControladorCliente controlador = new ControladorCliente();

        return controlador.obtenerAlbumFavCliente(username);
    }

    @Override
    public String corroborarAlbumEnFav(String nombreAlbum, Collection<String> albumes) {
        ControladorCliente controlador = new ControladorCliente();

        return controlador.corroborarAlbumEnFav(nombreAlbum, albumes);
    }

    @Override
    public void eliminarAlbumDeFav(DataCliente cliente, DataAlbum album) {
        ControladorCliente controlador = new ControladorCliente();

        controlador.eliminarAlbum(cliente, album);
    }

    @Override
    public Collection<String> obtenerNombreTemasFavCliente(String username) {
        ControladorCliente controlador = new ControladorCliente();

        return controlador.obtenerTemaFavCliente(username);
    }

    @Override
    public String corroborarTemaEnFav(String nombreTema, Collection<String> temas) {
        ControladorCliente controlador = new ControladorCliente();

        return controlador.corroborarTemaEnFav(nombreTema, temas);
    }

    @Override
    public void eliminarTemaDeFav(DataCliente cliente, DataTema tema) {
        ControladorCliente controlador = new ControladorCliente();

        controlador.eliminarTema(cliente, tema);
    }

    @Override
    public Collection<String> obtenerNombreListasFavCliente(String username) {
        ControladorCliente controlador = new ControladorCliente();

        return controlador.obtenerListasFavCliente(username);
    }

    @Override
    public String corroborarListaEnFav(String nombreLista, String nombreUsuario, Collection<String> listasCole) {
        ControladorCliente controlador = new ControladorCliente();

        return controlador.corroborarListaEnFav(nombreLista, nombreUsuario, listasCole);
    }

    @Override
    public DataListaReproduccion devolverInformacionListaRepro(String idCoso, String idCreadorAlbum) {
        ControladorListaParticular controlador = new ControladorListaParticular();

        return controlador.devolverInformacionListaRepro(idCoso, idCreadorAlbum);
    }

    @Override
    public void eliminarListaDeFav(DataCliente cliente, DataListaReproduccion lista) {
        ControladorCliente controlador = new ControladorCliente();

        controlador.eliminarLista(cliente, lista);
    }

    @Override
    public void agregarTemaEnFav(DataCliente cliente, DataTema tema) {
        ControladorCliente controlador = new ControladorCliente();

        controlador.agregarTema(cliente, tema);
    }

    @Override
    public void agregarListaEnFav(DataCliente cliente, DataListaReproduccion lista) {
        ControladorCliente controlador = new ControladorCliente();

        controlador.agregarLista(cliente, lista);
    }

    @Override
    public void agregarAlbumEnFav(DataCliente cliente, DataAlbum album) {
        ControladorCliente controlador = new ControladorCliente();

        controlador.agregarAlbum(cliente, album);
    }

    @Override
    public DataListaPorDefecto retornarDataListaPorDefecto2(String nombreLista) {
        ControladorListaPorDefecto controlador = new ControladorListaPorDefecto();

        return controlador.devolverInformacionChu(nombreLista);
    }

    @Override
    public DataListaParticular retornarDataListaParticular(String nombreLista, String nombreCreador) {
        ControladorListaParticular controlador = new ControladorListaParticular();

        return controlador.devolverInformacion(nombreLista, nombreCreador);
    }

    @Override
    public void agregarTemaALista(String nickname, String nombreLista, DataTema temazo) {
        ControladorListaParticular controlador = new ControladorListaParticular();

        controlador.agregarTema(nickname, nombreLista, temazo);
    }

    @Override
    public Collection<DataListaParticular> obtenerDataListaParticualaresPublicas() {
        Collection<DataListaParticular> listas = new ArrayList<>();
        // FALTA IMPLEMENTAR
        return listas;
    }

    @Override
    public Collection<DataTema> obtenerTemasDeListas(String nombreLista, Integer tipoLista) {
        ControladorTema controlador = new ControladorTema();
        return controlador.retornarTemasDeLaLista(nombreLista, tipoLista);
    }

    @Override
    public Collection<DataTema> obtenerTemasDeAlbumes(String nombreAlbum) {
        ControladorTema controlador = new ControladorTema();
        return controlador.retornarTemasDeAlbum(nombreAlbum);
    }

    @Override
    public void hiroshimaYNagasaki() {
        ControladorCliente controlador = new ControladorCliente();
        controlador.hiroshimaYnagasaki();
    }

    @Override
    public void agregarRegistro(String nickname, String os, String navegador, String ip, String url) {
        ControladorCliente controlador = new ControladorCliente();
        controlador.agregarRegistro(nickname, os, navegador, ip, url);
    }

    @Override
    public void crearListaParticular(String nombreLista, DataCliente cliente) {
        ControladorListaParticular controlador = new ControladorListaParticular();
        controlador.crearLista(nombreLista, cliente);
    }

    @Override
    public void actualizarListaParticular(DataListaParticular lista) {
        ControladorListaParticular controlador = new ControladorListaParticular();
        controlador.actualizarLista(lista); //a ver que tul
    }

    @Override
    public Registro_tema devolverRegistroTema(String nombreTema, String albumName) {
        ControladorAdicionalTema controlador = new ControladorAdicionalTema();
        return controlador.devolverRegistroTema(nombreTema, albumName);
    }

    @Override
    public Collection<Registro_tema> obtenerLos100MasPopulares() {
        ControladorAdicionalTema controlador = new ControladorAdicionalTema();
        return controlador.buscarLos100MasPopulares();
    }

    @Override
    public void eliminarArtista(String nickname) {
        ControladorAlbum controlAl = new ControladorAlbum();
        ControladorTema controlTema = new ControladorTema();
        ControladorCliente controlCli = new ControladorCliente();
        ControladorListaParticular controlLipa = new ControladorListaParticular();
        ControladorListaPorDefecto controlLipo = new ControladorListaPorDefecto();
        ControladorArtista controlador = new ControladorArtista();

        controlador.eliminarArtitsta(nickname, controlAl, controlTema, controlCli, controlLipa, controlLipo);
    }

    @Override
    public Boolean checkSiEsGenero(String nombreGenero) {
        DAO_Genero gen = new DAO_Genero();
        Genero genero = gen.find(nombreGenero);
        if (genero != null) {
            return true;
        }
        return false;
    }

    @Override
    public Collection<DataListaPorDefecto> obtenerDataListaPorDefectoPorParecido(String busqueda) {
        ControladorListaPorDefecto controlador = new ControladorListaPorDefecto();
        return controlador.retornarDataListasParecidasA(busqueda);
    }

    @Override
    public Collection<DataListaParticular> obtenerDataListaParticularPorParecido(String busqueda) {
        ControladorListaParticular controlador = new ControladorListaParticular();
        return controlador.retornarDataListasParecidasA(busqueda);
    }

    @Override
    public Collection<DataAlbum> obtenerDataAlbumPorParecido(String busqueda) {
        ControladorAlbum controlador = new ControladorAlbum();
        return controlador.retornarDataAlbumesParecidosA(busqueda);
    }

    @Override
    public Collection<DataTema> obtenerDataTemaPorParecido(String busqueda) {
        ControladorTema controlador = new ControladorTema();
        return controlador.retornarDataTemasParecidosA(busqueda);
    }

    @Override
    public Collection<String> obtenerSeguidoresDeUsuario(String nickname) {
        ControladorCliente controlador = new ControladorCliente();
        return controlador.obtenerSeguidoresUsuario(nickname);
    }

    @Override
    public Collection<String> obtenerSeguidosDeUsuario(String nickname) {
        ControladorCliente controlador = new ControladorCliente();
        return controlador.obtenerSeguidosUsuario(nickname);
    }

    @Override
    public Collection<DataAlbum> obtenerDataAlbumesDeArtista(String nickname) {
        ControladorArtista controlador = new ControladorArtista();
        return controlador.obtenerDataAlbumesDeArtista(nickname);
    }

    @Override
    public Collection<DataListaParticular> obtenerDataListasDeClientes(String nickname) {
        ControladorCliente controlador = new ControladorCliente();
        return controlador.obtenerDataListasDeClientes(nickname);
    }

    @Override
    public Collection<DataAlbum> obtenerDataAlbumesFavoritos(String nickname) {
        ControladorCliente controlador = new ControladorCliente();
        return controlador.obtenerDataAlbumesFavoritos(nickname);
    }

    @Override
    public Collection<DataListaParticular> obtenerDataListasParticularesFavoritas(String nickname) {
        ControladorCliente controlador = new ControladorCliente();
        return controlador.obtenerDataListasParticularesFavoritas(nickname);
    }

    @Override
    public Collection<DataListaPorDefecto> obtenerDataListasPorDefectoFavoritas(String nickname) {
        ControladorCliente controlador = new ControladorCliente();
        return controlador.obtenerDataListasPorDefectoFavoritas(nickname);
    }

    @Override
    public Collection<DT_IdTema> obtenerDataIdTemasFavoritos(String nickname) {
        ControladorCliente controlador = new ControladorCliente();
        return controlador.obtenerDataIdTemasFavoritos(nickname);
    }

    @WebMethod(exclude = true)
    public void publicar() {
        String url = "http://localhost:9128/publicador";
        if (endpoint != null) {
            System.out.println("El servicio ya está publicado en: " + url);
            return;
        }

        // Publica el servicio en la URL proporcionada
        endpoint = Endpoint.publish(url, this);
        System.out.println("Servicio publicado en: " + url);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndPoint() {
        return endpoint; // Devuelve el endpoint actual
    }
}
