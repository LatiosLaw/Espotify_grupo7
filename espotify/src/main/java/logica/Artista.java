package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Artista extends Usuario {

    @Column(length = 1024)  // Cambiar la longitud del campo
    private String biografia;
    private String dirWeb;
    @OneToMany(mappedBy = "creador")
    private Collection<Album> albumes = new ArrayList<Album>();

    public Artista() {

    }

    public Artista(String nickname) {
        super(nickname);
    }

    public Artista(String nickname, String nombre, String apellido, String email, String foto_perfil, LocalDate fecha_naci, String biografia, String dirWeb) {
        super(nickname, nombre, apellido, email, foto_perfil, fecha_naci);
        this.biografia = biografia;
        this.dirWeb = dirWeb;
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

    @Override
    public void mostrarInformacion() {
        System.out.println("Artista: " + getNombre() + " " + getApellido() + ". Biografía: " + biografia);
    }
}
