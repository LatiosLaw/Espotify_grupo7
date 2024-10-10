package logica.controladores;

import java.util.Collection;
import logica.ListaReproduccion;
import logica.dt.DataCliente;
import logica.dt.DataListaParticular;
import logica.dt.DataListaReproduccion;
import logica.dt.DataTema;

public interface IControladorListaParticular {

    Collection<String> retornarListasPublicas();
            
    void crearLista(String nombre, DataCliente cli);
    
    void crearListaConVisibilidad(String nombre, DataCliente cli, boolean publica, String foto);

    void agregarTema(String nick_cliente, String nombre_lista, DataTema nombre_tema);

    void quitarTema(String nick_cliente, String nombre_lista, String nombre_tema, String nombre_album_tema);

    boolean publicarLista(String nick_cliente, String nombre_lista);

    DataListaParticular devolverInformacion(String nombre_lista, String nick_cliente);

    Collection<DataListaParticular> devolverListadeCliente(String nickname);
    
    Collection<String> devolverListasParticularesPublicasString(String nickname);
    
    DataListaParticular retornarlista(String nickname, String nombreCliente);

   public DataListaReproduccion devolverInformacionListaRepro(String coso);
    
    void actualizarLista(DataListaParticular lista);
    
     
}
