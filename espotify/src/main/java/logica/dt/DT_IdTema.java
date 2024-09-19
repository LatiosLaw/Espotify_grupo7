/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.dt;

import java.io.Serializable;

/**
 *
 * @author Law
 */

public class DT_IdTema implements Serializable {

    private String nombre_tema;
    private String nombre_album;
    
    public DT_IdTema(){
        
    }
    
    public DT_IdTema(String nombre_tema, String nombre_album){
        this.nombre_tema = nombre_tema;
        this.nombre_album = nombre_album;
    }
    
    public void setNombreTema(String nombre_tema){
        this.nombre_tema = nombre_tema;
    }
    
    public void setNombreAlbumTema(String nombre_album){
        this.nombre_album = nombre_album;
    }

    public String getNombreTema(){
        return nombre_tema;
    }
    
    public String getNombreAlbumTema(){
        return nombre_album;
    }
}
