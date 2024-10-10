package logica.dt;

public class DataListaPorDefecto extends DataListaReproduccion {

    private DataGenero genero;

    public DataListaPorDefecto(String nombre, DataCliente creador, DataGenero genero) {
        super(nombre, creador);
        this.genero = genero;
    }
    
    public DataListaPorDefecto(String nombre, String foto, DataGenero genero) {
        super(nombre, foto);
        this.genero = genero;
    }

    public DataListaPorDefecto() {
        super();
    }

    public DataListaPorDefecto(String nombre, DataGenero dataGenero) {
        super(nombre);
        this.genero = dataGenero;
    }
    
    public DataListaPorDefecto(String nombre) {
        super(nombre);
    }
    public DataListaPorDefecto(String nombre,DataCliente creador) {
        super(nombre);
    }
    
    
    public DataGenero getGenero() {
        return genero;
    }

    public void setGenero(DataGenero genero) {
        this.genero = genero;
    }
}
