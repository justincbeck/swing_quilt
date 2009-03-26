package com.beckproduct.quilt.panel;

import com.beckproduct.quilt.listener.*;
import com.beckproduct.quilt.utilities.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import org.springframework.context.support.*;
import org.springframework.context.*;

// I need to add a comment so I can check something in...  I'll remove it, I promise.
public class QuiltPanel extends JPanel
{
    public static final long serialVersionUID = 1l;

    private JFrame mainFrame;

    public static void main(String[] args)
    {
        String[] contextPaths = new String[]{"conf/applicationContext.xml"};
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(contextPaths);

        QuiltPanel generator = new QuiltPanel();
        
        // Frame
        generator.mainFrame = (JFrame) applicationContext.getBean("mainFrame");

        // Run it!
        generator.start();
    }

    private void start()
    {
        WindowUtilities.setNativeLookAndFeel();
        mainFrame.setSize(750, 600);

        Container content = mainFrame.getContentPane();
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
        go.addActionListener(new GenerateListener(mainFrame));

        jButtonPanel.add(go, BorderLayout.CENTER);

        content.add(jButtonPanel);
        content.add(jDimensionPanel);
        mainFrame.addWindowListener(new ExitListener());
        mainFrame.setVisible(true);
    }

    public JFrame getMainFrame()
    {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }
}