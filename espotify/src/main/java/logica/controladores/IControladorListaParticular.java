package logica.controladores;

import java.util.Collection;
import logica.dt.DataCliente;
import logica.dt.DataListaParticular;

public interface IControladorListaParticular {

    void crearLista(String nombre, DataCliente cli);

    void agregarTema(String nick_cliente, String nombre_lista, String nombre_tema);

    void quitarTema(String nick_cliente, String nombre_lista, String nombre_tema);

    boolean publicarLista(String nick_cliente, String nombre_lista);

    DataListaParticular devolverInformacion(String nombre_lista, String nick_cliente);

    Collection<DataListaParticular> devolverListadeCliente(String nickname);
}
