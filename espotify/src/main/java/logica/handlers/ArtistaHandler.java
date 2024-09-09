/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import javax.persistence.PersistenceException;
import logica.Artista;
import logica.Usuario;
import persistencia.DAO_Usuario;

/**
 *
 * @author Nico
 */
public class ArtistaHandler implements IArtistaHandler{
    @Override
    public Artista retornarArtista(String nickname){
        Usuario retorno;
        DAO_Usuario persistence = new DAO_Usuario();
        retorno = persistence.findUsuarioByNick(nickname);
         if (retorno instanceof Artista) {
            return (Artista) retorno; // Casting dinámico
        } else {
            throw new IllegalArgumentException("El usuario con nickname " + nickname + " no es un Artista.");
        }
    }
    
    @Override
    public void agregarArtista(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac, String biografia, String dirWeb) {
        // Verificar que el nickname y el mail no esten en uso
        DAO_Usuario persistence = new DAO_Usuario();

        if (persistence.findUsuarioByNick(nickname) != null) {
            System.out.println("El nickname: " + nickname + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        if (persistence.findUsuarioByMail(mail) != null) {
            System.out.println("El correo electronico: " + mail + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        // Crear el nuevo artista
        Artista nuevoArtista = new Artista(nickname, nombre, apellido, mail, fechaNac, biografia, dirWeb);

        // Guardar el artista en la base de datos
        try {
            persistence.save(nuevoArtista);
            System.out.println("Artista agregado exitosamente.");
        } catch (PersistenceException e) {
            System.out.println("Error al guardar el artista: " + e.getMessage());
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
        }
    }
}

 /*else if (persistence.findUsuarioByNick(mail) != null) {
        throw new IllegalArgumentException("El mail ya está en uso.");
        }*/