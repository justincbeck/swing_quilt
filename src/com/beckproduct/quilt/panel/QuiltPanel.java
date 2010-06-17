package com.beckproduct.quilt.panel;

import com.beckproduct.quilt.listener.*;
import com.beckproduct.quilt.utilities.*;
import com.beckproduct.quilt.repository.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

import org.springframework.context.support.*;
import org.springframework.context.*;
import org.apache.log4j.*;

public class QuiltPanel extends JPanel
{
    public static final long serialVersionUID = 1l;

    static Logger logger = Logger.getLogger(QuiltPanel.class);

    private JFrame mainFrame;

    private IImageRepository imageRepository;

    public QuiltPanel(String name)
    {
        super.setName(name);
    }

    public static void main(String[] args)
    {
        PropertyConfigurator.configure("conf/log4j.conf");

        WindowUtilities.setNativeLookAndFeel();

        String[] contextPaths = new String[]{"conf/applicationContext.xml"};
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(contextPaths);

        QuiltPanel generator = new QuiltPanel("Quilt Generator");
        generator.mainFrame = (JFrame) applicationContext.getBean("mainFrame");
        generator.imageRepository = (IImageRepository) applicationContext.getBean("imageRepository");

        generator.start();
    }

    private void start()
    {
        mainFrame.setSize(750, 600);
        mainFrame.setIconImage(ImageUtilities.getApplicationIconImage());

        Container content = mainFrame.getContentPane();
        content.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name:");
        nameLabel.setVisible(true);

        JTextField nameText = new JTextField(8);
        nameText.setName("nameText");
        nameLabel.setVisible(true);

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

        DefaultListModel listModel = new DefaultListModel();
        Object[] imageNames = imageRepository.list().toArray();
        for (Object o : imageNames) listModel.addElement(o);
        JList list = new JList(listModel);
        list.setLayoutOrientation(JList.VERTICAL);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        JPanel jDimensionPanel = new JPanel(new GridLayout(3, 2));
        jDimensionPanel.add(nameLabel);
        jDimensionPanel.add(nameText);
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

        JPanel jListScrollerPanel = new JPanel(new BorderLayout());
        jListScrollerPanel.add(listScroller);

        JButton go = new JButton("Generate");
        go.setName("generateButton");
        go.setPreferredSize(new Dimension(100, 50));
        go.addActionListener(new GenerateListener(imageRepository, mainFrame));
        jButtonPanel.add(go, BorderLayout.CENTER);

        content.add(jButtonPanel);
        content.add(jDimensionPanel);
        content.add(jListScrollerPanel);

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

    public IImageRepository getImageRepository()
    {
        return imageRepository;
    }

    public void setImageRepository(IImageRepository imageRepository)
    {
        this.imageRepository = imageRepository;
    }
}