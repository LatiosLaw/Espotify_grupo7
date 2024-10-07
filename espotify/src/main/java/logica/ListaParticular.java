package logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ListaParticular extends ListaReproduccion implements Serializable {

    private boolean visibilidad;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "creador_nickname")
    private Cliente creador;

    public ListaParticular() {

    }
    
    public ListaParticular(String nombre, boolean visibilidad) {
        super(nombre);
        this.visibilidad = visibilidad;
    }

    public ListaParticular(String nombre, Cliente cliente) {
        super(nombre,cliente.getNickname());
        this.creador = cliente;
    }

    public ListaParticular(String nombre, boolean visibilidad, Cliente creador) {
        super(nombre);
        this.visibilidad = visibilidad;
        this.creador = creador;
    }

    public boolean getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(boolean visibilidad) {
        this.visibilidad = visibilidad;
    }
    
    public Cliente getCliente(){
        return this.creador;
    }

    @Override
    public String toString() {
        return "logica.ListaParticular[ visibilidad=" + visibilidad + " ]";
    }
}
