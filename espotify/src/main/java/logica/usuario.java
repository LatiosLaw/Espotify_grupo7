package logica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
/**
 *
 * @author Law
 */
@Entity
public abstract class usuario implements Serializable {
    @Id
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected LocalDate fecha_nac;

    // Métodos comunes a todos los usuarios
    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return correo;
    }
    
    public LocalDate getNacimiento() {
        return fecha_nac;
    }
    
    public void setNickname(String nickname) {
    this.nickname = nickname;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setApellido(String apellido) {
    this.apellido = apellido;
}

public void setEmail(String correo) {
    this.correo = correo;
}

public void setNacimiento(LocalDate fecha_nac) {
    this.fecha_nac = fecha_nac;
}

    // Método abstracto para que las subclases implementen
    public abstract void mostrarInformacion();
}