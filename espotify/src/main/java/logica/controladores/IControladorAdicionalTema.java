package logica.controladores;

public interface IControladorAdicionalTema {

    public void crearRegistroTema(String nombre_tema, String nombre_album_tema);
     
     public void incrementarInfoReproduccion(String nombre_tema, String nombre_album);
     
     public void incrementarInfoAgregadoALista(String nombre_tema, String nombre_album);
     
     public void incrementarInfoFavorito(String nombre_tema, String nombre_album);
     
     public void reducirInfoReproduccion(String nombre_tema, String nombre_album);
     
     public void reducirInfoAgregadoALista(String nombre_tema, String nombre_album);
     
     public void reducirInfoFavorito(String nombre_tema, String nombre_album);
}
