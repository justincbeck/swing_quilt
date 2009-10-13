package com.beckproduct.quilt.utilities;

import com.beckproduct.quilt.domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import org.apache.log4j.*;

public class ImageUtilities
{
    static Logger logger = Logger.getLogger(ImageUtilities.class);

    public static BufferedImage toBufferedImage(GraphicsConfiguration config, Image image)
    {
        image = new ImageIcon(image).getImage();
        BufferedImage bufferedImage = config.createCompatibleImage(image.getWidth(null), image.getHeight(null), Transparency.OPAQUE);

        Graphics graphics = bufferedImage.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();

        return bufferedImage;
    }

    public static Image getImage(String fileName)
    {
        Image originalImage;
        FileInputStream fis;

        try
        {
            fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch;
            while ((ch = bis.read()) != -1)
            {
                baos.write(ch);
            }

            originalImage = Toolkit.getDefaultToolkit().createImage(baos.toByteArray());
        }
        catch (FileNotFoundException e)
        {
            logger.error("I cannot find the file: " + fileName);
            return null;
        }
        catch (IOException ioe)
        {
            logger.error("Error reading file: " + fileName);
            return null;
        }

        return originalImage;
    }

    public static Image rotateImage(Image rawImage, int rotation)
    {
        double angle = Math.toRadians(rotation * 90);

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        GraphicsConfiguration config = device.getDefaultConfiguration();

        BufferedImage bufferedImage = ImageUtilities.toBufferedImage(config, rawImage);

        double sin = Math.abs(Math.sin(angle));
        double cos = Math.abs(Math.cos(angle));

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        int neww = (int) Math.floor(width * cos + height * sin);
        int newh = (int) Math.floor(height * cos + width * sin);

        BufferedImage image = config.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D graphics = image.createGraphics();

        graphics.translate((neww - width) / 2, (newh - height) / 2);
        graphics.rotate(angle, width / 2, height / 2);
        graphics.drawRenderedImage(bufferedImage, null);
        graphics.dispose();

        return image;
    }

    public static Image scaleImage(Image rawImage)
    {
        return rawImage.getScaledInstance(50, 50, 0);
    }
}
