package com.beckproduct.quilt.menu;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 13, 2009
 * Time: 4:08:49 PM
 */
public class ImageMenu extends JMenu
{
    public void init()
    {
        this.setText("Image");
    }

    public void setAddImageMenuItem(JMenuItem addImageMenuItem)
    {
        super.add(addImageMenuItem);
    }
}
