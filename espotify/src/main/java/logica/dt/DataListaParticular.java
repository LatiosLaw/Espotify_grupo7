package logica.dt;

public class DataListaParticular extends DataListaReproduccion {

    private boolean visibilidad;
    private DataCliente creador;

    public DataListaParticular(String nombre, DataCliente creador, boolean visibilidad) {
        super(nombre, creador);
        this.visibilidad = visibilidad;
        this.creador = creador;
    }
    public DataListaParticular(String nombre, DataCliente creador, String foto, boolean visibilidad) {
        super(nombre, creador, foto);
        this.visibilidad = visibilidad;
        this.creador = creador;
    }
     public DataListaParticular(String nombre, DataCliente creador) {
        super(nombre, creador);
        this.creador = creador;
    }
    public DataListaParticular() {
        super();
        this.visibilidad = false;
        this.creador = null;
    }
    
    public DataListaParticular(String nombre) {
        super(nombre);
    }

    public boolean getVisibilidad() {
        return visibilidad;
    }

    public DataCliente getDataCliente() {
        return this.creador;
    }

    public void setVisibilidad(boolean visibilidad) {
        this.visibilidad = visibilidad;
    }
}
