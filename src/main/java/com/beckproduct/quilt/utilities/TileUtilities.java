package com.beckproduct.quilt.utilities;

import com.beckproduct.quilt.domain.QuiltTile;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 12, 2009
 * Time: 1:05:59 PM
 */
public class TileUtilities
{
    public static String getFileName(Object[] list)
    {
        int nextInt = NumberUtilities.getRandomNumber(list.length);
        return (String) list[nextInt];
    }

    public static QuiltTile createTile(Image image, int rotation)
    {
        QuiltTile tile = new QuiltTile();
        tile.setIcon(new ImageIcon(image));
        tile.setRotation(rotation);

        return tile;
    }

}
