package logica.controladores;

import java.util.Collection;
import logica.dt.DataGenero;
import logica.dt.DataListaPorDefecto;
import logica.dt.DataTema;

public interface IControladorListaPorDefecto {

    void crearLista(String nombre, DataGenero genero, String foto);
    
    void actualizarLista(DataListaPorDefecto lista);

    void agregarTema(String nombre_lista, String nombre_genero, DataTema temazo);

    void quitarTema(String nombre_lista, String genero, String nombre_tema, String nombre_album_tema);

    Collection<String> listarListasPorDefectoConGenero();
    
    DataListaPorDefecto devolverInformacion(String ls, String nombre_genero);
    
    Collection<String> listarListasPorDefecto() ;
    
    DataListaPorDefecto devolverInformacionChu(String nombre_lista);   
     
    Collection<String> retornarListasDelGenero(String genero);
    
    Collection<DataListaPorDefecto> retornarListasDelGeneroDT(String genero);
    
    Collection<DataListaPorDefecto> retornarListasPorDefecto();
    
    public void eliminarTemaDeTodasLasListas(DataTema dtTema) ;
}
