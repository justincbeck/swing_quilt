package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.domain.Quilt;
import com.beckproduct.quilt.repository.IQuiltRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SaveListener implements ActionListener
{
    private JFrame frame;

    private IQuiltRepository quiltRepository;

    public SaveListener(JFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        Container content = frame.getContentPane();
        JPanel jQuiltPanel = (JPanel) content.getComponent(3);
        Quilt quilt = (Quilt) jQuiltPanel.getComponent(0);

        quiltRepository.save(quilt);
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