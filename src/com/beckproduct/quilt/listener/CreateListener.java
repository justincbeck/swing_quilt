package com.beckproduct.quilt.listener;

import java.awt.event.*;
import java.awt.*;

import com.beckproduct.quilt.repository.*;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:42:21 PM
 */
public class CreateListener implements ActionListener
{
    private ITileRepository tileRepository;

    public void actionPerformed(ActionEvent event)
    {
        tileRepository.create(null);

        // TODO: Find out the best way to close the new Quilt window
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
