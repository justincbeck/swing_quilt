package com.beckproduct.quilt.frame;

import com.beckproduct.quilt.listener.SelectListener;
import com.beckproduct.quilt.repository.IQuiltRepository;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:32:23 PM
 */
public class OpenFrame extends JFrame
{
    public OpenFrame(String title, JFrame mainFrame, IQuiltRepository quiltRepository)
    {
        super(title);

        setName("openFrame");
        setSize(400, 300);
        Container content = this.getContentPane();
        content.setLayout(new FlowLayout());

        JButton selectButton = new JButton();
        selectButton.setText("Open");
        selectButton.addActionListener(new SelectListener(mainFrame, quiltRepository));

        JPanel jButtonPanel = new JPanel(new BorderLayout());
        jButtonPanel.setPreferredSize(new Dimension(100, 50));
        jButtonPanel.add(selectButton);
        jButtonPanel.setVisible(true);

        content.add(jButtonPanel);
    }
}