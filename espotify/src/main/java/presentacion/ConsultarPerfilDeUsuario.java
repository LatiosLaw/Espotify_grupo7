/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import static java.lang.String.valueOf;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import logica.Usuario;
import logica.dt.DataCliente;
import logica.dt.DataArtista;
import logica.controladores.IControladorCliente;
import logica.controladores.IControladorArtista;
import logica.dt.DataUsuario;

/**
 *
 * @author Urbina
 */
public class ConsultarPerfilDeUsuario extends javax.swing.JPanel {

    /**
     * Creates new form ConsultarPerfilDeUsuario
     */
    private IControladorCliente controlCli;
    private IControladorArtista controlArt;
    private JComboBox<DataUsuario> comboBoxUsuarios;
    private JList<DataUsuario> listUsuarios;

    public ConsultarPerfilDeUsuario(IControladorCliente icc, IControladorArtista ica) {

        controlCli = icc;
        controlArt = ica;

        initComponents();
        //lstUsuarios = new javax.swing.JList<DataUsuario>();

        txtPaginaWeb.setVisible(false);
        txtaBiografia.setVisible(false);
        lstListas.setVisible(false);
        lstSeguidores.setVisible(false);
        lblNroSeguidores.setVisible(false);
        lblSeguidores.setVisible(false);
        txtNumeroDeSeguidoresPosta.setVisible(false);
        lblAlbumSiguiendo.setVisible(false);
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        txtNickName = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreoElectronico = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtFechaNaci1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaBiografia = new javax.swing.JTextArea();
        txtPaginaWeb = new javax.swing.JTextField();
        lblSeguidores = new javax.swing.JLabel();
        lblAlbumSiguiendo = new javax.swing.JLabel();
        lblNroSeguidores = new javax.swing.JLabel();
        txtNumeroDeSeguidoresPosta = new javax.swing.JLabel();
        cbxOpt = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstSeguidores = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstListas = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        txtBuscar = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstAlbumSiguiendo1 = new javax.swing.JList<>();
        lblListas = new javax.swing.JLabel();
        lblFavs = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        lstFavs = new javax.swing.JList<>();
        cbxFavss = new javax.swing.JComboBox<>();
        lblSeguidores1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(860, 471));

        panel1.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        txtNickName.setEditable(false);

        txtApellido.setEditable(false);

        txtCorreoElectronico.setEditable(false);
        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });

        txtNombre.setEditable(false);

        txtFechaNaci1.setEditable(false);

        txtaBiografia.setColumns(20);
        txtaBiografia.setRows(5);
        jScrollPane2.setViewportView(txtaBiografia);

        txtPaginaWeb.setEditable(false);

        lblSeguidores.setText("Seguidores ");

        lblAlbumSiguiendo.setText("Albumes");

        lblNroSeguidores.setText("Numero de Seguidores:");

        txtNumeroDeSeguidoresPosta.setText("0");

        cbxOpt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPT", "Cliente", "Artista" }));
        cbxOpt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxOptItemStateChanged(evt);
            }
        });
        cbxOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOptActionPerformed(evt);
            }
        });

        lstSeguidores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(lstSeguidores);

        lstListas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(lstListas);

        lstUsuarios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Larry", "Capaja", "El", "Hombre", "Que ", "No ", "Te", "Engaña" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(lstUsuarios);

        txtBuscar.setColumns(10);

        btnOK.setText("Buscar");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        lstAlbumSiguiendo1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(lstAlbumSiguiendo1);

        lblListas.setText("Listas");

        lblFavs.setText("Favs");

        lstFavs.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(lstFavs);

        cbxFavss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temas", "Albums", "Listas" }));
        cbxFavss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFavssActionPerformed(evt);
            }
        });

        lblSeguidores1.setText("Usuario Seleccionado : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSeguidores1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNroSeguidores)
                            .addComponent(lblSeguidores)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblListas)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAlbumSiguiendo))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFavs)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbxFavss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtNumeroDeSeguidoresPosta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtNickName)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido)
                                    .addComponent(txtFechaNaci1))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroDeSeguidoresPosta)
                    .addComponent(lblNroSeguidores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSeguidores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(697, 697, 697))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cbxOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(txtFechaNaci1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblSeguidores1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblFavs)
                                        .addGap(6, 6, 6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cbxFavss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAlbumSiguiendo)
                                    .addComponent(lblListas))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(697, 697, 697))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxOptItemStateChanged

    }//GEN-LAST:event_cbxOptItemStateChanged
    private void lenarLista(List<Usuario> lista) {

        //lstUsuarios.add("a");
    }

    private void cbxOptActionPerformed(java.awt.event.ActionEvent evt) {

        int token = cbxOpt.getSelectedIndex();

        switch (token) {
            case 0 -> {// OPT
                limpiarCampos();
                break;
            }

            case 1 -> {
                // Cliente
                limpiarCampos();
                lblAlbumSiguiendo.setText("Siguiendo");
                Collection<DataCliente> cole = controlCli.mostrarClientes();
                cargarUsuariosLstBuscar(cole);
                txtPaginaWeb.setVisible(false);
                txtaBiografia.setVisible(false);
                lstListas.setVisible(true);
                lstSeguidores.setVisible(true);
                lblNroSeguidores.setVisible(true);
                lblSeguidores.setVisible(true);
                txtNumeroDeSeguidoresPosta.setVisible(true);
                lblAlbumSiguiendo.setVisible(true);
                cbxFavss.setVisible(true);
                lblFavs.setVisible(true);
                lstListas.setVisible(true);
                lblListas.setVisible(true);
                lstFavs.setVisible(true);
                break;
            }
            case 2 -> {
                // Artista
                
                Collection<DataArtista> cole = controlArt.mostrarArtistas();
                cargarArtistasLstBuscar(cole);
                
                 lblAlbumSiguiendo.setText("Album");
                limpiarCampos();
                txtPaginaWeb.setVisible(true);
                txtaBiografia.setVisible(true);
                lstListas.setVisible(true);
                lstSeguidores.setVisible(true);
                lblNroSeguidores.setVisible(true);
                lblSeguidores.setVisible(true);
                txtNumeroDeSeguidoresPosta.setVisible(true);
                lblAlbumSiguiendo.setVisible(true);
                cbxFavss.setVisible(false);
                lblFavs.setVisible(false);
                lstListas.setVisible(false);
                lstFavs.setVisible(false);
                lblListas.setVisible(false);
                break;
            }
        }
    }

    private void limpiarCampos() {
        txtNickName.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNaci1.setText("");
        txtCorreoElectronico.setText("");
        txtPaginaWeb.setText("");
        txtaBiografia.setText("");
        lstListas.setModel(new javax.swing.DefaultListModel<>()); // Limpiar lista de albumes
        lstSeguidores.setModel(new javax.swing.DefaultListModel<>()); // Limpiar lista de seguidores
        lstAlbumSiguiendo1.setModel(new javax.swing.DefaultListModel<>()); 
        lstFavs.setModel(new javax.swing.DefaultListModel<>()); 
        txtNumeroDeSeguidoresPosta.setText("0");
        
        
        /*
        txtPaginaWeb.setVisible(false);
        txtaBiografia.setVisible(false);
        lstAlbumSiguiendo.setVisible(false);
        lstSeguidores.setVisible(false);
        lblNroSeguidores.setVisible(false);
        lblSeguidores.setVisible(false);
        txtNumeroDeSeguidoresPosta.setVisible(false);
        lblAlbumSiguiendo.setVisible(false);
        */
    }

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String nickBuscar = txtBuscar.getText();
        String token = String.valueOf(cbxOpt.getSelectedItem());
        if (nickBuscar.isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresa un nombre de usuario.");
        } else {
            limpiarCampos(); // Limpia los campos antes de buscar

            if (!"OPT".equals(token)) {
                if ("Cliente".equals(token)) {
                    DataCliente usr = controlCli.consultarPerfilCliente(nickBuscar);
                    if (usr != null) {
                        
                      
                        txtNickName.setText(usr.getNickname());
                        txtNombre.setText(usr.getNombre());
                        txtApellido.setText(usr.getApellido());
                        txtFechaNaci1.setText(usr.getFechaNac().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
                        txtCorreoElectronico.setText(usr.getCorreo());
                        txtPaginaWeb.setText("");
                        txtaBiografia.setText("");
                        txtNumeroDeSeguidoresPosta.setText(valueOf(controlCli.obtenerNumeroSeguidores(usr.getNickname())));
                        
                        Collection<String> coleSeguidores =controlCli.obtenerSeguidoresUsuario(usr.getNickname());
                        Collection<String> coleSeguidos = controlCli.obtenerSeguidosUsuario(usr.getNickname());
                        Collection<String> coleListas = controlCli.obtenerListasDeUsuario(usr.getNickname());
                        cargarUsuariosLstSegudidores(coleSeguidores);
                        cargarUsuariosLstSeguidos(coleSeguidos);
                        cargarListasLst(coleListas);
                        
                         String tokenFav = String.valueOf(cbxFavss.getSelectedItem());
                        switch (tokenFav) {
                            case "Temas":
                           //     System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA-1");
                                Collection<String> favTema = controlCli.obtenerTemaFavCliente(usr.getNickname());
                                cargarLstFav(favTema);
                                
                                break;
                            case "Albums":
                                Collection<String> favAlbum =controlCli.obtenerAlbumFavCliente(usr.getNickname());
                                cargarLstFav(favAlbum);
                                break;
                            case "Listas":
                                Collection<String> favLista =controlCli.obtenerListasFavCliente(usr.getNickname());
                                cargarLstFav(favLista);
                                break;
                            default:
                                break;
                        }
                        
                        
                        
                       
                       
                       
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el cliente.");
                    }
                } else if ("Artista".equals(token)) {
 
                    DataArtista art = controlArt.retornarArtista(nickBuscar);
                    if (art != null) {
                      
                        txtNickName.setText(art.getNickname());
                        txtNombre.setText(art.getNombre());
                        txtApellido.setText(art.getApellido());
                        txtFechaNaci1.setText(art.getFechaNac().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
                        txtCorreoElectronico.setText(art.getCorreo());
                        txtPaginaWeb.setText(art.getDirWeb());
                        txtaBiografia.setText(art.getBiografia());
                        txtNumeroDeSeguidoresPosta.setText(valueOf(controlArt.obtenerNumeroSeguidores(art.getNickname())));
                        Collection<String> coleSeguidores =controlArt.obtenerSeguidoresArt(art.getNickname());
                        cargarUsuariosLstSegudidores(coleSeguidores);
                        
                         Collection<String> artAlbum =controlArt.obtenerAlbumsArt(art.getNickname());
                                cargarUsuariosLstSeguidos(artAlbum);
                        
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el artista.");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    private void cbxFavssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFavssActionPerformed
      String usr =  txtNickName.getText();
      
        String tokenFav = String.valueOf(cbxFavss.getSelectedItem());
      //  System.out.println(tokenFav);
            switch (tokenFav) {
           case "Temas":
                           //     System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA-1");
                                Collection<String> favTema = controlCli.obtenerTemaFavCliente(usr);
                                cargarLstFav(favTema);
                                
                                break;
                            case "Albums":
                                Collection<String> favAlbum =controlCli.obtenerAlbumFavCliente(usr);
                                cargarLstFav(favAlbum);
                                break;
                            case "Listas":
                                Collection<String> favLista =controlCli.obtenerListasFavCliente(usr);
                                cargarLstFav(favLista);
                                break;
                            default:
                                break;
        }
    }//GEN-LAST:event_cbxFavssActionPerformed

    public void cargarUsuariosLstBuscar(Collection<DataCliente> cole) {
        DefaultListModel<String> model;

        model = new DefaultListModel<String>();

        for (DataCliente elemento : cole) {
            String nick = elemento.getNickname();
            model.addElement(nick);
        }
        lstUsuarios.setModel(model);

    }
    public void cargarArtistasLstBuscar(Collection<DataArtista> cole) {
        DefaultListModel<String> model;

        model = new DefaultListModel<String>();

        for (DataArtista elemento : cole) {
            String nick = elemento.getNickname();
            model.addElement(nick);
        }
        lstUsuarios.setModel(model);

    }
    
    
    
     public void cargarUsuariosLstSegudidores(Collection<String> cole) {
        DefaultListModel<String> model;

        model = new DefaultListModel<String>();

        for (String elemento : cole) {
           // System.out.print("Elemento de lstSeguidores"+elemento);
            String nick = elemento;
            model.addElement(nick);
        }
        lstSeguidores.setModel(model);

    }
    public void cargarListasLst(Collection<String> cole) {
        DefaultListModel<String> model;

        model = new DefaultListModel<String>();

        for (String elemento : cole) {
            //System.out.print("Elemento de lstSeguidores"+elemento);
            String nombre = elemento;
            model.addElement(nombre);
        }
        lstListas.setModel(model);

    }
    public void cargarUsuariosLstSeguidos(Collection<String> cole) {
        DefaultListModel<String> model;

        model = new DefaultListModel<String>();

        for (String elemento : cole) {
           // System.out.print("Elemento de lstSeguidos"+elemento);
            String nick = elemento;
            model.addElement(nick);
        }
        lstAlbumSiguiendo1.setModel(model);

    }
    public void cargarLstFav(Collection<String> cole) {
        DefaultListModel<String> model;

        model = new DefaultListModel<String>();

        for (String elemento : cole) {
          //  System.out.print("Elemento de lstSeguidos"+elemento);
            String nombre = elemento;
            model.addElement(nombre);
        }
        lstFavs.setModel(model);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbxFavss;
    private javax.swing.JComboBox<String> cbxOpt;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblAlbumSiguiendo;
    private javax.swing.JLabel lblFavs;
    private javax.swing.JLabel lblListas;
    private javax.swing.JLabel lblNroSeguidores;
    private javax.swing.JLabel lblSeguidores;
    private javax.swing.JLabel lblSeguidores1;
    private javax.swing.JList<String> lstAlbumSiguiendo1;
    private javax.swing.JList<String> lstFavs;
    private javax.swing.JList<String> lstListas;
    private javax.swing.JList<String> lstSeguidores;
    private javax.swing.JList<String> lstUsuarios;
    private java.awt.Panel panel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtFechaNaci1;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtNumeroDeSeguidoresPosta;
    private javax.swing.JTextField txtPaginaWeb;
    private javax.swing.JTextArea txtaBiografia;
    // End of variables declaration//GEN-END:variables
}
