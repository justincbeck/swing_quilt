package com.beckproduct.quilt.frame;

import com.beckproduct.quilt.menu.MainMenuBar;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 2:38:37 PM
 */
public class MainFrame extends JFrame
{
    public MainFrame(String title, String name)
    {
        super.setTitle(title);
        super.setName(name);
    }

    public void setMainMenuBar(MainMenuBar mainMenuBar)
    {
        super.setJMenuBar(mainMenuBar);
    }
}
