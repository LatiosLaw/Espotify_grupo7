package logica.dt;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataUsuario")
public class DataUsuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String correo;
    private String foto_perfil;
    @XmlElement(name = "dtype")
    private String DTYPE;

    private LocalDate fechaNac;

    public DataUsuario(String nickname, String nombre, String apellido, String contraseña, String correo, String foto_perfil, LocalDate fechaNac) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.correo = correo;
        this.foto_perfil = foto_perfil;
        this.fechaNac = fechaNac;
    }

    public DataUsuario() {

    }

    public DataUsuario(String nickname, String DTYPE) {
        this.nickname = nickname;
        this.DTYPE = DTYPE;
    }

    public DataUsuario(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }
    
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public String getFoto() {
        return foto_perfil;
    }

    public String getContra() {
        return contraseña;
    }

    public String getDTYPE() {
        return DTYPE;
    }

    public void setContra(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setFoto(String nueva_foto) {
        this.foto_perfil = nueva_foto;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "DataUsuario{"
                + "nickname='" + nickname + '\''
                + ", nombre='" + nombre + '\''
                + ", apellido='" + apellido + '\''
                + ", correo='" + correo + '\''
                + ", fechaNac=" + fechaNac
                + '}';
    }
}
