/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import logica.Usuario;
import logica.dt.DataUsuario;
import logica.dt.DataCliente;
import logica.dt.DataArtista;
import logica.controladores.IControladorCliente;
import logica.controladores.IControladorArtista;




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
               lstAlbum.setVisible(false);
               lstSeguidores.setVisible(false);
               lblNroSeguidores.setVisible(false);
               lblSegui.setVisible(false);
               txtNumeroDeSeguidoresPosta.setVisible(false);
               lblAlbum.setVisible(false);
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
        lblSegui = new javax.swing.JLabel();
        lblAlbum = new javax.swing.JLabel();
        lblNroSeguidores = new javax.swing.JLabel();
        txtNumeroDeSeguidoresPosta = new javax.swing.JLabel();
        cbxOpt = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstSeguidores = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstAlbum = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        txtBuscar = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();

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

        lblSegui.setText("Seguidores ");

        lblAlbum.setText("Albumes");

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

        lstAlbum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(lstAlbum);

        lstUsuarios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Larry", "Capaja", "El", "Hombre", "Que ", "No ", "Te", "Engaña" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(lstUsuarios);

        txtBuscar.setColumns(10);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxOpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtNickName)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido)
                                    .addComponent(txtFechaNaci1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSegui)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAlbum))
                                .addGap(136, 136, 136))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNroSeguidores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroDeSeguidoresPosta)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroDeSeguidoresPosta)
                            .addComponent(lblNroSeguidores))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSegui)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAlbum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(691, 691, 691))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxOptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxOptItemStateChanged
       
    }//GEN-LAST:event_cbxOptItemStateChanged
    private void lenarLista(List <Usuario> lista){
        
        //lstUsuarios.add("a");
        
    }
    private void cbxOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOptActionPerformed
       
        
        String token = String.valueOf( cbxOpt.getSelectedItem());
       
        switch (token) {
            case "OPT":
               txtPaginaWeb.setVisible(false);
               txtaBiografia.setVisible(false);
               lstAlbum.setVisible(false);
               lstSeguidores.setVisible(false);
               lblNroSeguidores.setVisible(false);
               lblSegui.setVisible(false);
               txtNumeroDeSeguidoresPosta.setVisible(false);
               lblAlbum.setVisible(false);
               
            case "Cliente":
                
              
               Collection<DataCliente> cole = controlCli.mostrarClientes();
               cargarUsuarios(cole);
               
                
             txtPaginaWeb.setVisible(false);
               txtaBiografia.setVisible(false);
               lstAlbum.setVisible(false);
               lstSeguidores.setVisible(false);
               lblNroSeguidores.setVisible(false);
               lblSegui.setVisible(false);
               txtNumeroDeSeguidoresPosta.setVisible(false);
               lblAlbum.setVisible(false);
              
                break;
            case "Artista":
               txtPaginaWeb.setVisible(true);
               txtaBiografia.setVisible(true);
               lstAlbum.setVisible(true);
               lstSeguidores.setVisible(true);
               lblNroSeguidores.setVisible(true);
               lblSegui.setVisible(true);
               txtNumeroDeSeguidoresPosta.setVisible(true);
               
                break;
                
    }//GEN-LAST:event_cbxOptActionPerformed
}
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        
         //System.out.println("AAAAAAAAAAAAAAAAAAAA");
         
         
         
         
         
        String nickBuscar = txtBuscar.getText();
       String token= String.valueOf( cbxOpt.getSelectedItem());
       if(token == "OPT"){
                 //no
                 
                 
                 
       }else if(token == "Cliente"){
         // Usuario usr =  cliHandler.consultarPerfilCliente(txtBuscar.getText());
         System.out.println("Se quiere mostrar los datos de un cliente");
          DataUsuario usr = controlCli.consultarPerfilCliente(nickBuscar);
         txtNickName.setText(usr.getNickname());
           txtNombre.setText(usr.getNombre());
           txtApellido.setText(usr.getApellido());
           
            DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            String formattedString = usr.getFechaNac().format(formatter);
           
           
           
           txtFechaNaci1.setText(formattedString);
           txtCorreoElectronico.setText(usr.getCorreo());
           txtPaginaWeb.setText(token);
           txtaBiografia.setText(token);
           
       }else if(token == "Artista"){
           
       }
       
       //mandar mierda
       
       
       //recibir mierda()
       
       
       
       
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    public void cargarUsuarios(Collection<DataCliente> cole) {
        DefaultListModel<String> model;

            model = new DefaultListModel<String>();
            
            for (DataCliente elemento : cole) {
               String nick =  elemento.getNickname();
               model.addElement(nick);
            }
            lstUsuarios.setModel(model);
            

    }
    
    
    public ArrayList<String> dataUsrToString(Collection<DataCliente> cole){
         
        ArrayList<String> pepe = new ArrayList<String>();
        Iterator<DataCliente> iterator = cole.iterator();
        while(iterator.hasNext()){
            DataCliente cli = iterator.next();
           pepe.add(cli.getNickname());
 
        }
        
   
        
       return pepe;
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbxOpt;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JLabel lblNroSeguidores;
    private javax.swing.JLabel lblSegui;
    private javax.swing.JList<String> lstAlbum;
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
