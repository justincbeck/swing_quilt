package com.beckproduct.quilt.listener;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.beckproduct.quilt.utilities.ImageUtilities;
import com.beckproduct.quilt.utilities.NumberUtilities;

public class GenerateListener implements ActionListener
{
    private JFrame frame;

    private ArrayList lastRow;

    private ArrayList currentRow;

    public GenerateListener(JFrame frame)
    {
        this.lastRow = new ArrayList();
        this.currentRow = new ArrayList();
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        Container content = frame.getContentPane();
        Component[] comps = content.getComponents();

        if (comps.length == 2) {
            content.remove(1);
        }

        JPanel jQuiltPanel = new JPanel(new BorderLayout());
        jQuiltPanel.setName("quiltPanel");
        jQuiltPanel.setPreferredSize(new Dimension(670, 450));
        jQuiltPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Your quilt Madam!");
        jQuiltPanel.setBorder(titledBorder);

        JPanel quilt = new JPanel(new GridLayout(9, 13));
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 13; col++) {
                Component tile = getNextTile(row, col);
                quilt.add(tile);
            }
        }

        jQuiltPanel.add(quilt);
        content.add(jQuiltPanel);

        frame.setContentPane(content);
    }

    private Component getNextTile(int row, int col)
    {
        String fileName = getFileName();
        if (row == 0) {
            while (currentRow.size() > 0 && ((String) currentRow.get(col - 1)).equalsIgnoreCase(fileName)) {
                fileName = getFileName();
            }
        }
        else {
            while (currentRow.size() > 0 && ((String) currentRow.get(col - 1)).equalsIgnoreCase(fileName) || ((String) lastRow.get(col)).equalsIgnoreCase(fileName)) {
                fileName = getFileName();
            }
        }
        currentRow.add(fileName);
        if (currentRow.size() == 13) {
            lastRow = currentRow;
            currentRow = new ArrayList();
        }

        Image scaledImage = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int ch;
            while ((ch = bis.read()) != -1) {
                baos.write(ch);
            }
            Image originalImage = Toolkit.getDefaultToolkit().createImage(baos.toByteArray());
            scaledImage = ImageUtilities.performRandomRotation(originalImage).getScaledInstance(50, 50, 0);
        } catch (FileNotFoundException e) {
            System.out.println("I cannot find the file: " + fileName);
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + fileName);
        }
        Icon icon = new ImageIcon(scaledImage);
        JLabel tile = new JLabel(icon);
        return tile;
    }

    private String getFileName()
    {
        String fileName = "";
        int nextInt = Integer.parseInt(NumberUtilities.getRandomNumber("012"));
        switch (nextInt) {
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
}