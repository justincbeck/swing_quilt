package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.*;

import java.awt.event.*;


public class SaveListener implements ActionListener
{
    private IQuiltRepository quiltRepository;

    public void actionPerformed(ActionEvent event)
    {
        quiltRepository.update(null);
        // TODO: Write the SaveListner.actionPerformed(ActionEvent event) method
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