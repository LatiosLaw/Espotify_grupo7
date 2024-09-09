package logica.dt;

public class DataTema {
    private String nickname;
    private Integer duracion;
    private DataAlbum album; 

    public DataTema(String nickname, Integer duracion) {
        this.nickname = nickname;
        this.duracion = duracion;
    }

    public DataTema(String nickname, Integer duracion, DataAlbum album) {
        this.nickname = nickname;
        this.duracion = duracion;
        this.album = album;
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