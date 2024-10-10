/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.dt;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DT_IdLista implements Serializable {

    @Column(length = 100)
    private String nombre_lista;
    @Column(length = 100)
    private String nombre_cliente;
    
    public DT_IdLista(){
        
    }
    
    public DT_IdLista(String nombre_lista, String nombre_cliente){
        this.nombre_lista = nombre_lista;
        this.nombre_cliente = nombre_cliente;
    }
    
    public void setNombre_lista(String nombre_lista){
        this.nombre_lista = nombre_lista;
    }
    
    public void setNombre_cliente(String nombre_album){
        this.nombre_cliente = nombre_album;
    }

    public String getNombre_lista(){
        return nombre_lista;
    }
    
    public String getNombre_cliente(){
        return nombre_cliente;
    }
}
