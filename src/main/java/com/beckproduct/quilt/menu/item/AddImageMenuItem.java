package com.beckproduct.quilt.menu.item;

import com.beckproduct.quilt.listener.AddImageListener;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 13, 2009
 * Time: 2:44:06 PM
 */
public class AddImageMenuItem extends JMenuItem
{
    public void init()
    {
        this.setText("Add Image");
        this.setName("addImage");
    }

    public void setActionListener(AddImageListener addImageListener)
    {
        this.addActionListener(addImageListener);
    }

    public AddImageListener getActionListener()
    {
        return (AddImageListener) super.getActionListeners()[0];
    }
}
