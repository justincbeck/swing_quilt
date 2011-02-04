package com.beckproduct.quilt.menu.item;

import com.beckproduct.quilt.listener.OpenListener;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 11:26:47 AM
 */
public class OpenMenuItem extends JMenuItem
{
    public void init()
    {
        this.setText("Open");
        this.setName("open");
    }

    public void setActionListener(OpenListener openListener)
    {
        this.addActionListener(openListener);
    }

    public OpenListener getActionListener()
    {
        return (OpenListener) super.getActionListeners()[0];
    }
}