package com.beckproduct.quilt.listener;

import com.beckproduct.quilt.domain.RawImage;
import com.beckproduct.quilt.repository.IImageRepository;
import com.beckproduct.quilt.utilities.FileUtilities;
import com.beckproduct.quilt.utilities.WindowUtilities;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 13, 2009
 * Time: 2:46:05 PM
 */
public class AddImageListener implements ActionListener
{
    static Logger logger = Logger.getLogger(AddImageListener.class);

    private JFrame frame;

    private IImageRepository imageRepository;

    public AddImageListener(JFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        JFileChooser chooser = new JFileChooser(new File("/"));
        int returnVal = chooser.showDialog(((JMenuItem) event.getSource()).getParent(), "Choose");
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            byte[] array;
            try
            {
                array = FileUtilities.convertToByteArray(file);
                logger.info("Array Length: " + array.length);
            }
            catch (IOException e)
            {
                logger.error(e.getMessage(), e);
                return;
            }

            imageRepository.saveFile(new RawImage(chooser.getSelectedFile().getName(), array));

            JList list = WindowUtilities.getJList(frame);
            DefaultListModel model = (DefaultListModel) list.getModel();
            model.addElement(chooser.getSelectedFile().getName());
        }
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
