package utn.arquitectura.main;

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

        // Configurar el filtro de archivos: EXPLICAR FORMATOS
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

            switch (LabelTipo.getText()) {
                case "txt" -> job.setPrintable(new FilePrintable(archivo));
                case "pdf" -> throw new UnsupportedOperationException();
                case "png", "jpg" -> {
                    try {
                        job.setPrintable(new ImagePrintable(archivo));
                    }catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al cargar la imagen.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            if (job.printDialog()) {
                try {
                    imprimirColaImpresion(job.getPrintService().getName());
                    job.print();

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
