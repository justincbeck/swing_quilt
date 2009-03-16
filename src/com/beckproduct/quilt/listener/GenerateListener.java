package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.utilities.*;
import com.beckproduct.quilt.domain.*;
import org.apache.commons.lang.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class GenerateListener implements ActionListener
{
    private JFrame frame;

    private ArrayList<String> lastRow;

    private ArrayList<String> currentRow;

    private int rows = 9;

    private int cols = 13;

    public GenerateListener(JFrame frame)
    {
        this.lastRow = new ArrayList<String>();
        this.currentRow = new ArrayList<String>();
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        Container content = frame.getContentPane();

        this.setDimensions(content);

        Component[] comps = content.getComponents();

        if (comps.length == 3)
        {
            content.remove(2);
        }

        JPanel jQuiltPanel = new JPanel(new BorderLayout());
        jQuiltPanel.setName("quiltPanel");
        jQuiltPanel.setPreferredSize(new Dimension(this.cols * 50, this.rows * 50));
        jQuiltPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Your quilt Madam!");
        jQuiltPanel.setBorder(titledBorder);

        Quilt quilt = new Quilt(new GridLayout(this.rows, this.cols, 0, 0));
        for (int row = 0; row < this.rows; row++)
        {
            for (int col = 0; col < this.cols; col++)
            {
                QuiltTile tile = getNextTile(row, col);
                quilt.add(tile);
            }
        }

        jQuiltPanel.add(quilt);
        content.add(jQuiltPanel);

        frame.setContentPane(content);
    }

    private QuiltTile getNextTile(int row, int col)
    {
        String fileName = getFileName();

        if (row == 0)
        {
            while (currentRow.size() > 0 && (currentRow.get(col - 1)).equalsIgnoreCase(fileName))
            {
                fileName = getFileName();
            }
        }
        else
        {
            while (currentRow.size() > 0 && (currentRow.get(col - 1)).equalsIgnoreCase(fileName) || (lastRow.get(col)).equalsIgnoreCase(fileName))
            {
                fileName = getFileName();
            }
        }

        currentRow.add(fileName);

        if (currentRow.size() == this.cols)
        {
            lastRow = currentRow;
            currentRow = new ArrayList<String>();
        }

        return getImage(fileName);
    }

    private void setDimensions(Container content)
    {
        Component[] components = content.getComponents();

        JPanel dimensionPanel = (JPanel) components[1];
        JTextField rowsField = (JTextField) dimensionPanel.getComponents()[1];
        JTextField colsField = (JTextField) dimensionPanel.getComponents()[3];

        if (!StringUtils.isEmpty(rowsField.getText()) && !StringUtils.isEmpty(colsField.getText()))
        {
            this.rows = Integer.parseInt(rowsField.getText());
            this.cols = Integer.parseInt(colsField.getText());
        }
        else
        {
            this.rows = 9;
            this.cols = 13;
        }
    }

    private String getFileName()
    {
        String fileName = "";
        int nextInt = NumberUtilities.getRandomNumber(3);
        switch (nextInt)
        {
            case 0:
                fileName = "images/Stripe.jpg";
                break;
            case 1:
                fileName = "images/Solid.jpg";
                break;
            case 2:
                fileName = "images/Print.jpg";
                break;
        }
        return fileName;
    }

    private QuiltTile getImage(String fileName)
    {
        Image scaledImage;
        int rotation;

        FileInputStream fis;

        try
        {
            fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch;
            while ((ch = bis.read()) != -1)
            {
                baos.write(ch);
            }

            rotation = NumberUtilities.getRandomNumber(4);

            Image originalImage = Toolkit.getDefaultToolkit().createImage(baos.toByteArray());
            Image rotatedImage = ImageUtilities.performRotation(originalImage, rotation);
            scaledImage = rotatedImage.getScaledInstance(50, 50, 0);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("I cannot find the file: " + fileName);
            return null;
        }
        catch (IOException ioe)
        {
            System.err.println("Error reading file: " + fileName);
            return null;
        }
        
        return new QuiltTile(new ImageIcon(scaledImage), fileName, rotation);
    }
}