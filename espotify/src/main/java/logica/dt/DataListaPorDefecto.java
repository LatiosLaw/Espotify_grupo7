package logica.dt;

public class DataListaPorDefecto extends DataListaReproduccion {
    private DataGenero genero; 

    public DataListaPorDefecto(String nombre, DataCliente creador, DataGenero genero) {
        super(nombre, creador);
        this.genero = genero;
    }

    public DataListaPorDefecto() {
        super();
    }

    public DataGenero getGenero() {
        return genero;
    }

    public void setGenero(DataGenero genero) {
        this.genero = genero;
    }
}