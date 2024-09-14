/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import java.time.LocalDate;
import java.util.Collection;
import logica.dt.DataArtista;

/**
 *
 * @author Nico
 */
public interface IControladorArtista {
    public DataArtista retornarArtista(String nickname);
    public void agregarArtista(String nickname, String nombre, String apellido, String mail, String foto, LocalDate fechaNac, String biografia, String dirWeb);
    public Collection<DataArtista> mostrarArtistas();
    public int obtenerNumeroSeguidores(String nick);
        public Collection<String> obtenerSeguidoresArt(String nick);
        public Collection<String> obtenerAlbumsArt(String nick);

}
