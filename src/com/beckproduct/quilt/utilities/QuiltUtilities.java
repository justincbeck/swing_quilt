package com.beckproduct.quilt.utilities;

import org.apache.commons.lang.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 12, 2009
 * Time: 1:17:16 PM
 */
public class QuiltUtilities
{
    public static String getName(Container content)
    {
        Component[] components = content.getComponents();

        JPanel dimensionPanel = (JPanel) components[1];
        JTextField nameField = (JTextField) dimensionPanel.getComponents()[1];

        if (!StringUtils.isEmpty(nameField.getText()))
        {
            return nameField.getText();
        }
        else
        {
            return String.valueOf(Calendar.getInstance().getTimeInMillis());
        }
    }

    public static int getRows(Container content)
    {
        Component[] components = content.getComponents();

        JPanel dimensionPanel = (JPanel) components[1];
        JTextField rowsField = (JTextField) dimensionPanel.getComponents()[3];

        if (!StringUtils.isEmpty(rowsField.getText()))
        {
            return Integer.parseInt(rowsField.getText());
        }
        else
        {
            return 9;
        }
    }

    public static int getCols(Container content)
    {
        Component[] components = content.getComponents();

        JPanel dimensionPanel = (JPanel) components[1];
        JTextField colsField = (JTextField) dimensionPanel.getComponents()[5];

        if (!StringUtils.isEmpty(colsField.getText()))
        {
            return Integer.parseInt(colsField.getText());
        }
        else
        {
            return 13;
        }
    }

    public static JFrame removeCurrentQuilt(JFrame frame)
    {
        Component[] comps = frame.getContentPane().getComponents();

        if (comps.length == 4)
        {
            frame.getContentPane().remove(3);
        }

        return frame;
    }
}
