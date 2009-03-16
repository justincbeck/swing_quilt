package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.*;

import java.awt.event.*;


public class OpenListener implements ActionListener
{
    private ITileRepository tileRepository;

    public void actionPerformed(ActionEvent event)
    {
        tileRepository.getInstance(null);
        // TODO: Write the OpenListner.actionPerformed(ActionEvent event) method
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