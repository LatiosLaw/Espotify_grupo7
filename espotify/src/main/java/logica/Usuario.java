package logica;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author Law
 */
@Entity
public abstract class Usuario {
    @Id
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected LocalDate fecha_nac;
    
    public Usuario(){
    }

    public Usuario(String nickname, String nombre, String apellido, String correo, String fecha_naci) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        LocalDate fechaNacimiento = LocalDate.parse(fecha_naci, DateTimeFormatter.ISO_LOCAL_DATE);
        this.fecha_nac = fechaNacimiento;
    }

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

    // Método abstracto para que las subclases implementen
    public abstract void mostrarInformacion();
}