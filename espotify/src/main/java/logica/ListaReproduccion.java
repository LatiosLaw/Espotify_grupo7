package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class ListaReproduccion implements Serializable {

    @Id
    protected String nombre;

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
