package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class AlbumEliminados implements Serializable {

    @Id
    private int id;
    private String nombre;
    private String imagen;
    private int anioCreacion;
    
    @ManyToOne
    private ArtistasEliminados creador;
    
    @ManyToMany(mappedBy = "albumes_del_generoEli", cascade = CascadeType.MERGE)
    private Collection<Genero> generos = new ArrayList<Genero>();
    
     @OneToMany(mappedBy = "albumEli")
    private Collection<temasEliminados> temasEli = new ArrayList<temasEliminados>();

    public AlbumEliminados(){
        
    }
    
    public AlbumEliminados(String nombre){
        this.nombre = nombre;
    }
    
    public AlbumEliminados(String nombre, int anioCreacion){
        this.nombre = nombre;
        this.anioCreacion = anioCreacion;
    }
    
    public AlbumEliminados(String nombre, String imagen, int anioCreacion, ArtistasEliminados artista){
        this.nombre = nombre;
        this.imagen = imagen;
        this.anioCreacion = anioCreacion;
        this.creador = artista;
    }
    
     public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getanioCreacion() {
        return anioCreacion;
    }

    public void setanioCreacion(int anio) {
        this.anioCreacion = anio;
    }
    
    public void setCreador(ArtistasEliminados artista) {
        this.creador = artista;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public String getImagen() {
        return imagen;
    }

    public ArtistasEliminados getCreador() {
        return creador;
    }
    
    public void agregarTema(temasEliminados t) {
        t.setAlbum(this);
        this.temasEli.add(t);
    }
    
    public void agregarGenero(Genero g) {
        this.generos.add(g);
    }
    
    public Collection<Genero> getGeneros(){
        return this.generos;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AlbumEliminados)) {
            return false;
        }
        AlbumEliminados other = (AlbumEliminados) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }
}
