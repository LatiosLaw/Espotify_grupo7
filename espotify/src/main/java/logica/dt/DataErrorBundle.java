package logica.dt;

public class DataErrorBundle {

    private boolean verificacion;
    private Integer numero_error_interno;

    public DataErrorBundle(boolean valor, Integer numero) {
        this.verificacion = valor;
        this.numero_error_interno = numero;
    }

    public boolean getValor() {
        return this.verificacion;
    }

    public Integer getNumero() {
        return this.numero_error_interno;
    }
}
