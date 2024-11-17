package logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import logica.dt.DT_IdTema;

@Entity
public class temasEliminados implements Serializable {
    
    @Id
    private int id;
    private String nombreTema;
    private String nombreAlbum;
    @Column(name = "METODO_DE_ACCESO", length = 255)
    private String metodo_de_acceso;
    private String identificador_archivo;
    private Integer duracion;
    private Integer posicion_album;
    
    @ManyToOne
    private AlbumEliminados albumEli;

     public temasEliminados(){
        
    }
     
     public temasEliminados(String nickname, String nombre_album) {
        this.nombreTema=nickname;
        this.nombreAlbum=nombre_album;
    }
     
     public temasEliminados(String nickname, String nombre_album, Integer duracion) {
       this.nombreTema=nickname;
        this.nombreAlbum=nombre_album;
        this.duracion = duracion;
    }
    
    public temasEliminados(String nickname, Integer duracion) {
        this.nombreTema=nickname;
        this.nombreAlbum="none";
        this.duracion = duracion;
    }
    
    public temasEliminados(String nickname, Integer duracion, String metodo_de_acceso, String archivo) {
        this.nombreTema=nickname;
        this.nombreAlbum="none";
        this.duracion = duracion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
    }
    
    public temasEliminados(String nickname, String nombre_album, Integer duracion, Integer posicion, String metodo_de_acceso, String archivo) {
        this.nombreTema=nickname;
        this.nombreAlbum=nombre_album;
        this.duracion = duracion;
        this.posicion_album = posicion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
    }
    
    public temasEliminados(String nickname, String nombre_album, Integer duracion, String metodo_de_acceso, String archivo) {
        this.nombreTema=nickname;
        this.nombreAlbum=nombre_album;
        this.duracion = duracion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
    }
  
    public temasEliminados(String nickname, String nombre_album, Integer duracion, String metodo_de_acceso, String archivo, Integer posicion, AlbumEliminados album) {
       this.nombreTema=nickname;
        this.nombreAlbum=nombre_album;
        this.duracion = duracion;
        this.posicion_album = posicion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
        this.albumEli = album;
    }
    
    public temasEliminados(String nickname, String nombre_album, Integer duracion, String metodo_de_acceso, String archivo, Integer posicion) {
        this.nombreTema=nickname;
        this.nombreAlbum=nombre_album;
        this.duracion = duracion;
        this.posicion_album = posicion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNickname() {
        return this.nombreTema;
    }
    
    public String getNombreAlbum() {
        return this.nombreAlbum;
    }

    public void setNombreTema(String id) {
        this.nombreTema = id;
    }
    
    public void setNombreAlbum(String id) {
        this.nombreAlbum = id;
    }
    
    public Integer getPos() {
        return posicion_album;
    }

    public void setPos(Integer posicion) {
        this.posicion_album = posicion;
    }
    
    public String getArchivo() {
        return identificador_archivo;
    }

    public void setArchivo(String archivo) {
        this.identificador_archivo = archivo;
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
    
    public AlbumEliminados getAlbum() {
        return albumEli;
    }

    public void setAlbum(AlbumEliminados album) {
        this.albumEli = album;
    }

    
}
