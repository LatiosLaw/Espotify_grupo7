package logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public abstract class ListaReproduccion implements Serializable {

    @Id
    protected String nombre;
    
    protected String foto;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<tema> temas;

    public ListaReproduccion() {

    }

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Collection<tema> getTemas() {
        return temas;
    }

    public void agregarTema(tema tema) {
        this.temas.add(tema);
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaReproduccion)) {
            return false;
        }
        ListaReproduccion other = (ListaReproduccion) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.ListaReproduccion[ nombre=" + nombre + " ]";
    }
}
