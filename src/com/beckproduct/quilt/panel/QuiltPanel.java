package com.beckproduct.quilt.panel;

import com.beckproduct.quilt.listener.ExitListener;
import com.beckproduct.quilt.listener.GenerateListener;
import com.beckproduct.quilt.listener.PrintListener;
import com.beckproduct.quilt.utilities.WindowUtilities;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QuiltPanel extends JPanel
{

    public static final long serialVersionUID = 1l;

    public static void main(String[] args)
    {
        QuiltPanel generator = new QuiltPanel();
        generator.start();
    }

    private void start()
    {
        WindowUtilities.setNativeLookAndFeel();
        JFrame frame = new JFrame("Sarah's quilt generator!");
        frame.setName("mainFrame");
        frame.setSize(750, 600);

        JMenuItem menuItem = new JMenuItem("Print");
        menuItem.addActionListener(new PrintListener());

        JMenu menu = new JMenu();
        menu.add(menuItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);

        Container content = frame.getContentPane();
        content.setLayout(new FlowLayout());

        JLabel rowsLabel = new JLabel();
        rowsLabel.setText("Row count:");
        rowsLabel.setVisible(true);

        JTextField rowsText = new JTextField(3);
        rowsText.setName("rowsText");
        rowsLabel.setVisible(true);

        JLabel colsLabel = new JLabel();
        colsLabel.setText("Column count:");
        rowsLabel.setVisible(true);

        JTextField colsText = new JTextField(3);
        colsText.setName("colsText");
        rowsLabel.setVisible(true);

        JPanel jDimensionPanel = new JPanel(new GridLayout(2, 2));
        jDimensionPanel.add(rowsLabel);
        jDimensionPanel.add(rowsText);
        jDimensionPanel.add(colsLabel);
        jDimensionPanel.add(colsText);

        JPanel jButtonPanel = new JPanel(new BorderLayout());
        jButtonPanel.setPreferredSize(new Dimension(180, 90));
        jButtonPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Click to Generate!");
        jButtonPanel.setBorder(titledBorder);

        JButton go = new JButton("Generate");
        go.setName("generateButton");
        go.setPreferredSize(new Dimension(100, 50));
        go.addActionListener(new GenerateListener(frame));

        jButtonPanel.add(go, BorderLayout.CENTER);

        content.add(jButtonPanel);
        content.add(jDimensionPanel);
        frame.addWindowListener(new ExitListener());
        frame.setVisible(true);
    }
}