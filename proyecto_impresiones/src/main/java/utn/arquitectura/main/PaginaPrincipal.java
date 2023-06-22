package utn.arquitectura.main;

/*
Las librerías importadas pertenecen a JNA (Java Native Access).
Se utilizan para interactuar con funciones nativas de Windows relacionadas con la administración de impresoras y la cola de impresión. 

    com.sun.jna.platform.win32.WinNT: 
        Proporciona definiciones de constantes y estructuras utilizadas por las API de Windows relacionadas 
        con el manejo de objetos del sistema, como identificadores de impresoras y trabajos de impresión.

    com.sun.jna.platform.win32.Winspool: 
        Proporciona definiciones de funciones y estructuras utilizadas para interactuar con las API de Windows relacionadas 
        con la administración de impresoras y la cola de impresión. Proporciona métodos para abrir y cerrar impresoras, obtener 
        información sobre los trabajos en la cola de impresión, enviar trabajos de impresión, etc.

    com.sun.jna.platform.win32.WinspoolUtil: 
        Esta clase proporciona métodos de utilidad para obtener información detallada sobre los trabajos de impresión 
        en la cola de impresión. Permite obtener información adicional, como el nombre del documento, el usuario que envió el trabajo, 
        el estado del trabajo, el número total de páginas, entre otros.
*/
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.Winspool;
import com.sun.jna.platform.win32.WinspoolUtil;

import java.awt.print.PrinterAbortException;
import java.awt.print.PrinterException;
import java.awt.print.PrinterIOException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;

public class PaginaPrincipal extends javax.swing.JFrame {

    private File archivo;

    public PaginaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelDerecho = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        LabelTituloPrincipal = new javax.swing.JLabel();
        BtnSeleccionarArchivo = new javax.swing.JPanel();
        LabelSeleccionarArchivo = new javax.swing.JLabel();
        BtnImprimir = new javax.swing.JPanel();
        LabelImprimir = new javax.swing.JLabel();
        LabelTituloInformacion = new javax.swing.JLabel();
        LabelTipo = new javax.swing.JLabel();
        Separador = new javax.swing.JSeparator();
        LabelTituloColaImpresion = new javax.swing.JLabel();
        LabelTituloTipo = new javax.swing.JLabel();
        LabelTituloArchivoSeleccionado = new javax.swing.JLabel();
        LabelArchivoSeleccionado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaTextoColaImpresion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelDerecho.setBackground(new java.awt.Color(102, 255, 102));

        LabelLogo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        LabelLogo.setForeground(new java.awt.Color(255, 255, 255));
        LabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelLogo.setText("LOGO");
        LabelLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout PanelDerechoLayout = new javax.swing.GroupLayout(PanelDerecho);
        PanelDerecho.setLayout(PanelDerechoLayout);
        PanelDerechoLayout.setHorizontalGroup(
            PanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDerechoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(LabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        PanelDerechoLayout.setVerticalGroup(
            PanelDerechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDerechoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(399, Short.MAX_VALUE))
        );

        PanelPrincipal.add(PanelDerecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 130, 500));

        LabelTituloPrincipal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        LabelTituloPrincipal.setForeground(new java.awt.Color(51, 51, 51));
        LabelTituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTituloPrincipal.setText("IMPRESIONES EN JAVA");
        PanelPrincipal.add(LabelTituloPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 60));

        BtnSeleccionarArchivo.setBackground(new java.awt.Color(102, 255, 102));
        BtnSeleccionarArchivo.setForeground(new java.awt.Color(255, 255, 255));
        BtnSeleccionarArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSeleccionarArchivoMouseClicked(evt);
            }
        });

        LabelSeleccionarArchivo.setBackground(new java.awt.Color(255, 255, 255));
        LabelSeleccionarArchivo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        LabelSeleccionarArchivo.setForeground(new java.awt.Color(255, 255, 255));
        LabelSeleccionarArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSeleccionarArchivo.setText("Seleccionar Archivo");
        LabelSeleccionarArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelSeleccionarArchivoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BtnSeleccionarArchivoLayout = new javax.swing.GroupLayout(BtnSeleccionarArchivo);
        BtnSeleccionarArchivo.setLayout(BtnSeleccionarArchivoLayout);
        BtnSeleccionarArchivoLayout.setHorizontalGroup(
            BtnSeleccionarArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BtnSeleccionarArchivoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LabelSeleccionarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        BtnSeleccionarArchivoLayout.setVerticalGroup(
            BtnSeleccionarArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelSeleccionarArchivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        PanelPrincipal.add(BtnSeleccionarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 140, 30));

        BtnImprimir.setBackground(new java.awt.Color(255, 255, 255));
        BtnImprimir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 255, 102), 3, true));

        LabelImprimir.setBackground(new java.awt.Color(102, 255, 102));
        LabelImprimir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        LabelImprimir.setForeground(new java.awt.Color(102, 102, 102));
        LabelImprimir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelImprimir.setText("Imprimir");
        LabelImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelImprimirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BtnImprimirLayout = new javax.swing.GroupLayout(BtnImprimir);
        BtnImprimir.setLayout(BtnImprimirLayout);
        BtnImprimirLayout.setHorizontalGroup(
            BtnImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnImprimirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BtnImprimirLayout.setVerticalGroup(
            BtnImprimirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BtnImprimirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelPrincipal.add(BtnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 90, 30));

        LabelTituloInformacion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        LabelTituloInformacion.setForeground(new java.awt.Color(51, 51, 51));
        LabelTituloInformacion.setText("Información");
        PanelPrincipal.add(LabelTituloInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, -1));

        LabelTipo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        LabelTipo.setForeground(new java.awt.Color(102, 102, 102));
        LabelTipo.setText(". . .");
        PanelPrincipal.add(LabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 70, 20));
        PanelPrincipal.add(Separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 310, 10));

        LabelTituloColaImpresion.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        LabelTituloColaImpresion.setForeground(new java.awt.Color(102, 102, 102));
        LabelTituloColaImpresion.setText("Cola de Impresión Actual");
        PanelPrincipal.add(LabelTituloColaImpresion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 140, 20));

        LabelTituloTipo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        LabelTituloTipo.setForeground(new java.awt.Color(102, 102, 102));
        LabelTituloTipo.setText("Tipo:");
        PanelPrincipal.add(LabelTituloTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 30, 20));

        LabelTituloArchivoSeleccionado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        LabelTituloArchivoSeleccionado.setForeground(new java.awt.Color(102, 102, 102));
        LabelTituloArchivoSeleccionado.setText("Archivo:");
        PanelPrincipal.add(LabelTituloArchivoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, 20));

        LabelArchivoSeleccionado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        LabelArchivoSeleccionado.setForeground(new java.awt.Color(102, 102, 102));
        LabelArchivoSeleccionado.setText("Seleccione un archivo ...");
        PanelPrincipal.add(LabelArchivoSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 20));

        AreaTextoColaImpresion.setEditable(false);
        AreaTextoColaImpresion.setBackground(new java.awt.Color(255, 255, 255));
        AreaTextoColaImpresion.setColumns(20);
        AreaTextoColaImpresion.setForeground(new java.awt.Color(102, 102, 102));
        AreaTextoColaImpresion.setRows(5);
        AreaTextoColaImpresion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        AreaTextoColaImpresion.setCaretColor(new java.awt.Color(255, 255, 255));
        AreaTextoColaImpresion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        AreaTextoColaImpresion.setFocusable(false);
        jScrollPane1.setViewportView(AreaTextoColaImpresion);

        PanelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 310, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelSeleccionarArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSeleccionarArchivoMouseClicked
        JFileChooser fileChooser = new JFileChooser();

        // Configurar el filtro de archivos:
        /*
            txt: Este tipo de archivo representa un archivo de texto sin formato. 
            Es ampliamente utilizado para almacenar información de texto simple.
        
            pdf: Los archivos PDF son utilizados para representar documentos de manera independiente del software, el hardware y el sistema operativo. 
            Son archivos de solo lectura que conservan el formato original del documento, incluidos los elementos de texto, imágenes, gráficos y diseño. 
            Para imprimir un archivo PDF, se utiliza un objeto PDFPrintable que interpreta el contenido del PDF y lo envía a la impresora.
        
            png: Los archivos PNG (Portable Network Graphics) son un formato de imagen comprimida sin pérdida. 
            Se utilizan para almacenar imágenes con transparencia y admiten una amplia gama de colores.
        
            jpg: Los archivos JPG (Joint Photographic Experts Group) son un formato de imagen comprimida con pérdida.
            Son ampliamente utilizados para almacenar fotografías y admiten una compresión significativa sin una pérdida apreciable de calidad de imagen. 
         */
        FileNameExtensionFilter filter = new FileNameExtensionFilter("", "txt", "pdf", "png", "jpg");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
            LabelArchivoSeleccionado.setText(archivo.getName());
            LabelTipo.setText(FilenameUtils.getExtension(archivo.toString()));
        } else {
            JOptionPane.showMessageDialog(null, "Selección de archivo cancelada.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LabelSeleccionarArchivoMouseClicked

    private void LabelImprimirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelImprimirMouseClicked
        if (archivo != null) {
            PrinterJob job = PrinterJob.getPrinterJob();
            
            // Imprime el archivo seleccionado según su tipo de archivo
            switch (LabelTipo.getText()) {

                case "txt" -> {
                    job.setPrintable(new FilePrintable(archivo));
                    break;
                }

                case "pdf" -> {
                    try {
                        PDDocument document = PDDocument.load(archivo);
                        job.setPrintable(new PDFPrintable(document));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al cargar el pdf.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }

                case "png", "jpg" -> {
                    try {
                        ImagePrintable img = new ImagePrintable(archivo);
                        job.setPrintable(img);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al cargar la imagen.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al cargar la imagen.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }

            if (job.printDialog()) {
                try {
                    imprimirColaImpresion(job.getPrintService().getName());
                    job.print();
                    JOptionPane.showMessageDialog(null,
                            "El archivo se está imprimiendo!", "Acción Completada", JOptionPane.INFORMATION_MESSAGE);
                } catch (PrinterAbortException e) {
                    JOptionPane.showMessageDialog(null,
                            "Se ha abortado la impresión del archivo. \nHa solicitado la cancelación de la impresión antes de que se complete.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (PrinterIOException e) {
                    JOptionPane.showMessageDialog(null,
                            "Se ha interrumpido la conexión con la impresora. \nVerifique la conexión via USB con la impresora.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } catch (PrinterException e) {
                    JOptionPane.showMessageDialog(null, "Error al imprimir el archivo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La impresión se canceló.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún archivo para imprimir.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LabelImprimirMouseClicked

    private void imprimirColaImpresion(String nombreImpresora) {
        
        // Creación de una referencia al identificador de la impresora
        WinNT.HANDLEByReference phPrinter = new WinNT.HANDLEByReference();
        boolean ok = Winspool.INSTANCE.OpenPrinter(nombreImpresora, phPrinter, null);
        if (ok) {

            String texto;
            Winspool.JOB_INFO_1[] jobs = WinspoolUtil.getJobInfo1(phPrinter);
            if (jobs.length == 0) {
                texto = " " + nombreImpresora + " no tiene trabajos en la cola.";
            } else {
                texto = nombreImpresora + " tiene " + jobs.length + " trabajos en la cola:\n";
                for (Winspool.JOB_INFO_1 job : jobs) {
                    texto += "Archivo: " + job.pDocument + "\n"
                            + "Usuario: " + job.pUserName + "\n"
                            + "Estado: " + job.pStatus != null ? job.pStatus : job.Status + "\n"
                                    + "Total de páginas: " + job.TotalPages + "\n";
                }
            }

            AreaTextoColaImpresion.setText(texto);
        } else {
            JOptionPane.showMessageDialog(null, "Error al abrir la impresora.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        Winspool.INSTANCE.ClosePrinter(phPrinter.getValue());
    }

    private void BtnSeleccionarArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSeleccionarArchivoMouseClicked
        LabelImprimirMouseClicked(evt);
    }//GEN-LAST:event_BtnSeleccionarArchivoMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaTextoColaImpresion;
    private javax.swing.JPanel BtnImprimir;
    private javax.swing.JPanel BtnSeleccionarArchivo;
    private javax.swing.JLabel LabelArchivoSeleccionado;
    private javax.swing.JLabel LabelImprimir;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelSeleccionarArchivo;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JLabel LabelTituloArchivoSeleccionado;
    private javax.swing.JLabel LabelTituloColaImpresion;
    private javax.swing.JLabel LabelTituloInformacion;
    private javax.swing.JLabel LabelTituloPrincipal;
    private javax.swing.JLabel LabelTituloTipo;
    private javax.swing.JPanel PanelDerecho;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JSeparator Separador;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
