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
public class Artista extends Usuario {

    @Id
    private String biografia;
    private String dirWeb;

    // Constructor por defecto
    public Artista() {
        // Constructor vacío necesario para JPA
    }

    public Artista(String nickname, String nombre, String apellido, String email, String fecha_naci, String biografia, String dirWeb) {
        super(nickname, nombre, apellido, email, fecha_naci);
        this.biografia = biografia;
        this.dirWeb = dirWeb;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getDirWeb() {
        return dirWeb;
    }

    public void setDirWeb(String dirWeb) {
        this.dirWeb = dirWeb;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Artista: " + getNombre() + " " + getApellido() + ". Biografía: " + biografia);
    }
}