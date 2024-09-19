package logica;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import logica.dt.DT_IdTema;

@Entity
public class tema implements Serializable {

    @Id
    private DT_IdTema identificador;
    private String metodo_de_acceso;
    private String identificador_archivo;
    private Integer duracion;
    private Integer posicion_album;
    
    @ManyToOne
    @JoinColumn(name = "ALBUM_NOMBRE")
    private Album album;
    
    @ManyToMany(mappedBy = "temas")
    private Collection<ListaReproduccion> listas;
    
     public tema(){
        
    }
     
     public tema(String nickname, String nombre_album) {
        this.identificador = new DT_IdTema();
        this.identificador.setNombreTema(nickname);
        this.identificador.setNombreAlbumTema(nombre_album);
    }
    
    public tema(String nickname, Integer duracion) {
        this.identificador = new DT_IdTema();
        this.identificador.setNombreTema(nickname);
        this.identificador.setNombreAlbumTema(null);
        this.duracion = duracion;
    }
    
    public tema(String nickname, Integer duracion, String metodo_de_acceso, String archivo) {
        this.identificador = new DT_IdTema();
        this.identificador.setNombreTema(nickname);
        this.identificador.setNombreAlbumTema(null);
        this.duracion = duracion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
    }
    
    public tema(String nickname, Integer duracion, Integer posicion, String metodo_de_acceso, String archivo) {
        this.identificador = new DT_IdTema();
        this.identificador.setNombreTema(nickname);
        this.identificador.setNombreAlbumTema(null);
        this.duracion = duracion;
        this.posicion_album = posicion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
    }
    
    public tema(String nickname, Integer duracion, String metodo_de_acceso, String archivo, Integer posicion, Album album) {
        this.identificador = new DT_IdTema();
        this.identificador.setNombreTema(nickname);
        this.identificador.setNombreAlbumTema(album.getNombre());
        this.duracion = duracion;
        this.posicion_album = posicion;
        this.metodo_de_acceso = metodo_de_acceso;
        this.identificador_archivo = archivo;
        this.album = album;
    }

    public String getNickname() {
        return identificador.getNombreTema();
    }

    public void setId(String id) {
        this.identificador.setNombreTema(id);
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
    
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador.getNombreTema() != null ? identificador.getNombreTema().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof tema)) {
            return false;
        }
        tema other = (tema) object;
        if ((this.identificador.getNombreTema() == null && other.identificador.getNombreTema() != null) || (this.identificador.getNombreTema() != null && !this.identificador.getNombreTema().equals(other.identificador.getNombreTema()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.tema[ id=" + identificador.getNombreTema() + " ]";
    }
}
