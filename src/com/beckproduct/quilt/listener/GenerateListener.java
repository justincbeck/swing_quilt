package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.utilities.*;
import com.beckproduct.quilt.domain.*;
import com.beckproduct.quilt.repository.*;
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

    private int cols;

    private Object[] list;

    private ArrayList<String> lastRow;

    private ArrayList<String> currentRow;

    private IImageRepository imageRepository;

    public GenerateListener(IImageRepository imageRepository, JFrame frame)
    {
        this.lastRow = new ArrayList<String>();
        this.currentRow = new ArrayList<String>();
        this.frame = frame;
        this.imageRepository = imageRepository;
    }

    public void actionPerformed(ActionEvent event)
    {
        Container content = frame.getContentPane();
        frame = (JFrame) QuiltUtilities.removeCurrentQuilt(frame);

        String name = QuiltUtilities.getName(content);
        int rows = QuiltUtilities.getRows(content);
        cols = QuiltUtilities.getCols(content);

        JPanel jQuiltPanel = new JPanel(new BorderLayout());
        jQuiltPanel.setName("quiltPanel");
        jQuiltPanel.setPreferredSize(new Dimension(cols * 50, rows * 50));
        jQuiltPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Your quilt Madam!");
        jQuiltPanel.setBorder(titledBorder);

        Quilt quilt = new Quilt(name, cols, rows);
        quilt.setLayoutManager(new GridLayout(quilt.getRows(), quilt.getCols(), 0, 0));

        list = getImageList(frame);

        for (int row = 0; row < quilt.getRows(); row++)
        {
            for (int col = 0; col < quilt.getCols(); col++)
            {
                String fileName = getFileName(row, col);
                RawImage rawImage = imageRepository.getInstanceByName(fileName);

                int rotation = NumberUtilities.getRandomNumber(3);

                Image image = ImageUtilities.getImage(rawImage);
                Image scaledImage = ImageUtilities.scaleImage(image);
                Image rotatedImage = ImageUtilities.transformImage(scaledImage, rotation);

                QuiltTile tile = TileUtilities.createTile(rotatedImage, rotation);
                tile.setImage(rawImage);
                quilt.addComponent(tile);
                quilt.addTile(tile);
            }
        }

        jQuiltPanel.add(quilt);
        content.add(jQuiltPanel);

        frame.setContentPane(content);
    }

    private Object[] getImageList(JFrame frame)
    {
        Component[] comps = frame.getContentPane().getComponents();
        JPanel panel = (JPanel) comps[2];
        JScrollPane scrollPane = (JScrollPane) panel.getComponents()[0];
        JViewport viewPort = (JViewport) scrollPane.getComponents()[0];
        JList list = (JList) viewPort.getComponents()[0];

        return list.getSelectedValues();
    }

    private String getFileName(int row, int col)
    {
        String fileName = TileUtilities.getFileName(list);

        if (row == 0)
        {
            while (currentRow.size() > 0 && (currentRow.get(col - 1)).equalsIgnoreCase(fileName))
            {
                fileName = TileUtilities.getFileName(list);
            }
        }
        else
        {
            while (currentRow.size() > 0 && (currentRow.get(col - 1)).equalsIgnoreCase(fileName) || (lastRow.get(col)).equalsIgnoreCase(fileName))
            {
                fileName = TileUtilities.getFileName(list);
            }
        }

        currentRow.add(fileName);

        if (currentRow.size() == cols)
        {
            lastRow = currentRow;
            currentRow = new ArrayList<String>();
        }

        return fileName;
    }
}