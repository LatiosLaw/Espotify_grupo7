package logica.dt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "DataListaReproduccion")
@XmlType(propOrder = { "nombre", "foto", "creador", "temas" })
public class DataListaReproduccion {

    private String nombre;
    private String foto;
    private DataCliente creador;
    private Collection<DataTema> temas;

    public DataListaReproduccion(String nombre, DataCliente creador) {
        this.nombre = nombre;
        this.creador = creador;
        this.temas = new ArrayList<>();
    }
    
    public DataListaReproduccion(String nombre, DataCliente creador, String foto) {
        this.nombre = nombre;
        this.creador = creador;
        this.foto = foto;
        this.temas = new ArrayList<>();
    }
    
    public DataListaReproduccion(String nombre, String creadirNick) {
        this.nombre = nombre;
        this.creador = new DataCliente();
        creador.setNickname(creadirNick);
        this.temas = new ArrayList<>();
    }
    
    public DataListaReproduccion(String nombre, String foto, Integer diferenciador) {
        this.nombre = nombre;
        this.foto = foto;
        this.temas = new ArrayList<>();
    }
    
    public DataListaReproduccion(String nombre, String foto, String creadirNick) {
        this.nombre = nombre;
        this.foto = foto;
        this.temas = new ArrayList<>();
        creador.setNickname(creadirNick);
    }

    public DataListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.temas = new ArrayList<>();
    }

    public DataListaReproduccion() {
        this.temas = new ArrayList<>(); // Inicializa la colección
    }

    @XmlElement(name = "nombre") // Anotación para el campo nombre
    public String getNombre() {
        return nombre;
    }

    @XmlElement(name = "creador") // Anotación para el campo creador
    public DataCliente getCreador() {
        return creador;
    }
    
    @XmlElement(name = "foto") // Anotación para el campo foto
    public String getFoto() {
        return foto;
    }

    @XmlElement(name = "temas") // Anotación para el campo temas
    public Collection<DataTema> getTemas() {
        return temas;
    }

    public void agregarTema(DataTema tema) {
        this.temas.add(tema);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setCreador(DataCliente creador) {
        this.creador = creador;
    }
}