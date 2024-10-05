package presentacion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import logica.controladores.IControladorAlbum;
import logica.controladores.IControladorGenero;
import logica.controladores.IControladorTema;
import logica.dt.DataGenero;
import logica.dt.DataTema;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import logica.controladores.IControladorArtista;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataCliente;

public class AltaDeAlbum extends javax.swing.JPanel {

    private final IControladorAlbum controlAlb;
    private final IControladorGenero controlGen;
    private final IControladorArtista controlArt;
    private final IControladorTema controlTem;
    private final JFileChooser fileChooserAudio;
    private final JFileChooser fileChooserImagen;
    private final Collection<String> generos_seleccionados;
    private final ArrayList<String> temas_del_album;
    String selectedGenre;

    public AltaDeAlbum(IControladorAlbum icalb, IControladorGenero icg, IControladorTema ict, IControladorArtista ica) {
        controlAlb = icalb;
        controlGen = icg;
        controlArt = ica;
        controlTem = ict;
        fileChooserAudio = new JFileChooser();
        fileChooserImagen = new JFileChooser();
        fileChooserImagen.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooserAudio.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooserImagen.setDialogTitle("Selecciona una imagen para el album");
        fileChooserImagen.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagenes (JPG, PNG)", "jpg", "png"));
        fileChooserAudio.setDialogTitle("Selecciona un archivo MP3");
        fileChooserAudio.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos MP3", "mp3"));
        generos_seleccionados = new ArrayList<>();
        temas_del_album = new ArrayList<>();
        initComponents();
        cargarGeneros();
        cargarArtistas();
        lblMin.setVisible(false);
        lblSeg.setVisible(false);
        txtMin.setVisible(false);
        txtSeg.setVisible(false);

        txtAnio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // Si no es un número
                    e.consume(); // Bloquea la tecla
                }
            }
        });
        
        txtMin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // Si no es un número
                    e.consume(); // Bloquea la tecla
                }
            }
        });
        
        txtSeg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // Si no es un número
                    e.consume(); // Bloquea la tecla
                }
            }
        });

        txtPosTemaAlb.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // Si no es un número
                    e.consume(); // Bloquea la tecla
                }
            }
        });
        
        listGen.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Evitar acciones repetidas cuando la selección sigue cambiando
                if (!e.getValueIsAdjusting()) {
                    // Obtener el nombre seleccionado
                    selectedGenre = listGen.getSelectedValue();
                    if(selectedGenre != null){
                         if (generos_seleccionados.contains(listGen.getSelectedValue())) {
            JOptionPane.showMessageDialog(null, "Este album ya cuenta con este genero");
        } else {
            generos_seleccionados.add(listGen.getSelectedValue());
            DefaultListModel<String> model = new DefaultListModel();
            if (!generos_seleccionados.isEmpty()) {
                Iterator<String> iterator = generos_seleccionados.iterator();
                while (iterator.hasNext()) {
                    model.addElement(iterator.next());
                }
            }
            listGenSelect.setModel(model);
        }
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArt = new javax.swing.JLabel();
        lblNomAlb = new javax.swing.JLabel();
        txtNomAlb = new javax.swing.JTextField();
        lblAnioAlb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listGen = new javax.swing.JList<>();
        lblGenAlb1 = new javax.swing.JLabel();
        lblNomTemaAlb = new javax.swing.JLabel();
        txtNomTemaAlb = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        lblNomTemaAlb1 = new javax.swing.JLabel();
        cbxTipMus = new javax.swing.JComboBox<>();
        txtTipMus = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        lblMsjArch = new javax.swing.JLabel();
        btnConfTem = new javax.swing.JButton();
        txtAnio = new javax.swing.JTextField();
        btnReiGen = new javax.swing.JButton();
        lblGenSel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listGenSelect = new javax.swing.JList<>();
        lblGenDelSis = new javax.swing.JLabel();
        lblDireccionTema = new javax.swing.JLabel();
        txtPosTemaAlb = new javax.swing.JTextField();
        btnNukear1 = new javax.swing.JButton();
        lblPosTemaAlb = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblSeg = new javax.swing.JLabel();
        txtMin = new javax.swing.JTextField();
        txtSeg = new javax.swing.JTextField();
        btnArch = new javax.swing.JButton();
        jButtonImagen = new javax.swing.JButton();
        CmbArtistas = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(860, 471));

        lblArt.setText("Artista creador del album :");

        lblNomAlb.setText("Nombre del album :");

        lblAnioAlb.setText("Año del album :");

        jScrollPane1.setViewportView(listGen);

        lblGenAlb1.setText("Link de la imagen (opcional) :");

        lblNomTemaAlb.setText("Nombre del tema :");

        txtNomTemaAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomTemaAlbActionPerformed(evt);
            }
        });

        jList1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jList1HierarchyChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        lblNomTemaAlb1.setText("Temas del album :");

        cbxTipMus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Archivo mp3", "Enlace web" }));
        cbxTipMus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipMusActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Subir Album");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblMsjArch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMsjArch.setText(" ");

        btnConfTem.setText("Subir Tema");
        btnConfTem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfTemActionPerformed(evt);
            }
        });

        btnReiGen.setText("Reinicar Generos");
        btnReiGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiGenActionPerformed(evt);
            }
        });

        lblGenSel.setText("Generos Seleccionados : ");

        jScrollPane3.setViewportView(listGenSelect);

        lblGenDelSis.setText("Generos del Sistema : ");

        lblDireccionTema.setText("URL Descargable o Link :");

        txtPosTemaAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPosTemaAlbActionPerformed(evt);
            }
        });

        btnNukear1.setText("Cancelar Album");
        btnNukear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNukear1ActionPerformed(evt);
            }
        });

        lblPosTemaAlb.setText("Posicion del tema :");

        lblMin.setText("Minutos :");

        lblSeg.setText("Segundos :");

        txtMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinActionPerformed(evt);
            }
        });

        txtSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegActionPerformed(evt);
            }
        });

        btnArch.setText("Subir Archivo");
        btnArch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchActionPerformed(evt);
            }
        });

        jButtonImagen.setText("Subir");
        jButtonImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImagenActionPerformed(evt);
            }
        });

        CmbArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPT" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnConfTem, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                            .addComponent(lblNomTemaAlb1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMin)
                                    .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSeg)
                                    .addComponent(txtSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtNomTemaAlb, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomTemaAlb)
                            .addComponent(lblPosTemaAlb)
                            .addComponent(txtPosTemaAlb, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNukear1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomAlb)
                            .addComponent(lblArt)
                            .addComponent(lblGenAlb1)
                            .addComponent(lblAnioAlb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomAlb)
                            .addComponent(txtAnio, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jButtonImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CmbArtistas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblGenSel)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnReiGen, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGenDelSis)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDireccionTema)
                            .addComponent(txtTipMus, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnArch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxTipMus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMsjArch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArt)
                            .addComponent(CmbArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomAlb)
                            .addComponent(txtNomAlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGenAlb1)
                            .addComponent(jButtonImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnioAlb)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblNomTemaAlb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfTem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNukear1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGenDelSis)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGenSel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReiGen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNomTemaAlb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomTemaAlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDireccionTema)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipMus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPosTemaAlb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPosTemaAlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblMin)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSeg)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxTipMus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnArch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMsjArch, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(485, 485, 485))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomTemaAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomTemaAlbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomTemaAlbActionPerformed

    private void jList1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jList1HierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jList1HierarchyChanged

    private void btnConfTemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfTemActionPerformed
        if (!txtNomTemaAlb.getText().isEmpty() && !txtPosTemaAlb.getText().isEmpty() && !txtTipMus.getText().isEmpty()) {
            String nombre_tema = txtNomTemaAlb.getText();
            Integer posicion_deseada = Integer.parseInt(txtPosTemaAlb.getText());
            if (cbxTipMus.getSelectedItem() == "Archivo mp3") {
                File selectedFile;
                if (fileChooserAudio.getSelectedFile() != null) {
                    selectedFile = fileChooserAudio.getSelectedFile();
                    File destinationDir = new File("espotify\\src\\main\\java\\temas");
                    if (!destinationDir.exists()) {
                        destinationDir.mkdirs(); // Crear la carpeta si no existe
                    }
                    // Crear el archivo de destino con el mismo nombre que el seleccionado
                    File destinationFile = new File(destinationDir, selectedFile.getName());
                    // Copiar el archivo al destino
                    if (selectedFile.getName().endsWith(".mp3")) {
                        try {
                            // Extrae la duracion del archivo mp3
                            Mp3File mp3File = new Mp3File(selectedFile.getAbsolutePath());
                            if (mp3File.hasId3v2Tag()) {
                                ID3v2 id3v2Tag = mp3File.getId3v2Tag();
                                long durationInSeconds = mp3File.getLengthInSeconds();
                                if (insertarEnPosicion(temas_del_album, nombre_tema, posicion_deseada) && !txtTipMus.getText().isEmpty() && controlTem.crearTemaDefault(nombre_tema, (int) durationInSeconds, txtTipMus.getText(), selectedFile.getName())) {
                                    JOptionPane.showMessageDialog(null, "Tema agregado con exito");
                                    DefaultListModel<String> model = new DefaultListModel();
                                    Iterator<String> iterator = temas_del_album.iterator();
                                    while (iterator.hasNext()) {
                                        model.addElement(iterator.next());
                                    }
                                    jList1.setModel(model);
                                    txtNomTemaAlb.setText(null);
                                    txtPosTemaAlb.setText(null);
                                    fileChooserAudio.setSelectedFile(null);
                                    txtTipMus.setText(null);
                                    txtMin.setText(null);
                                    txtSeg.setText(null);
                                    lblMsjArch.setText("El archivo no se reconoce como un mp3");
                                    try {
                                        Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                                        System.out.println("Archivo guardado exitosamente en: " + destinationFile.getAbsolutePath());
                                    } catch (IOException i) {
                                        System.out.println("Error al guardar el archivo.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Un error ha ocurrido, es posible que la posicion del tema en la lista no sea valida o el nombre se encuentre repetido.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Un error ha ocurrido.");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error al leer el archivo MP3");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, seleccione un archivo MP3");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un archivo MP3");
                }

            } else {
                if(!txtMin.getText().isEmpty() && !txtSeg.getText().isEmpty()){
                if (insertarEnPosicion(temas_del_album, nombre_tema, posicion_deseada) && controlTem.crearTemaDefault(nombre_tema, Integer.parseInt(txtMin.getText())*60+Integer.parseInt(txtSeg.getText()), txtTipMus.getText(), null)) {
                    JOptionPane.showMessageDialog(null, "Tema agregado con exito");
                    DefaultListModel<String> model = new DefaultListModel();
                    Iterator<String> iterator = temas_del_album.iterator();
                    while (iterator.hasNext()) {
                        model.addElement(iterator.next());
                    }
                    jList1.setModel(model);
                    txtNomTemaAlb.setText(null);
                    txtTipMus.setText(null);
                    txtPosTemaAlb.setText(null);
                    fileChooserAudio.setSelectedFile(null);
                    txtTipMus.setText(null);
                    txtMin.setText(null);
                    txtSeg.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(null, "Un error ha ocurrido, es posible que la posicion del tema en la lista no sea valida o el nombre se encuentre repetido.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La duracion del tema es obligatoria.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre, posicion del tema y un link de descarga o para escucharlo son obligatorios.");
        }
    }//GEN-LAST:event_btnConfTemActionPerformed

    public void cargarArtistas(){
        Collection<DataArtista> cole = this.controlArt.mostrarArtistas();
        DefaultComboBoxModel<String> model;
        model = new DefaultComboBoxModel<>();
        model.addElement("OPT");
        for (DataArtista elemento : cole) {
            String nick = elemento.getNickname();
            model.addElement(nick);
        }
        this.CmbArtistas.setModel(model);
    }
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        if (String.valueOf(CmbArtistas.getSelectedItem()) != "OPT" || txtNomAlb.getText().isEmpty() || txtAnio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete el formulario con la informacion necesaria");
        } else {
            if (controlArt.retornarArtista(String.valueOf(CmbArtistas.getSelectedItem())) != null) {
                String nick_artista = String.valueOf(CmbArtistas.getSelectedItem());
                String nombre_album = txtNomAlb.getText();
                File selectedFile = fileChooserImagen.getSelectedFile();
                Integer año_album = Integer.parseInt(txtAnio.getText());
                //// CALCULAR GENEROS SELECCIONADOS
                Collection<DataGenero> generos = new ArrayList<>();
                if (generos_seleccionados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione generos para el album");
                } else {
                    Iterator<String> iterator = generos_seleccionados.iterator();
                    while (iterator.hasNext()) {
                        String elemento = iterator.next();
                        generos.add(new DataGenero(elemento));
                    }
                }
                //// CALCULAR TEMAS SELECCIONADOS
                Collection<DataTema> temas = new ArrayList<>();
                if (temas_del_album.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, genere temas para el album");
                } else {
                    Iterator<String> iterator = temas_del_album.iterator();
                    Integer posicion = 1;
                    while (iterator.hasNext()) {
                        DataTema tema_actual = controlTem.retornarTema(iterator.next());
                        tema_actual.setPos(posicion);
                        posicion = posicion + 1;
                        tema_actual.setAlbum(new DataAlbum(txtNomAlb.getText()));
                        temas.add(tema_actual);
                    }
                    if (selectedFile.getName().isBlank()) {
                        DataAlbum album_nuevo = controlAlb.agregarAlbum(nick_artista, nombre_album, "default", año_album, temas);
                        Iterator<String> iterator_gen = generos_seleccionados.iterator();
                        while (iterator_gen.hasNext()) {
                            String genero = iterator_gen.next();
                            Collection<String> albumes = controlAlb.retornarAlbumsDelGenero(genero);
                            controlGen.actualizarGenero(new DataGenero(genero), albumes, album_nuevo);
                        }
                        JOptionPane.showMessageDialog(null, "Album agregado con exito");
                        reiniciarCampos();
                    } else {
                        DataAlbum album_nuevo = controlAlb.agregarAlbum(nick_artista, nombre_album, selectedFile.getName(), año_album, temas);
                        Iterator<String> iterator_gen = generos_seleccionados.iterator();
                        while (iterator_gen.hasNext()) {
                            String genero = iterator_gen.next();
                            Collection<String> albumes = controlAlb.retornarAlbumsDelGenero(genero);
                            controlGen.actualizarGenero(new DataGenero(genero), albumes, album_nuevo);
                        }
                        JOptionPane.showMessageDialog(null, "Album agregado con exito");
                        reiniciarCampos();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nickname seleccionado no existe o pertenece a un usuario común");
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void reiniciarCampos() {
        DefaultComboBoxModel<String> modelo_vacio;
        modelo_vacio = new DefaultComboBoxModel<>();
        CmbArtistas.setModel(modelo_vacio);
        txtNomAlb.setText(null);
        fileChooserAudio.setSelectedFile(null);
        jButtonImagen.setText("Subir");
        txtAnio.setText(null);
        txtNomTemaAlb.setText(null);
        txtTipMus.setText(null);
        txtPosTemaAlb.setText(null);
        fileChooserAudio.setSelectedFile(null);
        txtMin.setText(null);
        txtSeg.setText(null);
        lblMsjArch.setText("El archivo no se reconoce como un mp3");
        DefaultListModel<String> model = new DefaultListModel();
        listGenSelect.setModel(model);
        jList1.setModel(model);
        generos_seleccionados.removeAll(generos_seleccionados);
        temas_del_album.removeAll(temas_del_album);
    }

    private void btnArchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchActionPerformed
        int result = fileChooserAudio.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserAudio.getSelectedFile();
            if (selectedFile.getName().endsWith(".mp3")) {
                lblMsjArch.setText("Archivo seleccionado: " + selectedFile.getName());
            } else {
                lblMsjArch.setText("Archivo seleccionado no valido");
            }
        }
    }//GEN-LAST:event_btnArchActionPerformed

    private void cbxTipMusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipMusActionPerformed
        if (cbxTipMus.getSelectedItem() == "Archivo mp3") {
            btnArch.setVisible(true);
            lblMsjArch.setVisible(true);
            lblMin.setVisible(false);
            lblSeg.setVisible(false);
            txtMin.setVisible(false);
            txtSeg.setVisible(false);
        } else {
            btnArch.setVisible(false);
            lblMsjArch.setVisible(false);
            lblMin.setVisible(true);
            lblSeg.setVisible(true);
            txtMin.setVisible(true);
            txtSeg.setVisible(true);
        }
    }//GEN-LAST:event_cbxTipMusActionPerformed


    private void btnReiGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiGenActionPerformed
        DefaultListModel<String> model = new DefaultListModel();
        listGenSelect.setModel(model);
        generos_seleccionados.clear();
    }//GEN-LAST:event_btnReiGenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtPosTemaAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPosTemaAlbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPosTemaAlbActionPerformed

    private void btnNukear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNukear1ActionPerformed
        Iterator<String> iterator = temas_del_album.iterator();
        while (iterator.hasNext()) {
            controlTem.BorrarTema(iterator.next());
        }
        reiniciarCampos();
        JOptionPane.showMessageDialog(null, "Alta de Album cancelada con exito");
    }//GEN-LAST:event_btnNukear1ActionPerformed

    private void txtMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinActionPerformed

    private void txtSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegActionPerformed

    private void jButtonImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImagenActionPerformed
        int result = fileChooserImagen.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooserImagen.getSelectedFile();
            if (selectedFile.getName().endsWith(".png") || selectedFile.getName().endsWith(".jpg")) {
                jButtonImagen.setText("Imagen: " + selectedFile.getName());
            } else {
                jButtonImagen.setText("Subir");
            }
        }
    }//GEN-LAST:event_jButtonImagenActionPerformed

    public void cargarGeneros() {
        DefaultListModel<String> model = new DefaultListModel();
        Collection<String> retorno = controlGen.mostrarGeneros();
        if (!retorno.isEmpty()) {
            Iterator<String> iterator = retorno.iterator();
            while (iterator.hasNext()) {
                model.addElement(iterator.next());
            }
        }
        listGen.setModel(model);
    }
    
    private boolean insertarEnPosicion(ArrayList<String> temas, String temazo, int posicion) {
        if(posicion>0){
            posicion = posicion - 1;
        }
        // Verificar que la posición sea válida
        if (posicion < 0) {
            return false;
        }
        if (posicion > temas.size()) {
            temas.add(temazo);
            return true;
        } else {
            temas.add(posicion, temazo); // El método add en ArrayList automáticamente mueve los elementos hacia abajo
            return true;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbArtistas;
    private javax.swing.JButton btnArch;
    private javax.swing.JButton btnConfTem;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnNukear1;
    private javax.swing.JButton btnReiGen;
    private javax.swing.JComboBox<String> cbxTipMus;
    private javax.swing.JButton jButtonImagen;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnioAlb;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblDireccionTema;
    private javax.swing.JLabel lblGenAlb1;
    private javax.swing.JLabel lblGenDelSis;
    private javax.swing.JLabel lblGenSel;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblMsjArch;
    private javax.swing.JLabel lblNomAlb;
    private javax.swing.JLabel lblNomTemaAlb;
    private javax.swing.JLabel lblNomTemaAlb1;
    private javax.swing.JLabel lblPosTemaAlb;
    private javax.swing.JLabel lblSeg;
    private javax.swing.JList<String> listGen;
    private javax.swing.JList<String> listGenSelect;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtMin;
    private javax.swing.JTextField txtNomAlb;
    private javax.swing.JTextField txtNomTemaAlb;
    private javax.swing.JTextField txtPosTemaAlb;
    private javax.swing.JTextField txtSeg;
    private javax.swing.JTextField txtTipMus;
    // End of variables declaration//GEN-END:variables
}
