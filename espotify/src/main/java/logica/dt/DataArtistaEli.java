package logica.dt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class DataArtistaEli extends DataUsuario {

    private int id;
    private String biografia;
    private String dirWeb;
    private Collection<DataAlbum> albumes;
    private LocalDate fehcaEli;

    public DataArtistaEli() {

    }

    public DataArtistaEli(String nickname, String nombre, String apellido, String contraseña, String correo, String foto_perfil, LocalDate fechaNac, String biografia, String dirWeb, LocalDate fecha) {
        super(nickname, nombre, apellido, contraseña, correo, foto_perfil, fechaNac);
        this.biografia = biografia;
        this.dirWeb = dirWeb;
        this.albumes = new ArrayList<>();
        this.fehcaEli = fecha;
    }
    
    public DataArtistaEli(String nickname) {
        super(nickname);
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
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public LocalDate GetFehcaEli(){
        return this.fehcaEli;
    }
    public void setFehcaEli(LocalDate fecha){
        this.fehcaEli = fecha;
    }
    
}
