package presentacion;

import java.time.LocalDate;
import java.util.Collection;

import logica.controladores.IControladorAlbum;
import logica.controladores.IControladorArtista;
import logica.controladores.IControladorCliente;
import logica.controladores.IControladorGenero;
import logica.controladores.IControladorListaParticular;
import logica.controladores.IControladorListaPorDefecto;
import logica.controladores.IControladorSuscripcion;
import logica.controladores.IControladorTema;

import logica.factory.Fabrica;
import java.util.Scanner;
import logica.dt.DataCliente;


public class EspotifyMain {
     private static IControladorAlbum controlAlb;
     private static IControladorGenero controlGen;
     private static IControladorCliente controlCli;
     private static IControladorArtista controlArt;
     private static IControladorTema controlTem;
     private static IControladorListaParticular controlListPar;
     private static IControladorListaPorDefecto controlListPD;
     private static IControladorSuscripcion controlSus;
    public static void main(String[] args) {
        
        cargarControladores();
        crearPoggers();
        boolean token = true;
        while(token == true){
            System.out.println("------------------------------------------------");
            System.out.println("Bienvenido a el menu no grafico");
             System.out.println("1-Crear Cliente");
             System.out.println("2-Crear Artista");
             System.out.println("3-Listar Usuarios");
             System.out.println("4-Listar Clientes");
             System.out.println("5-Listar Artistas");
             System.out.println("6-Mostrar datos de cliente");
             System.out.println("7-Salir del coso feo este");
             
             Scanner s = new Scanner(System.in);
             
             int token2 = s.nextInt();
             switch (token2) {
                 
                 case 1 ->{
                     s.nextLine();
                      System.out.println("//Ingresar Clientes//");
                     System.out.println("Ingrese nombre del usuario nuevo");
                     String nombre = s.nextLine();
                     System.out.println("Ingrese nick del usuario nuevo");
                     String nickname = s.nextLine();
                     System.out.println("Ingrese apellido del usuario nuevo");
                     String apellido = s.nextLine();
                     System.out.println("Ingrese contra del usuario nuevo");
                     String contra = s.nextLine();
                     System.out.println("Ingrese mail del usuario nuevo");
                     String mail = s.nextLine();

                     controlCli.agregarCliente(nickname, nombre, apellido, contra, mail, "poto", LocalDate.now());
                 }
                 case 2 ->{
                     s.nextLine();
                             
                      System.out.println("//Ingresar Artistas//");
                     System.out.println("Ingrese nombre del usuario nuevo");
                     String nombre = s.nextLine();
                     System.out.println("Ingrese nick del usuario nuevo");
                     String nickname = s.nextLine();
                     System.out.println("Ingrese apellido del usuario nuevo");
                     String apellido = s.nextLine();
                     System.out.println("Ingrese contra del usuario nuevo");
                     String contra = s.nextLine();
                     System.out.println("Ingrese mail del usuario nuevo");
                     String mail = s.nextLine();
                     
                     System.out.println("Ingrese descripcion del usuario nuevo");
                     String bio = s.nextLine();
                     System.out.println("Ingrese dirweb del usuario nuevo");
                     String dirweb = s.nextLine();
                     
                     
                     controlArt.agregarArtista(nickname, nombre, apellido, contra, mail, "poto", LocalDate.MIN, bio, dirweb );
                 }
                 case 3 ->{
                     s.nextLine();
                 }
                 case 4 ->{
                     s.nextLine();
                     System.out.println("//Listar Clientes//");
                     Collection <String> cole = controlCli.mostrarUsuarios();
                     int tokenInt = 0;
                     for(String cosa:cole){
                         tokenInt ++;
                         System.out.println(tokenInt + "-" + cosa);
                     }
                     
                     
                 }
                 case 5 ->{
                    // s.nextLine();
                     System.out.println("//Listar Artistas//");
                     Collection <String> cole = controlArt.mostrarNicksArtistas();
                     int tokenInt = 0;
                     for(String cosa:cole){
                         tokenInt ++;
                         System.out.println(tokenInt + "-" + cosa);
                     }
                 }
                 case 6 ->{
                     s.nextLine();
                     System.out.println("Ingrese nombre del Cliente");
                     String nick_cli = s.nextLine();
                     
                     
                     DataCliente cliente = controlCli.consultarPerfilCliente(nick_cli);
                     
                     if(cliente == null){
                         System.out.println("No existe cliente con ese nick");
                     }else{
                         System.out.println("nick: " + cliente.getNickname());
                         System.out.println("nombre: " + cliente.getNombre());
                         System.out.println("apelloido: " + cliente.getApellido());
                         System.out.println("contra: " + cliente.getContra());
                         System.out.println("mail: " + cliente.getCorreo()); 
                     }
                     
                     
                 }
                 case 7 ->{
                     token = false;
                 }
                 default ->{
                      System.out.println("Defoault momento.");
                 }
                 
             }
             
             
             
             
        }
        
        
    
    }

    private static void cargarControladores() {
        Fabrica factory = Fabrica.getInstance();
        controlCli = factory.getIControladorCliente();
        controlArt = factory.getIControladorArtista();
        controlAlb = factory.getIControladorAlbum();
        controlGen = factory.getIControladorGenero();
        controlTem = factory.getIControladorTema();
        controlListPD = factory.getIControladorListaPorDefecto();
        controlListPar = factory.getIControladorListaParticular();
        controlSus = factory.getIControladorSuscripcion();
    }
    
    
    private static void crearPoggers(){
        
        controlCli.inicializarBaseDeDatos();
        
        
    }
    
    
    
}
