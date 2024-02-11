package boottapak.jakgrit.lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*  This program is "ReadImage" that extends "JPanel"
 *  It used for reading image
 *  by paintComponent method
 *  
 *  if it can read image, it will show image when call this class.
 *  but if it can't read image, it will show error.
 * 
 *  if image is null, Dimension will be Width:100, Height:100
 *  and if image isn't null, Dimension will be image size.
 *  
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class ReadImage extends JPanel {
    public BufferedImage img;

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public ReadImage(String imagePath) {
        try {
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public Dimension getPreferredSize() {
        if (img == null)
            return new Dimension(100, 100);
        else
            return new Dimension(img.getWidth(), img.getHeight());
    }
}
