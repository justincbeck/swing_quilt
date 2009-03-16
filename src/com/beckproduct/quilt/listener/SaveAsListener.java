package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.*;

import java.awt.event.*;


public class SaveAsListener implements ActionListener
{
    private ITileRepository tileRepository;

    public void actionPerformed(ActionEvent event)
    {
        tileRepository.update(null);
        // TODO: Write the SaveingAsListner.actionPerformed(ActionEvent event) method
    }

    public ITileRepository getTileRepository()
    {
        return tileRepository;
    }

    public void setTileRepository(ITileRepository tileRepository)
    {
        this.tileRepository = tileRepository;
    }
}