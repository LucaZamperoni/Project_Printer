package utn.arquitectura.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePrintable implements Printable {
    private BufferedImage imagen;
    
    public ImagePrintable(File archivo) throws IOException, Exception{
        this.imagen = ImageIO.read(archivo);
        if (this.imagen == null) {
            throw new Exception();
        }
    }
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();
        double width = pageFormat.getImageableWidth();
        double height = pageFormat.getImageableHeight();

        // Scale the image to fit within the page boundaries
        double scaleX = width / imagen.getWidth();
        double scaleY = height / imagen.getHeight();
        double scale = Math.min(scaleX, scaleY);

        int scaledWidth = (int) (imagen.getWidth() * scale);
        int scaledHeight = (int) (imagen.getHeight() * scale);

        // Calculate the centered position of the image on the page
        int xOffset = (int) ((width - scaledWidth) / 2);
        int yOffset = (int) ((height - scaledHeight) / 2);

        // Draw the image on the page
        g2d.drawImage(imagen, (int) x + xOffset, (int) y + yOffset, scaledWidth, scaledHeight, null);

        return PAGE_EXISTS;
    }
    
}
