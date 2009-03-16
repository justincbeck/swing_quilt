package com.beckproduct.quilt.frame;

import com.beckproduct.quilt.listener.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:32:23 PM
 */
public class NewFrame extends JFrame
{
    private CreateListener createListener;

    // TODO: Figure out the best way to inject the createListener rather than use a constructor-arg
    public NewFrame(CreateListener createListener)
    {
        setTitle("New");
        setName("newFrame");
        setSize(400, 600);
        Container content = this.getContentPane();
        content.setLayout(new FlowLayout());

        JPanel jButtonPanel = new JPanel(new BorderLayout());
        jButtonPanel.setPreferredSize(new Dimension(200, 100));
        jButtonPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Go!");
        jButtonPanel.setBorder(titledBorder);

        JButton go = new JButton("Go");
        go.setName("newButton");
        go.setPreferredSize(new Dimension(100, 50));
        go.addActionListener(createListener);

        jButtonPanel.add(go, BorderLayout.CENTER);

        content.add(jButtonPanel);
    }

    public CreateListener getCreateListener()
    {
        return createListener;
    }

    public void setCreateListener(CreateListener createListener)
    {
        this.createListener = createListener;
    }
}
