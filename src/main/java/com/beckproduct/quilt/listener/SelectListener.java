package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.domain.Quilt;
import com.beckproduct.quilt.domain.QuiltTile;
import com.beckproduct.quilt.repository.IQuiltRepository;
import com.beckproduct.quilt.utilities.ImageUtilities;
import com.beckproduct.quilt.utilities.QuiltUtilities;
import com.beckproduct.quilt.utilities.TileUtilities;
import com.beckproduct.quilt.utilities.WindowUtilities;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectListener implements ActionListener
{
    private JFrame mainFrame;

    private IQuiltRepository quiltRepository;

    public SelectListener(JFrame mainFrame, IQuiltRepository quiltRepository)
    {
        this.mainFrame = mainFrame;
        this.quiltRepository = quiltRepository;
    }

    public void actionPerformed(ActionEvent event)
    {
        Quilt quilt = (Quilt) quiltRepository.getInstanceByName(getSelection(event));
        quilt.setLayoutManager(new GridLayout(quilt.getRows(), quilt.getCols(), 0, 0));

        ArrayList<String> names = new ArrayList<String>();

        for (QuiltTile quiltTile : quilt.getTiles())
        {
            Image image = ImageUtilities.getImage(quiltTile.getImage());
            Image scaledImage = ImageUtilities.scaleImage(image);
            Image rotatedImage = ImageUtilities.transformImage(scaledImage, quiltTile.getRotation());

            QuiltTile tile = TileUtilities.createTile(rotatedImage, quiltTile.getRotation());
            quilt.addComponent(tile);

            names.add(quiltTile.getImage().getName());
        }

        Container content = mainFrame.getContentPane();
        mainFrame = QuiltUtilities.removeCurrentQuilt(mainFrame);
        
        JPanel jQuiltPanel = new JPanel(new BorderLayout());
        jQuiltPanel.setName("quiltPanel");
        jQuiltPanel.setPreferredSize(new Dimension(quilt.getCols() * 50, quilt.getRows() * 50));
        jQuiltPanel.setVisible(true);

        Border border = BorderFactory.createEtchedBorder();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Your quilt Madam!");
        jQuiltPanel.setBorder(titledBorder);

        jQuiltPanel.add(quilt, 0);
        content.add(jQuiltPanel);
        Component[] components = content.getComponents();

        JPanel dimensionPanel = (JPanel) components[1];
        JTextField nameField = (JTextField) dimensionPanel.getComponents()[1];
        JTextField rowsField = (JTextField) dimensionPanel.getComponents()[3];
        JTextField colsField = (JTextField) dimensionPanel.getComponents()[5];
        nameField.setText(quilt.getName());
        rowsField.setText(String.valueOf(quilt.getRows()));
        colsField.setText(String.valueOf(quilt.getCols()));

        JList list = WindowUtilities.getJList(mainFrame);
        DefaultListModel model = (DefaultListModel) list.getModel();
        int[] indices = new int[names.size()];

        for (int i = 0; i < names.size(); i++) indices[i] = model.indexOf(names.get(i));

        list.setSelectedIndices(indices);
        mainFrame.setContentPane(content);
    }

    private String getSelection(ActionEvent event)
    {
        JButton source = (JButton) event.getSource();
        JPanel panel = (JPanel) source.getParent();
        JPanel frame = (JPanel) panel.getParent();
        JFrame root = (JFrame) frame.getRootPane().getParent();
        root.dispose();
        
        Component[] comps = frame.getComponents();
        JComboBox cb = (JComboBox) comps[1];
        return (String) cb.getSelectedItem();
    }

    public IQuiltRepository getQuiltRepository()
    {
        return quiltRepository;
    }

    public void setQuiltRepository(IQuiltRepository quiltRepository)
    {
        this.quiltRepository = quiltRepository;
    }
}