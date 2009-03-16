package com.beckproduct.quilt.listener;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:42:21 PM
 */
public class CreateListener implements ActionListener
{
    private JFrame frame;

    public CreateListener(JFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        System.out.println("Create it!");
        frame.setVisible(false);
    }
}
