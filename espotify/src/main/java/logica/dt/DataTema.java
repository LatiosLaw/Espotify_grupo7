package logica.dt;

public class DataTema {

    private String nickname;
    private String nombre_album;
    private Integer posicion_album;
    private Integer duracion;
    private DataAlbum album;
    private String identificador_archivo;
    private String metodo_de_acceso;

    public DataTema(String nickname, String nombre_album, Integer duracion, Integer posicion, String metodo_de_acceso) {
        this.nickname = nickname;
        this.nombre_album = nombre_album;
        this.duracion = duracion;
        this.posicion_album = posicion_album;
        this.metodo_de_acceso = metodo_de_acceso;
    }

    public DataTema(String nickname, String nombre_album, Integer duracion) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.nombre_album = nombre_album;
    }
    
    public DataTema(String nickname, String nombre_album, Integer duracion, String archivo) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.nombre_album = nombre_album;
        this.identificador_archivo = archivo;
    }
    
    public DataTema(String nickname, String nombre_album, Integer duracion, String archivo, String acceso) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.nombre_album = nombre_album;
        this.identificador_archivo = archivo;
        this.metodo_de_acceso = acceso;
    }

    public DataTema(String nickname, Integer duracion, DataAlbum album) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.album = album;
    }

    public DataTema(String nickname, String nombre_album, Integer duracion, DataAlbum album, Integer posicion_album) {
        this.nickname = nickname;
        this.nombre_album = nombre_album;
        this.duracion = duracion;
        this.album = album;
        this.posicion_album = posicion_album;
    }

    public DataTema() {
        this.setNickname(new String());
        this.setNomAlb(null);
        this.setDuracion(null);
        //this.album = new DataAlbum();
    }

    public DataTema(String nickname, String nombre_album, Integer duracion, DataAlbum dataAlbum, String acceso, String archivo) {
        this.nickname = nickname;
        this.nombre_album = nombre_album;
        this.duracion = duracion;
        this.album = dataAlbum;
        this.metodo_de_acceso = acceso;
        this.identificador_archivo = archivo;
    }
    
    public DataTema(String nickname, String nombre_album, Integer duracion, DataAlbum dataAlbum, String acceso, String archivo, Integer posic) {
        this.nickname = nickname;
        this.nombre_album = nombre_album;
        this.duracion = duracion;
        this.album = dataAlbum;
        this.metodo_de_acceso = acceso;
        this.identificador_archivo = archivo;
        this.posicion_album = posic;
    }
    
    public DataTema(String nickname, String nombre_album) {
        this.nickname = nickname;
        this.nombre_album = nombre_album;
    }
    
    public String getNomAlb() {
        return nombre_album;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public DataAlbum getAlbum() {
        return album;
    }

    public Integer getPos() {
        return posicion_album;
    }

    public void setPos(Integer posicion) {
        this.posicion_album = posicion;
    }
    
    public void setNomAlb(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public String getAccess() {
        return metodo_de_acceso;
    }
    
    public String getArchivo() {
        return identificador_archivo;
    }

    public void setArchivo(String archivo) {
        this.identificador_archivo = archivo;
    }

    public void setAccess(String metodo_de_acceso) {
        this.metodo_de_acceso = metodo_de_acceso;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setAlbum(DataAlbum album) {
        this.album = album;
    }
}
