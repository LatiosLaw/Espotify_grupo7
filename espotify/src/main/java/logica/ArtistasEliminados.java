/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Urbina
 */
@Entity
public class ArtistasEliminados implements Serializable {
    
    @Id
    protected int id;
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected String contraseña;
    protected String foto_perfil;
    protected LocalDate fecha_nac;
    //Cosas de artista 
    private String biografia;
    private String dirWeb;
    private LocalDate fechaEli;
    
     @OneToMany(mappedBy = "creador")
    private Collection<AlbumEliminados> albumes = new ArrayList<AlbumEliminados>();
    
    public ArtistasEliminados(){
        
    }
    public ArtistasEliminados(String nick, String nombre, String apellido, String correo, String contra, LocalDate fechaNaci,
            String bio, String dirWeb){
        nickname = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        contraseña = contra;
        fecha_nac = fechaNaci;
        //Cosas de artista 
        biografia = bio;
        this.dirWeb = dirWeb;

    }
    
     public String getNickname() {
        return nickname;
    }
     public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    } 
      public LocalDate getFechaEli() {
        return fechaEli;
    }
    public void setFechaEli(LocalDate fecha){
        this.fechaEli = fecha;
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
        return foto_perfil;
    }

    public void setFoto(String coso) {
        this.foto_perfil = coso;
    }
    
    public String getContra() {
        return foto_perfil;
    }

    public void setContra(String coso) {
        this.contraseña = coso;
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

      public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getDirWeb() {
        return dirWeb;
    }

    public void setDirWeb(String dirWeb) {
        this.dirWeb = dirWeb;
    }

}
