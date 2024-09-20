package logica.dt;

import java.time.LocalDate;

public class DataUsuario {

    private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private String foto_perfil;
    private LocalDate fechaNac;

    public DataUsuario(String nickname, String nombre, String apellido, String correo, String foto_perfil, LocalDate fechaNac) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.foto_perfil = foto_perfil;
        this.fechaNac = fechaNac;
    }

    public DataUsuario() {
        this.setNickname(new String());
        this.setNombre(new String());
        this.setApellido(new String());
        this.setCorreo(new String());
        this.setFoto(new String());
        this.setFechaNac(null);
    }

    public DataUsuario(String nickname){
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

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public String getFoto() {
        return foto_perfil;
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
