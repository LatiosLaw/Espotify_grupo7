package logica.dt;

public class DataListaParticular extends DataListaReproduccion {
    private boolean visibilidad; 
    private DataCliente creador; 

    // Constructor
    public DataListaParticular(String nombre, DataCliente creador, boolean visibilidad) {
        super(nombre, creador);
        this.visibilidad = visibilidad;
        this.creador = creador;
    }

    public DataListaParticular() {
        super();
        this.visibilidad = false;
        this.creador = null;
    }

    public boolean getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(boolean visibilidad) {
        this.visibilidad = visibilidad;
    }
}