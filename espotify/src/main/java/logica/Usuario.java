package logica;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ManyToMany;

@Entity
public abstract class Usuario implements Serializable {

    @Id
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String contraseña;
    protected String foto_perfil;
    protected LocalDate fecha_nac;
    @ManyToMany(mappedBy = "seguidos")
    protected Collection<Cliente> seguidores = new ArrayList<Cliente>();

    public Usuario() {
    }
    
    public Usuario(String nickname) {
        this.nickname = nickname;
    }

    public Usuario(String nickname, String nombre, String apellido, String contraseña, String correo, String foto_perfil, LocalDate fecha_naci) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.correo = correo;
        this.foto_perfil = foto_perfil;
        LocalDate fechaNacimiento = fecha_naci;
        this.fecha_nac = fechaNacimiento;
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

    public String getEmail() {
        return correo;
    }

    public LocalDate getNacimiento() {
        return fecha_nac;
    }
    
    public String getFoto() {
        return contraseña;
    }

    public void setFoto(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public String getContra() {
        return foto_perfil;
    }

    public void setContra(String nueva_foto) {
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

    public void setFechaNac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }


    public abstract void mostrarInformacion();
}
