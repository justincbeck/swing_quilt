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

    private JMenuItem newMenuItem;

    private JMenuItem openMenuItem;

    private JMenuItem saveMenuItem;

    private JMenuItem saveAsMenuItem;

    private JMenuItem printMenuItem;

    public static void main(String[] args)
    {
        String[] contextPaths = new String[]{"conf/applicationContext.xml"};
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(contextPaths);
        QuiltPanel generator = new QuiltPanel();
        generator.newMenuItem = (JMenuItem) applicationContext.getBean("newMenuItem");
        generator.openMenuItem = (JMenuItem) applicationContext.getBean("openMenuItem");
        generator.saveMenuItem = (JMenuItem) applicationContext.getBean("saveMenuItem");
        generator.saveAsMenuItem = (JMenuItem) applicationContext.getBean("saveAsMenuItem");
        generator.printMenuItem = (JMenuItem) applicationContext.getBean("printMenuItem");
        generator.start();
    }

    private void start()
    {
        WindowUtilities.setNativeLookAndFeel();
        JFrame frame = new JFrame("Sarah's quilt generator!");
        frame.setName("mainFrame");
        frame.setSize(750, 600);

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(printMenuItem);

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

    public JMenuItem getNewMenuItem()
    {
        return newMenuItem;
    }

    public void setNewItem(JMenuItem newMenuItem)
    {
        this.newMenuItem = newMenuItem;
    }

    public JMenuItem getOpenMenuItem()
    {
        return openMenuItem;
    }

    public void setOpenMenuItem(JMenuItem openMenuItem)
    {
        this.openMenuItem = openMenuItem;
    }

    public JMenuItem getSaveMenuItem()
    {
        return saveMenuItem;
    }

    public void setSaveMenuItem(JMenuItem saveMenuItem)
    {
        this.saveMenuItem = saveMenuItem;
    }

    public JMenuItem getSaveAsMenuItem()
    {
        return saveAsMenuItem;
    }

    public void setSaveAsMenuItem(JMenuItem saveAsMenuItem)
    {
        this.saveAsMenuItem = saveAsMenuItem;
    }

    public JMenuItem getPrintMenuItem()
    {
        return printMenuItem;
    }

    public void setPrintMenuItem(JMenuItem printMenuItem)
    {
        this.printMenuItem = printMenuItem;
    }
}