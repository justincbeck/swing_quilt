package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.frame.*;
import com.beckproduct.quilt.repository.*;

import java.awt.event.*;

public class NewListener implements ActionListener
{
    private ITileRepository tileRepository;

    public void actionPerformed(ActionEvent event)
    {
        NewFrame frame = new NewFrame("New");
        frame.setVisible(true);

        tileRepository.test();
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