package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import logica.Genero;
import logica.ListaPorDefecto;
import logica.ListaReproduccion;
import logica.dt.DataGenero;
import logica.dt.DataListaPorDefecto;
import logica.dt.DataTema;
import logica.tema;
import persistencia.DAO_Genero;
import persistencia.DAO_ListaReproduccion;
import persistencia.DAO_Tema;

public class ControladorListaPorDefecto implements IControladorListaPorDefecto {

    @Override
    public void crearLista(String nombre, DataGenero dGenero, String foto) {
        DAO_ListaReproduccion dao = new DAO_ListaReproduccion();
        DAO_Genero gdao = new DAO_Genero();
        // Verificar si la lista ya existe
        ListaReproduccion listaExistente = dao.findListaPorDefectoPorNombre(nombre);
        if (listaExistente != null) {
            throw new IllegalArgumentException("La lista de reproducción ya existe.");
        }
        if (dGenero == null) {
            throw new IllegalArgumentException("DataGenero no puede ser nulo.");
        }
        // Verificar que exista el genero
        Genero generoExistente = gdao.find(dGenero.getNombre());
        if (generoExistente == null) {
            throw new IllegalArgumentException("El genero especificado no existe.");
        }
        ListaPorDefecto nuevaLista = new ListaPorDefecto(nombre, generoExistente);
        nuevaLista.setFoto(foto);
        // Guardar la nueva lista en la base de datos
       // System.out.println("Antes del try");
        try {
           
            ListaPorDefecto ls = new ListaPorDefecto();
            ls.setNombreLista(nuevaLista.getNombreLista());
            ls.setNombreCliente(nuevaLista.getNombreCliente());
            dao.save(ls);

            dao.update(nuevaLista);
            System.out.println("Lista Por Defecto creada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
    }
    
    @Override
    public void actualizarLista(DataListaPorDefecto lista){
        DAO_ListaReproduccion dao_l = new DAO_ListaReproduccion();
        DAO_Tema dao_t = new DAO_Tema();
        ListaPorDefecto lista_actualizable = dao_l.findListaPorDefectoPorNombre(lista.getNombre());
        
        
        Iterator<DataTema> iterator = lista.getTemas().iterator();
        while (iterator.hasNext()) {
            DataTema tema = iterator.next();
            lista_actualizable.agregarTema(dao_t.find(tema.getNickname(), tema.getNomAlb()));
        }
        dao_l.update(lista_actualizable);
    }

    @Override
    public void agregarTema(String nombre_lista, String nombre_genero, DataTema temazo) {
        DAO_ListaReproduccion daoLista = new DAO_ListaReproduccion();
        ListaPorDefecto lista = daoLista.findListaPorDefectoPorNombre(nombre_lista);
        lista.agregarTema(new tema(temazo.getNickname(), temazo.getNomAlb(), temazo.getDuracion()));
        daoLista.update(lista);
    }

    @Override
    public void quitarTema(String nombre_lista, String nombre_genero, String nombre_tema, String nombre_album_tema) {
        DAO_ListaReproduccion daoLista = new DAO_ListaReproduccion();
        DAO_Tema daoTema = new DAO_Tema();
        tema temazo = daoTema.find(nombre_tema, nombre_album_tema);
        ListaPorDefecto lista = daoLista.findListaPorDefectoPorNombre(nombre_lista);
        lista.eliminarTema(new tema(temazo.getNickname(), temazo.getNombreAlbum()));
        daoLista.update(lista);
    }
    
    @Override
    public Collection<String> retornarListasDelGenero(String genero){
        Collection<String> lista_final = new ArrayList<>();
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        Collection<ListaPorDefecto> albu = persistence.findListasPorGeneros(genero);
        Iterator<ListaPorDefecto> iterator = albu.iterator();
        while (iterator.hasNext()) {
            ListaPorDefecto lista = iterator.next();
            lista_final.add(lista.getNombreLista());
        }
        return lista_final;
    }

    @Override
    public DataListaPorDefecto devolverInformacion(String nombre_lista, String nombre_genero) {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        // Obtener la lista particular por nombre de lista y el nickname del creador
        ListaPorDefecto ls = persistence.findListaPorDefectoPorNombre(nombre_lista);
        if (ls != null) {
            // Obtener el género asociado a la lista
            Genero gen = ls.getGenero(); // Asegúrate de que hay un método getGenero()
            // Crear el DataGenero
            DataGenero dataGenero = new DataGenero(
                    gen.getNombre() // Suponiendo que existe un método getNombre() en Genero
            );
            System.out.println("DataLista retornado correctamente.");
            // Crear y retornar DataListaPorDefecto
            return new DataListaPorDefecto(
                    ls.getNombreLista(), // Suponiendo que hay un método getNombre()
                    ls.getFoto(),

                    dataGenero // Pasar el DataGenero creado
            );
        } else {
            System.out.println("No existe, error.");
            return null;
        }
    }
    
    @Override
    public Collection<String> listarListasPorDefecto() {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
       return persistence.devolverListasPorDefectoString();   
    }
    
    @Override
    public Collection<String> listarListasPorDefectoConGenero() {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        Collection<ListaPorDefecto> listadPD = persistence.devolverListasPorDefecto();
        Collection<String> retorno = new ArrayList<>();
        Iterator<ListaPorDefecto> iterator = listadPD.iterator();
        while (iterator.hasNext()) {
            ListaPorDefecto lista = iterator.next();
            retorno.add(lista.getNombreLista().concat("/").concat(lista.getGenero().getNombre()));
        }
        return retorno;
    }
    
    @Override
    public DataListaPorDefecto devolverInformacionChu(String nombre_lista) {
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        // Obtener la lista particular por nombre de lista y el nickname del creador
        ListaPorDefecto ls = persistence.findListaPorDefectoPorNombre(nombre_lista);
        if (ls != null) {
            // Obtener el género asociado a la lista
            Genero gen = ls.getGenero(); // Asegúrate de que hay un método getGenero()
            // Crear el DataGenero
            DataGenero dataGenero = new DataGenero(
                    gen.getNombre() // Suponiendo que existe un método getNombre() en Genero
            );
            System.out.println("DataLista retornado correctamente.");
            // Crear y retornar DataListaPorDefecto
            return new DataListaPorDefecto(
                    ls.getNombreLista(), // Suponiendo que hay un método getNombre()
                    dataGenero // Pasar el DataGenero creado
            );
        } else {
            System.out.println("No existe, error.");
            return null;
        }
    }
    
}
