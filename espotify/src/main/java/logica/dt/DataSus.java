package logica.dt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "DataSus")
@XmlType(propOrder = {"id", "userNick", "estado", "ultiFechaHabi", "tipoSus"})
@XmlAccessorType(XmlAccessType.FIELD)  // Indica que JAXB usará los campos directamente
public class DataSus {

    @XmlElement(name = "id")  // Se usa en el campo
    private int id;

    @XmlElement(name = "userNick")  // Se usa en el campo
    private String userNick;

    @XmlElement(name = "estado")  // Se usa en el campo
    private String estado;

    // Se usa solo en el campo, no en el getter
    @XmlElement(name = "ultiFechaHabi")
    @XmlJavaTypeAdapter(LocalDateAdapter.class) // Usando el adaptador para LocalDate
    private LocalDate ultiFechaHabi;

    @XmlElement(name = "tipoSus")  // Se usa en el campo
    private String tipoSus;

    // Constructores
    public DataSus() {
        this.userNick = "";
        this.estado = "";
        this.ultiFechaHabi = LocalDate.now(); // Inicializa con la fecha actual
        this.tipoSus = "";
    }

    public DataSus(String usrNick) {
        this.userNick = usrNick;
        this.estado = "";
        this.ultiFechaHabi = LocalDate.now();
        this.tipoSus = "";
    }

    public DataSus(String usrNick, LocalDate fecha) {
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha;
        this.estado = "";
        this.tipoSus = "";
    }

    public DataSus(String usrNick, LocalDate fecha, String estado) {
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha;
        this.estado = estado;
        this.tipoSus = "";
    }

    public DataSus(String usrNick, LocalDate fecha, String estado, String tipo) {
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha;
        this.estado = estado;
        this.tipoSus = tipo;
    }

    public DataSus(String usrNick, LocalDate fecha, String estado, String tipo, int id) {
        this.userNick = usrNick;
        this.ultiFechaHabi = fecha;
        this.estado = estado;
        this.tipoSus = tipo;
        this.id = id;
    }

    // Métodos de acceso (getters) ya no necesitan @XmlElement
    public int getId() {
        return id;
    }

    public String getUserNick() {
        return userNick;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getUltiFechaHabi() {
        return ultiFechaHabi;
    }

    public String getTipoSus() {
        return tipoSus;
    }

    // Métodos de modificación (setters)
    public void setId(int id) {
        this.id = id;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setUltiFechaHabi(LocalDate ultiFechaHabi) {
        this.ultiFechaHabi = ultiFechaHabi;
    }

    public void setTipoSus(String tipoSus) {
        this.tipoSus = tipoSus;
    }
}
