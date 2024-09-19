package logica.controladores;

import java.util.Collection;
import logica.dt.DataGenero;
import logica.dt.DataListaPorDefecto;

public interface IControladorListaPorDefecto {

    void crearLista(String nombre, DataGenero genero);

    void agregarTema(String nombre_lista, String nombre_tema);

    void quitarTema(String nombre_lista, String nombre_tema);

    DataListaPorDefecto devolverInformacion(String ls, String nombre_genero);
    
    Collection<String> listarListasPorDefecto() ;
    
    DataListaPorDefecto devolverInformacionChu(String nombre_lista);    
}
