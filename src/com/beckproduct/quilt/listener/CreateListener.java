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
    private IQuiltRepository quiltRepository;

    public void actionPerformed(ActionEvent event)
    {
        quiltRepository.create(null);

        // TODO: Find out the best way to close the new Quilt window
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
