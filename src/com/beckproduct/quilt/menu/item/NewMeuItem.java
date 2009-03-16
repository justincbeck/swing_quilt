package com.beckproduct.quilt.menu.item;

import com.beckproduct.quilt.listener.*;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 11:26:47 AM
 */
public class NewMeuItem extends JMenuItem
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
