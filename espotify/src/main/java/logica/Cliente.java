package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cliente extends Usuario {
    
    @OneToOne(mappedBy = "cli", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Suscripcion sus;
  
    @ManyToMany
    @JoinTable(name = "seguidos",
            joinColumns = @JoinColumn(name = "nick_seguidor"), // El que sigue
            inverseJoinColumns = @JoinColumn(name = "nick_seguido")) // El que es seguido
    protected Collection<Usuario> seguidos = new ArrayList<Usuario>();
    @ManyToMany
    @JoinTable(name = "temas_favoritos",
            joinColumns = @JoinColumn(name = "nick_cliente"),
            inverseJoinColumns = {
            @JoinColumn(name = "nombre_tema", referencedColumnName = "nombre_tema"),  // Referencia a TemaId.campo1
            @JoinColumn(name = "nombre_album", referencedColumnName = "nombre_album")   // Referencia a TemaId.campo2
        })
    protected Collection<tema> temas_favoritos = new ArrayList<tema>();
    @ManyToMany
    @JoinTable(name = "albumes_favoritos",
            joinColumns = @JoinColumn(name = "nick_cliente"),
            inverseJoinColumns = @JoinColumn(name = "nombre_album"))
    protected Collection<Album> albumes_favoritos = new ArrayList<Album>();
    @ManyToMany
    @JoinTable(name = "listas_favoritas",
            joinColumns = @JoinColumn(name = "nick_cliente"),
            inverseJoinColumns = {
                @JoinColumn(name = "nombre_lista", referencedColumnName = "nombre_lista"),
                 @JoinColumn(name = "nombre_cliente", referencedColumnName = "nombre_cliente")
            }
    )
    protected Collection<ListaReproduccion> listas_favoritas = new ArrayList<ListaReproduccion>();

    @OneToMany(mappedBy = "creador")
    protected Collection<ListaParticular> listasReproduccion = new ArrayList<>();

    public Cliente() {

    }

    public Cliente(String nickname, String nombre, String apellido, String contraseña, String email, String foto_perfil, LocalDate fecha_naci) {
        super(nickname, nombre, apellido, contraseña, email, foto_perfil, fecha_naci);
    }

    
    public void seguir(Usuario usuario) {
        this.seguidos.add(usuario);
    }
    
    public void dejarDeSeguir(Usuario usuario) {
        this.seguidos.remove(usuario);
    }
    
    public void temaFav(tema tema) {
        this.temas_favoritos.add(tema);
    }
    
    public void albumFav(Album album) {
        this.albumes_favoritos.add(album);
    }
    
    public void listasFav(ListaReproduccion lista) {
        if(lista instanceof ListaParticular listaParticular){
            System.out.println("La visibilidad de la lista: " + lista.getNombreLista() + " es: " + listaParticular.getVisibilidad());
            if(listaParticular.getVisibilidad()==true){
                this.listas_favoritas.add(lista);
            }else{
                System.out.println("Esta lista particular es privada.");
            }
        }else{
            this.listas_favoritas.add(lista);
        }
    }
    
    public void quitarTemaFav(tema tema) {
        this.temas_favoritos.remove(tema);
    }
    
    public void quitarAlbumFav(Album album) {
        this.albumes_favoritos.remove(album);
    }
    
    public void quitarListasFav(ListaReproduccion lista) {
        this.listas_favoritas.remove(lista);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " " + apellido);
    }
}
