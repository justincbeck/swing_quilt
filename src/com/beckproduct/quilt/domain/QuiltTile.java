package com.beckproduct.quilt.domain;


import org.hibernate.annotations.*;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:59:39 PM
 */

//@Entity
//@Table(name = "quiltTile")
public class QuiltTile extends JLabel
{
    private int rotation;

    private String fileName;

    public QuiltTile(ImageIcon image, String fileName, int rotation)
    {
        super(image);
        this.fileName = fileName;
        this.rotation = rotation;
    }

    public int getRotation()
    {
        return rotation;
    }

    public void setRotation(int rotation)
    {
        this.rotation = rotation;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
}
