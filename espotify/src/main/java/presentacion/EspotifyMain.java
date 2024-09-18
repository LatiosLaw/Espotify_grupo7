package presentacion;

import logica.controladores.*;

public class EspotifyMain {

    public static void main(String[] args) {

        IControladorArtista artHandler = new ControladorArtista();
        IControladorCliente cliHandler = new ControladorCliente();
        IControladorAlbum albHandler = new ControladorAlbum();
        IControladorGenero genHandler = new ControladorGenero();
        IControladorListaPorDefecto listHandler = new ControladorListaPorDefecto();
        IControladorListaParticular listPHandler = new ControladorListaParticular();
        IControladorTema temHandler = new ControladorTema();

        FormPrin fp = new FormPrin(listPHandler, listHandler, cliHandler, artHandler, albHandler, genHandler, temHandler);
        fp.setVisible(true);
    }
}
