package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import logica.Genero;
import logica.dt.DataAlbum;
import logica.dt.DataGenero;
import persistencia.DAO_Album;
import persistencia.DAO_Genero;

public class ControladorGenero implements IControladorGenero {

    @Override
    public void crearGeneroUnico(String nombre) {
        DAO_Genero persistence = new DAO_Genero();
        Genero nuevo_genero = new Genero(nombre);
        persistence.save(nuevo_genero);
        System.out.println("Genero agregado exitosamente.");
    }

    @Override
    public void crearGeneroConSubgeneros(String nombre, Collection<String> genero_padre) {
        DAO_Genero persistence = new DAO_Genero();
        Genero nuevo_genero = new Genero(nombre);
        
        for(String genero : genero_padre){
            nuevo_genero.agregarSubgenero(new Genero(genero));
        }
        
        Genero genero_vacio = new Genero();
        genero_vacio.setNombre(nuevo_genero.getNombre());
        persistence.save(genero_vacio);
        persistence.update(nuevo_genero);
        
        System.out.println("Genero con subgeneros agregado exitosamente.");
    }

    @Override
    public Collection<String> mostrarGeneros() {
        Collection<String> lista = new ArrayList<>();
        DAO_Genero persistence = new DAO_Genero();
        Collection<Genero> gene = persistence.findAll();
        Iterator<Genero> iterator = gene.iterator();
        while (iterator.hasNext()) {
            Genero genero = iterator.next();
            lista.add(genero.getNombre());
        }
        return lista;
    }

    @Override
    public Collection<DataGenero> darGenerosDelAlbum(String nombre_album) {
        Collection<DataGenero> lista = new ArrayList<>();
        DAO_Genero persistence = new DAO_Genero();
        Collection<String> gene = persistence.findfromAlbum(nombre_album);
        Iterator<String> iterator = gene.iterator();
        while (iterator.hasNext()) {
            String genero = iterator.next();
            lista.add(new DataGenero(genero));
        }
        return lista;
    }

    @Override
    public void actualizarGenero(DataGenero genero, Collection<String> albumes_previos_del_genero, DataAlbum album) {
        DAO_Genero persistence = new DAO_Genero();
        DAO_Album persistence_a = new DAO_Album();
        Genero genero_actualizable = persistence.find(genero.getNombre());
        genero_actualizable.agregarAlbumDelGenero(persistence_a.find(album.getNombre()));
        persistence.update(genero_actualizable);
    }
}
