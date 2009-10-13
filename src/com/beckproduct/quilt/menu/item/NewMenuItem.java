package com.beckproduct.quilt.menu.item;

import com.beckproduct.quilt.listener.*;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 12, 2009
 * Time: 5:09:16 PM
 */
public class NewMenuItem extends JMenuItem
{
    public void init()
    {
        this.setText("New");
        this.setName("new");
    }

    public void setActionListener(NewListener newListener)
    {
        this.addActionListener(newListener);
    }

    public NewListener getActionListener()
    {
        return (NewListener) super.getActionListeners()[0];
    }
}
