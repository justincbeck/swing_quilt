package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.IQuiltRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:42:21 PM
 */
public class OpenListener implements ActionListener
{
    private JFrame openFrame;

    private IQuiltRepository quiltRepository;

    public void actionPerformed(ActionEvent event)
    {
        List quilts = quiltRepository.list();

        JComboBox quiltCombo = new JComboBox(quilts.toArray());

        if (openFrame.getContentPane().getComponents().length == 2)
        {
            openFrame.getContentPane().remove(1);
        }
        openFrame.getContentPane().add(quiltCombo);
        openFrame.setVisible(true);
    }

    public JFrame getOpenFrame()
    {
        return openFrame;
    }

    public void setOpenFrame(JFrame openFrame)
    {
        this.openFrame = openFrame;
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
