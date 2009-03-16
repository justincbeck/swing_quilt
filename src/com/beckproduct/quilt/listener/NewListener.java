package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.frame.*;

import java.awt.event.*;

public class NewListener implements ActionListener
{
    private NewFrame frame;

    public void actionPerformed(ActionEvent event)
    {
        frame.setVisible(true);
    }

    public NewFrame getFrame()
    {
        return frame;
    }

    public void setFrame(NewFrame frame)
    {
        this.frame = frame;
    }
}