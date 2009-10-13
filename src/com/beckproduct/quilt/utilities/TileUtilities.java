package com.beckproduct.quilt.utilities;

import com.beckproduct.quilt.domain.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 12, 2009
 * Time: 1:05:59 PM
 */
public class TileUtilities
{
    public static String getFileName()
    {
        String fileName = "";
        int nextInt = NumberUtilities.getRandomNumber(3);
        switch (nextInt)
        {
            case 0:
                fileName = "images/Stripe.jpg";
                break;
            case 1:
                fileName = "images/Solid.jpg";
                break;
            case 2:
                fileName = "images/Print.jpg";
                break;
        }
        return fileName;
    }

    public static QuiltTile createTile(Image image, String fileName, int rotation)
    {
        QuiltTile tile = new QuiltTile();
        tile.setIcon(new ImageIcon(image));
        tile.setFileName(fileName);
        tile.setRotation(rotation);

        return tile;
    }

}
