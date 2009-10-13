package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.*;
import com.beckproduct.quilt.domain.*;
import com.beckproduct.quilt.utilities.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class OpenListener implements ActionListener
{
    private JFrame frame;

    private IQuiltRepository quiltRepository;

    public OpenListener(JFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        // TODO: Temporarily writing this to get the quilt with id of 1
        // will add a dialog to select the quilt by name later.

        Quilt quilt = (Quilt) quiltRepository.getInstance(1l);
        quilt.setLayoutManager(new GridLayout(quilt.getRows(), quilt.getCols(), 0, 0));

        int rotation = NumberUtilities.getRandomNumber(3);

        ListIterator<QuiltTile> tileIterator = quilt.getTiles().listIterator();
        while (tileIterator.hasNext())
        {
            QuiltTile t = tileIterator.next();

            Image image = ImageUtilities.getImage(t.getFileName());
            Image scaledImage = ImageUtilities.scaleImage(image);
            Image rotatedImage = ImageUtilities.rotateImage(scaledImage, rotation);

            QuiltTile tile = TileUtilities.createTile(rotatedImage, t.getFileName(), rotation);
            quilt.addComponent(tile);
        }

        Container content = frame.getContentPane();
        frame = (JFrame) QuiltUtilities.removeCurrentQuilt(frame);
        
        JPanel jQuiltPanel = new JPanel(new BorderLayout());
        jQuiltPanel.setName("quiltPanel");
        jQuiltPanel.setPreferredSize(new Dimension(quilt.getCols() * 50, quilt.getRows() * 50));
        jQuiltPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Your quilt Madam!");
        jQuiltPanel.setBorder(titledBorder);

        jQuiltPanel.add(quilt, 0);
        content.add(jQuiltPanel);

        frame.setContentPane(content);
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