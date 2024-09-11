package logica.dt;

public class DataListaReproduccion {

    private String nombre;
    private DataCliente creador;

    public DataListaReproduccion(String nombre, DataCliente creador) {
        this.nombre = nombre;
        this.creador = creador;
    }

    public DataListaReproduccion(String nombre) {
        this.nombre = nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreador(DataCliente creador) {
        this.creador = creador;
    }
}
