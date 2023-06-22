package utn.arquitectura.main;

import java.awt.FontMetrics;               // Biblioteca para obtener métricas de fuentes
import java.awt.Graphics;                  // Biblioteca para gráficos básicos
import java.awt.Graphics2D;                // Biblioteca para gráficos avanzados
import java.awt.print.PageFormat;          // Biblioteca para el formato de página de impresión
import java.awt.print.Printable;           // Biblioteca para crear documentos imprimibles
import java.awt.print.PrinterException;    // Biblioteca para excepciones relacionadas con la impresión
import java.io.BufferedReader;             // Biblioteca para leer archivos de forma eficiente
import java.io.File;                       // Biblioteca para manipular archivos y directorios
import java.io.FileReader;                 // Biblioteca para leer archivos de texto
import java.io.IOException;                // Biblioteca para excepciones de E/S (entrada/salida)
import java.nio.charset.StandardCharsets;  // Biblioteca para especificar la codificación de caracteres
import javax.swing.JOptionPane;            // Biblioteca para mostrar mensajes de diálogo

public class FilePrintable implements Printable {
    
    private File archivo;
    
    public FilePrintable(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        try {
            FileReader fileReader = new FileReader(archivo, StandardCharsets.UTF_8);
            // Se crea un BufferedReader para leer el archivo línea por línea.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Se obtiene el contexto gráfico para realizar la impresión.
            Graphics2D g2d = (Graphics2D) graphics;
            
            // Se establece la posición inicial de impresión en la esquina superior izquierda de la página.
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            // Se obtienen las métricas de fuente para calcular el tamaño de los caracteres.
            FontMetrics fontMetrics = g2d.getFontMetrics();

            // Se calcula la altura de línea basada en las métricas de fuente.
            int lineHeight = fontMetrics.getHeight();
            
            // Se calcula la cantidad de líneas que caben en una página basándose en la altura imprimible de la página.
            int linesPerPage = (int) (pageFormat.getImageableHeight() / lineHeight);

            String line;
            int lineNumber = 0;

            // Se lee cada línea del archivo hasta que se alcance el límite de líneas por página o se llegue al final del archivo.
            while ((line = bufferedReader.readLine()) != null && lineNumber < linesPerPage) {
                int x = 0;
                int y = (lineNumber + 1) * lineHeight;
                g2d.drawString(line, x, y);
                lineNumber++;
            }
            bufferedReader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error durante la impresión.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        // Se indica que la página se imprimió exitosamente.
        return PAGE_EXISTS;
    }
}