package logica;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import logica.dt.DT_IdTema;

@Entity
public class Registro_tema implements Serializable {

    @EmbeddedId
    private DT_IdTema identificador;
    private Integer reproducciones;
    private Integer favoritos;
    private Integer agregado_a_lista;
    private Integer descargas;
    
     public Registro_tema(){
        
    }
     
     public Registro_tema(String nombre_tema, String nombre_album) {
        this.identificador = new DT_IdTema();
        this.identificador.setNombreTema(nombre_tema);
        this.identificador.setNombreAlbumTema(nombre_album);
        this.reproducciones = 0;
        this.favoritos = 0;
        this.agregado_a_lista = 0;
        this.descargas = 0;
    }

    public String getNombre() {
        return identificador.getNombreTema();
    }
    
    public String getNombreAlbum() {
        return identificador.getNombreAlbumTema();
    }

    public void setNombreTema(String nombreTema) {
        this.identificador.setNombreTema(nombreTema);
    }
    
    public void setAlbumTema(String albumTema) {
        this.identificador.setNombreAlbumTema(albumTema);
    }
    
    public void sumarRepro() {
        this.reproducciones = getRepro() + 1;
    }
    
    public void restarRepro() {
        int repro = getRepro();
        if(repro<=0){
           this.reproducciones = getRepro();
        }else{
           this.reproducciones = getRepro() - 1; 
        }
    }
    
    public Integer getRepro() {
        return reproducciones;
    }

    public void setRepro(Integer reproducciones) {
        this.reproducciones = reproducciones;
    }
    
    public void sumarDescarga() {
        this.descargas = getDescarga() + 1;
    }
    
    public void restarDescarga() {
        int desc = getDescarga();
        if(desc<=0){
           this.descargas = getDescarga();
        }else{
           this.descargas = getDescarga() - 1; 
        }
    }
    
    public Integer getDescarga() {
        return descargas;
    }

    public void setDescarga(Integer descargas) {
        this.descargas = descargas;
    }
    
    public void sumarFavoritos() {
        this.favoritos = getFavoritos() + 1;
    }
    
    public void restarFavoritos() {
        int favo = getFavoritos();
        if(favo<=0){
           this.favoritos = getFavoritos();
        }else{
           this.favoritos = getFavoritos() - 1; 
        }
    }
    
    public Integer getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Integer favoritos) {
        this.favoritos = favoritos;
    }
    
    public void sumarListas() {
        this.agregado_a_lista = getListas() + 1;
    }
    
    public void restarListas() {
        int cant_lista = getListas();
        if(cant_lista<=0){
           this.agregado_a_lista = getListas();
        }else{
           this.agregado_a_lista = getListas() - 1; 
        }
    }
    
    public Integer getListas() {
        return agregado_a_lista;
    }
    
    public void setListas(Integer agregado_a_lista) {
        this.agregado_a_lista = agregado_a_lista;
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
        if (!(object instanceof Registro_tema)) {
            return false;
        }
        Registro_tema other = (Registro_tema) object;
        if ((this.identificador.getNombreTema() == null && other.identificador.getNombreTema() != null) || (this.identificador.getNombreTema() != null && !this.identificador.getNombreTema().equals(other.identificador.getNombreTema()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "logica.tema[ id=" + identificador.getNombreTema() + " ]";
    }

    public DT_IdTema getIdentificador() {
        return identificador;
    }

    public void setIdentificador(DT_IdTema identificador) {
        this.identificador = identificador;
    }
}
