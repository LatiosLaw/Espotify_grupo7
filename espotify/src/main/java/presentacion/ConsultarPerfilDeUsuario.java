package presentacion;

import java.awt.Image;
import static java.lang.String.valueOf;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import logica.Usuario;
import logica.dt.DataCliente;
import logica.dt.DataArtista;
import logica.controladores.IControladorCliente;
import logica.controladores.IControladorArtista;
import logica.dt.DataUsuario;

public class ConsultarPerfilDeUsuario extends javax.swing.JPanel {

    private final IControladorCliente controlCli;
    private final IControladorArtista controlArt;
    private JComboBox<DataUsuario> comboBoxUsuarios;
    private JList<DataUsuario> listUsuarios;
    String selectedUser;

    public ConsultarPerfilDeUsuario(IControladorCliente icc, IControladorArtista ica) {
        controlCli = icc;
        controlArt = ica;
        initComponents();
        txtBuscar.setVisible(false);
        txtPaginaWeb.setVisible(false);
        txtaBiografia.setVisible(false);
        lstListas.setVisible(false);
        lstSeguidores.setVisible(false);
        lblNroSeguidores.setVisible(false);
        lblSeguidores.setVisible(false);
        txtNumeroDeSeguidoresPosta.setVisible(false);
        lblAlbumSiguiendo.setVisible(false);
        jLabelIMAGEN.setText("");
        this.revalidate();
        this.repaint();
        
        lstUsuarios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Evitar acciones repetidas cuando la selección sigue cambiando
                if (!e.getValueIsAdjusting()) {
                    // Obtener el nombre seleccionado
                    selectedUser = lstUsuarios.getSelectedValue();
                    txtBuscar.setText(selectedUser);
                    if(!txtBuscar.getText().isEmpty()){
                    buscarInfo();
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane9 = new javax.swing.JScrollPane();
        lstAlbumSiguiendo1 = new javax.swing.JList<>();
        lblListas = new javax.swing.JLabel();
        lblFavs = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        lstFavs = new javax.swing.JList<>();
        cbxFavss = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabelIMAGEN = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(860, 471));

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

        txtaBiografia.setEditable(false);
        txtaBiografia.setColumns(20);
        txtaBiografia.setLineWrap(true);
        txtaBiografia.setRows(5);
        jScrollPane2.setViewportView(txtaBiografia);

        txtPaginaWeb.setEditable(false);

        lblSeguidores.setText("Seguidores :");

        lblAlbumSiguiendo.setText("Albumes :");

        lblNroSeguidores.setText("Numero de Seguidores :");

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

        lstSeguidores.setMaximumSize(new java.awt.Dimension(90, 125));
        jScrollPane6.setViewportView(lstSeguidores);

        jScrollPane7.setViewportView(lstListas);

        jScrollPane8.setViewportView(lstUsuarios);

        txtBuscar.setColumns(10);

        jScrollPane9.setViewportView(lstAlbumSiguiendo1);

        lblListas.setText("Listas :");

        lblFavs.setText("Favs :");

        lstFavs.setMaximumSize(new java.awt.Dimension(90, 125));
        jScrollPane10.setViewportView(lstFavs);

        cbxFavss.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temas", "Albums", "Listas" }));
        cbxFavss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFavssActionPerformed(evt);
            }
        });

        jLabel1.setText("Tipo de Usuario :");

        jLabelIMAGEN.setText("jLabel2");
        jLabelIMAGEN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaNaci1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPaginaWeb, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNickName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblListas)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFavs)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxFavss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNroSeguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroDeSeguidoresPosta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlbumSiguiendo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeguidores)))
                    .addComponent(jLabelIMAGEN, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaNaci1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelIMAGEN, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroDeSeguidoresPosta)
                            .addComponent(lblNroSeguidores))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAlbumSiguiendo)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSeguidores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblListas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFavs)
                                    .addComponent(cbxFavss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxOptItemStateChanged

    }//GEN-LAST:event_cbxOptItemStateChanged
    private void lenarLista(List<Usuario> lista) {

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
        jLabelIMAGEN.setIcon(null);
        lstListas.setModel(new javax.swing.DefaultListModel<>()); // Limpiar lista de albumes
        lstSeguidores.setModel(new javax.swing.DefaultListModel<>()); // Limpiar lista de seguidores
        lstAlbumSiguiendo1.setModel(new javax.swing.DefaultListModel<>());
        lstFavs.setModel(new javax.swing.DefaultListModel<>());
        txtNumeroDeSeguidoresPosta.setText("0");
    }

    public void buscarInfo(){
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
                        Collection<String> coleSeguidores = controlCli.obtenerSeguidoresUsuario(usr.getNickname());
                        Collection<String> coleSeguidos = controlCli.obtenerSeguidosUsuario(usr.getNickname());
                        Collection<String> coleListas = controlCli.obtenerListasDeUsuario(usr.getNickname());
                        cargarUsuariosLstSegudidores(coleSeguidores);
                        cargarUsuariosLstSeguidos(coleSeguidos);
                        cargarListasLst(coleListas);
                        String tokenFav = String.valueOf(cbxFavss.getSelectedItem());
                        switch (tokenFav) {
                            case "Temas":
                                Collection<String> favTema = controlCli.obtenerTemaFavCliente(usr.getNickname());
                                cargarLstFav(favTema);
                                break;
                            case "Albums":
                                Collection<String> favAlbum = controlCli.obtenerAlbumFavCliente(usr.getNickname());
                                cargarLstFav(favAlbum);
                                break;
                            case "Listas":
                                Collection<String> favLista = controlCli.obtenerListasFavCliente(usr.getNickname());
                                cargarLstFav(favLista);
                                break;
                            default:
                                break;
                        }
                        ImageIcon defaultIcon = new ImageIcon("espotify\\src\\main\\java\\imagenes\\perfiles\\usuarioDefault.jpg");
            Image DefaultImage = defaultIcon.getImage();
            Image resizedDefault = DefaultImage.getScaledInstance(148, 148, Image.SCALE_SMOOTH);
            ImageIcon resizedIconDefault = new ImageIcon(resizedDefault);
            if(usr.getFoto()!="default" && usr.getFoto()!=null && (usr.getFoto().endsWith(".png") || usr.getFoto().endsWith(".jpg"))){
            ImageIcon imageIcon = new ImageIcon("espotify\\src\\main\\java\\imagenes\\perfiles\\"+usr.getFoto());
            if(imageIcon.getImage()!=null){
                Image DefaultProfile = imageIcon.getImage();
            Image resizedProfile = DefaultProfile.getScaledInstance(148, 148, Image.SCALE_SMOOTH);
            ImageIcon resizedIconProfile = new ImageIcon(resizedProfile);
            jLabelIMAGEN.setIcon(resizedIconProfile);
            }else{
            jLabelIMAGEN.setIcon(resizedIconDefault);    
            }
            }else{
            jLabelIMAGEN.setIcon(resizedIconDefault);
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
                        Collection<String> coleSeguidores = controlArt.obtenerSeguidoresArt(art.getNickname());
                        cargarUsuariosLstSegudidores(coleSeguidores);
                        Collection<String> artAlbum = controlArt.obtenerAlbumsArt(art.getNickname());
                        cargarUsuariosLstSeguidos(artAlbum);
ImageIcon defaultIcon = new ImageIcon("espotify\\src\\main\\java\\imagenes\\perfiles\\usuarioDefault.jpg");
            Image DefaultImage = defaultIcon.getImage();
            Image resizedDefault = DefaultImage.getScaledInstance(148, 148, Image.SCALE_SMOOTH);
            ImageIcon resizedIconDefault = new ImageIcon(resizedDefault);
            if(art.getFoto()!="default" && art.getFoto()!=null && (art.getFoto().endsWith(".png") || art.getFoto().endsWith(".jpg"))){
            ImageIcon imageIcon = new ImageIcon("espotify\\src\\main\\java\\imagenes\\perfiles\\"+art.getFoto());
            if(imageIcon.getImage()!=null){
                Image DefaultProfile = imageIcon.getImage();
            Image resizedProfile = DefaultProfile.getScaledInstance(148, 148, Image.SCALE_SMOOTH);
            ImageIcon resizedIconProfile = new ImageIcon(resizedProfile);
            jLabelIMAGEN.setIcon(resizedIconProfile);
            }else{
            jLabelIMAGEN.setIcon(resizedIconDefault);    
            }
            }else{
            jLabelIMAGEN.setIcon(resizedIconDefault);
            }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el artista.");
                    }
                }
            }
        }
    }
    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    private void cbxFavssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFavssActionPerformed
        String usr = txtNickName.getText();
        String tokenFav = String.valueOf(cbxFavss.getSelectedItem());
        switch (tokenFav) {
            case "Temas":
                Collection<String> favTema = controlCli.obtenerTemaFavCliente(usr);
                cargarLstFav(favTema);
                break;
            case "Albums":
                Collection<String> favAlbum = controlCli.obtenerAlbumFavCliente(usr);
                cargarLstFav(favAlbum);
                break;
            case "Listas":
                Collection<String> favLista = controlCli.obtenerListasFavCliente(usr);
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
            String nick = elemento;
            model.addElement(nick);
        }
        lstSeguidores.setModel(model);

    }

    public void cargarListasLst(Collection<String> cole) {
        DefaultListModel<String> model;
        model = new DefaultListModel<String>();
        for (String elemento : cole) {
            String nombre = elemento;
            model.addElement(nombre);
        }
        lstListas.setModel(model);

    }

    public void cargarUsuariosLstSeguidos(Collection<String> cole) {
        DefaultListModel<String> model;
        model = new DefaultListModel<String>();
        for (String elemento : cole) {
            String nick = elemento;
            model.addElement(nick);
        }
        lstAlbumSiguiendo1.setModel(model);
    }

    public void cargarLstFav(Collection<String> cole) {
        DefaultListModel<String> model;
        model = new DefaultListModel<String>();
        for (String elemento : cole) {
            String nombre = elemento;
            model.addElement(nombre);
        }
        lstFavs.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxFavss;
    private javax.swing.JComboBox<String> cbxOpt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelIMAGEN;
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
    private javax.swing.JList<String> lstAlbumSiguiendo1;
    private javax.swing.JList<String> lstFavs;
    private javax.swing.JList<String> lstListas;
    private javax.swing.JList<String> lstSeguidores;
    private javax.swing.JList<String> lstUsuarios;
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
