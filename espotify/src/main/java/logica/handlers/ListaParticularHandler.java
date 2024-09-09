/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;


import logica.ListaParticular;
import logica.ListaReproduccion;
import persistencia.DAO_ListaReproduccion;
import javax.persistence.EntityManager;
import logica.Cliente;
import logica.ListaParticular;
import logica.ListaReproduccion;
import logica.Usuario;
import persistencia.DAO_ListaReproduccion;
import persistencia.DAO_Usuario;


/**
 *
 * @author Nico
 */
public class ListaParticularHandler implements IListaParticularHandler {

    @Override    
    public void crearLista(String nombre, Cliente nicknameCliente) {
        DAO_ListaReproduccion daoLista = new DAO_ListaReproduccion();
        DAO_Usuario daoUsuario = new DAO_Usuario();

        // Buscar el cliente existente usando el nickname
        Usuario clienteExistente = daoUsuario.findUsuarioByNick(nicknameCliente.getNickname());
        if (clienteExistente == null) {
            throw new IllegalArgumentException("No se encontro el cliente con el nickname: " + nicknameCliente.getNickname());
        }

        // Verificar si la lista ya existe
        ListaReproduccion listaExistente = daoLista.find(nombre);
        if (listaExistente != null) {
            throw new IllegalArgumentException("La lista de reproduccion ya existe.");
        }

        // Crear la nueva lista particular y asociar el cliente existente
        ListaParticular nuevaLista = new ListaParticular(nombre, (Cliente) clienteExistente);
        nuevaLista.setVisibilidad(false); // Establecer visibilidad según sea necesario

        // Guardar la nueva lista en la base de datos
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
    public void publicarLista(String nick_cliente, String nombre_lista){
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        ListaParticular lista_a_publicar = persistence.findListaPorNicks(nick_cliente, nombre_lista);
        if (lista_a_publicar != null) {
            lista_a_publicar.setVisibilidad(true);
            persistence.update(lista_a_publicar);
        } else {
            throw new IllegalArgumentException("La lista con nombre " + nombre_lista + " no existe.");
        }
    }
    
    @Override
    public void devolverInformacion(String nombre_lista){
        
    }
}
