package com.beckproduct.quilt.panel;

import com.beckproduct.quilt.listener.*;
import com.beckproduct.quilt.utilities.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import org.springframework.context.support.*;
import org.springframework.context.*;

public class QuiltPanel extends JPanel
{
    public static final long serialVersionUID = 1l;

    private JMenuItem newItem;

    public static void main(String[] args)
    {
        String[] contextPaths = new String[]{"conf/applicationContext.xml"};
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(contextPaths);
        QuiltPanel generator = new QuiltPanel();
        generator.newItem = (JMenuItem) applicationContext.getBean("newItem");
        generator.start();
    }

    private void start()
    {
        WindowUtilities.setNativeLookAndFeel();
        JFrame frame = new JFrame("Sarah's quilt generator!");
        frame.setName("mainFrame");
        frame.setSize(750, 600);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setName("save");
        saveItem.addActionListener(new SaveListener());

        JMenuItem saveAsItem = new JMenuItem("Save As");
        saveAsItem.setName("saveAs");
        saveAsItem.addActionListener(new SaveAsListener());

        JMenuItem printItem = new JMenuItem("Print");
        printItem.setName("print");
        printItem.addActionListener(new PrintListener());

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(printItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);

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

    public JMenuItem getNewItem()
    {
        return newItem;
    }

    public void setNewItem(JMenuItem newItem)
    {
        this.newItem = newItem;
    }
}