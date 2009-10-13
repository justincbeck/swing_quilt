package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.*;

import java.awt.event.*;


public class SaveAsListener implements ActionListener
{
    private IQuiltRepository quiltRepository;

    public void actionPerformed(ActionEvent event)
    {
        quiltRepository.save(null);
        // TODO: Write the SaveAsListner.actionPerformed(ActionEvent event) method
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