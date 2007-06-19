package com.beckproduct.quilt.panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.beckproduct.quilt.listener.ExitListener;
import com.beckproduct.quilt.listener.GenerateListener;
import com.beckproduct.quilt.listener.PrintListener;
import com.beckproduct.quilt.utilities.WindowUtilities;

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
        frame.addWindowListener(new ExitListener());
        frame.setVisible(true);
    }
}