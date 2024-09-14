/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Law
 */
@Entity
public class tema implements Serializable {

    @Id
    private String nickname;
    private String metodo_de_acceso;
    private Integer duracion;
    private Integer posicion_album;
    
    @ManyToOne
    @JoinColumn(name = "ALBUM_NOMBRE")
    private Album album;
    
     public tema(){
        
    }
    
    public tema(String nickname, Integer duracion) {
        this.nickname = nickname;
        this.duracion = duracion;
    }
    
    public tema(String nickname, Integer duracion, String metodo_de_acceso) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.metodo_de_acceso = metodo_de_acceso;
    }
    
    public tema(String nickname, Integer duracion, Integer posicion, String metodo_de_acceso) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.posicion_album = posicion;
        this.metodo_de_acceso = metodo_de_acceso;
    }
    
    public tema(String nickname, Integer duracion, Integer posicion_album) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.posicion_album = posicion_album;
    }

    public String getNickname() {
        return nickname;
    }

    public void setId(String id) {
        this.nickname = id;
    }
    
    public Integer getPos() {
        return posicion_album;
    }

    public void setPos(Integer posicion) {
        this.posicion_album = posicion;
    }
    
    public void setAcceso(String metodo_de_acceso) {
        this.metodo_de_acceso = metodo_de_acceso;
    }
    
    public String getAcceso() {
        return metodo_de_acceso;
    }
    
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tema)) {
            return false;
        }
        tema other = (tema) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.tema[ id=" + nickname + " ]";
    }
    
}
