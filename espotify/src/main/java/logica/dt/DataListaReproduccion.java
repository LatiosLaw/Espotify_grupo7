package logica.dt;

import java.util.ArrayList;
import java.util.Collection;

public class DataListaReproduccion {

    private String nombre;
    private DataCliente creador;
    private Collection<DataTema> temas;

    public DataListaReproduccion(String nombre, DataCliente creador) {
        this.nombre = nombre;
        this.creador = creador;
        this.temas = new ArrayList<>();
    }
    
    public DataListaReproduccion(String nombre, String creadirNick) {
        this.nombre = nombre;
        this.creador = new DataCliente();
        creador.setNickname(creadirNick);
        this.temas = new ArrayList<>();
    }
    
    public DataListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }

    public DataListaReproduccion() {
        this.setNombre(new String());
    }

    public String getNombre() {
        return nombre;
    }

    public DataCliente getCreadorNickname() {
        return creador;
    }
    public Collection<DataTema> getTemas() {
        return temas;
    }

    public void agregarTema(DataTema tema) {
        this.temas.add(tema);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreador(DataCliente creador) {
        this.creador = creador;
    }
}
