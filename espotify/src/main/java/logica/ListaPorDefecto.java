/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Nico
 */
@Entity
public class ListaPorDefecto extends ListaReproduccion implements Serializable {
   @ManyToOne(cascade = CascadeType.PERSIST)
   private Genero genero;
   
   public ListaPorDefecto(){
   
   }
   
   public ListaPorDefecto(String nombre){
       super(nombre);
   }
   
   public ListaPorDefecto(String nombre, Genero g){
       super(nombre);
       this.genero = g;
   }
   
   public Genero getGenero(){
       return this.genero;
   }
   
   public void setGenero(Genero g){
       this.genero = g;
   }
    
}
