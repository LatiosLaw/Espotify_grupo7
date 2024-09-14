/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import logica.dt.DataAlbum;
import logica.dt.DataTema;

/**
 *
 * @author Nico
 */
public interface IControladorTema {
    public boolean crearTemaDefault(String nombre_tema, int duracion, String metodo_de_acceso);
    public DataTema retornarTema(String nickname);
    public void actualizarTema(DataTema tema, DataAlbum album);
    public void BorrarTema(String nombre_tema);
}
