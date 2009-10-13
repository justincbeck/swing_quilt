package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.utilities.*;
import com.beckproduct.quilt.domain.*;
import org.apache.log4j.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GenerateListener implements ActionListener
{
    static Logger logger = Logger.getLogger(GenerateListener.class);

    private JFrame frame;

    private ArrayList<String> lastRow;

    private ArrayList<String> currentRow;

    public GenerateListener(JFrame frame)
    {
        this.lastRow = new ArrayList<String>();
        this.currentRow = new ArrayList<String>();
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        Container content = frame.getContentPane();
        frame = (JFrame) QuiltUtilities.removeCurrentQuilt(frame);

        int rows = QuiltUtilities.getRows(content);
        int cols = QuiltUtilities.getCols(content);

        JPanel jQuiltPanel = new JPanel(new BorderLayout());
        jQuiltPanel.setName("quiltPanel");
        jQuiltPanel.setPreferredSize(new Dimension(cols * 50, rows * 50));
        jQuiltPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Your quilt Madam!");
        jQuiltPanel.setBorder(titledBorder);

        Quilt quilt = new Quilt(cols, rows);
        quilt.setLayoutManager(new GridLayout(quilt.getRows(), quilt.getCols(), 0, 0));
        
        for (int row = 0; row < quilt.getRows(); row++)
        {
            for (int col = 0; col < quilt.getCols(); col++)
            {
                String fileName = TileUtilities.getFileName();

                if (row == 0)
                {
                    while (currentRow.size() > 0 && (currentRow.get(col - 1)).equalsIgnoreCase(fileName))
                    {
                        fileName = TileUtilities.getFileName();
                    }
                }
                else
                {
                    while (currentRow.size() > 0 && (currentRow.get(col - 1)).equalsIgnoreCase(fileName) || (lastRow.get(col)).equalsIgnoreCase(fileName))
                    {
                        fileName = TileUtilities.getFileName();
                    }
                }

                currentRow.add(fileName);

                if (currentRow.size() == cols)
                {
                    lastRow = currentRow;
                    currentRow = new ArrayList<String>();
                }

                int rotation = NumberUtilities.getRandomNumber(3);

                Image image = ImageUtilities.getImage(fileName);
                Image scaledImage = ImageUtilities.scaleImage(image);
                Image rotatedImage = ImageUtilities.rotateImage(scaledImage, rotation);

                QuiltTile tile = TileUtilities.createTile(rotatedImage, fileName, rotation);
                quilt.addComponent(tile);
                quilt.addTile(tile);
            }
        }

        jQuiltPanel.add(quilt);
        content.add(jQuiltPanel);

        frame.setContentPane(content);
    }
}