package logica.dt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class DataArtista extends DataUsuario {

    private String biografia;
    private String dirWeb;
    private Collection<DataAlbum> albumes;

    public DataArtista() {

    }

    public DataArtista(String nickname, String nombre, String apellido, String contraseña, String correo, String foto_perfil, LocalDate fechaNac, String biografia, String dirWeb) {
        super(nickname, nombre, apellido, contraseña, correo, foto_perfil, fechaNac);
        this.biografia = biografia;
        this.dirWeb = dirWeb;
        this.albumes = new ArrayList<>();
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

    public Collection<DataAlbum> getAlbumes() {
        return albumes;
    }

    public void agregarAlbum(DataAlbum album) {
        this.albumes.add(album);
    }
}
