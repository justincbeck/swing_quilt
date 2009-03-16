package com.beckproduct.quilt.menu;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 2:17:11 PM
 */
public class FileMenu extends JMenu
{
    public void init()
    {
        this.setText("File");
    }

    public void setNewMenuItem(JMenuItem newMenuItem)
    {
        super.add(newMenuItem);
    }

    public void setOpenMenuItem(JMenuItem openMenuItem)
    {
        super.add(openMenuItem);
    }

    public void setSaveMenuItem(JMenuItem saveMenuItem)
    {
        super.add(saveMenuItem);
    }

    public void setSaveAsMenuItem(JMenuItem saveAsMenuItem)
    {
        super.add(saveAsMenuItem);
    }

    public void setPrintMenuItem(JMenuItem printMenuItem)
    {
        super.add(printMenuItem);
    }
}
