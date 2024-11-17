package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import logica.Cliente;
import logica.ListaParticular;
import logica.ListaReproduccion;
import logica.Usuario;
import logica.dt.DataCliente;
import logica.dt.DataListaParticular;
import logica.dt.DataListaReproduccion;
import logica.dt.DataTema;
import logica.tema;
import persistencia.DAO_ListaReproduccion;
import persistencia.DAO_Tema;
import persistencia.DAO_Usuario;

public class ControladorListaParticular implements IControladorListaParticular {

    @Override
    public Collection<String> retornarListasPublicas(){
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        Collection<ListaParticular> listas = persistence.findAllListasParticulares();
        Collection<String> coleString = new ArrayList<>();
        for(ListaParticular listaP : listas){
                if(listaP.getVisibilidad() == true){
                coleString.add(listaP.getNombreLista());
                }
        }
       return coleString;
    }
    
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
        ListaReproduccion listaExistente = daoLista.findListaPorNicks(clienteExistente.getNickname(),nombre);
        if (listaExistente != null) {
            throw new IllegalArgumentException("La lista de reproduccion ya existe.");
        }
        
        // Crear la nueva lista particular y asociar el cliente existente
        //System.out.println("Antes");
        ListaParticular nuevaLista = new ListaParticular(nombre, (Cliente) clienteExistente);
       // System.out.println("Despues");
        nuevaLista.setVisibilidad(false);
       // System.out.println("Despues2");
        ListaParticular ls = new ListaParticular();
       // System.out.println("Despues3");
        ls.setNombreLista(nuevaLista.getNombreLista());
        ls.setNombreCliente(nuevaLista.getNombreCliente());
        //System.out.println("Despues4");
        daoLista.save(ls);
       // System.out.println("Despues5");
        daoLista.update(nuevaLista);
        //System.out.println("Despues6");
        System.out.println("Lista Particular creada exitosamente.");
    }
    
    @Override
    public void crearListaConVisibilidad(String nombre, DataCliente cli, boolean publica, String foto){
        DAO_ListaReproduccion daoLista = new DAO_ListaReproduccion();
        DAO_Usuario daoUsuario = new DAO_Usuario();
        // Buscar el usuario existente usando el nickname
        Usuario clienteExistente = daoUsuario.findUsuarioByNick(cli.getNickname());
        if (clienteExistente == null) {
            throw new IllegalArgumentException("No se encontro el cliente con el nickname: " + cli.getNickname());
        }
        // Verificar si la lista ya existe
        ListaReproduccion listaExistente = daoLista.findListaPorNicks(nombre, clienteExistente.getNickname());
        if (listaExistente != null) {
            throw new IllegalArgumentException("La lista de reproduccion ya existe.");
        }
        // Crear la nueva lista particular y asociar el cliente existente
        ListaParticular nuevaLista = new ListaParticular(nombre, (Cliente) clienteExistente);
        nuevaLista.setVisibilidad(publica);
        nuevaLista.setFoto(foto);
        ListaParticular ls = new ListaParticular();
        ls.setNombreLista(nuevaLista.getNombreLista());
        ls.setNombreCliente(nuevaLista.getNombreCliente());
        daoLista.save(ls);
        daoLista.update(nuevaLista);
        System.out.println("Lista Particular creada exitosamente.");
    }

    @Override
    public void agregarTema(String nick_cliente, String nombre_lista, DataTema temazo){
        DAO_ListaReproduccion daoLista = new DAO_ListaReproduccion();
        ListaParticular lista = null;
        Collection<ListaParticular> listas = daoLista.findListaPorCliente(nick_cliente);
        Iterator<ListaParticular> iterator = listas.iterator();
        while (iterator.hasNext()) {
            lista = iterator.next();
            String nombrel = lista.getNombreLista();
            if(nombrel.equals(nombre_lista)){
                if(lista == null){
                    System.out.println("No existen listas en el sistema."); 
                }else{
                    lista.agregarTema(new tema(temazo.getNickname(), temazo.getNomAlb(), temazo.getDuracion()));
                    daoLista.update(lista);
                }
                break;
            }
        }
    }

    @Override
    public void quitarTema(String nick_cliente, String nombre_lista, String nombre_tema, String nombre_album_tema) {
DAO_ListaReproduccion daoLista = new DAO_ListaReproduccion();
DAO_Tema daoTema = new DAO_Tema();
        ListaParticular lista = null;
        Collection<ListaParticular> listas = daoLista.findListaPorCliente(nick_cliente);
        tema temazo = daoTema.find(nombre_tema, nombre_album_tema);
        Iterator<ListaParticular> iterator = listas.iterator();
        while (iterator.hasNext()) {
            lista = iterator.next();
            String nombrel = lista.getNombreLista();
            if(nombrel == nombre_lista){
                if(lista == null){
                    System.out.println("No existen listas en el sistema."); 
                }else{
                    lista.eliminarTema(new tema(temazo.getNickname(), temazo.getNombreAlbum()));
                    daoLista.update(lista);
                }
                break;
            }
        }
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
                    cliente.getContra(),
                    cliente.getEmail(),
                    cliente.getFoto(),
                    cliente.getNacimiento());
            System.out.println("DataLista retornado correctamente.");
            // Crear y retornar DataListaParticular
            return new DataListaParticular(
                    ls.getNombreLista(), // Suponiendo que hay un método getNombre()
                    dataCliente, // Pasar el DataCliente creado
                    ls.getFoto(),
                    ls.getVisibilidad() // Suponiendo que hay un método getVisibilidad()
            );
        } else {
            System.out.println("La lista con nombre " + nombre_lista + " no existe, error.");
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
                        listaP.getCliente().getContra(),
                        listaP.getCliente().getEmail(),
                        listaP.getCliente().getFoto(),
                        listaP.getCliente().getNacimiento());
                dataListas.add(new DataListaParticular(listaP.getNombreLista(), cli, listaP.getVisibilidad()));
            }
            System.out.println("Listas retornadas correctamente.");
        } else {
            System.out.println("No se encontraron listas para el cliente con nickname: " + nickname);
        }
        return dataListas;
    }
    
    @Override
     public Collection<String> devolverListasParticularesPublicasString(String nickname) {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        Collection<ListaParticular> listas = persistence.findListaPorCliente(nickname);
        Collection<String> coleString = new ArrayList<>();
        for(ListaParticular listaP : listas){
            if(listaP.getVisibilidad() == true){
                coleString.add(listaP.getNombreLista());
            }
        }
       return coleString;
    }
    
    @Override
      public DataListaReproduccion devolverInformacionListaRepro(String coso, String nombre){
          DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
          ListaReproduccion token = persistence.findListaReproduccionPorNombre(coso,nombre);
            //WARNINMG
          if(token == null){
              return null;
          }else{
               DataListaReproduccion token2 = new DataListaReproduccion(token.getNombreLista(), token.getNombreCliente());
               return token2;
          }
      }
    @Override
    public DataListaParticular retornarlista(String nickname, String nombreCliente){
        DAO_Usuario persistence2 = new DAO_Usuario();
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        ListaReproduccion lista = persistence.findListaPorNicks(nombreCliente, nickname);
        if(lista != null){
            if(lista instanceof ListaParticular listaP){
                Cliente cli = listaP.getCliente();
                DataListaParticular listaRetorno = new DataListaParticular();
                listaRetorno.setNombre(listaP.getNombreLista());
                listaRetorno.setCreador(new DataCliente(cli.getNickname(), cli.getNombre(), cli.getApellido(), cli.getContra(), cli.getEmail(), cli.getFoto(), cli.getNacimiento()));
                listaRetorno.setFoto(listaP.getFoto());
                listaRetorno.setVisibilidad(listaP.getVisibilidad());
                System.out.println("Listas retornadas correctamente.");
                return listaRetorno;
            }
        }
        System.out.println("Error al retornar Lista.");
        return null;
    }
    
    @Override
    public void actualizarLista(DataListaParticular lista){
        DAO_ListaReproduccion dao_l = new DAO_ListaReproduccion();
        DAO_Tema dao_t = new DAO_Tema();
        ListaParticular lista_actualizable = dao_l.findListaPorNicks(lista.getCreador().getNickname(), lista.getNombre());
        Iterator<DataTema> iterator = lista.getTemas().iterator();
        while (iterator.hasNext()) {
            DataTema tema = iterator.next();
            lista_actualizable.agregarTema(dao_t.find(tema.getNickname(), tema.getNomAlb()));
        }
        dao_l.update(lista_actualizable);
    }
}
