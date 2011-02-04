package com.beckproduct.quilt.menu.item;

import com.beckproduct.quilt.listener.PrintListener;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 11:26:47 AM
 */
public class PrintMenuItem extends JMenuItem
{
    public void init()
    {
        this.setText("Print");
        this.setName("print");
    }

    public void setActionListener(PrintListener printListener)
    {
        this.addActionListener(printListener);
    }

    public PrintListener getActionListener()
    {
        return (PrintListener) super.getActionListeners()[0];
    }
}