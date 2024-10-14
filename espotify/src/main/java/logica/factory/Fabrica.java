package logica.factory;

import logica.controladores.*;

public class Fabrica {

    private static Fabrica instancia;

    private Fabrica() {
    }

    ;

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
    public IControladorSuscripcion getIControladorSuscripcion() {
        return new ControladorSuscripcion();
    }
    
    
}
