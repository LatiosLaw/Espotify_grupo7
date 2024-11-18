package logica.dt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataErrorBundle")
public class DataErrorBundle {

    private boolean verificacion;
    private Integer numero_error_interno;

    public DataErrorBundle() {
        
    }

    public DataErrorBundle(boolean valor, Integer numero) {
        this.verificacion = valor;
        this.numero_error_interno = numero;
    }

    @XmlElement(name = "valor")
    public boolean getValor() {
        return this.verificacion;
    }

    @XmlElement(name = "numero")
    public Integer getNumero() {
        return this.numero_error_interno;
    }

    public void setValor(boolean verificacion) {
        this.verificacion = verificacion;
    }

    public void setNumero(Integer numero_error_interno) {
        this.numero_error_interno = numero_error_interno;
    }
}