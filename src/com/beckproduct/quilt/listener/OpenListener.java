package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.repository.*;
import com.beckproduct.quilt.domain.*;
import com.beckproduct.quilt.utilities.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

import org.apache.commons.lang.*;


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

        for (QuiltTile quiltTile : quilt.getTiles())
        {
            Image image = ImageUtilities.getImage(quiltTile.getFileName());
            Image scaledImage = ImageUtilities.scaleImage(image);
            Image rotatedImage = ImageUtilities.rotateImage(scaledImage, rotation);

            QuiltTile tile = TileUtilities.createTile(rotatedImage, quiltTile.getFileName(), rotation);
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
        Component[] components = content.getComponents();

        JPanel dimensionPanel = (JPanel) components[1];
        JTextField nameField = (JTextField) dimensionPanel.getComponents()[1];
        JTextField rowsField = (JTextField) dimensionPanel.getComponents()[3];
        JTextField colsField = (JTextField) dimensionPanel.getComponents()[5];
        nameField.setText(quilt.getName());
        rowsField.setText(String.valueOf(quilt.getRows()));
        colsField.setText(String.valueOf(quilt.getCols()));

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