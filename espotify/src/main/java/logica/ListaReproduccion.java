package logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import logica.dt.DT_IdLista;


@Entity
public abstract class ListaReproduccion implements Serializable {

    @EmbeddedId
    private DT_IdLista identificador = new DT_IdLista();
    
    protected String foto;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<tema> temas;

    public ListaReproduccion() {

    }
    
    public ListaReproduccion(String nombreLista) {
        this.identificador = new DT_IdLista();
        this.identificador.setNombre_lista(nombreLista);
        identificador.setNombre_cliente("none");
    }
     public ListaReproduccion(String nombreLista, String nombreCliente) {
        this.identificador = new DT_IdLista();
        this.identificador.setNombre_lista(nombreLista);
        identificador.setNombre_cliente(nombreCliente);
    }
    public String getNombreCliente() {
        return identificador.getNombre_cliente();
    }

    public void setNombreCliente(String nombre) {
        this.identificador.setNombre_cliente(nombre);
    }
    
    public String getNombreLista() {
        return this.identificador.getNombre_lista();
    }

    public void setNombreLista(String nombre) {
        this.identificador.setNombre_lista(nombre);
    }
    
    public Collection<tema> getTemas() {
        return temas;
    }

    public void agregarTema(tema tema) {
        this.temas.add(tema);
    }
    
    public void eliminarTema(tema tema) {
        this.temas.remove(tema);
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ListaReproduccion)) {
            return false;
        }
        ListaReproduccion other = (ListaReproduccion) object;
        if ((this.identificador.getNombre_lista() == null && other.identificador.getNombre_lista() != null) || (this.identificador.getNombre_lista() != null && !this.identificador.getNombre_lista().equals(other.identificador.getNombre_lista()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.ListaReproduccion[ nombre=" + identificador.getNombre_lista() + " ]";
    }
}
