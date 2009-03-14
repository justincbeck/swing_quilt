package com.beckproduct.quilt.utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtilities
{
    public static Image performRandomRotation(Image image)
    {
        int nextInt = NumberUtilities.getRandomNumber(4);
        double angle = Math.toRadians(nextInt * 90);

        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = environment.getDefaultScreenDevice();
        GraphicsConfiguration config = device.getDefaultConfiguration();

        BufferedImage bufferedImage = ImageUtilities.toBufferedImage(config, image);

        double sin = Math.abs(Math.sin(angle));
        double cos = Math.abs(Math.cos(angle));

        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        int neww = (int) Math.floor(width * cos + height * sin);
        int newh = (int) Math.floor(height * cos + width * sin);

        BufferedImage result = config.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
        Graphics2D graphics = result.createGraphics();

        graphics.translate((neww - width) / 2, (newh - height) / 2);
        graphics.rotate(angle, width / 2, height / 2);
        graphics.drawRenderedImage(bufferedImage, null);
        graphics.dispose();

        return result;
    }

    public static BufferedImage toBufferedImage(GraphicsConfiguration config, Image image)
    {
        image = new ImageIcon(image).getImage();
        BufferedImage bufferedImage = config.createCompatibleImage(image.getWidth(null), image.getHeight(null), Transparency.OPAQUE);

        Graphics graphics = bufferedImage.createGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();

        return bufferedImage;
    }
}
