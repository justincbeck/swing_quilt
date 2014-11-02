package com.beckproduct.quilt.menu.item;

import com.beckproduct.quilt.listener.SaveListener;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 11:26:47 AM
 */
public class SaveMenuItem extends JMenuItem
{
    public void init()
    {
        this.setText("Save");
        this.setName("save");
    }

    public void setActionListener(SaveListener saveListener)
    {
        this.addActionListener(saveListener);
    }

    public SaveListener getActionListener()
    {
        return (SaveListener) super.getActionListeners()[0];
    }
}