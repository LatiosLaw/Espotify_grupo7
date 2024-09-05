package logica.factory;

import logica.controladores.ControladorAlbum;
import logica.controladores.ControladorArtista;
import logica.controladores.ControladorCliente;
import logica.controladores.ControladorGenero;
import logica.controladores.ControladorListaParticular;
import logica.controladores.ControladorListaPorDefecto;
import logica.controladores.ControladorTema;
import logica.controladores.IControladorAlbum;
import logica.controladores.IControladorArtista;
import logica.controladores.IControladorCliente;
import logica.controladores.IControladorGenero;
import logica.controladores.IControladorListaParticular;
import logica.controladores.IControladorListaPorDefecto;
import logica.controladores.IControladorTema;

/**
 * Fábrica para la construcción de un controlador de usuarios (uno distinto para cada invocación).
 * Se implementa en base al patrón Singleton.
 * @author TProg2017
 *
 */
public class Fabrica {

    private static Fabrica instancia;

    private Fabrica() {
    };

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorArtista getIControladorArtista() {
        return new ControladorArtista();
    }

    public IControladorCliente getIControladorCliente() {
        return new ControladorCliente();
    }

    public IControladorAlbum getIControladorAlbum() {
        return new ControladorAlbum();
    }

    public IControladorGenero getIControladorGenero() {
        return new ControladorGenero();
    }

    public IControladorListaParticular getIControladorListaParticular() {
        return new ControladorListaParticular();
    }

    public IControladorListaPorDefecto getIControladorListaPorDefecto() {
        return new ControladorListaPorDefecto();
    }

    public IControladorTema getIControladorTema() {
        return new ControladorTema();
    }

}
