package com.beckproduct.quilt.menu;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 2:33:02 PM
 */
public class MainMenuBar extends JMenuBar
{
    public void setFileMenu(FileMenu fileMenu)
    {
        super.add(fileMenu);
    }
}
