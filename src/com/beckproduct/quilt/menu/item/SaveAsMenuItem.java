package com.beckproduct.quilt.menu.item;

import com.beckproduct.quilt.listener.SaveAsListener;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 11:26:47 AM
 */
public class SaveAsMenuItem extends JMenuItem
{
    public void init()
    {
        this.setText("Save As...");
        this.setName("saveAs");
    }

    public void setActionListener(SaveAsListener saveAsListener)
    {
        this.addActionListener(saveAsListener);
    }

    public SaveAsListener getActionListener()
    {
        return (SaveAsListener) super.getActionListeners()[0];
    }
}