package com.beckproduct.quilt.listener;

import java.awt.event.*;

import com.beckproduct.quilt.repository.*;
import com.beckproduct.quilt.utilities.*;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:42:21 PM
 */
public class NewListener implements ActionListener
{
    private JFrame frame;

    private IQuiltRepository quiltRepository;

    public NewListener(JFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        frame = (JFrame) QuiltUtilities.removeCurrentQuilt(frame);
    }

    public IQuiltRepository getQuiltRepository()
    {
        return quiltRepository;
    }

    public void setQuiltRepository(IQuiltRepository quiltRepository)
    {
        this.quiltRepository = quiltRepository;
    }
}
