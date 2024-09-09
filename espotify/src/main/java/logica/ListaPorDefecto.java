/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nico
 */
@Entity
public class ListaPorDefecto extends ListaReproduccion implements Serializable {

   private Genero genero;
   
   public ListaPorDefecto(){
   
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
