package utn.arquitectura.main;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

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
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            FontMetrics fontMetrics = g2d.getFontMetrics();

            int lineHeight = fontMetrics.getHeight();
            int linesPerPage = (int) (pageFormat.getImageableHeight() / lineHeight);

            String line;
            int lineNumber = 0;

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

        return PAGE_EXISTS;
    }
    
}
