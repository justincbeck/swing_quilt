package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.*;

import java.awt.event.*;


public class OpenListener implements ActionListener
{
    private IQuiltRepository quiltRepository;

    public void actionPerformed(ActionEvent event)
    {
        quiltRepository.getInstance(null);
        // TODO: Write the OpenListner.actionPerformed(ActionEvent event) method
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