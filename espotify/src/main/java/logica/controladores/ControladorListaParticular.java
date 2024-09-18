package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import logica.Cliente;
import logica.ListaParticular;
import logica.ListaReproduccion;
import logica.Usuario;
import logica.dt.DataCliente;
import logica.dt.DataListaParticular;
import persistencia.DAO_ListaReproduccion;
import persistencia.DAO_Usuario;

public class ControladorListaParticular implements IControladorListaParticular {

    @Override
    public void crearLista(String nombre, DataCliente dataCliente) {
        DAO_ListaReproduccion daoLista = new DAO_ListaReproduccion();
        DAO_Usuario daoUsuario = new DAO_Usuario();

        // Buscar el usuario existente usando el nickname
        Usuario clienteExistente = daoUsuario.findUsuarioByNick(dataCliente.getNickname());
        if (clienteExistente == null) {
            throw new IllegalArgumentException("No se encontro el cliente con el nickname: " + dataCliente.getNickname());
        }

        // Verificar si la lista ya existe
        ListaReproduccion listaExistente = daoLista.find(nombre);
        if (listaExistente != null) {
            throw new IllegalArgumentException("La lista de reproduccion ya existe.");
        }

        // Crear la nueva lista particular y asociar el cliente existente
        ListaParticular nuevaLista = new ListaParticular(nombre, (Cliente) clienteExistente);
        nuevaLista.setVisibilidad(false);

        ListaParticular ls = new ListaParticular();
        ls.setNombre(nuevaLista.getNombre());
        daoLista.save(ls);
        daoLista.update(nuevaLista);

        System.out.println("Lista Particular creada exitosamente.");
    }

    @Override
    public void agregarTema(String nick_cliente, String nombre_lista, String nombre_tema) {

    }

    @Override
    public void quitarTema(String nick_cliente, String nombre_lista, String nombre_tema) {

    }

    @Override
    public boolean publicarLista(String nick_cliente, String nombre_lista) {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        ListaParticular lista_a_publicar = persistence.findListaPorNicks(nick_cliente, nombre_lista);
        if (lista_a_publicar != null) {
            lista_a_publicar.setVisibilidad(true);
            persistence.update(lista_a_publicar);
            return true;
        } else {
            System.out.println("La lista con nombre " + nombre_lista + " no existe.");
            return false;
        }
    }

    @Override
    public DataListaParticular devolverInformacion(String nombre_lista, String nick_cliente) {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        ListaParticular ls = persistence.findListaPorNicks(nick_cliente, nombre_lista);

        if (ls != null) {
            // Obtener el cliente asociado a la lista
            Cliente cliente = ls.getCliente(); // Suponiendo que getCliente() retorna un objeto Cliente

            // Crear el DataCliente con los atributos necesarios
            DataCliente dataCliente = new DataCliente(
                    cliente.getNickname(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getEmail(),
                    cliente.getFoto(),
                    cliente.getNacimiento()
            );

            System.out.println("DataLista retornado correctamente.");
            // Crear y retornar DataListaParticular
            return new DataListaParticular(
                    ls.getNombre(), // Suponiendo que hay un método getNombre()
                    dataCliente, // Pasar el DataCliente creado
                    ls.getVisibilidad() // Suponiendo que hay un método getVisibilidad()
            );
        } else {
            System.out.println("No existe, error.");
            return null;
        }
    }

    @Override
    public Collection<DataListaParticular> devolverListadeCliente(String nickname) {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();

        Collection<DataListaParticular> dataListas = new ArrayList<>();

        // Obtener listas de un cliente
        Collection<ListaParticular> listas = persistence.findListaPorCliente(nickname);

        if (!listas.isEmpty()) {
            for (ListaParticular listaP : listas) {
                DataCliente cli = new DataCliente(
                        listaP.getCliente().getNickname(),
                        listaP.getCliente().getNombre(),
                        listaP.getCliente().getApellido(),
                        listaP.getCliente().getEmail(),
                        listaP.getCliente().getFoto(),
                        listaP.getCliente().getNacimiento()
                );

                dataListas.add(new DataListaParticular(listaP.getNombre(), cli, listaP.getVisibilidad()));
            }

            System.out.println("Listas retornadas correctamente.");
        } else {
            System.out.println("No se encontraron listas para el cliente con nickname: " + nickname);
        }

        return dataListas;
    }
}
