package com.beckproduct.quilt.utilities;

import com.beckproduct.quilt.domain.RawImage;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public static Image getImage(RawImage rawImage)
    {
        return Toolkit.getDefaultToolkit().createImage(rawImage.getImage());
    }

    public static Image transformImage(Image rawImage, int rotation)
    {
        double angle = Math.toRadians(rotation * 90);

        GraphicsConfiguration config = getGraphicsEnvironment();

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

    public static GraphicsConfiguration getGraphicsEnvironment()
    {
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        return device.getDefaultConfiguration();
    }

    public static Image scaleImage(Image rawImage)
    {
        return rawImage.getScaledInstance(50, 50, 0);
    }

    public static Image getApplicationIconImage()
    {
        File file = new File("images/icon.gif");
        try
        {
            return ImageIO.read(file);
        }
        catch (IOException e)
        {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
