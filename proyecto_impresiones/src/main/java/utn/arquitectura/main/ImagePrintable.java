package utn.arquitectura.main;

import java.awt.Graphics;                  // Biblioteca para gráficos básicos
import java.awt.Graphics2D;                // Biblioteca para gráficos avanzados
import java.awt.image.BufferedImage;       // Biblioteca para trabajar con imágenes en memoria
import java.awt.print.PageFormat;          // Biblioteca para el formato de página de impresión
import java.awt.print.Printable;           // Biblioteca para crear documentos imprimibles
import java.awt.print.PrinterException;    // Biblioteca para excepciones relacionadas con la impresión
import java.io.File;                       // Biblioteca para manipular archivos y directorios
import java.io.IOException;                // Biblioteca para excepciones de E/S (entrada/salida)
import javax.imageio.ImageIO;              // Biblioteca para leer y escribir imágenes en varios formatos

public class ImagePrintable implements Printable {
    private BufferedImage imagen;
    
    public ImagePrintable(File archivo) throws IOException, Exception {
        this.imagen = ImageIO.read(archivo);
        if (this.imagen == null) {
            throw new Exception();
        }
    }
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // Se obtiene el contexto gráfico 2D a partir del contexto gráfico pasado como parámetro.
        Graphics2D g2d = (Graphics2D) graphics;
        
        // Se obtienen las coordenadas y dimensiones de la página imprimible.
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();
        double width = pageFormat.getImageableWidth();
        double height = pageFormat.getImageableHeight();

        // Se escala la imagen para ajustarla dentro de los límites de la página.
        double scaleX = width / imagen.getWidth();
        double scaleY = height / imagen.getHeight();
        double scale = Math.min(scaleX, scaleY);

        int scaledWidth = (int) (imagen.getWidth() * scale);
        int scaledHeight = (int) (imagen.getHeight() * scale);

        // Se calcula la posición centrada de la imagen en la página.
        int xOffset = (int) ((width - scaledWidth) / 2);
        int yOffset = (int) ((height - scaledHeight) / 2);

        // Se dibuja la imagen en la página utilizando el contexto gráfico 2D.
        g2d.drawImage(imagen, (int) x + xOffset, (int) y + yOffset, scaledWidth, scaledHeight, null);

        // Se indica que la página se imprimió exitosamente.
        return Printable.PAGE_EXISTS;
    }  
}
