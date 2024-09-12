package logica.dt;

public class DataTema {
    private String nickname;
    private Integer posicion_album;
    private Integer duracion;
    private DataAlbum album; 
    
    public DataTema(String nickname, Integer duracion, Integer posicion) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.posicion_album = posicion_album;
    }
    
    public DataTema(String nickname, Integer duracion) {
        this.nickname = nickname;
        this.duracion = duracion;
    }

    public DataTema(String nickname, Integer duracion, DataAlbum album) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.album = album;
    }
    
    public DataTema(String nickname, Integer duracion, DataAlbum album, Integer posicion_album) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.album = album;
        this.posicion_album = posicion_album;
    }

    public DataTema(){
        this.setNickname(new String());
        this.setDuracion(null);
        this.album = new DataAlbum();
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